package com.baidu.uuap.service.processor;

import com.baidu.uuap.pojo.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

/**
 * 中间转换器
 */
public class CsvItemProcessor extends ValidatingItemProcessor<Person> {

    private static final Logger log = LoggerFactory.getLogger(CsvItemProcessor.class);

    @Override
    public Person process(final Person person) throws ValidationException {
        super.process(person);

        if ("male".equals(person.getSex())) {
            person.setSex("famale");
        } else {
            person.setSex("male");
        }

        return person;
    }

}  