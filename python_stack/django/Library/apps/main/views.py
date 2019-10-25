from django.shortcuts import render, redirect

# Create your views here.
def main_index(request):
    return render(request,"main/index.html")

def admin_index(request):
    return render(request,'main/staff-index.html')