package top.dadagum.encode.common;

/**
 * @Description 常量，主要用于记录映射表
 * @Author Honda
 * @Date 2019/4/8 14:14
 **/
public class Mapping {

    /**
     * 明文的初始置换映射表
     */
    public static final int[] IR = {};

    /**
     * 密钥的置换选择1映射表
     */
    public static final int[] RS_ONE = {};

    /**
     * 置换选择2映射表
     */
    public static final int[] RS_TWO = {};

    /**
     * 明文的逆初始置换映射表
     */
    public static final int[] REVERSE_IR = {};

    /**
     * 沙盒
     */
    public static final int[][] SAND_BOX = {
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {}
    };

    /**
     * 密钥左移动轮次
     */
    public static final int[] ROUND = {};
}
