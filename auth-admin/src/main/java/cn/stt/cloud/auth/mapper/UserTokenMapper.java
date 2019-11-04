package cn.stt.cloud.auth.mapper;


import cn.stt.cloud.auth.entity.UserToken;

public interface UserTokenMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserToken record);

    UserToken selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserToken record);

    UserToken findByToken(String token);

    UserToken findByUserId(Integer userId);
}