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
}
