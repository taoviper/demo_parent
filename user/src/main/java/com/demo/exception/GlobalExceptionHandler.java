package com.demo.exception;

import com.demo.enums.ResponseVo;
import com.demo.enums.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author 9527
 * @version 1.0
 * @date 2020-10-30 11:37
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 自定义参数错误异常处理
     * @param e 异常
     * @return 封装类
     */
    @ResponseBody
    @ExceptionHandler(ParamaErrorException.class)
    public ResponseVo paramExceptionHandler(ParamaErrorException e){
       log.error("",e);
       if (!StringUtils.isEmpty(e.getMessage())){
           return new ResponseVo(ResultEnum.PARAMETER_ERROR.getCode(),e.getMessage());
       }
       return new ResponseVo(ResultEnum.PARAMETER_ERROR.getCode(),ResultEnum.PARAMETER_ERROR.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseVo error(Exception e){
        log.error(e.getMessage());
        return new ResponseVo(ResultEnum.UNKNOWN_ERROR.getCode(),e.getMessage());
    }

}
