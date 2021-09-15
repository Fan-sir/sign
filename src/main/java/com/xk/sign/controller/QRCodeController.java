package com.xk.sign.controller;

import com.auth0.jwt.JWT;
import com.xk.sign.bean.User;
import com.xk.sign.token.LoginToken;
import com.xk.sign.util.QRCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@Slf4j
@RequestMapping("/qrcode")
public class QRCodeController {

    StringBuffer url = new StringBuffer("www.xkyun.top:12032");

    @GetMapping("/signIn")
    @LoginToken
    public void signInQRCode(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader("token");
        long indexTime = Long.parseLong(JWT.decode(token).getAudience().get(1));

        if ((indexTime - System.currentTimeMillis()) < 0) {
            url.append("/menu/singIn");
            String codeContent = String.valueOf(url);
            System.out.println("codeContent=" + codeContent);
            try {
                /*
                 * 调用工具类生成二维码并输出到输出流中
                 */
                QRCodeUtil.createCodeToOutputStream(codeContent, response.getOutputStream());
                log.info("成功生成二维码!");
            } catch (IOException e) {
                log.error("发生错误， 错误信息是：{}！", e.getMessage());
            }
        } else {
            throw new RuntimeException("二维码有效,请直接扫码！");
        }
    }

    @GetMapping("/signOut")
    @LoginToken
    public void signOutQRCode(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader("token");
        long indexTime = Long.parseLong(JWT.decode(token).getAudience().get(1));

        if ((indexTime - System.currentTimeMillis()) < 0) {
            url.append("/menu/signOut");
            String codeContent = String.valueOf(url);
            System.out.println("codeContent=" + codeContent);
            try {
                /*
                 * 调用工具类生成二维码并输出到输出流中
                 */
                QRCodeUtil.createCodeToOutputStream(codeContent, response.getOutputStream());
                log.info("成功生成二维码!");
            } catch (IOException e) {
                log.error("发生错误， 错误信息是：{}！", e.getMessage());
            }
        } else {
            throw new RuntimeException("二维码有效,请直接扫码！");
        }


    }

}
