package top.dadagum.encode;

/**
 * @Description des 加密过程
 * 64位明文 -> 初始置换 -> 16函数迭代 -> 输出64比特流 -> 左右相互换 -> 逆初始置换 -> 64位密文
 * 64为密钥 -> 56位密钥 -> 置换选择1 -> 循环左移和置换Ki
 * @Author Honda
 * @Date 2019/3/28 20:28
 **/
public class AppRunner {

    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
