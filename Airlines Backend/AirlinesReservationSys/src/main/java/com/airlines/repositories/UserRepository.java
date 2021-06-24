package com.airlines.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airlines.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	//User findByUserNameAndPassword(String userName,String password);//select u from User u where u.userName=1? and password=2?;
	
	User findByEmailIdAndPassword(String emailId,String password);
	User findByUserName(String userName);
	//User findByUserRole(String userRole);
}
