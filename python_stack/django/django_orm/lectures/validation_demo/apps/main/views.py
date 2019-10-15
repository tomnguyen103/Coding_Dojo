from django.shortcuts import render, redirect

from django.contrib import messages
from .models import Movie, User

import bcrypt

# Create your views here.
def index(request):
    return render(request,"main/index.html")

# def dashboard(request):
#     return render(request,"main/dashboard.html",{
#         "movies" : Movie.objects.all()
#     })

def process(request):
    form = request.POST

    errors = Movie.objects.basic_validator(form)

    if len(errors) > 0:
        for key, val in errors.items():
            messages.error(request,val)
        return redirect("/")
    Movie.objects.create(title=form["title"], description = form["description"], year=int(form["year"]))



    return redirect('/')

def register(request):
    form = request.POST

    errors = User.objects.basic_validator(form)

    if len(errors) > 0:
        for key, val in errors.items():
            messages.error(request,val)
        return redirect("/")
    
    user = User.objects.create(
        first_name=form["first_name"], 
        last_name=form["last_name"], 
        email=form["email"],
        password = bcrypt.hashpw(form["password"], bcrypt.gensal())
        )
    
    request.session["user_id"] = user.id

    return redirect("/dashboard")

def dashboard(request):
    if "user_id" not in request.session:
        messages.error(request, "You must log in first!")
        return redirect("/")
    
    return render(request,"main/dashboard",{
        "user" : User.objects.get(id=request.session["user_id"])
    })

def login(request):
    form = request.POST

    try:
        user= User.objects.get(email=form["email"])
    except:
        messages.error(request,"Please check your email and password")
        return redirect("/")

    if bcrypt.checkpw(form["password"].encode(),user.password.encode()) == False:
        messages.error(request,"Please check your email and password")
        return redirect("/")
    
    request.session["user_id"] = user.id
    return redirect("/dashboard")

def logout(request):
    request.session.clear
    return redirect("/login")