package com.stu.sd.repository;

import com.stu.sd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo  extends JpaRepository<User,Long> {
}
