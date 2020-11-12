package com.demo.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author taoweipu
 * @since 2020-11-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserRole对象", description="")
public class UserRole extends Model<UserRole> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色id")
    @TableId("role_id")
    private Integer roleId;

    @ApiModelProperty(value = "角色名称( 0,打工人;1,将军;2,总统;)")
    @TableField("role_name")
    private String roleName;


    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }

}
