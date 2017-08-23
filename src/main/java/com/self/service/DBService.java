package com.self.service;

import com.self.repository.DBDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 作者：boys
 * 创建时间：2017-08-23 17:36
 * 类描述：
 * 修改人：
 * 修改时间：
 */
@Service("dbService")
public class DBService {

    @Autowired
    private DBDao dbDao;

    public void addData() {
        System.out.println("添加成功");
    }

    public Map<String, Object> getOne() {
        return this.dbDao.selectOne(DBService.class.getName()+".", "selectOne", null);
    }
}
