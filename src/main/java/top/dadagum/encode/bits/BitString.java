package top.dadagum.encode.bits;

/**
 * 比特串
 */
public interface BitString {

    /**
     * 得到比特串的长度
     * @return 比特串的长度
     */
    int length();

    /**
     * 返回比特串第pos位置的值
     * @param pos 位置
     * @return 0或者1
     */
    byte at(int pos);

    /**
     * 设置比特串位置pos的值
     * @param pos 位置pos
     * @param value 0 或者 1
     */
    void set(int pos, byte value);

    /**
     * 置换操作（初始置换 / 选择置换 / 扩展置换）
     * @param mapping 映射表
     */
    void replace(int[] mapping);

    /**
     * 得到当前比特串的副本
     */
    BitString copy();

    /**
     * 比特串进行左移动
     * @param cnt 移动位数
     */
    void shiftLeft(int cnt);
}
