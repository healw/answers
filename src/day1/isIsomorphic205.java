package day1;

import java.util.HashMap;

/**
 * @Package:PACKAGE_NAME
 * @Author: wyb
 * @DATE:2022/8/27
 * @Description: 力扣 T205同构字符串
 */
class isIsomorphic205 {
    public boolean isIsomorphic(String s, String t) {
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        HashMap<Character,Character> res = new HashMap<>();
        for(int i = 0; i < sarr.length; i++){
            if(res.containsKey(sarr[i])){
                if(tarr[i] != res.get(sarr[i])){
                    return false;
                }
            }
            res.put(sarr[i],tarr[i]);
        }
        return true;
    }
}
