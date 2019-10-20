from django.shortcuts import render,redirect
from django.contrib import messages
from .models import *
import bcrypt

# Create your views here.
def index(request):
    return render(request,'main/index.html')

def process(request):
    form = request.POST

    errors = Job.objects.basic_validator(form)

    if len(errors) > 0:
        for key, val in errors.items():
            messages.error(request,val)
        return redirect("/")

    Job.objects.create(
        title=form["title"],
        description = form["description"],
        location= form["location"],
        category= form["category"],
        other= form["other"],
        )

    return redirect('/dashboard')

def register(request):
    form = request.POST

    errors = User.objects.basic_validator(form)

    if len(errors)>0:
        for key, val in errors.items():
            messages.error(request,val)
        return redirect('/')
    
    user = User.objects.create(
        first_name= form["first_name"],
        last_name= form["last_name"],
        email= form["email"],
        password = bcrypt.hashpw(form["password"].encode(), bcrypt.gensalt()),
    )

    # user = User.objects.filter(email=form['email'])

    request.session["user_id"] = user.id

    return redirect('/dashboard')

def dashboard(request):
    if "user_id" not in request.session:
        messages.error(request, "You must log in first!")
        return redirect("/")
    user = User.objects.get(id=request.session["user_id"]),
    job = Job.objects.all()

    return render(request,"main/dashboard.html",{
        "user" : user,
        "job_html": job,
    })

def login(request):
    form = request.POST
    
    try:
        user=User.objects.get(email=form["login_email"])
    except:
        messages.error(request,"Please enter a correct email!")
        return redirect("/")
    if bcrypt.checkpw(form["login_password"].encode(), user.password.encode()) == False:
        messages.error(request,"Please enter a correct password!")
        return redirect("/")
    
    request.session["user_id"] = user.id
    return redirect("/dashboard")

def logout(request):
    request.session.clear()
    return redirect('/')

def new_job(request):
    return render(request, "main/new-job.html",{
        "user": User.objects.get(id=request.session['user_id'])
    })

def addJobs(request):
    return render(request, 'main/dashboard.html',{
        "joblists": Job.objects.all()
    })

def job(request,job_id):
    job = Job.objects.get(id=job_id)
    
    return render(request,'main/jobdetail.html',{
        "job_html": job,
    })
    

def edit(request,job_id):
    return render(request, 'main/edit-job.html',{
        'job': Job.objects.get(id=job_id),
        "user" : User.objects.get(id=request.session["user_id"]),
    })

def update_job(request,job_id):

    form = request.POST

    job = Job.objects.get(id=job_id)
    job.title = form['title']
    job.description = form['description']
    job.location = form['location']
    job.category = form['category']
    job.other = form['other']

    job.save()

    return redirect(f"/jobs/{job_id}")

def add_job(request,job_id):
    form = request.POST

    this_job = Job.objects.get(id=job_id)
    this_user = User.objects.get(id=request.session["user_id"])

    this_user.id.add(this_job)

    return redirect("/dashboard",{
        "user_job_html": this_user
    })


def delete_job(request,job_id):
    job_delete = Job.objects.get(id=job_id)
    job_delete.delete()

    return redirect('/dashboard')