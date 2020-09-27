package com.itheima.dao;

import com.itheima.domain.Books;

import java.util.List;

public interface BooksDao {
    int   save(Books books);

    int delete(Books books);

    int update(Books books);

    Books findById(Integer id );

    List<Books> findAll();
}
