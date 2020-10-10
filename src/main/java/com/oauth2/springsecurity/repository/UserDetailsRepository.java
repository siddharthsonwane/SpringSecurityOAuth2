package com.oauth2.springsecurity.repository;

import com.oauth2.springsecurity.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface UserDetailsRepository extends JpaRepository<UserInfo, String> {

    public UserInfo findByUserNameAndEnabled(String userName, short enabled);

    public List<UserInfo> findAllByEnabled(short enabled);

    public UserInfo findById(Integer id);
//
//	@Override
//	public UserInfo save(UserInfo userInfo);

    public void deleteById(Integer id);

}