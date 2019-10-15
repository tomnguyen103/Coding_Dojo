from django.shortcuts import render,redirect

from .models import *

# Create your views here.
def addBooks(request):
    return render(request, 'book_authors_app/books.html',{
        "bookLists": Book.objects.all()
    })

def process(request):
    form = request.POST

    Book.objects.create(title=form["title"], desc=form["desc"])

    return redirect("/")

def book(request,number):

    book = Book.objects.get(id=int(number))
    book_author = book.authors.all()
    all_authors = Author.objects.all()
    context = {
        "book_html" : book,
        "book_author_html" : book_author,
        "all_authors_html" : all_authors,
    }

    return render(request,'book_authors_app/bookdetails.html',context)

def addAuthor(request,number):
    book_id = int(number)
    author_id = int(request.POST["author"])

    get_book_id = Book.objects.get(id=book_id)
    get_author_id = Author.objects.get(id=author_id)

    get_book_id.authors.add(get_author_id)

    return redirect(f"/books/{number}")

def addAuthors(request):
    return render(request, 'book_authors_app/authors.html',{
        "authorLists": Author.objects.all()
    })


def process2(request):
    form = request.POST

    Author.objects.create(first_name=form["first_name"], last_name=form["last_name"], notes=form["notes"])

    return redirect("/")

def author(request,number):

    author = Author.objects.get(id=int(number))
    author_book = author.books.all()
    all_books = Book.objects.all()
    context = {
        "author_html" : author,
        "author_book_html" : author_book,
        "all_books_html" : all_books,
    }

    return render(request,'book_authors_app/authordetails.html',context)

def addBook(request,number):
    author_id = int(number)
    book_id = int(request.POST["book"])

    get_author_id = Author.objects.get(id=author_id)
    get_book_id = Book.objects.get(id=book_id)

    get_author_id.books.add(get_book_id)

    return redirect(f"/authors/{number}")