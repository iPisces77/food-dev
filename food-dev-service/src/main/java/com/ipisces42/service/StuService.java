package com.ipisces42.service;

import com.ipisces42.pojo.Stu;
public interface StuService{


    int deleteByPrimaryKey(Integer id);

    int insert(Stu record);

    int insertSelective(Stu record);

    Stu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Stu record);

    int updateByPrimaryKey(Stu record);

    Stu getStuInfo(int id);

    void saveStu();
    void updateStu(int id);
    void deleteStu(int id);

}
