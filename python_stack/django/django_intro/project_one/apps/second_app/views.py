from django.shortcuts import render, HttpResponse

def index(request):
    return HttpResponse("main page second app")

def new(request):
    return HttpResponse("new page from the second app")

def other(request):
    return HttpResponse("other page in the second app")