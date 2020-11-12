package com.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.vo.UserInfo;
import com.demo.vo.UserInfoRole;
import com.demo.vo.UserInfoRoleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 9527
 * @version 1.0
 * @date 2020-10-27 10:06
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    /**
     * @return 分页查询所有
     */
    List<UserInfoRole> page(UserInfoRoleVo vo);

    /**
     * 查询总数
     * @param vo  condition
     * @return total
     */
    int total(UserInfoRoleVo vo);

    IPage<UserInfoRole> customPage(UserInfoRoleVo vo);

    List<UserInfoRole> getPage(Page page,UserInfoRoleVo vo);
}
