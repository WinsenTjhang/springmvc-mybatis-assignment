package com.winsen.demo.repository;

import com.winsen.demo.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserRepository {

    User findById(@Param("id") String id);

}


