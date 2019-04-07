package top.dadagum.encode.entity;

/**
 * @Description 密钥
 * @Author Honda
 * @Date 2019/4/7 21:02
 **/
public class PrivateKey {

    /**
     * 一个私钥分成C和D两部分
     */
    private C c;
    private D d;
    private static final int PART_SIZE = 28;

    public PrivateKey(byte[] bits_56) {
        c = new C(bits_56, 0, PART_SIZE);
        d = new D(bits_56, PART_SIZE, PART_SIZE);
    }

    public D D() {
        return d;
    }

    public C C() {
        return c;
    }

    /**
     * 密钥合并
     */
    public void combine(C c, D d) {
        this.c = c;
        this.d = d;
    }

    /**
     * C部分
     */
    private static class C extends BitsString {

        public C(byte[] bitString, int begin, int length) {
            super(bitString, begin, length);
        }
    }

    /**
     * D部分
     */
    private static class D extends BitsString {

        public D(byte[] bitString, int begin, int length) {
            super(bitString, begin, length);
        }
    }

}
