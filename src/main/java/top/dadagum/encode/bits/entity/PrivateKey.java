package top.dadagum.encode.bits.entity;

import top.dadagum.encode.bits.BitString;
import top.dadagum.encode.bits.SimpleBitString;

/**
 * @Description 密钥
 * @Author Honda
 * @Date 2019/4/7 21:02
 **/
public class PrivateKey implements BitString {

    private BitString C;
    private BitString D;
    private static final int PART_SIZE = 32;

    public PrivateKey(byte[] bits_64) {
        C = new SimpleBitString(bits_64, 0, PART_SIZE);
        D = new SimpleBitString(bits_64, PART_SIZE, PART_SIZE);
    }


    public BitString C() {
        return C;
    }

    public BitString D() {
        return D;
    }

    public void setC(BitString c) {
        this.C = c;
    }

    public void setD(BitString d) {
        this.D = d;
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
            return C.at(pos);
        }
        return D.at(pos - PART_SIZE);
    }

    public void set(int pos, byte value) {
        if (pos < 0 || pos >= 2 * PART_SIZE){
            throw new IllegalArgumentException("illegal pos");
        }
        if (pos < PART_SIZE) {
            C.set(pos, value);
        } else {
            D.set(pos - PART_SIZE, value);
        }
    }


}
