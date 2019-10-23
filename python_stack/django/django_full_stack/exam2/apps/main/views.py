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
        request.session["email"] = user.email
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
    # creator = User.object.get
    # this_creator = User.objects.get(id=request.session["logged_in"])
    
    return render(request,"main/dashboard.html",{
        "user" : User.objects.get(id=request.session["logged_in"]),
        "trips": Trip.objects.all(),
        'others': Trip.objects.all().exclude(join = request.session["logged_in"]),
    })

def new_trip(request):
    trip= Trip.objects.all()
    return render(request, "main/new-trip.html", {
        "user" : User.objects.get(id=request.session["logged_in"]),
        "trip": trip,
        })


def create_trip_process(request):
    form = request.POST

    errors = Trip.objects.trip_validation(form)

    if len(errors):
        for key, value in errors.items():
            messages.error(request,value)
        
    else:
        user = User.objects.get(id=request.session['logged_in'])
        
        trip = Trip.objects.create(
            destination= form["destination"],
            start_date = form["start_date"],
            end_date = form["end_date"],
            plan = form["plan"],
            creator= user,
        )

        return redirect("/dashboard")
    return redirect("/trips/new")


def trip_detail(request,trip_id):
    trip = Trip.objects.get(id=trip_id)
    user = User.objects.get(id=request.session['logged_in'])

    return render(request,'main/trip-detail.html',{
        'user': user,
        'trip': trip,
        'others': User.objects.filter(joiner=trip_id).exclude(id=trip.creator.id)
    })


def remove_trip(request,trip_id):
    trip = Trip.objects.get(id=trip_id)
    if  trip.creator.id == request.session['logged_in']:
        trip.delete()
    
        # return redirect('/dashboard')
    return redirect('/dashboard')

def edit(request,trip_id):
    return render(request, 'main/edit-trip.html',{
        'trip': Trip.objects.get(id=trip_id),
        "user" : User.objects.get(id=request.session["logged_in"]),
    })

def update_trip(request,trip_id):

    form = request.POST

    errors = Trip.objects.update_trip_validation(form)

    if len(errors):
        for key, value in errors.items():
            messages.error(request,value)
        
    else:
        trip = Trip.objects.get(id=trip_id)
        trip.destination = form['destination']
        trip.start_date = form['start_date']
        trip.end_date = form['end_date']
        trip.plan = form['plan']
        trip.save()
        return redirect("/dashboard")

    return redirect(f"/trips/edit/{trip_id}")

def join(request,trip_id):
    # if request.method == "GET":
    #     messages.error(request,'What trip do you want to join?')
    #     return redirect('/')
    Trip.objects.join(request.session["logged_in"],trip_id)
    # this_trip = Trip.objects.get(id=trip_id)
    # this_trip.join.add(joiner)
    # messages.error(request,'What trip do you want to join?')
    return redirect('/dashboard')

def cancel_trip(request,trip_id):
    trip = Trip.objects.get(id=trip_id)
    user = User.objects.get(id=request.session['logged_in'])
    trip.join.remove(user)
    return redirect('/dashboard')

# "latest": Trip.objects.order_by('created_at').reverse()[:3],
        # "latest": Trip.objects.order_by(creator=request.session["logged_in"]),
        # "latest": Trip.objects.all().exclude(join_id=request.session["logged_in"]),

# 'others': User.objects.filter(joiner_id=trip_id).exclude(id=trip.creator.id),
# "others": Trip.objects.all().exclude(join_id=request.session["logged_in"])