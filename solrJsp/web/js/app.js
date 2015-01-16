/**
 * Created by Lifeix on 14-12-8.
 */
//$(document).ready(function(){
//    $("#button1").click(function(){
//        var content = $("#content").val();
//        alert(content);
//    });
//});


//function doRequestUsingGET(){
//    var content = $("#content").val();
//    $.ajax({
//        type:"GET",
//        url:'http://192.168.199.22:8080/ft_topic_core/select?q=topicName%3A'+content+'&wt=json&indent=true',
//        dataType:'jsonp',
//        jsonpCallback:"ajaxTest",
//        jsonpCallback:'?',
//        success:function(data){
//            $("#call").html(decodeURL(data));
//            alert(data);
//        }
//        error:function(){
//            alert('fail');
//        }

//    });
//}

//function ajaxTest(json){
//    alert(00 + '---' + json);
//}


function doRequestUsingGET(){
    var content = $("#content").val();
    $.ajax({

        url:'http://192.168.199.22:8080/ft_topic_core/',
        dataType:'json',
        data:{
            wt:"json",
            q:""
        },
        success:function(data){
            $("#call").html(decodeURL(data));
            alert(data);
        },
        error:function(){
            alert('fail');
        }

    });
}
