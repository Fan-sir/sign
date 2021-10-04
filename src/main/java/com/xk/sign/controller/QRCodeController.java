package com.xk.sign.controller;

import com.auth0.jwt.JWT;
import com.xk.sign.bean.User;
import com.xk.sign.token.LoginToken;
import com.xk.sign.util.QRCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@Slf4j
@RequestMapping("/qrcode")
public class QRCodeController {

    private static final long SIGN_USER = 3 * 1000;//签到可用时长范围
    private static final String url = "http://www.xkyun.top:12032";//扫码跳转链接

    @GetMapping("/signIn")
    @LoginToken
    public String signInQRCode(HttpServletResponse response) {
        StringBuffer urlS = new StringBuffer(url);

        urlS.append("/menu/signIn?expirationTime=");
        urlS.append(System.currentTimeMillis() + SIGN_USER);
        String codeContent = String.valueOf(urlS);
        System.out.println("codeContent=" + codeContent);
        /*
         * 调用工具类生成二维码并输出到输出流中
         */
        String qrcode = QRCodeUtil.createCodeToOutputStream(codeContent);
        log.info("成功生成二维码!");
        return qrcode;
    }

    @GetMapping("/signOut")
    @LoginToken
    public String signOutQRCode(HttpServletResponse response) {
        StringBuffer urlS = new StringBuffer(url);
        urlS.append("/menu/signOut?expirationTime=");
        urlS.append(System.currentTimeMillis() + SIGN_USER);
        String codeContent = String.valueOf(urlS);
        System.out.println("codeContent=" + codeContent);
        /*
         * 调用工具类生成二维码并输出到输出流中
         */
        String qrcode = QRCodeUtil.createCodeToOutputStream(codeContent);
        log.info("成功生成二维码!");

        return qrcode;
    }

}
