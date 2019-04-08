package top.dadagum.encode;

import top.dadagum.encode.bits.BitString;
import top.dadagum.encode.bits.SimpleBitString;
import top.dadagum.encode.bits.entity.PrivateKey;
import top.dadagum.encode.bits.entity.Text;
import top.dadagum.encode.common.BitStringUtils;
import top.dadagum.encode.common.Mapping;

/**
 * @Description des算法加密入口
 * @Author Honda
 * @Date 2019/4/8 14:47
 **/
public class Des {

    /**
     * 沙盒的长
     */
    private static final int SB_LEN = 16;

    /**
     * 沙盒的输入比特位
     */
    private static final int SB_IN = 6;

    /**
     * 沙盒的输出比特位
     */
    private static final int SB_OUT = 4;

    /**
     * 对明文进行des加密
     * @param text 明文
     * @param key 密钥
     * @return 密文
     */
    public static void encode(Text text, PrivateKey key) {
        text.replace(Mapping.IR); // 明文的初始置换
        key.replace(Mapping.RS_ONE); // 密钥的置换选择
        // 进行16轮
        for (int i = 0; i < Mapping.ROUND.length; i++) {
            // 进行密钥的变换
            // 循环左移
            key.L().shiftLeft(Mapping.ROUND[i]);
            key.R().shiftLeft(Mapping.ROUND[i]);
            // 拷贝一份密钥参与置换选择2
            PrivateKey pk = key.copy();
            // 进行置换选择2
            pk.replace(Mapping.RS_TWO);

            // 进行明文的变换
            // 拷贝一份LR
            SimpleBitString bR = text.R().copy();
            SimpleBitString bL = text.L().copy();
            // R进行扩充变换
            bR.replace(Mapping.E);
            // 和pk进行异或操作
            BitString tmp1 = BitStringUtils.XOR(pk, bR);
            // 沙盒操作
            tmp1 = toSandBox(tmp1);
            // 进行置换P
            tmp1.replace(Mapping.P);
            // bL和tmp1进行异或
            tmp1 = BitStringUtils.XOR(tmp1, bL);

            // 得到新一轮的“明文”
            text.setL(bR);
            text.setR((SimpleBitString) tmp1);
        }
        // 左右互换得到预输出
        SimpleBitString bR = text.R();
        text.setR(text.L());
        text.setL(bR);
        // 进行逆初始置换，得到最终密文
        text.replace(Mapping.REVERSE_IR);
    }

    /**
     * 进行沙盒操作
     * @param bits
     * @return
     */
    private static BitString toSandBox(BitString bits) {
        byte[] bytes = new byte[Mapping.SAND_BOX.length * SB_OUT];
        int curr = 0;
        for (int i = 0, s = 0; i < Mapping.SAND_BOX.length; i++, s += SB_IN) {
            int row = bits.at(s) * 2 + bits.at(s + SB_IN - 1);
            int column = 0;
            for (int j = s + SB_IN - 2; j > s; j--) {
                column = column * 2 + bits.at(j);
            }
            int value = Mapping.SAND_BOX[i][SB_LEN * row + column];
            // 新的输出4位
            for (int j = 0; j < SB_OUT; j++) {
                bytes[curr++] = (byte) (value & 1);
                value = value >> 1;
            }
        }
        return new SimpleBitString(bytes);
    }
}
