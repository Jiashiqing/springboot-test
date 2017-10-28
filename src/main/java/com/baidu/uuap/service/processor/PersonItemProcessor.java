package com.baidu.uuap.service.processor;

import com.baidu.uuap.pojo.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 中间转换器
 */
public class PersonItemProcessor implements ItemProcessor<Person, Person> {
    //查询  
    private static final String GET_PRODUCT = "select * from Person where name = ?";

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Person process(final Person person) throws Exception {
        List<Person> personList = jdbcTemplate.query(GET_PRODUCT, new Object[]{person.getName()}, new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                Person p = new Person();
                p.setName(resultSet.getString(1));
                p.setAge(resultSet.getString(2));
                p.setSex(resultSet.getString(3));
                return p;
            }
        });
        if (personList.size() > 0) {
            log.info("该数据已录入!!!");
        }
        String sex = null;
        if (person.getSex().equals("male")) {
            sex = "famale";
        } else {
            sex = "male";
        }
        log.info("转换 (性别：" + person.getSex() + ") 为 (" + sex + ")");
        final Person transformedPerson = new Person(person.getName(), person.getAge(), sex);
        log.info("转换 (" + person + ") 为 (" + transformedPerson + ")");

        return transformedPerson;
    }

}  