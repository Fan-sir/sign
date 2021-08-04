package com.xk.sign.service;

import java.util.HashMap;
import java.util.List;

public interface SignTimeService {

    HashMap<String, Object> getTimeData();

    HashMap<String, Object> delSignTimeIds(List<Integer> list);
}
