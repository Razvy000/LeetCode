/*
 Reverse bits of a given 32 bits unsigned integer.

 For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

 Follow up:
 If this function is called many times, how would you optimize it?

 Related problem: Reverse Integer
 */

public class L190_Reverse_Bits_Ezy {

    // ABCD -> rotate 2 -> CDAB -> mask 2 & rotate -> DC BA
    public int reverseBits(int n) {
        n = (n >>> 16) | (n << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }

    public int rtCircShift(int bits, int k) {
        return (bits >>> k) | (bits << (Integer.SIZE - k));
    }

    public int reverseBits2(int n) {
        int b = 0;
        while (n != 0) {
            b <<= 1;
            b |= (n & 1);
            n >>= 1;
        }
        return b;
    }

    public static void main(String[] args) {

        L190_Reverse_Bits_Ezy o = new L190_Reverse_Bits_Ezy();

        int v1 = 1 << 16;
        System.out.println(Integer.toBinaryString(v1));

        int v1r = o.reverseBits(v1);
        System.out.println(Integer.toBinaryString(v1r));

    }
}
