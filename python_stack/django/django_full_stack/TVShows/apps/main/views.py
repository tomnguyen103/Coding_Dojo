from django.shortcuts import render,redirect,HttpResponse
from .models import *

# Create your views here.
def index(request):
    return redirect("/shows")

def shows(request):
    return render(request,'main/index.html',{
        "all_shows_html" : Show.objects.all()
    })
def new_shows(request):

    return render(request,"main/create.html")

def add_new_shows(request):
    form = request.POST
    print("you are right at form")
    new_show = Show.objects.create(title=form['title'],network=form['network'],release_date=form['release_date'],desc=form['desc'])
    return redirect("/shows")

def display_show(request):
    pass