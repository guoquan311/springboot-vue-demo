package com.example.demo.service;

import com.example.demo.dao.StuRepository;
import com.example.demo.entity.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    @Resource
    private StuRepository stuRepository;

    @Transactional
    public List<Stu> saveAll(List<Stu> stus) {
        return stuRepository.saveAll(stus);
    }

    public Stu save(Stu stu) {
        return stuRepository.saveAndFlush(stu);
    }

    public List<Stu> findAll() {
        List<Stu> stus = stuRepository.findAll();
        return stus;
    }

    public List<Stu> findAll(Example<Stu> example) {
        List<Stu> stus = stuRepository.findAll(example);
        return stus;
    }

    public Page<Stu> findAll(Example<Stu> example, PageRequest pageRequest) {
        Page<Stu> stus = stuRepository.findAll(example, pageRequest);
        return stus;
    }

    public void deleteById() {
        stuRepository.existsById(1);//判断是否存在
        stuRepository.deleteById(1);//删除
    }
}
