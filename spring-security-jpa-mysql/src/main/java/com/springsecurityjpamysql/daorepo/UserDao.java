package com.springsecurityjpamysql.daorepo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurityjpamysql.entity.UserInformation;

public interface UserDao extends JpaRepository<UserInformation, Integer>{

	Optional<UserInformation> findByUserName(String userName);
}
