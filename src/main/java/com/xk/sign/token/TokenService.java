package com.xk.sign.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.xk.sign.bean.Root;
import com.xk.sign.bean.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("tokenService")
public class TokenService {

    private static final long EXPIRE_TIME = 999 * 60 * 1000;

    public String getToken(User user) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        String token = "";
        System.out.println(date);
        token = JWT.create().withAudience(user.getId() + "")
                .withExpiresAt(date)
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

    public String getToken(Root root) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        String token = "";
        token = JWT.create().withAudience(root.getId() + "")
                .withExpiresAt(date)
                .sign(Algorithm.HMAC256(root.getPassword()));
        return token;
    }
}
