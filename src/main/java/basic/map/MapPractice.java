package basic.map;

import basic.collection.Util;
import com.google.common.collect.ImmutableMap;

import java.util.*;
import java.util.stream.Stream;

/**
 * @program: practice
 * @description:
 * @author: Sansanli
 * @create: 2021-09-30 21:11
 */

public class MapPractice {

    void testHashMap(){

        /*

        最常用的Map,它根据键的HashCode值存储数据,根据键可以直接获取它的值，具有很快的访问速度。
        HashMap最多只允许一条记录的键为Null(多条会覆盖);允许多条记录的值为 Null。非同步的。

        LinkedHashMap保存了记录的插入顺序，在用Iterator遍历LinkedHashMap时，先得到的记录肯定是先插入的.
        在遍历的时候会比HashMap慢。key和value均允许为空，非同步的。

*/


        //初始化
        Map<String,Integer> map1 = new HashMap<>();
        map1.put("Lily",21);
        map1.put("Tom",22);

        Map<String,Integer> map2 = ImmutableMap.of(
                "Limei", 23,
                "Lilei", 22
        );

        map1.putAll(map2);

        //key集合
        Set<String> set1 = map1.keySet();
        Util.normalCollectionMethod(set1);

        for(Map.Entry<String,Integer> entry:map1.entrySet()){
            System.out.println("key is : "+entry.getKey()+" value is : "+entry.getValue());
        }

        Map<String,Integer> map3 = new LinkedHashMap<String,Integer>(){
            {
                put("Lily",21);
                put("Tom",22);
                put("Limei",23);
                put("Lilei",22);
            }
        };

        for(Map.Entry<String,Integer> entry:map3.entrySet()){
            System.out.println("key is : "+entry.getKey()+" value is : "+entry.getValue());
        }

    }

    void testTreeMap(){

       /*
        能够把它保存的记录根据键(key)排序,默认是按升序排序，也可以指定排序的比较器，
        当用Iterator 遍历TreeMap时，得到的记录是排过序的。
        TreeMap不允许key的值为null。非同步的。
        */

        Map<String,Integer> map = new TreeMap<String,Integer>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        }){
            {
                put("Lily",21);
                put("Tom",22);
                put("Limei",23);
                put("Lilei",22);
            }
        };

        for(Map.Entry<String,Integer> entry:map.entrySet()){
            System.out.println("key is : "+entry.getKey()+" value is : "+entry.getValue());
        }

    }

    void testHashTable(){
/*
    和HashMap一样，Hashtable 也是一个散列表，它存储的内容是键值对(key-value)映射。
    Hashtable 的函数都是同步的，这意味着它是线程安全的。它的key、value都不可以为null。此外，Hashtable中的映射不是有序的。

    主要的区别有：线程安全性，同步(synchronization)，以及速度。
    HashMap是非synchronized，而Hashtable是synchronized，
    这意味着Hashtable是线程安全的，多个线程可以共享一个Hashtable；
    而如果没有正确的同步的话，多个线程是不能共享HashMap的。
*/



    }


    public static void main(String[] args) {
        MapPractice mapPractice = new MapPractice();
       // mapPractice.testHashMap();
        mapPractice.testTreeMap();
    }
}
