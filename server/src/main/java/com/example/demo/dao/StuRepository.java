package com.example.demo.dao;

import com.example.demo.entity.Stu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StuRepository extends JpaRepository<Stu, Integer> {

}
