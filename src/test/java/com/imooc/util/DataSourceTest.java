package com.imooc.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class DataSourceTest {
    private ApplicationContext  ctx= null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
    }
    @After
    public void teardown(){
        ctx = null;
    }

    @Test
    public void testDataSource(){
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        Assert.assertNotNull(dataSource);

    }

    @Test
    public void testJdbcTemplate(){
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        Assert.assertNotNull(jdbcTemplate);

    }
}
