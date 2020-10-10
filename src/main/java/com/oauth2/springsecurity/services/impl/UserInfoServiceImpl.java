package com.oauth2.springsecurity.services.impl;

import com.oauth2.springsecurity.model.UserInfo;
import com.oauth2.springsecurity.repository.UserDetailsRepository;
import com.oauth2.springsecurity.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class UserInfoServiceImpl  implements UserInfoService {


    @Autowired
    private UserDetailsRepository userDatailsRepository;

    @Override
    public UserInfo getUserInfoByUserName(String userName) {

        short enabled = 1;
        return userDatailsRepository.findByUserNameAndEnabled(userName, enabled);
    }

    @Override
    public List<UserInfo> getAllActiveUserInfo() {
        return userDatailsRepository.findAllByEnabled((short) 1);
    }

    @Override
    public UserInfo getUserInfoById(Integer id) {
        return userDatailsRepository.findById(id);
    }

    @Override
    public UserInfo addUser(UserInfo userInfo) {
        userInfo.setPassword(new BCryptPasswordEncoder().encode(userInfo.getPassword()));
        return userDatailsRepository.save(userInfo);
    }

    @Override
    public UserInfo updateUser(Integer id, UserInfo userRecord) {
        UserInfo userInfo = userDatailsRepository.findById(id);
        userInfo.setUserName(userRecord.getUserName());
        userInfo.setPassword(userRecord.getPassword());
        userInfo.setRole(userRecord.getRole());
        userInfo.setEnabled(userRecord.getEnabled());
        return userDatailsRepository.save(userInfo);
    }

    @Override
    public void deleteUser(Integer id) {
        userDatailsRepository.deleteById(id);
    }

    @Override
    public UserInfo updatePassword(Integer id, UserInfo userRecord) {
        UserInfo userInfo = userDatailsRepository.findById(id);
        userInfo.setPassword(userRecord.getPassword());
        return userDatailsRepository.save(userInfo);
    }

    @Override
    public UserInfo updateRole(Integer id, UserInfo userRecord) {
        UserInfo userInfo = userDatailsRepository.findById(id);
        userInfo.setRole(userRecord.getRole());
        return userDatailsRepository.save(userInfo);
    }
}
