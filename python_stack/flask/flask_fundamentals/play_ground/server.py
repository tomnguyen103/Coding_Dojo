from flask import Flask, render_template

app = Flask(__name__)

@app.route("/play")
def app_work():
    return render_template("index.html")

@app.route("/play/{times}")
def more_grid(times):
    return render_template("index.html",time=times)

@app.route("/play/{times}/{color}")
def change_color(times,color):
    return render_template("index.html",time=times,color=colors)

if __name__ == "__main__":
    app.run(debug=True)