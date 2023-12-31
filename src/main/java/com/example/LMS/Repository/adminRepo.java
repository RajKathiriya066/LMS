package com.example.LMS.Repository;

import com.example.LMS.Users.Admin;
import org.springframework.data.repository.CrudRepository;

public interface adminRepo extends CrudRepository<Admin,String> {
}
