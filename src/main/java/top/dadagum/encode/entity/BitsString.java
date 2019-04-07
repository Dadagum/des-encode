package top.dadagum.encode.entity;

/**
 * 表示比特串
 */
public class BitsString {

    protected byte[] bits;

    /**
     * 从bitString中构造新的比特串
     * @param bitString 长的比特串
     * @param begin 从bitString开始拷贝的位置
     * @param length 拷贝的长度
     */
    public BitsString(byte[] bitString, int begin, int length) {
        bits = new byte[length];
        System.arraycopy(bitString, begin, bits, 0, length);
    }

    /**
     * 返回比特串第pos位置的值
     * @param pos 位置
     * @return 0或者1
     */
    public byte at(int pos) {
        return bits[pos];
    }
}
