from django.shortcuts import render, redirect

# Create your views here.
def amadon(request):
    return render(request,"Amadon/index.html")

def index(request):
    return redirect('/amadon')
