package com.example.demo.utils;

/**
 * @author wangfeng
 * @date 2017/11/21
 */
public class Tea {
    private final static int[] KEY = new int[]{
            // 加密解密所用的KEY
            0x789f5645, 0xf68bd5a4,
            0x81963ffb, 0x458fac54
    };

    /**
     * 加密
     *
     * @param content 加密内容
     * @param offset 补偿位
     * @param key 秘钥
     * @param times   加密轮数
     * @return 加密后的byte[]
     */
    public static byte[] encrypt(byte[] content, int offset, int[] key, int times) {
        int[] tempInt = byteToInt(content, offset);
        int y = tempInt[0], z = tempInt[1], sum = 0, i;
        // 这是算法标准给的值
        int delta = 0x9e3779b9;
        int a = key[0], b = key[1], c = key[2], d = key[3];
        for (i = 0; i < times; i++) {
            sum += delta;
            y += ((z << 4) + a) ^ (z + sum) ^ ((z >> 5) + b);
            z += ((y << 4) + c) ^ (y + sum) ^ ((y >> 5) + d);
        }
        tempInt[0] = y;
        tempInt[1] = z;
        return intToByte(tempInt, 0);
    }

    /**
     * 解密
     *
     * @param encryptContent 解密的byte[]
     * @param offset 补偿位
     * @param key 秘钥
     * @param times 解密伦数
     * @return 解密后的byte[]
     */
    public static byte[] decrypt(byte[] encryptContent, int offset, int[] key, int times) {
        int[] tempInt = byteToInt(encryptContent, offset);
        int y = tempInt[0], z = tempInt[1], sum, i;
        // 这是算法标准给的值
        int delta = 0x9e3779b9;
        int a = key[0], b = key[1], c = key[2], d = key[3];
        int times32 =32;
        int times16 = 16;
        if (times == times32) {
             /* delta << 5*/
            sum = 0xC6EF3720;
        } else if (times == times16) {
             /* delta << 4*/
            sum = 0xE3779B90;
        } else {
            sum = delta * times;
        }
        for (i = 0; i < times; i++) {
            z -= ((y << 4) + c) ^ (y + sum) ^ ((y >> 5) + d);
            y -= ((z << 4) + a) ^ (z + sum) ^ ((z >> 5) + b);
            sum -= delta;
        }
        tempInt[0] = y;
        tempInt[1] = z;

        return intToByte(tempInt, 0);
    }

    /**
     * byte[]型数据转成int[]型数据
     * @param content 内容
     * @param offset 补偿位
     * @return 转换后的int[]
     */
    private static int[] byteToInt(byte[] content, int offset) {
        //除以2的n次方 == 右移n位 即 content.length / 4 == content.length >> 2
        int[] result = new int[content.length >> 2];
        int step = 4;
        for (int i = 0, j = offset; j < content.length; i++, j += step) {
            result[i] = transform(content[j + 3]) | transform(content[j + 2]) << 8 |
                    transform(content[j + 1]) << 16 | (int) content[j] << 24;
        }
        return result;

    }

    /**
     * int[]型数据转成byte[]型数据
     *
     * @param content int数组
     * @param offset 补偿位
     * @return  byte[]
     */
    private static byte[] intToByte(int[] content, int offset) {
        // 乘以2的n次方 == 左移n位 即 content.length * 4 == content.length << 2
        byte[] result = new byte[content.length << 2];
        int step = 4;
        for (int i = 0, j = offset; j < result.length; i++, j += step) {
            result[j + 3] = (byte) (content[i] & 0xff);
            result[j + 2] = (byte) ((content[i] >> 8) & 0xff);
            result[j + 1] = (byte) ((content[i] >> 16) & 0xff);
            result[j] = (byte) ((content[i] >> 24) & 0xff);
        }
        return result;
    }

    /**
     * 若某字节为负数则需将其转成无符号正数
     *
     * @param temp 转换的值
     * @return 转换后的值
     */
    private static int transform(byte temp) {
        int tempInt = (int) temp;
        if (tempInt < 0) {
            tempInt += 256;
        }
        return tempInt;
    }

    /**
     * @param info  加密的信息
     * @return 通过TEA算法加密信息
     */
    public static byte[] encryptByTea(String info) {
        byte[] temp = info.getBytes();
        // 若temp的位数不足8的倍数,需要填充的位数
        int n = 8 - temp.length % 8;
        byte[] encryptStr = new byte[temp.length + n];
        encryptStr[0] = (byte) n;
        System.arraycopy(temp, 0, encryptStr, n, temp.length);
        byte[] result = new byte[encryptStr.length];
        int step = 8;
        for (int offset = 0; offset < result.length; offset += step) {
            byte[] tempEncrpt = encrypt(encryptStr, offset, KEY, 32);
            System.arraycopy(tempEncrpt, 0, result, offset, 8);
        }
        return result;
    }

    /**
     *  通过TEA算法解密信息
     * @param secretInfo 密码 byte[]
     * @return 解密结果
     */
    private static String decryptByTea(byte[] secretInfo) {
        byte[] decryptStr = null;
        byte[] tempDecrypt = new byte[secretInfo.length];
        int step = 8;
        for (int offset = 0; offset < secretInfo.length; offset += step) {
            decryptStr = decrypt(secretInfo, offset, KEY, 32);
            System.arraycopy(decryptStr, 0, tempDecrypt, offset, 8);
        }

        int n = tempDecrypt[0];
        if (decryptStr != null) {
            return new String(tempDecrypt, n, decryptStr.length - n);
        } else {
            return new String(tempDecrypt, n, 0 - n);
        }

    }

    /**
     * 将产生的16进制密码转换成字母
     * @param imei 手机串号
     * @return 加密后的密码
     */
    public static String createKey(String imei) {
        byte[] encryptInfo = Tea.encryptByTea(imei);
        StringBuilder str = new StringBuilder();
        for (byte b : encryptInfo) {
            int num = b;
            if (num < 0) {
                num = -num;
            }
            int cn = num % 26 + 65;
            char c = (char) cn;
            str.append(c);
        }
        return str.toString();
    }
}