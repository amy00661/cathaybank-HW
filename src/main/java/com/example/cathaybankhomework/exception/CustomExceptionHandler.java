package com.example.cathaybankhomework.exception;

import com.example.cathaybankhomework.dto.BaseRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseRes handle(HttpServletRequest req, HttpServletResponse response, HttpSession session, Exception ex){
        response.setHeader("Content-Type", "application/json; charset=utf-8");

        log.error("Request: " + req.getRequestURL());
        log.error("caught exception:", ex);

        BaseRes res = BaseRes.buildError(ex.getMessage(), "系統發生未預期的錯誤。");
        log.error("res:{}", res);
        return res;
    }
}
