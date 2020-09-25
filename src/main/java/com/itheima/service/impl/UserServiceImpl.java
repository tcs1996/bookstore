package com.itheima.service.impl;

import com.github.pagehelper.PageInfo;
import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.service.Userservice;
import com.itheima.utils.MapperFactory;
import com.itheima.utils.TransactionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Random;

public class UserServiceImpl implements Userservice {
    @Override
    public void save(User user) {
        SqlSession sqlSession = null;
        try {
            //1.获取SqlSession
            sqlSession = MapperFactory.getSqlSession();
            //2.获取Dao
            UserDao userDao = MapperFactory.getMapper(sqlSession, UserDao.class);
            //id使用主键，自动递增
            //3.调用Dao层操作
            userDao.save(user);
            //4.提交事务
            TransactionUtil.commit(sqlSession);
        } catch (Exception e) {
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
            //记录日志
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(User user) {

    }

    public void update(User user) {

    }

    public User findById(Integer id) {
        return null;
    }

    public List<User> findAll() {
        return null;
    }

    public PageInfo finAll(int page, int size) {
        return null;
    }
}
