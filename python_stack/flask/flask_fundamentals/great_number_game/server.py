from flask import Flask, render_template, redirect, session
import random

num = random.randint(1,100)

app = Flask(__name__)

app.secret_key = "this is secret"

@app.route('/')
def index():
    session['num'] = num

    return render_template('guess.html')

@app.route('/guess',methods=['GET','POST'])
def guess():
    form = request.form()

    session['num'] = form[]
    return redirect('/')

@app.route('/guess_low')
def low():

    return redirect('/')

@app.route('/guess_high')
def high():
    return redirect('/')

if __name__ == '__main__':
    app.run(debug=True)