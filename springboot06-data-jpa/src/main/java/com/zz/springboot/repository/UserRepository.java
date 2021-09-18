package com.zz.springboot.repository;

import com.zz.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//继承JpaRepository，来完成对数据库的操作
public interface UserRepository extends JpaRepository<User, Integer> {
}
