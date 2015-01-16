/**
 * Created by Lifeix on 14-12-8.
 */
$(function() {

    function log( message ) {
        $( "<div/>" ).text( message ).prependTo( "#log" );
        $( "#log" ).scrollTop( 0 );
    }

    //http://localhost:8088/solr-src/core0/suggest?q=so&wt=json
    //搜索引擎关键字自动填充
    $( "#city" ).autocomplete({
        source: function( request, response ) {
            $.ajax({
                url: "http://localhost:8080/solr/#/core1",
                dataType: "json",
                data: {
                    wt:"json",
                    q: request.term
                },
                success: function( data ) {

                    response(data.spellcheck.suggestions[1].suggestion)
                    /*
                     response( $.map( data, function( item ) {
                     return {
                     label: item.username,
                     value: item.username
                     }
                     }));
                     */
                }
            });
        },
        minLength: 2,//输入两个字符才会发送请求

        select: function( event, ui ) {
            log( ui.item ?
                "Selected: " + ui.item.label :
                "Nothing selected, input was " + this.value);
            //执行搜索
            $.getJSON("http://localhost:8080/solr/#/core1",
                { "q": ui.item.label, "version": "2.2","start":0,"rows":10,"indent":"on","wt":"json" },
                function(result) {
                    //显示搜索结果,这里简单显示json字符串
                    $("div#content").append(JSON.stringify(result.response.docs));


                });

        },
        open: function() {
            $( this ).removeClass( "ui-corner-all" ).addClass( "ui-corner-top" );
        },
        close: function() {
            $( this ).removeClass( "ui-corner-top" ).addClass( "ui-corner-all" );
        }

    });
});