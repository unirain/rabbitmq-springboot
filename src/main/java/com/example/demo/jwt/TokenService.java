package com.example.demo.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.entity.Ac01;
import org.springframework.stereotype.Service;

import java.util.Date;

/********************************************************************************
 *
 * Title: token服务
 *
 * Description:
 *
 * @author chenlm
 * create date on 2018/12/19
 *
 *******************************************************************************/
@Service
public class TokenService {
    /**
     * 获取token
     * @param ac01
     * @return
     */
    public String getToken(Ac01 ac01){
        String token= JWT.create().withAudience(ac01.getAac002()).withClaim("ip","192.168.1.1").sign(Algorithm.HMAC256(ac01.getPassword()));
        return token;
    }

}
