package top.dadagum.encode.bits.entity;

import top.dadagum.encode.bits.BitString;
import top.dadagum.encode.bits.SimpleBitString;

/**
 * @Description 明文
 * @Author Honda
 * @Date 2019/4/7 23:13
 **/
public class Text implements BitString {

    private BitString L;
    private BitString R;
    private static final int PART_SIZE = 32;

    public Text(byte[] bits_64) {
        L = new SimpleBitString(bits_64, 0, PART_SIZE);
        R = new SimpleBitString(bits_64, PART_SIZE, PART_SIZE);
    }


    public BitString L() {
        return L;
    }

    public BitString R() {
        return R;
    }

    public void setL(BitString l) {
        this.L = l;
    }

    public void setR(BitString r) {
        this.R = r;
    }


    public int length() {
        return 2 * PART_SIZE;
    }

    public byte at(int pos) {
        if (pos < 0 || pos >= 2 * PART_SIZE){
            throw new IllegalArgumentException("illegal pos");
        }
        if (pos < PART_SIZE) {
            return L.at(pos);
        }
        return R.at(pos - PART_SIZE);
    }

    public void set(int pos, byte value) {
        if (pos < 0 || pos >= 2 * PART_SIZE){
            throw new IllegalArgumentException("illegal pos");
        }
        if (pos < PART_SIZE) {
            L.set(pos, value);
        } else {
            R.set(pos - PART_SIZE, value);
        }
    }

}
