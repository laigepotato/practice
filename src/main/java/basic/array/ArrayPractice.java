package basic.array;

import java.util.Arrays;

/**
 * @program: practice
 * @description:
 * @author: Sansanli
 * @create: 2021-10-08 11:16
 */

public class ArrayPractice {

    public void testArrays(){
        int[] a = { 1, 2 };
        System.out.println(Arrays.toString(a));

        //两个数组以相同的顺序包含相同的元素
        int[] b = {2,1,5,7,4};
        System.out.println(Arrays.equals(a,b));

        //Arrays.sort(int[] a);对数组进行升序排序
        Arrays.sort(b);
        System.out.println(Arrays.toString(b));

        String s = "12345";
        int[] ints = Arrays.stream(s.split("")).mapToInt(x -> Integer.parseInt(x)).toArray();
        System.out.println(Arrays.toString(ints));


    }

    public static void main(String[] args) {
        ArrayPractice arrayPractice = new ArrayPractice();
        arrayPractice.testArrays();
    }
}
