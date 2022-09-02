package day1;

/**
 * @Package:PACKAGE_NAME
 * @Author: wyb
 * @DATE:2022/8/27
 * @Description:
 */
public class isSubsequence392 {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s,t));
    }

    public static boolean isSubsequence(String s, String t) {
        int[][] res = new int[s.length()-1][t.length()-1];
        return process2(s, t, 0, 0,res);
    }

    public static boolean process(String s,String t,int cur, int index) {
        if (cur == s.length()) {
            return true;
        }
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        for (int i = cur; cur < sarr.length;) {
            for (int j = index; j < tarr.length;  ) {
                if (sarr[i] == tarr[j]) {
                    return process(s, t, i+1, j+1);
                }
                j++;
            }
            return false;
        }
        return false;
    }

    public static boolean process2(String s,String t,int cur, int index, int[][] res) {
        if (cur == s.length()) {
            res[cur][index] = 1;
            return res[cur][index] == 1;
        }
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        for (int i = cur; cur < sarr.length;) {
            for (int j = index; j < tarr.length;  ) {
                if (sarr[i] == tarr[j]) {
                    res[cur][index] = res[cur+1][index+1];
                    return res[cur][index] == 1;
                    //return process2(s, t, i+1, j+1, res);
                }
                j++;
            }
            return res[cur][index] == 1;
        }
        return res[cur][index] == 1;
    }
}
