//declare the constant express and set it equal to the result of requiring the Express module
const express = require("express");
console.log(express);

//declare the constant app and setting it equal to the result of invoking express
const app = express();

app.use(express.static(__dirname+'/static'));

app.set('view engine', 'ejs');
// console.log(__dirname);
app.set('views', __dirname + '/views');

//(request,response) call back function
//invoking the get function of the app and passing it a route and a callback function
app.get('/', (_req, res) => {
    res.render('index',{
        users:[
            {
                firstName: "Tom",
                lastName: "Nguyen",
                email: "tom@gmail.com",
            }
        ]
    });
});

//set the app to listen port 8000 and pass in a callback to run once the app is listening
app.listen(8000, () => console.log("listening on port 8000"));
