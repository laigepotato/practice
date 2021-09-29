package basic.collection;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: practice
 * @description:
 * @author: Sansanli
 * @create: 2021-09-26 22:22
 */

public class SetPractice {

//Set: 用于存储无序(存入和取出的顺序不一定相同)元素，值不能重复。

/*
    引用到堆上同一个对象的两个引用是相等的。
    如果对两个引用调用hashCode方法，会得到相同的结果，如果对象所属的类没有覆盖Object的hashCode方法的话，
    hashCode会返回每个对象特有的序号（java是依据对象的内存地址计算出的此序号），所以两个不同的对象的hashCode值是不可能相等的。

    如果想要让两个不同的Person对象视为相等的，就必须覆盖Object继下来的hashCode方法和equals方法，
    因为Object  hashCode方法返回的是该对象的内存地址，所以必须重写hashCode方法，才能保证两个不同的对象具有相同的hashCode，同时也需要两个不同对象比较equals方法会返回true
*/



    void testHashSet(){
/*
    哈希表边存放的是哈希值。HashSet存储元素的顺序并不是按照存入时的顺序（和List显然不同） 是按照哈希值来存的所以取数据也是按照哈希值取得。
    HashSet会通过元素的hashcode（）和equals方法进行判断元素师否重复， 都相等时才判断为重复元素
    */
        // 1. 常用操作
        Set<String> set1 = new HashSet<String>();
        set1.add("apple");
        set1.add("banana");

        //java 8 ,使用Stream创建集合
        Set<String> set2 = Stream.of("orange","apple","watermelon").collect(Collectors.toSet());
        set1.addAll(set2);

        Util.normalCollectionMethod(set1);

        // 2. 重写hashCode和equals实验
        Set<Fruit> fruits = Stream.of(
                new Fruit("apple"),
                new Fruit("banana"),
                new Fruit("orange"),
                new Fruit("watermelon"),
                new Fruit("apple")).collect(Collectors.toSet());

        Util.normalCollectionMethod(fruits);

    }

    void testTreeSet(){

    }



    public static void main(String[] args) {
        SetPractice setPractice = new SetPractice();
        setPractice.testHashSet();



    }

    static class Fruit{
        String name;

        Fruit(String name){
            this.name = name;
        }

        public boolean equals(Object obj){
            return false;
        }

        public int hashCode(){
            return (int)(new Date().getTime());
        }

        public String toString(){
            return name;
        }
    }


}

