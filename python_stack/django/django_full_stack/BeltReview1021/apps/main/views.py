from django.shortcuts import render,redirect
from django.contrib import messages
from .models import *
import bcrypt

# Create your views here.
def index(request):
    if "logged_in" in request.session:
        return redirect("/books")

    return render(request,'main/index.html')

def register(request):
    form = request.POST

    errors = User.objects.basic_validator(form)

    if len(errors)>0:
        for key, val in errors.items():
            messages.error(request,val)
        return redirect('/')
    
    User.objects.create(
        name= form["name"],
        alias= form["alias"],
        email= form["email"],
        password = bcrypt.hashpw(form["password"].encode(), bcrypt.gensalt()),
    )
    user = User.objects.last()
    request.session["logged_in"] = user.id
    request.session["name"] = user.name
    request.session["alias"] = user.alias

    return redirect('/books')

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
        request.session["name"] = user.name
        request.session["alias"] = user.alias
        return redirect('/books')
    return redirect("/")

def logout(request):
    request.session.clear()
    return redirect('/')


def books(request):
    if "logged_in" not in request.session:
        messages.error(request, "You must log in first!")
        return redirect("/")

    return render(request,"main/books.html",{
        "user" : User.objects.get(id=request.session["logged_in"]),
        "latest": Review.objects.order_by('created_at').reverse()[:3],
        "rest": Review.objects.order_by('created_at').reverse(),

    })

def new_book_review(request):
    return render(request, "main/new-book.html", {"user" : User.objects.get(id=request.session["logged_in"])})


def create_book_process(request):
    form = request.POST

    errors = Book.objects.book_validation(form)

    if len(errors):
        for key, value in errors.items():
            messages.error(request,value)
        
    else:
        user = User.objects.get(id=request.session['logged_in'])

        book = Book.objects.create(
            title= form["title"],
            author= form["author"],
        )

        Review.objects.create(
            review= form['review'],
            rating= form['rating'],
            reviewer = user,
            book = book,
        )
        return redirect("/books")
    return redirect("/books/add")

def userpage(request,user_id):
    user = User.objects.get(id=user_id)
    review = Review.objects.filter(reviewer=user)
    count = review.count()

    return render(request,'main/user.html',{
        "user": user,
        "reviewedBooks": review,
        "countedReview": count,
    })

def showbook(request,book_id):
    