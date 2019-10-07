from flask import Flask, render_template, redirect, request, session

app = Flask(__name__)

app.secret_key = "some really secret key"

@app.route("/reset")
def reset():
    session.clear()
    return redirect("/")

@app.route("/process",methods=["GET","POST"])
def process():
    # print(request.args.get("first_name"))
    # print(request.form)

    form = request.form

    session["last_added_user"] = {
        "first_name" : form["first_name"],
        "last_name" : form["last_name"],
        "hair_color" : form["hair_color"]
    }
    return redirect("/")

@app.route("/")
def index():
    if "last_added_user" not in session:
        session["last_added_user"] = None
    
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
    return render_template("index.html", cohor_mates=users, last_added_user=session["last_added_user"] )


if __name__ == "__main__": #running directly
    app.run(port=7000,debug=True)