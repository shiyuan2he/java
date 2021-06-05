package org.hsy.java.security.aes;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
/**
 * AES加解密工具类
 * AES加密算法是密码学中的高级加密标准（Advanced Encryption Standard，AES），
 * 又称Rijndael加密法，是美国联邦政府采用的一种区块加密标准。
 * 这个标准用来替代原先的DES，已经被多方分析且广为全世界所使用。
 * AES 是一个新的可以用于保护电子数据的加密算法。明确地说，AES是一个迭代的、对称密钥分组的密码，
 * 它可以使用128、192 和 256 位密钥，并且用 128 位（16字节）分组加密和解密数据。
 * 与公共密钥密码使用密钥对不同，对称密钥密码使用相同的密钥加密和解密数据。
 * 通过分组密码返回的加密数据 的位数与输入数据相同。迭代加密使用一个循环结构，
 * 在该循环中重复置换（permutations ）和替换(substitutions）输入数据。
 *
 * @author heshiyuan
 * @date 2017/12/22 10:55
 */
public class AesHelper {

    private static final String initSaltCode = "lima";

    private static final String ALGORITHM_AES = "AES";
    private static final String MODE_AES = "ECB";
    private static final String PADDING_AES = "PKCS5Padding";

    // 支持：128, 192, 256，生成一个128位的随机源,根据传入的字节数组
    private static final Integer[] SECRET_LENGTH = {128, 192, 256};

    /**
     * 加密
     * 1.构造密钥生成器
     * 2.根据encodeRules规则初始化密钥生成器
     * 3.产生密钥
     * 4.创建和初始化密码器
     * 5.内容加密
     * 6.返回字符串
     */
    public static String encode(String content) {
        return encode(content, null);
    }
    public static String encode(String content, String saltCode) {
        try {
            //1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator keygen = KeyGenerator.getInstance(ALGORITHM_AES);
            /**
             * 2.根据saltCode规则初始化密钥生成器
             *
             */
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(null==saltCode?initSaltCode.getBytes():saltCode.getBytes());
            keygen.init(SECRET_LENGTH[0], random);
            //3.产生原始对称密钥
            SecretKey original_key = keygen.generateKey();
            //4.获得原始对称密钥的字节数组
            byte[] raw = original_key.getEncoded();
            //5.根据字节数组生成AES密钥
            SecretKey key = new SecretKeySpec(raw, ALGORITHM_AES);
            /**
             * 6.根据指定算法AES自成密码器,缺省的mode为ECB，缺省的padding为PKCS5Padding
             */
            Cipher cipher = Cipher.getInstance(ALGORITHM_AES + "/" + MODE_AES + "/" + PADDING_AES);
            //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.ENCRYPT_MODE, key);
            //8.获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
            byte[] byte_encode = content.getBytes(StandardCharsets.UTF_8);
            //9.根据密码器的初始化方式--加密：将数据加密
            byte[] byte_AES = cipher.doFinal(byte_encode);
            //10.将加密后的数据转换为字符串
            String AES_encode = new String(Base64.getEncoder().encode(byte_AES));
            //11.将字符串返回
            return AES_encode;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     * 解密过程：
     * 1.同加密1-4步
     * 2.将加密后的字符串反纺成byte[]数组
     * 3.将加密内容解密
     */
    public static String decode(String content) {
        try {
            //1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator keygen = KeyGenerator.getInstance(ALGORITHM_AES);
            //2.根据ecnodeRules规则初始化密钥生成器
            //生成一个128位的随机源,根据传入的字节数组
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(initSaltCode.getBytes());
            keygen.init(SECRET_LENGTH[0], random);
            //3.产生原始对称密钥
            SecretKey original_key = keygen.generateKey();
            //4.获得原始对称密钥的字节数组
            byte[] raw = original_key.getEncoded();
            //5.根据字节数组生成AES密钥
            SecretKey key = new SecretKeySpec(raw, "AES");
            //6.根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance(ALGORITHM_AES + "/" + MODE_AES + "/" + PADDING_AES);
            //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.DECRYPT_MODE, key);
            //8.将加密并编码后的内容解码成字节数组
            byte[] byte_content = Base64.getDecoder().decode(content);
            /*
             * 解密
             */
            byte[] byte_decode = cipher.doFinal(byte_content);
            String AES_decode = new String(byte_decode, "utf-8");
            return AES_decode;
        } catch (NoSuchAlgorithmException |
                 NoSuchPaddingException |
                 InvalidKeyException |
                 IOException |
                 IllegalBlockSizeException |
                 BadPaddingException e) {
            e.printStackTrace();
        }
        //如果有错就返加nulll
        return null;
    }
}
