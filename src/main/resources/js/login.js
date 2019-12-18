$(function() {
    $("#register_btn").click(function() {
        $("#register_form").css("display", "block");
        $("#login_form").css("display", "none");
    });
    $("#back_btn").click(function() {
        $("#register_form").css("display", "none");
        $("#login_form").css("display", "block");
    });
});

function dologin() {
    var user = $("#user").val();
    var pwd = $("#pwd").val();
    var url = "http://"+window.location.host+"/dologin";
    var data={"user":user,"pwd":pwd};
    alert(data);
    $.ajax({
        type: 'POST',
        url: url,
        data: data,
        success: function (data) {
            console.log(data);
            window.localStorage.setItem("token",data.token);
            window.localStorage.setItem("user",user);
            window.localStorage.setItem("pwd",pwd);
            window.location.href="http://"+window.location.host+"/indexpage";
        }
    });
};