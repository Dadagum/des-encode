package top.dadagum.encode.bits;


/**
 * @Description 默认的比特串实现
 * @Author Honda
 * @Date 2019/4/8 10:43
 **/
public class SimpleBitString implements BitString {

    protected byte[] bits;

    private int length;

    public SimpleBitString(byte[] bits) {
        this.bits = bits;
        length = bits.length;
    }

    public SimpleBitString(byte[] bits, int start, int length) {
        this.bits = new byte[length];
        this.length = length;
        System.arraycopy(bits, start, bits, 0, length);
    }

    public int length() {
        return length;
    }

    public byte at(int pos) {
        return bits[pos];
    }

    public void set(int pos, byte value) {
        bits[pos] = value;
    }

    public void replace(int[] mapping) {
        byte[] bytes = new byte[mapping.length];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = bits[mapping[i]];
        }
        bits = bytes;
    }

    /**
     * 得到当前比特串的副本(返回协变)
     */
    public SimpleBitString copy() {
        byte[] tmp = new byte[length];
        System.arraycopy(bits, 0, tmp, 0, length);
        return new SimpleBitString(tmp);
    }

    /**
     * 循环左移操作
     * @param cnt 左移步数
     */
    public void shiftLeft(int cnt) {
        byte[] bytes = new byte[length];
        for (int i = 0; i < length - cnt; i++) {
            bytes[i] = bits[i+cnt];
        }
        for (int i = length - cnt, j = 0; i < length; i++, j++) {
            bytes[i] = bits[j];
        }
        bits = bytes;
    }

}
