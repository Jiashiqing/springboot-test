package com.baidu.uuap.service.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by jiashiqing on 17/10/27.
 */
@Service
public class ScheduleTaskService {
    private static final Logger log = LoggerFactory.getLogger(ScheduleTaskService.class);

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    @Qualifier("csvJob")
    Job job;

//    @Scheduled(initialDelay = 1000, fixedRate = 10000)
    public void execute() throws Exception {

        JobParameters jobParameters =
                new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();

        jobLauncher.run(job, jobParameters);

        log.info("ScheduleTaskService......" + job.getName());

    }

}
