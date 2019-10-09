from django.shortcuts import render
from datetime import datetime

# Create your views here.
def index(request):
    if "favorite" not in request.session:
        request.session["favorite"] = "white"

    return render(request, 'main/index.html', {
        "favorite_color" : request.session["favorite"],
        "activities" : request.session["activities"],
    })

def colors(request):
    if request.method == "POST":
        color = request.POST["color"]

        request.session["favorite"] = color
        request.session["activities"].append({
            "color" : color,
            "time" : datetime.now()
        })
    
    return 