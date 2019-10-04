from flask import Flask, render_template, redirect, request

app = Flask(__name__)

@app.route("/process",methods=["GET","POST"])
def process():
    print(request.args.get("first_name"))
    print(request.form)
    return redirect("/")
    # return "Hello"

@app.route("/")
def index():
    users = [{
        "first_name" : "Mark",
        "last_name" : "Lopez",
        "hair_color" : "charcoal"
    },
    {
        "first_name" : "Mike",
        "last_name" : "Peterson",
        "hair_color" : "dark mustard"
    }]
    return render_template("index.html", cohor_mates=users)


if __name__ == "__main__": #running directly
    app.run(port=7000,debug=True)