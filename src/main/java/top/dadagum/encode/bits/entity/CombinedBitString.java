package top.dadagum.encode.bits.entity;

import top.dadagum.encode.bits.BitString;
import top.dadagum.encode.bits.SimpleBitString;

/**
 * @Description 由左右个子比特串组成的整个比特串
 * @Author Honda
 * @Date 2019/4/8 15:09
 **/
public class CombinedBitString implements BitString {
    
    protected SimpleBitString L;
    protected SimpleBitString R;
    private int partSize; // 对半分

    public CombinedBitString(byte[] bits) {
        this.partSize = bits.length / 2;
        L = new SimpleBitString(bits, 0, partSize);
        R = new SimpleBitString(bits, partSize, partSize);
    }

    public CombinedBitString(SimpleBitString l, SimpleBitString r) {
        this.L = l;
        this.R = r;
    }

    public SimpleBitString L() {
        return L;
    }

    public SimpleBitString R() {
        return R;
    }

    public void setL(SimpleBitString l) {
        this.L = l;
    }

    public void setR(SimpleBitString r) {
        this.R = r;
    }


    public int length() {
        return 2 * partSize;
    }

    public byte at(int pos) {
        if (pos < 0 || pos >= 2 * partSize){
            throw new IllegalArgumentException("illegal pos");
        }
        if (pos < partSize) {
            return L.at(pos);
        }
        return R.at(pos - partSize);
    }

    public void set(int pos, byte value) {
        if (pos < 0 || pos >= 2 * partSize){
            throw new IllegalArgumentException("illegal pos");
        }
        if (pos < partSize) {
            L.set(pos, value);
        } else {
            R.set(pos - partSize, value);
        }
    }

    public void replace(int[] mapping) {
        SimpleBitString tl = new SimpleBitString(new byte[partSize]);
        SimpleBitString tr = new SimpleBitString(new byte[partSize]);
        for (int i = 0; i < partSize; i++) {
            tl.set(i, L.at(mapping[i]));
        }
        for (int i = 0; i < partSize; i++) {
            tr.set(i, R.at(mapping[i + partSize]));
        }
        L = tl;
        R = tr;
    }

    public BitString copy() {
        throw new UnsupportedOperationException();
    }

    public void shiftLeft(int cnt) {
        throw new UnsupportedOperationException();
    }

}
