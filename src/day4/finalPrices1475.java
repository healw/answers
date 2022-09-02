package day4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Package:day4
 * @Author: wyb
 * @DATE:2022/9/1
 * @Description:
 */
public class finalPrices1475 {
    public static void main(String[] args) {

    }

    public int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];
        Stack<List<Integer>> stack = new Stack<>();
        for(int i = 0; i < prices.length; i++){
            while(!stack.isEmpty() && prices[stack.peek().get(0)] > prices[i]){
                List<Integer> popIs = stack.pop();
                if(popIs.size() == 1){
                    res[popIs.get(0)] = prices[popIs.get(0)] - prices[i];
                }else{
                    for(int j = 0; j < popIs.size(); j++){
                        if(j < popIs.size() -1){
                            res[popIs.get(j)] = 0;
                        }
                        res[popIs.get(popIs.size() - 1)] = prices[popIs.get(0)] - prices[i];
                    }
                }
            }
            if(!stack.isEmpty() && prices[stack.peek().get(0)] == prices[i]){
                stack.peek().add(Integer.valueOf(i));
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }

        while(!stack.isEmpty()){
            List<Integer> popIs = stack.pop();
            if(popIs.size() == 1){
                res[popIs.get(0)] = prices[popIs.get(0)];
            }else{
                for(int i = 0; i < popIs.size(); i++){
                    if(i < popIs.size() -1){
                        res[popIs.get(i)] = 0;
                    }
                    res[popIs.get(popIs.size() - 1)] = prices[popIs.get(0)];
                }
            }
        }
        return res;
    }
}
