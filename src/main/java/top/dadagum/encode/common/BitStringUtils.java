package top.dadagum.encode.common;

import top.dadagum.encode.bits.BitString;
import top.dadagum.encode.bits.SimpleBitString;

/**
 * @Description 比特串工具类
 * 功能：
 * 1. 比特串的异或操作
 * 默认返回的比特串都是SimpleBitString类型
 * @Author Honda
 * @Date 2019/4/7 23:59
 **/
public class BitStringUtils {

    /**
     * 比特串的异或操作（这两个比特串的长度需要一样）
     * @param bs1
     * @param bs2
     * @return 异或后的比特串
     */
    public static BitString XOR(BitString bs1, BitString bs2) {
        byte[] bytes = new byte[bs1.length()];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bs1.at(i) ^ bs2.at(i));
        }
        return new SimpleBitString(bytes);
    }
}
