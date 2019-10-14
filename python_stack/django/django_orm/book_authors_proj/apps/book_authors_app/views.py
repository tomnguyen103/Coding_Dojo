from django.shortcuts import render,redirect

from .models import Book

# Create your views here.
def addBooks(request):
    return render(request, 'book_authors_app/books.html',{
        "bookLists": Book.objects.all()
    })

def process(request):
    form = request.POST

    Book.objects.create(title=form["title"], desc=form["desc"])

    return redirect("/")

def book(request,id):

    return render(request,'book_authors_app/bookdetails.html')

def authors(request):
    return render(request,'book_authors_app/authors.html',{
        "bookLists": Book.objects.all()
    })
