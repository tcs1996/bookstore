package com.itheima.demo;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Books;
import com.itheima.domain.User;
import com.itheima.service.BooksService;
import com.itheima.service.UserService;
import com.itheima.service.impl.BooksServiceImpl;
import com.itheima.service.impl.UserServiceImpl;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class UserDemoTest {
    private static UserService userService = null;
    private static BooksService booksService =null;
    @BeforeClass
    public static void init(){
        userService = new UserServiceImpl();

         booksService = new BooksServiceImpl();

    }

    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("fsfd");
        user.setPassword("11231");
        userService.save(user);
    }
    @Test
    public void tsstFindAll(){
//        PageInfo all = booksService.finAll(1, 2);
        List<Books> all = booksService.findAll();
        System.out.println(all);

    }
    @AfterClass
    public static void destory(){
        userService = null;
        booksService = null;
    }
}
