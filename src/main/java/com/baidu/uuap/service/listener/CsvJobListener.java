package com.baidu.uuap.service.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

/**
 * Job执行监听器
 */
@Component("csvJobListener")
public class CsvJobListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(CsvJobListener.class);

    long startTime;
    long endTime;


    @Override
    public void beforeJob(JobExecution jobExecution) {
        startTime = System.currentTimeMillis();
        System.out.println("Job start!!!");

    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        endTime = System.currentTimeMillis();
        System.out.println("Job end!!!");
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }

}  