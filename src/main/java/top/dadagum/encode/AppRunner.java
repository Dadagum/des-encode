package top.dadagum.encode;

import top.dadagum.encode.bits.entity.PrivateKey;
import top.dadagum.encode.bits.entity.Text;

/**
 * @Description des 加密过程
 * 64位明文 -> 初始置换 -> 16函数迭代 -> 输出64比特流 -> 左右相互换 -> 逆初始置换 -> 64位密文
 * 64为密钥 -> 56位密钥 -> 置换选择1 -> 循环左移和置换Ki
 * @Author Honda
 * @Date 2019/3/28 20:28
 **/
public class AppRunner {

    private static byte[] pk = {0,0,0,0,0,0,1,0,
            1,0,0,1,0,1,1,0,
            0,1,0,0,1,0,0,0,
            1,1,0,0,0,1,0,0,
            0,0,1,1,1,0,0,0,
            0,0,1,1,0,0,0,0,
            0,0,1,1,1,0,0,0,
            0,1,1,0,0,1,0,0 };

    private static byte[] text1 = {0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0};

    private static byte[] text2 = {0,0,0,0,0,0,0,0,
            1,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0};
    /**
     * 测试加密
     * @param args
     */
    public static void main(String[] args) {
//        byte[] encoded = Des.encode(text1, pk);
//        for (int i = 0; i < encoded.length; i++) {
//            System.out.print(encoded[i] + " ");
//        }
        String encoded2 = Des.encode("12345678", "12345678");
        System.out.println(encoded2);
    }
}
