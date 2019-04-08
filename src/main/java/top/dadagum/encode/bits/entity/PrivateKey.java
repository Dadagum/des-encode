package top.dadagum.encode.bits.entity;

import top.dadagum.encode.bits.BitString;
import top.dadagum.encode.bits.SimpleBitString;

/**
 * @Description 密钥
 * @Author Honda
 * @Date 2019/4/7 21:02
 **/
public class PrivateKey implements BitString {

    private C c;
    private D d;
    private static final int PART_SIZE = 32;

    public PrivateKey(byte[] bits_64) {
        c = new C(bits_64, 0, PART_SIZE);
        d = new D(bits_64, PART_SIZE, PART_SIZE);
    }


    public C C() {
        return c;
    }

    public D D() {
        return d;
    }

    /**
     * L和R合并
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
    }

    /**
     * C部分
     */
    private class C extends SimpleBitString {

        public C(byte[] bits) {
            super(bits);
        }

        public C(byte[] bits, int start, int length) {
            super(bits, start, length);
        }

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
    private class D extends SimpleBitString {

        public D(byte[] bits) {
            super(bits);
        }

        public D(byte[] bits, int start, int length) {
            super(bits, start, length);
        }

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
}
