package com.xk.sign.mapper;

import com.xk.sign.bean.SignTime;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository("signTimeMapper")
public interface SignTimeMapper {
    void addIndexTime(HashMap<String, Object> map);

    SignTime findIndexTime(Integer userId, Integer weekly);

    void addTime(HashMap<String, Object> map);

    void deleteIndexTime(HashMap<String, Object> map);

    List<SignTime> findTimeData();

    void delSignTimeIds(Integer integer);

    void clearIndexTime();

    void createUserIdByUser();

    void updateWeekly(Integer weekly);

    Float getTotalTime(Integer id);

    void createSignTimeByUserId(Integer weekly, Integer userId);

    Float queryUserSignInfoById(HashMap<String, Object> map);
}
