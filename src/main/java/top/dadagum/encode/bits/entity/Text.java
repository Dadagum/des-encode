package top.dadagum.encode.bits.entity;

import top.dadagum.encode.bits.SimpleBitString;

/**
 * @Description 明文
 * @Author Honda
 * @Date 2019/4/7 23:13
 **/
public class Text extends CombinedBitString {

    public Text(byte[] bits) {
        super(bits);
    }

    public Text(SimpleBitString l, SimpleBitString r) {
        super(l, r);
    }

    /**
     * 得到比特串的实际值
     */
    public byte[] getByte() {
        byte[] tmp = new byte[2*partSize];
        for (int i = 0; i < partSize; i++) {
            tmp[i] = L.at(i);
        }
        for (int i = partSize; i < 2 * partSize; i++) {
            tmp[i] = R.at(i-partSize);
        }
        return tmp;
    }
}
