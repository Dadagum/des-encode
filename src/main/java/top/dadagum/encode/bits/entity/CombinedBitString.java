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
    protected int partSize; // 对半分

    public CombinedBitString(byte[] bits) {
        this.partSize = bits.length / 2;
        L = new SimpleBitString(bits, 0, partSize);
        R = new SimpleBitString(bits, partSize, partSize);
    }

    public CombinedBitString(SimpleBitString l, SimpleBitString r) {
        this.partSize = l.length();
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

    /**
     * 置换操作
     * @param mapping 映射表
     */
    public void replace(int[] mapping) {
        int newPartSize = mapping.length / 2;
      //  System.out.println("new PartSize = " + newPartSize + " partSize = " + partSize);
        SimpleBitString tl = new SimpleBitString(new byte[newPartSize]);
        SimpleBitString tr = new SimpleBitString(new byte[newPartSize]);
        for (int i = 0; i < newPartSize; i++) {
            //System.out.print(mapping[i] + " ");
            // 主要需要判断需要的数位在L还是R
            byte value = mapping[i] - 1 >= partSize ? R.at(mapping[i] - partSize - 1) : L.at(mapping[i] - 1);
            tl.set(i, value);
        }
        for (int i = 0; i < newPartSize; i++) {
            //System.out.print(mapping[i + newPartSize] + " ");
            byte value = mapping[i + newPartSize] - 1 >= partSize ? R.at(mapping[i + newPartSize] - partSize - 1) : L.at(mapping[i + newPartSize] - 1);
            tr.set(i, value);
        }
        L = tl;
        R = tr;
        partSize = newPartSize;
    }

    public BitString copy() {
        throw new UnsupportedOperationException();
    }

    public void shiftLeft(int cnt) {
        throw new UnsupportedOperationException();
    }

}
