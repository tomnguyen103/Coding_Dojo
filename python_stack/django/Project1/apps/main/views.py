from django.shortcuts import render, redirect
from django.contrib import messages
from .models import *
import bcrypt

# Create your views here.


def main(request):
    return render(request, 'main/index.html')

def about(request):
    return render(request, 'main/about.html')

def books(request):
    # this_book = Book.objects.get(id=request.session["logged_in"])
    return render(request, 'main/books.html',{
        "books": Book.objects.all(),

    })

def faq(request):
    return render(request, 'main/faq.html')

def privacy_policy(request):
    return render(request, 'main/privacy-policy.html')

def terms_conditions(request):
    return render(request, 'main/terms-conditions.html')

def products(request):
    return render(request, 'main/products.html')


def product_single(request,book_id):
    this_book= Book.objects.get(id=book_id)
    return render(request, 'main/product-single.html',{
        "books": Book.objects.all(),
        "this_book": this_book,
    })

def index(request):
    # if "logged_in" in request.session:
    #     return redirect("main/index.html")

    return render(request, 'main/login.html')

def register(request):
    form = request.POST

    errors = User.objects.basic_validator(form)

    if len(errors) > 0:
        for key, val in errors.items():
            messages.error(request, val)
        return redirect('/')

    User.objects.create(
        first_name=form["first_name"],
        last_name=form["last_name"],
        student_id=form["student_id"],
        email=form["email"],
        password=bcrypt.hashpw(form["password"].encode(), bcrypt.gensalt()),
    )
    user = User.objects.last()
    request.session["logged_in"] = user.id
    request.session["first_name"] = user.first_name
    request.session["last_name"] = user.last_name
    request.session["email"] = user.email
    request.session["student_id"] = user.student_id
    return redirect('/')


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
            messages.error(request, value)
    else:
        user = User.objects.get(email=form['login_email'])
        request.session["logged_in"] = user.id
        request.session["email"] = user.email
        request.session["first_name"] = user.first_name
        request.session["last_name"] = user.last_name
        request.session["student_id"] = user.student_id
        return redirect('/main')
    return redirect("/login")


def logout(request):
    request.session.clear()
    return redirect('/')

def add_question(request):
    form = request.POST

    Message.objects.create(
        message= form['question_message'],
        user= request.session["logged_in"]
    )
    return redirect('/')

def add_book(request,book_id):
    return render(request,'main/product-single.html',{
        "books": Book.objects.all()
    })

# def borrow(request):
#     form = request.POST

#     Book.objects.create(title=request.)
def choose_book(request,book_id):
    form = request.POST

    this_user = User.objects.get(id=request.session["logged_in"])
    
    this_book = Book.objects.get(id=request.session["logged_in"])

