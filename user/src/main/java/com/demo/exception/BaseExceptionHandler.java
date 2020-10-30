package com.demo.exception;

import constant.StatusCode;
import entity.ResultDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 9527
 * @version 1.0
 * @date 2020-10-28 17:06
 */
//@ControllerAdvice
//public class BaseExceptionHandler {
//
//    private static final Logger logger = LoggerFactory.getLogger(BaseExceptionHandler.class);
//
//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public ResultDto error(Exception e){
//        logger.error(e.getMessage());
//        return new ResultDto(StatusCode.EXCEPTION,e.getMessage());
//    }
//
//
//}
