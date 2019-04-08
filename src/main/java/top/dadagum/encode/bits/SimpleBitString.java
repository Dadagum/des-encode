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
}
