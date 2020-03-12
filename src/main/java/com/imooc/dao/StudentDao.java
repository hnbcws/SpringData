package com.imooc.dao;

import com.imooc.domain.Student;

import java.util.List;

/**
 * StudentDao访问接口
 */
public interface StudentDao {

    public List<Student> query();

    public void save(Student student);
}
