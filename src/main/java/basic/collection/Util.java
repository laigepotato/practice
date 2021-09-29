package basic.collection;

import java.util.Collection;
import java.util.Iterator;

/**
 * @program: practice
 * @description:
 * @author: Sansanli
 * @create: 2021-09-26 22:37
 */

public class Util {

    public static void normalCollectionMethod(Collection collection){
        System.out.println("1. Collect type is: " + collection.getClass().getName());
        System.out.println("2. Method: int size(): " + collection.size());
        System.out.println("3. Method: boolean isEmpty(): " + collection.isEmpty());
        System.out.println("4. 遍历: ");
        Object o = null;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            o = iterator.next();
            System.out.println(o);
        }
        System.out.println("5. Method: contains(Object o): " + collection.contains(o));
        System.out.println("6. Object[] toArray(),array[0] is : " + (collection.toArray())[0]);


    }

}
