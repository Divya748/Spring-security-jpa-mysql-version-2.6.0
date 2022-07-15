package com.springsecurityjpamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.springsecurityjpamysql.daorepo.UserDao;
import com.springsecurityjpamysql.entity.UserInformation;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserDao.class)
public class SpringSecurityJpaMysqlApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJpaMysqlApplication.class, args);
	}

	@Autowired
	UserDao userRepo; 
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		UserInformation u1 = new UserInformation("divya","divya@748",true,"ROLE_ADMIN");
		 userRepo.save(u1);
		 
		 UserInformation u2 = new UserInformation("divya123","divya@123",true,"ROLE_USER");
		 userRepo.save(u2);
	}

}
