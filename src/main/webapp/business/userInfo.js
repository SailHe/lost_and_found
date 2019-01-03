//$(document).ready(function ()
$(function () {
    const editor = {
        itemDescEditor : null,
        msgDescEditor: null
    }
    let {username, jumperAndParser, divWrap, showLimitLenStr} = initPage(editor);

    $.ajax({
        type: 'post',
        dataType: 'json',
        data: {
            username: username
        },
        url: "/user/query",
        success: callbackClosure((data) => {
            let $userInfoRoot = $('#userInfo');
            $userInfoRoot.text("邮箱: " + data.userEmailAddress);
            if(data.userRole == 20){
                $userInfoRoot.append("<button id='itemMgBtn'> 物品管理 </button>")
                $('#itemMgBtn').on('click', function () {
                    const $currentNode = $(this);
                    jumperAndParser.jumperToTarget("lafItem.html", "");
                });

            }else{
                // do nothing
            }
        }),
    });

});

