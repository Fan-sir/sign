package com.xk.sign.service;

import java.util.HashMap;

public interface MenuService {

    HashMap<String, String> signIn(Integer userNo);

    HashMap<String, String> signOut(Integer userNo);
}
