package algorithm.linkedlist;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @program: practice
 * @description:
 * @author: Sansanli
 * @create: 2021-10-05 22:44
 */

public class LRUCache {
    /*
        LRU算法实际上是让你设计数据结构：首先要接收一个capacity参数作为缓存的最大容量，
        然后实现两个API，一个是put(key, val) 方法存入键值对，另一个是 get(key) 方法获取 key 对应的 val，如果 key 不存在则返回 -1。

        cache 这个数据结构必要的条件：查找快，插入快，删除快，有顺序之分。
        哈希表查找快，但是数据无固定顺序；链表有顺序之分，插入删除快，但是查找慢。所以结合一下，形成一种新的数据结构：哈希链表。
        LRU 缓存算法的核心数据结构就是哈希链表，双向链表和哈希表的结合体。
        在 Java 语言中，同样有类似的数据结构 LinkedHashMap

        */
    class LinkedNode {
        int key;
        int value;
        LinkedNode prev;
        LinkedNode next;

        public LinkedNode() {
        }

        ;

        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, LinkedNode> cache = new HashMap<Integer, LinkedNode>();
    private LinkedNode head, tail;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        LinkedNode node = cache.get(key);
        if(node==null) return -1;
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(LinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        addToLinkList(node);
    }

    public void put(int key, int value) {

        LinkedNode node = cache.get(key);
        if(node==null){
            //key不存在时
            LinkedNode newNode = new LinkedNode(key, value);
            cache.put(key,newNode);
            addToLinkList(newNode);
            size ++;
            if (size > capacity) {
                LinkedNode nodeToRemove = removeTail();
                cache.remove(nodeToRemove.key);
                size--;
            }
        }else {
            node.value = value;
            moveToHead(node);
        }




    }

    private void addToLinkList(LinkedNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private LinkedNode removeTail(){
        LinkedNode lastNode = tail.prev;
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;

        return lastNode;
    }




}
