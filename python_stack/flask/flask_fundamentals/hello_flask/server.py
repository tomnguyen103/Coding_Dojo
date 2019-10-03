from flask import Flask
app = Flask(__name__)

@app.route("/")
def hello():
    return "Hello World!"
# @app.route("/success")
# def success():
#     return "success"

@app.route('/<name>')
def hello_person(name):
    return f"Hello {name}!"

if __name__ == "__main__":
    app.run(debug=True)
    