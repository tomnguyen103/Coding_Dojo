from flask import Flask, render_template 

app = Flask(__name__)  
@app.route('/')   
def checkerboard():
    return render_template('index.html',nums=8,nums2=8,coloo1='yellow',coloo2='red')

@app.route("/<num>")
def change_num(num):
    return render_template('index.html', nums=8, nums2 = int(num),coloo1='yellow',coloo2='red')
@app.route("/<num>/<col>")
def change_both(num,col):
    return render_template('index.html',nums= int(num),nums2=int(col),coloo1='yellow',coloo2='red')
@app.route("/<num>/<col>/<colo1>/<colo2>")
def change_four(num,col,colo1,colo2):
    return render_template('index.html',nums= int(num),nums2=int(col),coloo1=colo1, coloo2=colo2)

if __name__=="__main__":  
    app.run(debug=True)   
