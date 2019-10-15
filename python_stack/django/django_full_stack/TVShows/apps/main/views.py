from django.shortcuts import render,redirect,HttpResponse
from .models import *
from django.contrib import messages

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
    errors = Show.objects.basic_validator(form)

    if len(errors) > 0:
        for key, val in errors.items():
            messages.error(request,val)
        return redirect('/shows/new')

    # print("you are right at form")
    
    else:
        new_show = Show.objects.create(title=form['title'],network=form['network'],release_date=form['release_date'],desc=form['desc'])
        
        new_show_id = new_show.id
        return redirect(f"/shows/{new_show_id}")

def display_show(request,show_id):
    show_title = Show.objects.get(id=show_id)
    context = {
        "show_html" : show_title,
    }
    return render(request,"main/viewshow.html",context)

def edit_show(request,show_id):
    show_title = Show.objects.get(id=show_id)

    return render(request,"main/editshow.html", {
        "show_html":show_title
    })

def process_edit_show(request,show_id):
    show_title = Show.objects.get(id=show_id)
    form = request.POST

    errors = Show.objects.basic_validator(form)
    
    if len(errors)>0:
        for key, val in errors.items():
            messages.error(request,val)
        return redirect("/shows/"+show_id+"/edit")

    else:
        show_title.title = form['title']
        show_title.network = form['network']
        show_title.release_date = form['release_date']
        show_title.desc = form['desc']
        show_title.save()
        return redirect(f"/shows/{show_id}")

def delete_show(request,show_id):
    show_title = Show.objects.get(id=show_id)
    show_title.delete()
    return redirect("/shows")