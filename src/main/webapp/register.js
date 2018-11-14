$(function () {

});

$('button[type=submit]').on('click', function () {
    console.log("hello ");
    /*$.ajax({
        type: 'post',
        dataType: 'json',
        data: {
            //之前这里忘记val()了
            userName: $('input[name=userName]').val(),
            pwd: $('input[name=pwd]').val()
        },
        url: "user/signUp",
        success: function (result) {
            if(result.success){
                alert(result.data);
            }else{
                alert("注册失败!");
            }
        },
    });*/
});
