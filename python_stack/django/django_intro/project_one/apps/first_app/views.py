from django.shortcuts import render, HttpResponse

def index(request):
    return HttpResponse("main page first app")

def new(request):
    return HttpResponse("new page from the first app")