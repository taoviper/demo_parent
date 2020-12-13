package com.demo.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

/**
 * @author 9527
 * @version 1.0
 * @date 2020-12-8 11:17
 */
@Data
public class ParamCondition {

    @NotBlank(message = "长度不能为空")
    private String str;

    @Max(value = 10,message = "最大为10")
    @Min(value = 1,message = "最小为1")
    private Integer number;

    private Date startDate;

    @NotEmpty(message = "数组长度必须大于0")
    private List<String> list;

    @NotBlank(message = "去除长度不为空")
    private String string;

}
