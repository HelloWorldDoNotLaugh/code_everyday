package com.wy.leetcode;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/10/20
 */
public class L2525 {

    private static final int BULKY_SIZE_ELE = 10000;
    private static final int BULKY_SIZE_V = 1000000000;
    private static final int HEAVY_SIZE = 100;
    public String categorizeBox(int length, int width, int height, int mass) {
        return BoxType.getType(length, width, height, mass).desc;
    }

    enum BoxType {
        BULKY("Bulky"),
        HEAVY("Heavy"),
        BOTH("Both"),
        NEITHER("Neither"),
        ;

        public String desc;

        BoxType(String desc) {
            this.desc = desc;
        }

        public static BoxType getType(int length, int width, int height, int mass) {
            boolean isBulky = isBulky(length, width, height, mass);
            boolean isHeavy = isHeavy(mass);

            if (isBulky && isHeavy) {
                return BOTH;
            }

            if (isBulky) {
                return BULKY;
            }

            if (isHeavy) {
                return HEAVY;
            }

            return NEITHER;
        }

        public static boolean isBulky(int length, int width, int height, int mass) {
            if (length >= BULKY_SIZE_ELE || width >= BULKY_SIZE_ELE || height >= BULKY_SIZE_ELE || mass >= BULKY_SIZE_ELE) {
                return true;
            }

            return (long)length * width * height >= BULKY_SIZE_V;
        }

        public static boolean isHeavy(int mass) {
            return mass >= HEAVY_SIZE;
        }

        public static void main(String[] args) {
            L2525 l2525 = new L2525();
            System.out.println(l2525.categorizeBox(200, 50, 800, 50));
        }
    }
}
