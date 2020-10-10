package com.oauth2.springsecurity.services;

import com.oauth2.springsecurity.model.UserInfo;

import java.util.List;

public interface UserInfoService {

    public UserInfo getUserInfoByUserName(String userName);

    public List<UserInfo> getAllActiveUserInfo();

    public UserInfo getUserInfoById(Integer id);

    public UserInfo addUser(UserInfo userInfo);
    public UserInfo updateUser(Integer id, UserInfo userRecord);

    public void deleteUser(Integer id);
    public UserInfo updatePassword(Integer id, UserInfo userRecord);

    public UserInfo updateRole(Integer id, UserInfo userRecord);


}
