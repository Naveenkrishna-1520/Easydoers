package com.easydoers.employeeservice.configuration;

import com.easydoers.employeeservice.jobs.SendingEmailToEmployee;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzEmailConfig {

    @Bean
    public JobDetail emailJobDetail() {
        return JobBuilder.newJob(SendingEmailToEmployee.class)
                .withIdentity("emailJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger dailyEmailTrigger() {
        return TriggerBuilder.newTrigger()
                .forJob(emailJobDetail())
                .withIdentity("dailyEmailTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 9 * * ?")) // 9:00 AM every day
                .build();
    }
}
