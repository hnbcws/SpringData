package com.imooc.dao;

import com.imooc.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpringJdbcTemplateImpl implements  StudentDao {
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> query() {

        final List<Student> students = new ArrayList<Student>();
        String sql ="select * from student";
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                 Student student = new Student();

                student.setId(resultSet.getInt("id"));
                student.setAge(resultSet.getInt("age"));
                student.setName(resultSet.getString("name"));
                students.add(student);
            }

        });

        return students;
    }

    @Override
    public void save(Student student) {
        String sql ="insert into student (name,age) values(?,?)";
        jdbcTemplate.update(sql,new Object[]{student.getName(),student.getAge()});

    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
