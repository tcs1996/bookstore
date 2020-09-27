package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Books;

import java.util.List;

public interface BooksService {
    /*
     * 新增数据
     * */
    void  save(Books books);
    /*
     * 删除对象*/
    void delete(Books books);
    /*
     * 修改对象*/
    void update(Books books);
    /*
     * 查询单个：
     * param ID  查询条件（id）
     * return 查询结果，单个对象*/
    Books findById(Integer id );
    /*查询全部数据
     * return 全部数据的列表对象*/
    List<Books> findAll();
    /*分页查询
     * param page 页码
     * param size 每页查询的数量*/
    PageInfo finAll (int page, int size);
}
