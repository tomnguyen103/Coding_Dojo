from django.shortcuts import render,redirect
from django.contrib import messages
from .models import *
import bcrypt

# Create your views here.
def index(request):
    if "logged_in" in request.session:
        return redirect("/dashboard")

    return render(request,'main/index.html')

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
        email= form["email"],
        password = bcrypt.hashpw(form["password"].encode(), bcrypt.gensalt()),
    )
    user = User.objects.last()
    request.session["logged_in"] = user.id
    request.session["first_name"] = user.first_name
    request.session["last_name"] = user.last_name

    return redirect('/dashboard')

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
        request.session["first_name"] = user.first_name
        request.session["last_name"] = user.last_name
        return redirect('/dashboard')
    return redirect("/")

def logout(request):
    request.session.clear()
    return redirect('/')


def dashboard(request):
    if "logged_in" not in request.session:
        messages.error(request, "You must log in first!")
        return redirect("/")

    return render(request,"main/dashboard.html",{
        "user" : User.objects.get(id=request.session["logged_in"]),
        "job_html": Job.objects.all(),
        "job_available": Job.objects.all().exclude(user_doing_job = request.session['logged_in']),
        "job_assigned": Job.objects.filter(user_doing_job= User.objects.get(id=request.session['logged_in'])),

    })

def delete_job(request,job_id):
    job_delete = Job.objects.get(id=job_id)
    job_delete.delete()

    return redirect('/dashboard')

def job(request,job_id):
    form = request.POST
    if request.method == "POST":
        this_job = Job.objects.get(id=form['show_job_info'])
        return render(request,'main/job-detail.html',{
        "job_html": this_job,
        "user": User.objects.get(id=request.session["logged_in"]),
        })  

def edit_job(request,job_id):
    return render(request, 'main/edit-job.html',{
        'job': Job.objects.get(id=job_id),
        "user" : User.objects.get(id=request.session["logged_in"]),
    })

def update_job(request,job_id):
    form = request.POST

    errors = Job.objects.update_validation(form)

    if len(errors):
        for key, value in errors.items():
            messages.error(request,value)
    else:
        job = Job.objects.get(id=job_id)
        job.title = form['title']
        job.description = form['description']
        job.location = form['location']
        job.save()
        return redirect('/dashboard')

    return redirect('request.edit_job')


def new_job(request):
    return render(request, "main/new-job.html", {"user" : User.objects.get(id=request.session["logged_in"])})

def create_job_process(request):
    form = request.POST
    errors = Job.objects.job_validator(form)

    if len(errors):
        for key, value in errors.items():
            messages.error(request,value)
        
    else:
        this_user= User.objects.get(id=request.session["logged_in"])
        Job.objects.create(title=form['title'],description=form['description'],location=form['location'], user_created=this_user,)
        return redirect('/dashboard')
    return redirect('/jobs/new')


def add_job_to_user(request,job_id):
    # if request.medthod == "POST":
    form = request.POST
    this_user = User.objects.get(id=request.session["logged_in"])

    this_job = Job.objects.get(id=form['add_job_to_user'])


    this_job.user_doing_job = this_user

    this_job.save()
    return redirect ('/dashboard')


# def process(request):
#     form = request.POST

#     errors = Job.objects.basic_validator(form)

#     if len(errors) > 0:
#         for key, val in errors.items():
#             messages.error(request,val)
#         return redirect("/")

#     Job.objects.create(
#         title=form["title"],
#         description = form["description"],
#         location= form["location"],
#         # category= form["category"],
#         # other= form["other"],
#         )

#     return redirect('/dashboard')