from flask import Flask

app = Flask(__name__)
@app.route('/') #decorator
def only_splash(): 
    return "Hello World!"

@app.route('/dojo')
def show_dojo():
    return "Dojo!"

@app.route('/say/<name>')
def hello_person(name):
    return "Hi {}!".format(name)

@app.route('/repeat/<num>/<name>')
def make_multiple(num,name):
    return f"{name} " * int(num)

@app.route('/user/<int:user_id>')
def second_integer(user_id):
    return "You entered an integer for ID"

@app.errorhandler(404)
def page_not_found(e):
    return "Sorry! No response. Try again."

if __name__ == "__main__":
    app.run(debug=True)