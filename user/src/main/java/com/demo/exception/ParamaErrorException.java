package com.demo.exception;

/**
 * @author 9527
 * @version 1.0
 * @date 2020-10-30 11:12
 */
public class ParamaErrorException extends RuntimeException{

    public ParamaErrorException(){
    }

    public ParamaErrorException(String message){
        super(message);
    }
}
