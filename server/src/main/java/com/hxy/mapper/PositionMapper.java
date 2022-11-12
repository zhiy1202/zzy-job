package com.hxy.mapper;

import com.hxy.entity.Position;
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
public interface PositionMapper extends BaseMapper<Position> {
    //通过视图 company——position获取所有职位的简介
    @Select("select title , money , com_address , create_time , position_id from company_position")
    List<UserComPosition> getAllPosition();
    //通过positionId 获取详细信息
    @Select("select * from company_position where position_id = #{positionId}")
    UserComPosition getPositionDetail(Integer positionId);

    //通过title模糊查询
    @Select("select title , money , com_address , create_time , position_id from company_position where title like CONCAT('%' ,#{title} ,'%')")
    List<UserComPosition> getPositionsByTitle(String title);

    //查询用户旗下一个公司发布的所有职位
    @Select("select p.title , p.money , p.intro , p.position_id from t_position p join t_company c on p.company_id = c.company_id where c.user_id = #{userId}")
    List<UserComPosition> getCompanyAllPosition(Integer userId);
}
