package top.dadagum.encode.common;

import top.dadagum.encode.bits.BitString;
import top.dadagum.encode.bits.SimpleBitString;

/**
 * @Description 比特串工具类
 * 功能：
 * 1. 比特串的异或操作
 * 2. 置换操作（初始置换 / 选择置换 / 扩展置换）
 * 3. 比特串的批量拷贝
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

    /**
     * 置换操作
     * @param mapping 映射表
     * @param bits 原比特串
     * @return 返回置换后的新的比特串
     */
    public static BitString replaceAndGet(int[] mapping, BitString bits) {
        byte[] bytes = new byte[mapping.length];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = bits.at(mapping[i]);
        }
        return new SimpleBitString(bytes);
    }

}
