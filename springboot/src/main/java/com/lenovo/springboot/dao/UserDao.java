package com.lenovo.springboot.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lenovo.springboot.entity.User;
@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	public List<User> findByUserName(String name);
}
