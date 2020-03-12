package com.imooc.dao;

import com.imooc.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringJdbcTemplateImplTest {

    private ApplicationContext ctx ;
    private StudentDao studentDao;
    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        studentDao = (StudentDao) ctx.getBean("studentDao");
    }
    @After
    public void teardown(){
        ctx = null;
    }
    @Test
    public  void testQuery(){

        List<Student> students = studentDao.query();
        for (Student student: students
        ) {
            System.out.println("id:"+student.getId()+",name:"+
                    student.getName()+",age:"+student.getAge());

        }
    }

    @Test
    public  void testSave(){

        Student student =new Student();
        student.setName("xiaoming");
        student.setAge(60);
        studentDao.save(student);

    }
}
