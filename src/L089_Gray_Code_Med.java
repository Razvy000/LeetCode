
import java.util.ArrayList;
import java.util.List;


/*
 The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code,
 print the sequence of gray code. A gray code sequence must begin with 0.

 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

 00 - 0
 01 - 1
 11 - 3
 10 - 2
 Note:
 For a given n, a gray code sequence is not uniquely defined.

 For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

 For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */
public class L089_Gray_Code_Med {

    // idea points on a square, points on a cube, and visit them by mobing along edges
    // idea2 generate graycode from existing graycodes, like subsets
    
    // graycode2  = graycode1 + 1 << steps
    public List<Integer> grayCode(int n) {

        ArrayList<Integer> r = new ArrayList<Integer>();

        // start with 000
        r.add(0);

        for (int i = 0; i < n; i++) {

            // add a 1 in front
            int pow = 1 << i;

            // existing graycodes
            int size = r.size();

            //for(int j=0; j<size; j++){
            for (int j = size - 1; j >= 0; j--) {
                int graycode = r.get(j) + pow;
                r.add(graycode);
            }
        }
        return r;
    }
}
