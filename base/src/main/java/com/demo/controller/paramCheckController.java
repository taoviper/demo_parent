package com.demo.controller;

import com.demo.entity.ParamCondition;
import constant.StatusCode;
import entity.ResultDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author 9527
 * @version 1.0
 * @date 2020-12-8 11:10
 */
@Api(value = "参数校验",tags = {"测试对应的参数注解"})
@RestController
@RequestMapping(value = "/api/paramCheck")
public class paramCheckController {

    @PostMapping(value = "/testAnnotation")
    public ResultDto testAnnotation(@Valid @RequestBody ParamCondition condition){
        System.out.println(condition);
        return new ResultDto(StatusCode.SUCCESS,StatusCode.OPERATE_SUCCESS,null);
    }
}
