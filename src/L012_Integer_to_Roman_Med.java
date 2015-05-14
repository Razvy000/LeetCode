
public class L012_Integer_to_Roman_Med {

    // idea: take care, devil details
    public String intToRoman(int num) {
        int[] val = new int[]{1, 5, 10, 50, 100, 500, 1000};
        char[] rom = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};

        // i, ii, iii, iv, v, vi, vii, viii, ix, x;   {i, v, x}  1-10
        // x, xx, xxx, xl, l, lx, lxx, lxxx, xc, c;   {x, l, c}  10-100
        // c, cc, ccc, cd, d, dc, dcc, dccc, cm, m;    {c, d, m}  100-3900
        String s = "";
        int i = 6;
        while (num >= val[i]) {
            num -= val[i];
            s += rom[i];
        }

        for (i = 5; i >= 1; i -= 2) {
            int div = num / val[i - 1];
            System.out.println(div);
            switch (div) {
                case 0:
                    break;
                case 3:
                    s += "" + rom[i - 1];
                case 2:
                    s += "" + rom[i - 1];
                case 1:
                    s += "" + rom[i - 1];
                    break;
                case 4:
                    s += "" + rom[i - 1] + rom[i];
                    break;
                case 5:
                    s += "" + rom[i];
                    break;
                case 6:
                    s += "" + rom[i] + rom[i - 1];
                    break;
                case 7:
                    s += "" + rom[i] + rom[i - 1] + rom[i - 1];
                    break;
                case 8:
                    s += "" + rom[i] + rom[i - 1] + rom[i - 1] + rom[i - 1];
                    break;
                case 9:
                    s += "" + rom[i - 1] + rom[i + 1];
                    break;
            }
            num -= div * val[i - 1];
        }

        return s;
    }

    
    // other simple
    String intToRoman2(int num) 
{   
    String s="";  

    while (num > 0)
    {   
        if (num >= 1000) {s += "M"; num-=1000; continue;}
        if (num >= 900)  {s += "CM"; num-=900; continue;}
        if (num >= 500)  {s += "D"; num-=500; continue;}
        if (num >= 400)  {s += "CD"; num-=400; continue;}
        if (num >= 100)  {s += "C"; num-=100; continue;}
        if (num >= 90)   {s += "XC"; num-=90; continue;}
        if (num >= 50)   {s += "L"; num-=50; continue;}
        if (num >= 40)   {s += "XL"; num-=40; continue;}
        if (num >= 10)   {s += "X"; num-=10; continue;}
        if (num >= 9)    {s += "IX"; num-=9; continue;}
        if (num >= 5)    {s += "V"; num-=5; continue;}
        if (num >= 4)    {s += "IV"; num-=4; continue;}
        if (num == 3)    {s += "III"; num-=3; continue;}
        if (num == 2)    {s += "II"; num-=2; continue;}
        if (num == 1)    {s += "I"; num-=1; continue;}
    }   

    return s;
} 
    
    public static void main(String[] args) {
        L012_Integer_to_Roman_Med o = new L012_Integer_to_Roman_Med();
        System.out.println(o.intToRoman(4));
    }
}
