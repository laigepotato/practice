package basic.collection;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: practice
 * @description:
 * @author: Sansanli
 * @create: 2021-09-26 22:22
 */

public class ListPractice {

/*
    List集合是一个元素有序（每个元素都有对应的顺序索引，第一个元素索引为0）、且可重复的集合。
    List是Collection接口的子接口，拥有Collection所有方法外，还有一些对索引操作的方法。


    */

    void testArrayList(){

/*
        ArrayList底层通过数组实现，随着元素的增加而动态扩容，线程不安全
*/

        List<String> list1 = new ArrayList<String>();
        list1.add("0");
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("5");
        list1.add("6");

        list1.add(4,"4");
        list1.remove(6);

        //修改元素
        list1.set(1,"11");

        System.out.println(list1.indexOf("6"));

        Util.normalCollectionMethod(list1);

    }

    void testLinkedList(){

/*
        链表（Linked list）是一种常见的基础数据结构，是一种线性表，但是并不会按线性的顺序存储数据，而是在每一个节点里存到下一个节点的地址。
        与 ArrayList 相比，LinkedList 的增加和删除的操作效率更高，而查找和修改的操作效率较低。
        LinkedList 实现了 Queue 接口，可作为队列使用。

        */

        LinkedList<String> list1 = new LinkedList<String>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("5");
        list1.add("6");

        list1.addFirst("0");
        list1.addLast("7");

        Util.normalCollectionMethod(list1);

        list1.removeFirst();
        Util.normalCollectionMethod(list1);

        System.out.println("Get First : " + list1.getFirst());

        list1.push("8");
        System.out.println("Get Stack pop : " + list1.pop());



    }


    public static void main(String[] args) {
        ListPractice listPractice = new ListPractice();
        //listPractice.testArrayList();
        listPractice.testLinkedList();
    }
}
