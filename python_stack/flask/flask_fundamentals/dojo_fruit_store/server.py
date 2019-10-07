from flask import Flask, render_template, request, redirect
app = Flask(__name__)  

@app.route('/')         
def index():
    return render_template("index.html")

@app.route('/checkout', methods=['POST'])         
def checkout():
    print(request.form)
    form = request.form

    strawberry_entered = form['strawberry']
    raspberry_entered = form['raspberry']
    apple_entered = form['apple']
    first_name_entered = form['first_name']
    last_name_entered = form['last_name']
    id_entered = form['student_id']
    customer_name_entered = first_name_entered + ' ' + last_name_entered
    count = int(strawberry_entered) + int(raspberry_entered) + int(apple_entered)
    print("Charging "+ customer_name_entered + " for " + str(count) + " fruits.")

    return render_template("checkout.html", strawberry_on_template = strawberry_entered,raspberry_on_template= raspberry_entered,
    apple_on_template=apple_entered, first_name_on_template = first_name_entered, last_name_on_template = last_name_entered, id_on_template = id_entered,
    customer_on_template=customer_name_entered, count_on_template=count)

@app.route('/fruits')         
def fruits():
    return render_template("fruits.html")

if __name__=="__main__":   
    app.run(debug=True)    