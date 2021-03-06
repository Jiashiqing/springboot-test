package com.baidu.uuap.service.listener;

import com.baidu.uuap.pojo.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Job执行监听器
 */
@Component("jobCompletionNotificationListener")
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final String PERSON_SQL = "SELECT name, age,sex FROM Person";

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
        if (this.jdbcTemplate == null) {
            this.jdbcTemplate = jdbcTemplate;
        }
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!JOB 执行完成!");
            List<Person> results = jdbcTemplate.query(PERSON_SQL, new RowMapper<Person>() {
                @Override
                public Person mapRow(ResultSet rs, int row) throws SQLException {
                    return new Person(rs.getString(1), rs.getString(2), rs.getString(3));
                }
            });
            log.info("入库条数==" + results.size());
            for (Person person : results) {
                log.info("新增 <" + person.getName() + "> 成功!!!!!");
            }

        }
    }

    /* (non-Javadoc) 
     * @see org.springframework.batch.core.listener.JobExecutionListenerSupport#beforeJob(org.springframework.batch.core.JobExecution) 
     */
    @Override
    public void beforeJob(JobExecution jobExecution) {
        // TODO Auto-generated method stub  
        super.beforeJob(jobExecution);
    }

}  