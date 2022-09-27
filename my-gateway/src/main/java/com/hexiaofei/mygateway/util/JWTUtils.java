package com.hexiaofei.mygateway.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author lcyj
 * @date 2022-03-01 09:10
 * @since
 */
public class JWTUtils {

    /**
     * 密钥，仅服务端存储
     */
    private static String secret = "ksjkJKSJSS*7J2K2K@%$&&_SSDFJjsjdh83j23";

    private static int EXPIRATION_SOUND = 10 * 1000;


    public static String createToken(String subject){
        Date currentDate = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.SECOND, EXPIRATION_SOUND);

        String compactJws = Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(currentDate)
                .setExpiration(calendar.getTime())

                .signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, secret)
                .compact();

        return compactJws;
    }

    public static String parseToken(String cipher){
        Claims parse = Jwts.parser().setSigningKey(secret).parseClaimsJws(cipher).getBody();
        String subject = null;
        if(parse != null){
            subject = parse.getSubject();
        }
        return subject;
    }

    public static void main(String[] args) throws InterruptedException {
        String token = createToken("userid=lisi,role=admin,price=398");
        System.out.println(token);

        for(int i = 1 ; i <= EXPIRATION_SOUND-3 ; i++ ){
            TimeUnit.SECONDS.sleep(1);
            System.out.println(i+"s");
        }

        System.out.println(parseToken(token));
    }
}
