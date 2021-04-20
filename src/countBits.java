/*
2021/4/13 T338
给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，
计算其二进制数中的 1 的数目并将它们作为数组返回。
输入: 5
输出: [0,1,1,2,1,2]
 */

import java.util.Arrays;

public class countBits {
    public static int[] My_countBits(int num) {
        int[] res = new int[num + 1];
        int[] pow = new int[31];
        pow[0] = 1;
        for(int i = 0; i < 30; i++){
            pow[i+1] = 2 * pow[i];
        }
        res[0] = 0;
        if(num == 0) return res; //特判
        res[1] = 1;
        for(int i = 2; i <= num; i++){
            for(int j = 30; j >= 0; j--){
                if(i >= pow[j]){
                    res[i] = res[i - pow[j]] + 1;
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] argv){
        //输出数组
        System.out.println(Arrays.toString(My_countBits(20)));
    }
}
