<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dojo Survey Index</title>
</head>
<body>
	<div id="wrapper">
        <form action="/submit-form" method="POST">
            Your Name: <input type="text" name="name"><br>
            Dojo Location:
            <select name="location">
                <option value="blank"></option>
                <option value="San Jose">San Jose</option>
                <option value="Burbank">Burbank</option>
                <option value="San Francisco">San Francisco</option>
                <option value="San Francisco">Orange County</option>
            </select>
            <br>
            Language:
            <select name="language">
                <option value="blank"></option>
                <option value="Python!!">Python</option>
                <option value="Javascript!!">JavaScript</option>
                <option value="C++!!">C++</option>
                <option value="Java!!">Java</option>
            </select>
            <br>
            Comment (optional):
            <br>
            <textarea name="comment" id="comment_box" cols="33" rows="3"></textarea>
            <br>
            <button>Submit</button>
        </form>
    </div>
</body>
</html>