package com.self.repository;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * 作者：boys
 * 创建时间：2017-08-23 17:45
 * 类描述：
 * 修改人：
 * 修改时间：
 */
@Repository
public class DBDao extends SqlSessionDaoSupport{

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sessionFactory) {
        super.setSqlSessionFactory(sessionFactory);
    }

    public Map<String, Object> selectOne(String prefix, String key, Object parmas){
        return getSqlSession().selectOne(prefix + key, parmas);
    }
}
