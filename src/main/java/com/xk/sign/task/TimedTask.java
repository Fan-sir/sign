package com.xk.sign.task;


import com.xk.sign.mapper.SignTimeMapper;
import com.xk.sign.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class TimedTask {

    @Resource(name = "signTimeMapper")
    private SignTimeMapper signTimeMapper;

    @Resource(name = "timeUtil")
    private TimeUtil timeUtil;

    @Scheduled(cron = "0 0 0 * * ?")
    public void clearIndexTime(){
        signTimeMapper.clearIndexTime();
        System.out.println("清除IndexTime执行了");
    }

    @Scheduled(cron = "0 0 0 ? * 1")
    public void createNextWeekly(){
        Integer weekly = timeUtil.getWeek();
        signTimeMapper.createUserIdByUser();
        signTimeMapper.updateWeekly(weekly);
        System.out.println("createNextWeekly执行了");
    }

}
