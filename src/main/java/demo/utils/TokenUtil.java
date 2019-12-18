package demo.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@PropertySource("classpath:application.properties")
public class TokenUtil {

    private static final Logger logger = LoggerFactory.getLogger(TokenUtil.class);

    private static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Value("spring.token.timeout")
    private static int loginTime;

    @Value("spring.token.secretkey")
    private static String secretKey;


    /**
     * 获取token uuid
     *
     * @return
     */
    public static String getTokenId(){
        return UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
    }

    /**
     * base64加密
     * @param data
     * @return
     */
    public static String Base64Encode(String data){
        String result="";
        try {
            byte[] dbs = data.getBytes("utf-8");
            result = Base64.encodeBase64String(dbs);
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage());
        }
        return result;
    }

    /**
     * base64解密
     * @param data
     * @return
     */
    public static String Base64Decode(String data){
        return new String(Base64.decodeBase64(data));
    }

    /**
     *
     * @param data
     * @return
     */
    public static String getTokenString(Map<String ,Object> data){
        String header = Base64Encode("{'typ':'tdy','alg':'MD5'}");
        String plyload = Base64Encode(getPlyload(data.get("user").toString(),
                                    data.get("id").toString()));
        String signature = signature(header+"."+plyload);
        String token=header+"."+plyload+"."+signature;
        return token;
    }

    public static String signature(String message){
        String result="";
        result = DigestUtils.md5Hex(message+secretKey);
        return result;
    }

    public static String getPlyload(String user,String id){
        Long time = new Date().getTime();
        return "{'tdyid':'"+id+"','user':'"+user+"','qfsj':'"+time.toString()+"','gqsj':'"+String.valueOf(time+loginTime*60*1000)+"'}";
    }

}
