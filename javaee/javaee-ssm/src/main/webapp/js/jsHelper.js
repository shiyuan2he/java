var jsHelper = {
    /**
     * @description <p>格式化千分位</p>
     * @param inputNum
     * @returns {string}
     */
    formateToQianFenWei:function (inputNumber) {
        var floatNumber = parseFloat(inputNumber) ;
        if(floatNumber < 1000.0){
            return inputNumber ;
        }
        var n = floatNumber.toFixed(2);//补全两位小数
        var re = /(\d{1,3})(?=(\d{3})+(?:\.))/g;
        return n.replace(re, "$1,") ;
    },
    /**
     *
     * @description
     *		<p>千分位返回正常字符串</p>
     * @time 2017年4月18日 上午9:06:53
     * @github
     * 		http://github.com/shiyuan2he
     * @author shiyuan2he
     * @email heshiyuan@chtwm.com
     * @returnType any
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    formateFromQianFenWei : function (intputNumber){
        return parseFloat(intputNumber.split(',').join(""));
    }
}