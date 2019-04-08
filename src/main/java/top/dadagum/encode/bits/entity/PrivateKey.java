package top.dadagum.encode.bits.entity;

import top.dadagum.encode.bits.SimpleBitString;

/**
 * @Description 密钥
 * @Author Honda
 * @Date 2019/4/7 21:02
 **/
public class PrivateKey extends CombinedBitString {

    public PrivateKey(byte[] bits) {
        super(bits);
    }

    public PrivateKey(SimpleBitString l, SimpleBitString r) {
        super(l, r);
    }

    @Override
    public PrivateKey copy() {
        SimpleBitString l = L.copy();
        SimpleBitString r = R.copy();
        return new PrivateKey(l, r);
    }
}
