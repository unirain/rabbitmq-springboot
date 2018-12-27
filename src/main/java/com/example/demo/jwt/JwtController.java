package com.example.demo.jwt;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.entity.Ac01;
import oracle.jdbc.proxy.annotation.Post;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/********************************************************************************
 *
 * Title: token控制器
 *
 * Description:
 *
 * @author chenlm
 * create date on 2018/12/19
 *
 *******************************************************************************/
@RestController
public class JwtController {
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public Map login(@RequestBody Ac01 ac01){
        String a="{\"aud\":\"33333398\",\"ip\":\"192.168.1.1\"}";
        Map<String,Object> map=new HashMap<>();
        //是否登陆成功
        if (ac01.getAac001().equals(123L)){
            map.put("resultCode","1");
            map.put("resultMessage","登陆成功！");
            map.put("token",tokenService.getToken(ac01));
            map.put("user",ac01);
            DecodedJWT decodedJWT=JWT.decode((String) map.get("token"));
            System.out.println(decodedJWT.getHeader());
            System.out.println(decodedJWT.getPayload());
            System.out.println(decodedJWT.getSignature());
            String payload = Base64.encodeBase64URLSafeString(a.getBytes(StandardCharsets.UTF_8));
            System.out.println(payload);
            JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(ac01.getPassword())).build();
            jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzMzMzMzM5OCIsImlwIjoiMTkyLjE2OC4xLjEifQ.e_93LDyWdQIDdUz9Za-UB02s25PM2VczGUE1rXveD6Q");
        }else {
            map.put("resultCode","0");
            map.put("resultMessage","登陆失败！");
        }
        return map;
    }



}
