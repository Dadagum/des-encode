package top.dadagum.encode.entity;

/**
 * @Description 明文
 * @Author Honda
 * @Date 2019/4/7 23:13
 **/
public class Text {

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
     */
    public void combine(L l, R r) {
        this.l = l;
        this.r = r;
    }

    /**
     * R部分
     */
    private static class R extends BitsString {

        public R(byte[] bitString, int begin, int length) {
            super(bitString, begin, length);
        }
    }

    /**
     * L部分
     */
    private static class L extends BitsString {

        public L(byte[] bitString, int begin, int length) {
            super(bitString, begin, length);
        }
    }
}
