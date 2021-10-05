package basic.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @program: practice
 * @description:
 * @author: Sansanli
 * @create: 2021-09-26 22:22
 */

public class QueuePractice {

/*
    队列是一种特殊的线性表，它只允许在表的前端进行删除操作，而在表的后端进行插入操作。

    */

    void testQueue(){
/*
        LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。
*/

        Queue<String> queue = new LinkedList<String>();
        //1. 基础操作： 添加、读取、拿取
        //add()和remove()方法在失败的时候会抛出异常(不推荐)
        queue.offer("0");
        queue.offer("1");
        queue.offer("2");

        for(String element : queue){
            System.out.println(element);
        }

        System.out.println("poll="+queue.poll()); //返回第一个元素，并在队列中删除

        System.out.println("element="+queue.element()); //返回第一个元素

        System.out.println("peek="+queue.peek()); //返回第一个元素

       /*

       offer，add 区别：
       一些队列有大小限制，因此如果想在一个满的队列中加入一个新项，多出的项就会被拒绝。 这时新的 offer 方法就可以起作用了。它不是对调用 add() 方法抛出一个 unchecked 异常，而只是得到由 offer() 返回的 false。

        poll，remove 区别：
        remove() 和 poll() 方法都是从队列中删除第一个元素。remove() 的行为与 Collection 接口的版本相似， 但是新的 poll() 方法在用空集合调用时不是抛出异常，只是返回 null。因此新的方法更适合容易出现异常条件的情况。

        peek，element区别：
        element() 和 peek() 用于在队列的头部查询元素。与 remove() 方法类似，在队列为空时， element() 抛出一个异常，而 peek() 返回 null。
        */

    }

    void testBlockingQueue() throws Exception{
/*
        阻塞式队列与非阻塞队列的区别：
        阻塞队列，当队列是空的时，从队列中获取元素的操作将会被阻塞，或者当队列是满时，往队列里添加元素的操作会被阻塞。
        试图从空的阻塞队列中获取元素的线程将会被阻塞，直到其他的线程往空的队列插入新的元素。


        LinkedBlockingQueue是一个线程安全的阻塞队列，它实现了BlockingQueue接口，
        BlockingQueue接口继承自java.util.Queue接口，并在这个接口的基础上增加了take和put方法，这两个方法正是队列操作的阻塞版本。
*/

        // LinkedBlockingQueue ：一个由链接节点支持的可选有界队列。

        // 当阻塞队列满时，如果生产者线程往队列里put元素，队列会一直阻塞生产者线程，直到拿到数据，或者响应中断退出。
        // 当队列空时，消费者线程试图从队列里take元素，队列也会阻塞消费者线程，直到队列可用。

        BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<String>(2);

        blockingQueue.offer("0");
        blockingQueue.offer("1");
        blockingQueue.offer("2");

        blockingQueue.put("2");

        for(String element : blockingQueue){
            System.out.println(element);
        }


    }

    void testNotBlockingQueue() throws Exception {
/*
        ConcurrentLinkedQueue是一个基于链接节点的无界线程安全队列，它采用先进先出的规则对节点进行排序，当我们添加一个元素的时候，它会添加到队列的尾部；
        当我们获取一个元素时，它会返回队列头部的元素。

        入队和出队操作均利用CAS（compare and set）更新，这样允许多个线程并发执行，并且不会因为加锁而阻塞线程，使得并发性能更好。
*/

        ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue<Integer>();

        for (int i=0;i<100;i++){
            Thread t1 = new Thread() {
                public void run() {
                    Random r = new Random();
                    int x = r.nextInt();
                    concurrentLinkedQueue.offer(Integer.valueOf(x));
                    System.out.println("size is : "+concurrentLinkedQueue.size());
                    concurrentLinkedQueue.poll();
                }
            };
            t1.start();
        }

        System.out.println("last size is : "+concurrentLinkedQueue.size());

    }




    public static void main(String[] args) throws Exception{
        QueuePractice queuePractice = new QueuePractice();
       // queuePractice.testQueue();
        //queuePractice.testBlockingQueue();
        queuePractice.testNotBlockingQueue();
    }


}
