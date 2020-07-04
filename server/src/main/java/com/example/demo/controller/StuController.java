package com.example.demo.controller;

import com.example.demo.dao.StuRepository;
import com.example.demo.entity.Stu;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
@EnableJpaRepositories
public class StuController {
    @Resource
    private UserService userService;

    @GetMapping("/index")
    public String sayHello(){
        return "Welcome to Spring Boot!";
    }

    @GetMapping("/findAll")
    public String findAll() {
        List<Stu> stus = userService.findAll();
        return ""+stus;
    }

    /**
     * 创建
     *
     * @return
     */
    @GetMapping("/createOne")
    public List<Stu> createOne() {
        Stu stu = new Stu("李四", 12, "西湖");
//        Stu stu = new Stu();
//        stu.setId("111111");
//        stu.setName("李四");
//        stu.setAge(12);
//        stu.setAddress("西湖");
        Stu save = userService.save(stu);

        log.info(save.toString());

        List<Stu> stus = Arrays.asList(new Stu("李四", 12, "西湖"),
                new Stu("王五", 12, "南京路"),
                new Stu("交易员韩国", 12, "二环"));
        List<Stu> stus1 = userService.saveAll(stus);

        return stus1;
    }

    @GetMapping("/deleteById")
    public void deleteById() {
        userService.deleteById();
    }


    /**
     * 根据条件查询
     *
     * @return
     */
    @GetMapping("/findByExample")
    public List<Stu> findByExample() {
        Stu stu = new Stu();
        stu.setAge(12);
        Example<Stu> example = Example.of(stu);

        List<Stu> all = userService.findAll(example);
        return all;
    }

    /**
     * 实现分页查询
     *
     * @return
     */
    @GetMapping("/findWithPage")
    public Page<Stu> findWithPage() {
        Stu stu = new Stu();
        stu.setAge(12);
        Example<Stu> example = Example.of(stu);
        Page<Stu> all = userService.findAll(example, PageRequest.of(1, 5, Sort.by("name")));

        return all;
    }
}
