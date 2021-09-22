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
    public void signInQRCode(HttpServletResponse response) {
        StringBuffer urlS = new StringBuffer(url);

        urlS.append("/menu/signIn?");
        urlS.append(System.currentTimeMillis() + SIGN_USER);
        String codeContent = String.valueOf(urlS);
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
    }

    @GetMapping("/signOut")
    @LoginToken
    public void signOutQRCode(HttpServletResponse response) {
        StringBuffer urlS = new StringBuffer(url);
        urlS.append("/menu/signOut");
        urlS.append(System.currentTimeMillis() + SIGN_USER);
        String codeContent = String.valueOf(urlS);
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
    }

}
