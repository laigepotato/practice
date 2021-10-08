package algorithm.math;

import basic.map.MapPractice;

/**
 * @program: practice
 * @description:
 * @author: Sansanli
 * @create: 2021-10-06 21:26
 */

public class MathPractice {

/*
    给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
    你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。

    */

    public String addStrings(String num1, String num2){
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuffer stringBuffer = new StringBuffer();
        while (i >= 0 || j >= 0 || carry > 0){
            int x = ( i >=0 ? Integer.parseInt(num1.charAt(i)+"") : 0 ) ;
            int y = ( j >=0 ? Integer.parseInt(num2.charAt(j)+"") : 0 ) ;
            int value = ( x + y + carry ) % 10 ;
            carry = ( x + y + carry ) / 10 ;
            stringBuffer.append(value);
            i--;
            j--;
        }

        return stringBuffer.reverse().toString();
    }


    public static void main(String[] args) {
        MathPractice mathPractice = new MathPractice();
        mathPractice.addStrings("11","123");
    }
}
