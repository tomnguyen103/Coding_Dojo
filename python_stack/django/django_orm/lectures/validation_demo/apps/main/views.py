from django.shortcuts import render, redirect

from django.contrib import messages
from .models import Movie

# Create your views here.
def index(request):
    return render(request,"main/index.html",{
        "movies" : Movie.objects.all()
    })

def process(request):
    form = request.POST

    errors = Movie.objects.basic_validator(form)

    if len(errors) > 0:
        for key, val in errors.items():
            messages.error(request,val)
        return redirect("/")
    Movie.objects.create(title=form["title"], description = form["description"], year=int(form["year"]))



    return redirect('/')
