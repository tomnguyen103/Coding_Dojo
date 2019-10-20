from django.shortcuts import render, redirect
from django.contrib import messages
from .models import *
import bcrypt

# Create your views here.


def index(request):
    if "user_id" in request.session:
        return redirect('/success')
    
    
    return render(request, 'main/index.html')


def register(request):
    form = request.POST

    errors = User.objects.basic_validator(form)

    if len(errors) > 0:
        for key, val in errors.items():
            messages.error(request, val)
        return redirect('/')

    user = User.objects.create(
        first_name=form["first_name"],
        last_name=form["last_name"],
        email=form["email"],
        password=bcrypt.hashpw(form["password"].encode(), bcrypt.gensalt())
        )

    user = User.objects.filter(email=form['email'])

    request.session["user_id"] = user.id

    return redirect('/success')


def login(request):
    form = request.POST
    # print(form)
    try:
        user = User.objects.get(email=form["login_email"])
    except:
        messages.error(request, "Please enter a correct email!")
        return redirect("/")
    if bcrypt.checkpw(form["login_password"].encode(), user.password.encode()) == False:
        messages.error(request, "Please enter a correct password!")
        return redirect("/")

    request.session["user_id"] = user.id
    return redirect("/success")


def success(request):
    if "user_id" not in request.session:
        return redirect('/')

    return render(request, 'main/success.html', {
        "user": User.objects.get(id=request.session['user_id']),
        "post_data": Message.objects.all(),
        "comment_data": Comment.objects.all(),
    })


def logout(request):
    request.session.clear()
    return redirect('/')


def add_message(request):
    form = request.POST

    Message.objects.create(
        message=form['add-message'], 
        user=User.objects.get(id=request.session['user_id']))

    return redirect('/')


def add_comment(request):
    form = request.POST

    Comment.objects.create(comment=form['comment'], message=Message.objects.get(id=form['message_id']), user=User.objects.get(id=request.session['user_id']))
    return redirect('/success')


def delete_message(request, id):
    message_delete = Message.objects.get(id=id)

    message_delete.delete()

    return redirect('/success')


def delete_comment(request, id):
    comment_delete = Comment.objects.get(id=id)

    comment_delete.delete()

    return redirect('/success')
