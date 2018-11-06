package com.rest.dao.impl;

import com.rest.dao.UserDao;
import com.rest.model.UserModel;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {


    @Resource
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    protected <T> T getMapper(Class<T> clazz) {
        return getSqlSession().getMapper(clazz);
    }


    @Override
    public void addUser(UserModel user) {
        //继承SqlSessionDaoSupport，通过this.getSqlSession()就能得到sqlSession，因为SqlSessionDaoSupport中有该方法
        SqlSession sqlSession = this.getSqlSession();
        sqlSession.insert("addUser", user);
    }

    @Override
    public UserModel getUserById(String userId) {
        return null;
    }
}
