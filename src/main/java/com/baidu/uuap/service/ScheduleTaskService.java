package com.baidu.uuap.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by jiashiqing on 17/10/27.
 */
@Service
public class ScheduleTaskService {
    private static final Logger log = LoggerFactory.getLogger(ScheduleTaskService.class);

    @Autowired
    Job importUserJob;

    @Scheduled(initialDelay = 1000, fixedRate = 5000)
    public void execute() throws Exception {

//        log.info("ScheduleTaskService。。。");

    }

}
