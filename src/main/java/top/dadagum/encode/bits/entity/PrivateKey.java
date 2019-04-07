package top.dadagum.encode.bits.entity;

import top.dadagum.encode.bits.BitString;

/**
 * @Description 密钥
 * @Author Honda
 * @Date 2019/4/7 21:02
 **/
public class PrivateKey implements BitString {

    /**
     * 一个私钥分成C和D两部分
     */
    private C c;
    private D d;
    private byte[] bits;
    private static final int PART_SIZE = 28;

    public PrivateKey(byte[] bits_56) {
        bits = bits_56;
        this.c = new C();
        this.d = new D();
    }

    public D D() {
        return d;
    }

    public C C() {
        return c;
    }

    /**
     * 密钥合并
     * TODO
     */
    public void combine() {

    }

    public int length() {
        return 2 * PART_SIZE;
    }

    public byte at(int pos) {
        if (pos < 0 || pos >= 2 * PART_SIZE){
            throw new IllegalArgumentException("illegal pos");
        }
        if (pos < PART_SIZE) {
            return c.at(pos);
        }
        return d.at(pos - PART_SIZE);
    }

    public void set(int pos, byte value) {
        bits[pos] = value;
    }

    /**
     * C部分
     */
    private class C implements BitString {

        public int length() {
            return PART_SIZE;
        }

        public byte at(int pos) {
            return bits[pos];
        }

        public void set(int pos, byte value) {
            bits[pos] = value;
        }
    }

    /**
     * D部分
     */
    private class D implements BitString {

        public int length() {
            return PART_SIZE;
        }

        public byte at(int pos) {
            return bits[pos + PART_SIZE];
        }

        public void set(int pos, byte value) {
            bits[pos+PART_SIZE] = value;
        }
    }

}
