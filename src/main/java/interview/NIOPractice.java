package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: practice
 * @description:
 * @author: Sansanli
 * @create: 2021-10-07 20:55
 */

public class NIOPractice {

    void printList(List<Character> list){

        if(list.size()<1){
            return;
        }
        //int pos = 1;
        for(int pos =1;pos < list.size();pos++){
            for(int i = pos;i< list.size();i++){
                System.out.print(list.get(i)+"");
            }
            for(int j = 0 ;j<pos;j++){
                System.out.print(list.get(j)+"");
            }
            System.out.println("");
        }

    }

    public static void main(String[] args) {
        NIOPractice nioPractice = new NIOPractice();

        //List<Character> list = Stream.of('a','b','c','d').collect(Collectors.toList());


       // List<Character> list = Arrays.asList('a','b','c','d');

        Character[] characters = new Character[]{'a','b','c','d'};

        List<Character> list = Arrays.asList(characters);
        list.add('e');
        System.out.println("初始列表："+ Arrays.toString(list.toArray()));

        nioPractice.printList(list);



    }


}
