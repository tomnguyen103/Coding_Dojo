from flask import Flask, render_template

app = Flask(__name__)

@app.route("/play")
def app_work():
    return render_template("index.html",some_times=3)

@app.route("/play/<times>")
def more_grid(times):
    #print('in times function')
    return render_template("index.html",some_times=int(times))
    

@app.route("/play/<times>/<color>")
def change_color(times,color):
    # print("inside the function change_color")
    return render_template("index.html",some_times=int(times),some_color=color)

if __name__ == "__main__":
    app.run(debug=True)