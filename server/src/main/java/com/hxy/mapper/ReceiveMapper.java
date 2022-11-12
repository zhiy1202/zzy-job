package com.hxy.mapper;

import com.hxy.entity.Receive;
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
public interface ReceiveMapper extends BaseMapper<Receive> {

    @Select(("select r.receive_id , r.company_id , r.position_id,r.user_id,c.com_name,c.com_address,c.com_telephone , p.title,p.money,p.intro , r.create_time from t_receive r join t_company c on r.company_id = c.company_id join t_position p on r.position_id = p.position_id where r.user_id = #{userId}"))
    List<UserComPosition> getAllUserReceive(Integer userId);

    //一个公司下所有的投递简历
    @Select("select r.receive_id , r.company_id , r.position_id , r.user_id , r.resume_id , p.title , ur.wage , u.username ,ur.address ,ur.telephone,ur.intro  from t_receive r join t_position p on r.position_id = p.position_id join t_user u on r.user_id = u.user_id join user_resume ur on r.resume_id = ur.resume_id where r.company_id = #{companyId}")
    List<UserComPosition> getAllCompanyReceive(Integer companyId);

}
