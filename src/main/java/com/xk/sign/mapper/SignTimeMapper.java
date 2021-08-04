package com.xk.sign.mapper;

import com.xk.sign.bean.SignTime;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository("signTimeMapper")
public interface SignTimeMapper {
    void addIndexTime(HashMap<String,Object> map);

    SignTime findIndexTime(Integer id);

    void addTime(HashMap<String, Object> map);

    void deleteIndexTime(HashMap<String, Object> map);

    List<SignTime> findTimeData();

    void delSignTimeIds(Integer integer);
}
