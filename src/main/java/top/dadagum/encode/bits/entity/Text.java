package top.dadagum.encode.bits.entity;

import top.dadagum.encode.bits.BitString;
import top.dadagum.encode.bits.SimpleBitString;

/**
 * @Description 明文
 * @Author Honda
 * @Date 2019/4/7 23:13
 **/
public class Text implements BitString {

    private L l;
    private R r;
    private static final int PART_SIZE = 32;

    public Text(byte[] bits_64) {
        l = new L(bits_64, 0, PART_SIZE);
        r = new R(bits_64, PART_SIZE, PART_SIZE);
    }


    public L L() {
        return l;
    }

    public R R() {
        return r;
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
            return l.at(pos);
        }
        return r.at(pos - PART_SIZE);
    }

    public void set(int pos, byte value) {
    }

    /**
     * R部分
     */
    private class R extends SimpleBitString {

        public R(byte[] bits) {
            super(bits);
        }

        public R(byte[] bits, int start, int length) {
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
     * L部分
     */
    private class L extends SimpleBitString {

        public L(byte[] bits) {
            super(bits);
        }

        public L(byte[] bits, int start, int length) {
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
