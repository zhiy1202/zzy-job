package com.hxy.mapper;

import com.hxy.entity.Success;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxy.entity.UserComPosition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hxy
 * @since 2022-09-15
 */
@Mapper
public interface SuccessMapper extends BaseMapper<Success> {
    //获取用户收到的所有offer
    @Select("select s.success_id , s.company_id , s.position_id,s.user_id,c.com_name,c.com_address,c.com_telephone , p.title,p.money,p.intro ,s.create_time from t_success s join t_company c on s.company_id = c.company_id join t_position p on s.position_id = p.position_id where s.user_id = #{userId}")
    List<UserComPosition> getUserAllSuccess(Integer userId);
}
