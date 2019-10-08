from django.shortcuts import render, redirect

# Create your views here.
def index(request):
    return render(request,"main/index.html")

def process(request):
    print('Method: here', request.method)
    if request.method == 'POST':
        print(request.POST)
    else:
        print("this was not a post request!")
   # print(request.POST)
    return redirect("/")