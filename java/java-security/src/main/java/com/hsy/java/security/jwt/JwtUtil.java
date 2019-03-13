package com.hsy.java.security.jwt;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * java/com.hsy.java.security.jwt
 *
 * @author heshiyuan
 */
public class JwtUtil {
    /**
     * 解密
     * @param jsonWebToken
     * @param base64Security
     * @return
     */
    public static Claims parseJWT(String jsonWebToken, String base64Security) {
        try {
            Claims claims = Jwts.parser().setSigningKey(base64Security.getBytes()).parseClaimsJws(jsonWebToken).getBody();
            return claims;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 前三个参数为自己用户token的一些信息比如id，权限，名称等。不要将隐私信息放入（大家都可以获取到） *
     * @param map
     * @param base64Security
     * @return
     */
    public static String createJWT(Map<String, Object> map, String base64Security) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
                .setPayload(JSONObject.toJSONString(map))
                .signWith(signatureAlgorithm, base64Security.getBytes());
        //估计是第三段密钥
        // 生成JWT
        return builder.compact();
    }
    public static void main(String[] args) {
        String signStr = "9a67a095f404a4c8a20ef2f41436ca16" ;
        /*Map<String, Object> map = new HashMap<>();
        map.put("province", "898765");
        map.put("city", "898765");
        map.put("appkey", "HMu1H/cmyKDOiHv41Y9lLROuOlOo+PPG8F4/RotRmNc=");
        map.put("timestamp", new Date().getTime());
        //密钥
        String keyt = "79e7c69681b8270162386e6daa53d1dc";
        String token = JwtUtil.createJWT(map, keyt);
        System.out.println("JWT加密的结果：" + token);*/
        String newToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRlIjoiNTM2ODUzOWEzYTcwYWRmNzcxYzAyM2EwODQwNDEyOTkwOTEyNTI0OTUwNzRmOTVhNWFjMTliMjk3YzVlNWNlMzc3YWI3OWIyMzM4ZTJlMmJkZGU5ZTk4N2JjZDc2ZmIyMjdhYzFkZDQ3MmRhYzcwZWFjNzZkNTU5YzE4MTA1MDAzMmI3ZTQ3MzgxMTEyNWQzN2VmZDk2ZjFmM2VjNDk0OTdjMWIxZGMyNjYyMjIzMjllMWJiYTQ2MTIyZTk4ZDlhNzU2OTg4MmIyNjc4NGQ1ZWZiMGVhZGE5ZDg2MWZjNDg0ODExM2I4ZWIxMGY3YTc5YjMyNDdhMTEwNzgxYzVlOTJjMzUzZjQ4MmU0Mzk4NGNkMThjYzk1MjY5NGVmYzkzODhmZTQ0OWY3NTZiYjVhZmNhMTMzNjU0OGM4ZDkxNDQ4ZWZiYTNhMGI2YzU4MGRjZDQ3ZDNhMmFjNzNjM2FkODMwMDI1MWEzZDE5NWZjZTdkOWExZWU3OGQwYjkwZjgzNDdiZDMzZmQ0NDczNzdjNTFiNTZmMjgzNDZlNzYzMjc2NmVlNDcwNzU1ZDU4YmE5NWYyNGE3ZWE3NmU3NzI3YzhjOTA1MmE5YWUxYTFjNTljNTMwODkwZGVmMDBmNTBhMzI3MjIwY2FiMTM2ZTVkNThlYjZjODU4ZjBjZmZiYjEiLCJhdWQiOlsib3BlbmFwaSJdLCJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbImFsbCJdLCJleHAiOjE1NTE1MTI2NjUsImF1dGhvcml0aWVzIjpbImFsbCJdLCJqdGkiOiI3YmY0OTgxZS0wZjEyLTQzNjgtOTU2OC1lNzczZWRhZmQ2MDEiLCJjbGllbnRfaWQiOiJ3OGtGWHA5bU12cmZNZVFvN3gydCJ9.EBndO20r1lk8VcxKdMbnZOhpB30-l4q9GIYT76ClG04";
        String newToken2 = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsib3BlbmFwaSJdLCJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbImFsbCJdLCJleHAiOjE1NTE4NjA1MTQsInVzZXJJZCI6MSwiYXV0aG9yaXRpZXMiOlsiYWxsIl0sImp0aSI6Ijk0ZGJhZDBkLTQ2MDgtNDZlZi05YTk0LWYyNmFhMTgyMzU3MSIsImNsaWVudF9pZCI6Inc4a0ZYcDltTXZyZk1lUW83eDJ0In0.PC-uETxrFTFD9Q3-btd-CgVKksyCBNh7yiKoFzPtftY";
        System.out.println("JWT解密的结果：" + parseJWT(newToken2, signStr).get("userId"));
    }
}
