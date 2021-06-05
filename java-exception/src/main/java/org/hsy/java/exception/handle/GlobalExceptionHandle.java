package org.hsy.java.exception.handle;
/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/org.hsy.java.exception.handle
 * @date 2017/11/17 13:55
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
/*public class GlobalExceptionHandle implements HandlerExceptionResolver {
    private final Logger _logger = LoggerFactory.getLogger(this.getClass());
    private String defaultView ;
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 是否是ajax请求
        boolean isAjaxRequest = false;
        if(null!=request.getHeader("x-requested-with") && request.getHeader("x-requested-with").equals("XMLHttpRequest")){
            isAjaxRequest = true;
        }
        if(isAjaxRequest){
            try {
                //返回json格式的错误信息
                response.setContentType("text/html;charset=UTF-8");
                response.setCharacterEncoding("utf-8");
                PrintWriter writer = response.getWriter();
                String responseStr = JSON.toJSONString(new ResponseBodyBean<>(false,((BusinessException) ex).getCode(),ex.getMessage())) ;
                _logger.info("全局异常处理返回信息：{}",responseStr);
                writer.write(responseStr);
                writer.flush();
            } catch (Exception e) {
                _logger.error("全局处理异常失败,message:{}:",e.getMessage());
            }
        }else {
            //跳转到定制化的错误页面
            ModelAndView error = new ModelAndView();
            if(defaultView!=null){
                error.setViewName(defaultView);
            }else{
                error.setViewName("/error/500");
            }
            error.addObject("code", ((BusinessException) ex).getCode());
            error.addObject("message", ex.getMessage());
            return error;
        }
        return new ModelAndView();
    }

    public String getDefaultView() {
        return defaultView;
    }

    public void setDefaultView(String defaultView) {
        this.defaultView = defaultView;
    }
}*/
