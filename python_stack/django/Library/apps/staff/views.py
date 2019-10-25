from django.shortcuts import render,redirect
from django.contrib import messages
from .models import *
import bcrypt

# Create your views here.
def staff_index(request):
    if "staff_logged_in" in request.session:
        return render(request, 'main/index.html')
    return render(request,'main/index.html')

def staff_register(request):
    form = request.POST

    errors = Staff.objects.basic_validator(form)

    if len(errors)>0:
        for key, val in errors.items():
            messages.error(request,val)
        return redirect('/')
    
    Staff.objects.create(
        first_name= form["first_name"],
        last_name= form["last_name"],
        staff_id = form["staff_id"],
        email= form["email"],
        password = bcrypt.hashpw(form["password"].encode(), bcrypt.gensalt()),
    )
    staff = Staff.objects.last()
    request.session["logged_in"] = staff.id
    request.session["first_name"] = staff.first_name
    request.session["last_name"] = staff.last_name
    request.session["email"] = staff.email
    request.session["student_id"] = staff.staff_id
    return redirect('/main')

def staff_login(request):
    form = request.POST
    
    # try:
    #     user=User.objects.get(email=form["login_email"])
    # except:
    #     messages.error(request,"Please enter a correct email!")
    #     return redirect("/")
    # if bcrypt.checkpw(form["login_password"].encode(), user.password.encode()) == False:
    #     messages.error(request,"Please enter a correct password!")
    #     return redirect("/")

    errors = Staff.objects.login_validation(form)
    if len(errors):
        for key, value in errors.items():
            messages.error(request,value)
    else:
        staff = Staff.objects.get(email=form['login_email'])
        request.session["logged_in"] = staff.id
        request.session["email"] = staff.email
        request.session["first_name"] = staff.first_name
        request.session["last_name"] = staff.last_name
        request.session["staff_id"] = staff.staff_id
        return redirect('/main')
    return redirect("/")

def staff_logout(request):
    request.session.clear()
    return redirect('/')

