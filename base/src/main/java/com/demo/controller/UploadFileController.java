package com.demo.controller;

import constant.StatusCode;
import entity.ResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


/**
 * @author 9527
 * @version 1.0
 * @date 2020-11-19 16:32
 */
@Api(value = "文件controller",tags = {"处理文件上传下载的接口"})
@RestController
@RequestMapping(value = "/api/file")
public class UploadFileController {

    @ApiOperation(value = "上传文件")
    @PostMapping("/upload")
    public ResultDto uploadFile(@RequestPart MultipartFile file, HttpServletRequest request){
        String originalFilename = file.getOriginalFilename();
        System.out.println(originalFilename);
        String upload = request.getSession().getServletContext().getRealPath("upload");
        int indexOf = file.getOriginalFilename().lastIndexOf(".");

        System.out.println(upload);

        return new ResultDto(StatusCode.SUCCESS,StatusCode.OPERATE_SUCCESS);
    }


    public static void main(String[] args) {
        String s = "南山禾正医院地下停车场充电桩怎么走？" +
                "<img src=\"http://cdt-oss-uat.oss-cn-shenzhen.aliyuncs.com/webmgmtcomponent/LINK/df9a51d71dc54f07915f30bcecbc8f60?Expires=1764488358&OSSAccessKeyId=LTAI4G5228FSZRGcLbFCxR7m&Signature=s2XVm%2FaN60D7IfG6sS8mG%2Bonnnc%3D\"/>" +
                "龙珠七路向北行驶右转进入龙苑路，然后直行200米左转到达停车场入口<img src=\"http://cdt-oss-uat.oss-cn-shenzhen.aliyuncs.com/webmgmtcomponent/LINK/39fc70c1601f4d4caeae85677daddba6?Expires=1764488358&OSSAccessKeyId=LTAI4G5228FSZRGcLbFCxR7m&Signature=Fug404wQH229ol3IyUzWxl0Ksng%3D\"/>停车场入口<img src=\"http://cdt-oss-uat.oss-cn-shenzhen.aliyuncs.com/webmgmtcomponent/LINK/79c28b8260304269934f58512cb211a7?Expires=1764488358&OSSAccessKeyId=LTAI4G5228FSZRGcLbFCxR7m&Signature=WmIm9kP0VdEN%2Fjk%2FBXwvybVgiBA%3D\"/>进入地下停车场入口匝道<img src=\"http://cdt-oss-uat.oss-cn-shenzhen.aliyuncs.com/webmgmtcomponent/LINK/fcdeaf00a58e43ea9ac9649a20164205?Expires=1764488358&OSSAccessKeyId=LTAI4G5228FSZRGcLbFCxR7m&Signature=mj%2B49np4EDhwi6wsC0ey0DVu60k%3D\"/>充电桩位于停车场M层<img src=\"http://cdt-oss-uat.oss-cn-shenzhen.aliyuncs.com/webmgmtcomponent/LINK/6a7c9647d313457398e5afa5c3646a15?Expires=1764488358&OSSAccessKeyId=LTAI4G5228FSZRGcLbFCxR7m&Signature=2yKryq3TGvxIYVeEwCkcJnEPvvQ%3D\"/><img src=\"http://cdt-oss-uat.oss-cn-shenzhen.aliyuncs.com/webmgmtcomponent/LINK/749bb215da414e73a4ec8156da1e198f?Expires=1764488358&OSSAccessKeyId=LTAI4G5228FSZRGcLbFCxR7m&Signature=baDeFXcdRxLtKPv3ZuypaKMmzoc%3D\"/>";
        String[] split = s.split("\\|\\|");
        System.out.println(split.length);
        Arrays.asList(split).forEach(System.out::println);
    }
}
