package com.xk.sign.task;


import com.xk.sign.mapper.SignTimeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TimedTask {

    private SignTimeMapper signTimeMapper;

    @Scheduled(cron = "0 0 0 * * ?")
    public void clearIndexTime(){
        signTimeMapper.clearIndexTime();
        System.out.println("清除IndexTime执行了");
    }

    @Scheduled(cron = "0 0 0 ? * 2")
    public void createNextWeekly(){
        signTimeMapper.createUserIdByUser();
        signTimeMapper.updateWeekly();
        System.out.println("createNextWeekly执行了");
    }

}
