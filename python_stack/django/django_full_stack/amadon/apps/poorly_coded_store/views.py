from django.shortcuts import render, redirect
from .models import *

def index(request):
    return redirect('/amadon')

def amadon(request):
    if 'total_spent' not in request.session:
        request.session['total_spent'] = 0

    if 'product_ordered' not in request.session:
        request.session['product_ordered'] = 0

    return render(request, "poorly_coded_store/index.html")

def process(request):
    # quantity_from_form = int(request.POST["quantity"])
    # price_from_form = float(request.POST["price"])
    # total_charge = quantity_from_form * price_from_form
    # print("Charging credit card..." +str(total_charge))
    # Order.objects.create(quantity_ordered=quantity_from_form, total_price=total_charge)
    # return redirect('/amadon/checkout')
    # price = [
    #     "1":19.99,
    #     "2":29.99,
    #     "3":4.99,
    #     "4":49.99,
    # ]
    form = request.POST
    checkout_product_id = form.get('product_id')
    request.session['checkout_quantity'] = int(form.get('quantity'))

    product_prices = [{"1":19.99}, {"2":29.99}, {"3":4.99}, {"4":49.99}]

    for product in product_prices:
        for product_id in product:
            if checkout_product_id == product_id:
                request.session['product_price'] = (product[product_id]* request.session['checkout_quantity'])
                request.session['total_spent'] += (product[product_id]* request.session['checkout_quantity'])
                request.session['product_ordered'] += request.session['checkout_quantity']

    product_names = [{'1':'Dojo T-Shirt'}, {'2':'Dojo Sweater'}, {'3':'Dojo Cup'}, {'4':'Algorithm Book'}]
    for product in product_names:
        for product_name in product:
            if checkout_product_id == product_name:
                request.session['product_name'] = product[product_name]

    return redirect('/amadon/checkout')

def checkout_display(request):
    total_purchased = Order.objects.last()
    context ={
        "ordered_html":total_purchased.quantity_ordered,
        "price_html":total_purchased.total_price,
    }
    return render(request,'poorly_coded_store/checkout.html',context)

def go_back(request):
    return redirect('/')