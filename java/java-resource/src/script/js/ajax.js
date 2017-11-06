var ajax = {
    jsonpWithParam : function(requestType,serviceUrl,callbackFunc,param){
        if(null==param || undefined==param){
            $.ajax({
                type:requestType,
                dataType : "jsonp",
                jsonp : "callback",
                jsonpCallback : callbackFunc,
                url:serviceUrl,
                dataType:'jsonp',
                success:function(data){
                    console.log("jsonp请求成功返回：",data) ;
                },
                error:function(XMLHttpRequest, textStatus, errorThrown) {
                    console.log("jsonp请求成失败返回：",XMLHttpRequest.status,XMLHttpRequest.readyState,textStatus) ;
                }
            });
        }else{
            $.ajax({
                type:requestType,
                dataType : "jsonp",
                param : param,
                jsonp : "callback",
                jsonpCallback : callbackFunc,
                url:serviceUrl,
                dataType:'jsonp',
                success:function(data){
                    console.log("jsonp请求成功返回：",data) ;
                },
                error:function(XMLHttpRequest, textStatus, errorThrown) {
                    console.log("jsonp请求成失败返回：",XMLHttpRequest.status,XMLHttpRequest.readyState,textStatus) ;
                }
            });
        }
    },
    /**
     * @description <p>jsonp get请求方式</p>
     * @param serviceUrl 跨域请求地址
     * @param callbackFunc 回调方法
     * @author heshiyuan
     * @date 2017/11/6 08:30
     */
    getJsonp: function(serviceUrl,callbackFunc){
        ajax.jsonpWithParam("GET",serviceUrl,callbackFunc);
    },
    /**
     * @description <p>jsonp post请求方式</p>
     * @param serviceUrl 跨域请求地址
     * @param callbackFunc 回调方法
     * @author heshiyuan
     * @date 2017/11/6 08:30
     */
    postJsonp: function(serviceUrl,param,callbackFunc){
        ajax.jsonpWithParam("POST",serviceUrl,callbackFunc,param);
    },
    getJson : function(serviceUrl,callbackFunc){
        $.ajax({
            type : "GET",
            dataType : "json",
            url : serviceUrl,
            success:callbackFunc,
            error:function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
        });
    },
    postJson : function(serviceUrl,callbackFunc){
        $.ajax({
            type : "POST",
            dataType : "json",
            url : serviceUrl,
            success:callbackFunc,
            error:function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
        });
    }
}
