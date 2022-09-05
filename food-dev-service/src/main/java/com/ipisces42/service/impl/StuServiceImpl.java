package com.ipisces42.service.impl;

import com.ipisces42.mapper.StuMapper;
import com.ipisces42.pojo.Stu;
import com.ipisces42.service.StuService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StuServiceImpl implements StuService {

    @Resource
    private StuMapper stuMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return stuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Stu record) {
        return stuMapper.insert(record);
    }

    @Override
    public int insertSelective(Stu record) {
        return stuMapper.insertSelective(record);
    }

    @Override
    public Stu selectByPrimaryKey(Integer id) {
        return stuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Stu record) {
        return stuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Stu record) {
        return stuMapper.updateByPrimaryKey(record);
    }

    @Override
    @Transactional(readOnly = true)
    public Stu getStuInfo(int id) {
        return stuMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveStu() {

        var stu = Stu.builder().name("jack0").age(64).build();

        stuMapper.insert(stu);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateStu(int id) {
        var stu = Stu.builder().id(id).name("jack1").age(54).build();
        stuMapper.updateByPrimaryKey(stu);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteStu(int id) {
        stuMapper.deleteByPrimaryKey(id);
    }

}
