from flask import Flask, render_template, request, redirect, session

app = Flask(__name__)

app.secret_key = "some secrect keys"

app.count = 0

@app.route('/')
def index():
    if 'count' not in session:
        session['count'] = 0

    session['count'] += 1
    return render_template('index.html', counter = session['count'])

@app.route('/add_counter', methods = ['POST'])
def add_counter():
    session['count'] += 1
    return redirect('/')

@app.route('/destroy_session',methods = ['POST'])
def destroy():
    session.clear()
    return redirect('/')


if __name__=="__main__":   
    app.run(debug=True)  