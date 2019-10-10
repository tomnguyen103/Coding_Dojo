from django.shortcuts import render, redirect
from django.utils.crypto import get_random_string

# Create your views here.
def index(request):
    return render (request, 'random_words/index.html')

def random_words(request):
    print('method here is ', request.method)
    if request.method == 'POST':
        print(request.POST)
    else:
        print('this is not in post request')
    #random_string = get_random_string(length=14)
    #print(random_string)
    return redirect("/")
