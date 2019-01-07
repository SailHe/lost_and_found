package com.nit.cs161.lost_and_found.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Description: 安全散列标准类
 * SHA(Secure Hash Algorithm)安全散列(哈希)算法 : Encrypt(加密); 安全验证; 等<p>
 * _@see
 * https://zh.wikipedia.org/wiki/SHA%E5%AE%B6%E6%97%8F
 * https://blog.csdn.net/joyous/article/details/49898383
 * https://dotblogs.com.tw/chhuang/2011/01/19/20883
 *
 * @Package: org.demo
 * @author: SailHe
 * @date: 2019/1/7 16:31
 */
public class SecureHashStandard {

    public enum EnumSHAType {
        MD2("MD2"), MD5("MD5"), SHA_1("SHA-1"), SHA_256("SHA-256"), SHA_384("SHA-384"), SHA_512("SHA-512");
        private String customName;

        EnumSHAType(String customName) {
            this.customName = customName;
        }

        public String getCustomName() {
            return customName;
        }

        public void setCustomName(String customName) {
            this.customName = customName;
        }
    }

    public SecureHashStandard(final EnumSHAType shaType) {
        // MessageDigest 类为应用程序提供信息摘要算法的功能;
        // 信息摘要是安全的单向哈希函数，接收任意大小的数据，并输出固定长度的哈希值。
        try {
            messageDigest = MessageDigest.getInstance(shaType.getCustomName());
        } catch (NoSuchAlgorithmException e) {
            System.err.println("SHA 算法名错误!");
            e.printStackTrace();
        }
    }

    /**
     * Descriptions: 计算并返回字符串使用SHA后的字串<p>
     *
     * @author SailHe
     * @date 2019/1/7 18:07
     */
    public String calcHashValue(final String hashKeyStr) {
        String hashValueStr = null;

        // 只对有效字符串进行处理
        if (hashKeyStr != null && hashKeyStr.length() > 0) {
            // 使用指定的 byte 数组更新摘要。
            messageDigest.update(hashKeyStr.getBytes());
            // 执行诸如填充之类的最终操作完成哈希计算。在调用此方法之后，摘要被重置。(等价于reset)
            byte[] resultByteS = messageDigest.digest();

            // byte[] -> string
            StringBuffer hexStrBuf = new StringBuffer();
            for (byte ele : resultByteS) {
                // 1byte = 8bit : 低8bit有效
                // String hex = Integer.toHexString(0xff & ele);
                // hex  = hex.length() == 1 ? "0" + hex : hex;
                String hex = String.format("%02x", ele);
                hexStrBuf.append(hex);
            }
            hashValueStr = hexStrBuf.toString();
        }

        return hashValueStr;
    }

    public static String SHA256(final String hashKeyStr) {
        return new SecureHashStandard(EnumSHAType.SHA_256).calcHashValue(hashKeyStr);
    }

    public static String SHA512(final String hashKeyStr) {
        return new SecureHashStandard(EnumSHAType.SHA_512).calcHashValue(hashKeyStr);
    }

    private MessageDigest messageDigest;
}
