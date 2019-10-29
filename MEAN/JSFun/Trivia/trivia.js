// function questionGenerator(data){
//     console.log(data.results[0].question);
//     var str1 = "<h4>"+data.results[0].question+"</h4>";
//     $("#a1").append(str1);
//     // for(var i=0; i<data.results.length;i++){
//     //     var str = "<h4>"+data.results[i].question+"</h4>";
//     //     $("a1").append(str);
    
// }

$(document).ready(function(){
    $.get("https://opentdb.com/api.php?amount=4&category=9&type=multiple", function(data1){
        general = data1.results;
    });
    $.get("https://opentdb.com/api.php?amount=4&category=17&type=multiple", function(data2){
        science = data2.results;
    });
    $.get("https://opentdb.com/api.php?amount=4&category=21&type=multiple", function(data3){
        sport = data3.results;
    });

    $("#a1").click(function(){
        $("#a1").html("<div class='center'><p>"+general[0].question+"</p><br><p>"+ general[0].incorrect_answers[0]+"</p><p>"+general[0].correct_answer+"</p><p>"+general[0].incorrect_answers[1]+"</p></div>");
    });
    $("#a2").click(function(){
        $("#a2").html("<div class='center'><p>"+general[1].question+"</p><br><p>"+ general[1].incorrect_answers[0]+"</p><p>"+general[1].correct_answer+"</p><p>"+general[1].incorrect_answers[1]+"</p></div>");
    });
    $("#a3").click(function(){
        $("#a3").html("<div class='center'><p>"+general[2].question+"</p><br><p>"+ general[2].incorrect_answers[0]+"</p><p>"+general[2].correct_answer+"</p><p>"+general[2].incorrect_answers[1]+"</p></div>");
    });
    $("#a4").click(function(){
        $("#a4").html("<div class='center'><p>"+general[3].question+"</p><br><p>"+ general[3].incorrect_answers[0]+"</p><p>"+general[3].correct_answer+"</p><p>"+general[3].incorrect_answers[1]+"</p></div>");
    });


    $("#b1").click(function(){
        $("#b1").html("<div class='center'><p>"+science[0].question+"</p><br><p>"+ science[0].incorrect_answers[0]+"</p><p>"+science[0].correct_answer+"</p><p>"+science[0].incorrect_answers[1]+"</p></div>");
    });
    $("#b2").click(function(){
        $("#b2").html("<div class='center'><p>"+science[1].question+"</p><br><p>"+ science[1].incorrect_answers[0]+"</p><p>"+science[1].correct_answer+"</p><p>"+science[1].incorrect_answers[1]+"</p></div>");
    });
    $("#b3").click(function(){
        $("#b3").html("<div class='center'><p>"+science[2].question+"</p><br><p>"+ science[2].incorrect_answers[0]+"</p><p>"+science[2].correct_answer+"</p><p>"+science[2].incorrect_answers[1]+"</p></div>");
    });
    $("#b4").click(function(){
        $("#b4").html("<div class='center'><p>"+science[3].question+"</p><br><p>"+ science[3].incorrect_answers[0]+"</p><p>"+science[3].correct_answer+"</p><p>"+science[3].incorrect_answers[1]+"</p></div>");
    });


    $("#c1").click(function(){
        $("#c1").html("<div class='center'><p>"+sport[0].question+"</p><br><p>"+ sport[0].incorrect_answers[0]+"</p><p>"+sport[0].correct_answer+"</p><p>"+sport[0].incorrect_answers[1]+"</p></div>");
    });
    $("#c2").click(function(){
        $("#c2").html("<div class='center'><p>"+sport[1].question+"</p><br><p>"+ sport[1].incorrect_answers[0]+"</p><p>"+sport[1].correct_answer+"</p><p>"+sport[1].incorrect_answers[1]+"</p></div>");
    });
    $("#c3").click(function(){
        $("#c3").html("<div class='center'><p>"+sport[2].question+"</p><br><p>"+ sport[2].incorrect_answers[0]+"</p><p>"+sport[2].correct_answer+"</p><p>"+sport[2].incorrect_answers[1]+"</p></div>");
    });
    $("#c4").click(function(){
        $("#c4").html("<div class='center'><p>"+sport[3].question+"</p><br><p>"+ sport[3].incorrect_answers[0]+"</p><p>"+sport[3].correct_answer+"</p><p>"+sport[3].incorrect_answers[1]+"</p></div>");
    });

});

