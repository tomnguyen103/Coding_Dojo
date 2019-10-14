from django.shortcuts import render, redirect
from django.utils.crypto import get_random_string

# Create your views here.
def index(request):
    ran_str = get_random_string(length=14)
    random = {
        'rtext' : ran_str
    }
    if 'count' not in request.session:
        request.session['count'] = 1

    return render (request, 'random_words/index.html', random)

def random_words(request):
    request.session['count'] += 1
    return redirect('/')

def reset(request):
    request.session.clear()
    return redirect('/')
