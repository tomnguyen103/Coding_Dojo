from django.shortcuts import render, redirect
from time import gmtime, strftime
import datetime

# Create your views here.
def index(request):
    context = {
        "time" : strftime("%b %d, %Y %I:%M %p", gmtime())
    }
    return render(request,'view/index.html',context)

def time_display(request):
    return redirect('/')