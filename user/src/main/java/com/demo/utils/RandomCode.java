package com.demo.utils;

import java.util.Random;

/**
 * @author 9527
 * @version 1.0
 * @date 2020-10-27 9:58
 */
public class RandomCode {

    /**
     * 生成六位随机数验证码
     * @return 六位随机数
     */
    public static int sixCode(){
        Random random = new Random();
        int number = random.nextInt(999999);
        if(number<100000){
            number+=100000;
        }
        return number;
    }
}
