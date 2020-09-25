package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.User;

import java.util.List;

public interface Userservice {

    /*
    * 新增数据
    * */
    void  save(User user);
    /*
    * 删除对象*/
    void delete(User user);
    /*
    * 修改对象*/
    void update(User user);
    /*
    * 查询单个：
    * param ID  查询条件（id）
    * return 查询结果，单个对象*/
    User findById(Integer id );
    /*查询全部数据
    * return 全部数据的列表对象*/
    List<User> findAll();
    /*分页查询
    * param page 页码
    * param size 每页查询的数量*/
    PageInfo finAll (int page,int size);
}
