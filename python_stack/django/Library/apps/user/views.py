from django.shortcuts import render,redirect
from django.contrib import messages
from .models import *
import bcrypt

# Create your views here.
def show_main(request):
    return render(request,'main/index.html')
    
def index(request):
    if "logged_in" in request.session:
        return redirect("main/index.html")

    return render(request,'user/login.html')

def register(request):
    form = request.POST

    errors = User.objects.basic_validator(form)

    if len(errors)>0:
        for key, val in errors.items():
            messages.error(request,val)
        return redirect('/')
    
    User.objects.create(
        first_name= form["first_name"],
        last_name= form["last_name"],
        student_id = form["student_id"],
        email= form["email"],
        password = bcrypt.hashpw(form["password"].encode(), bcrypt.gensalt()),
    )
    user = User.objects.last()
    request.session["logged_in"] = user.id
    request.session["first_name"] = user.first_name
    request.session["last_name"] = user.last_name
    request.session["email"] = user.email
    request.session["student_id"] = user.student_id
    return redirect('/main')

def login(request):
    form = request.POST
    
    # try:
    #     user=User.objects.get(email=form["login_email"])
    # except:
    #     messages.error(request,"Please enter a correct email!")
    #     return redirect("/")
    # if bcrypt.checkpw(form["login_password"].encode(), user.password.encode()) == False:
    #     messages.error(request,"Please enter a correct password!")
    #     return redirect("/")

    errors = User.objects.login_validation(form)
    if len(errors):
        for key, value in errors.items():
            messages.error(request,value)
    else:
        user = User.objects.get(email=form['login_email'])
        request.session["logged_in"] = user.id
        request.session["email"] = user.email
        request.session["first_name"] = user.first_name
        request.session["last_name"] = user.last_name
        request.session["student_id"] = user.student_id
        return redirect('/main')
    return redirect("/")

def logout(request):
    request.session.clear()
    return redirect('/')

