package basic.stream;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * @program: practice
 * @description:
 * @author: Sansanli
 * @create: 2021-09-28 23:18
 */

public class StreamPractice {

    void testStreamInitCollection(){
        // 1. Stream初始化collection
        Set<String> set = Stream.of("a","b").collect(Collectors.toSet());
        System.out.println(set.getClass().getName());
        List<String> list = Stream.of("a","b").collect(Collectors.toList());
        System.out.println(list.getClass().getName());
        Map<String,String> map = Stream.of(
                new String[][]{ {"key1","value1"},{"key2","value2"}}
                ).collect(Collectors.toMap(data -> data[0], data -> data[1]));
        System.out.println(map.getClass().getName());

    }

    void testStreamFilter(){

    }

    public static void main(String[] args) {
        StreamPractice streamPractice = new StreamPractice();
        streamPractice.testStreamInitCollection();
    }



}
