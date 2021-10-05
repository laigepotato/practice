package algorithm.sort;

import java.util.Arrays;

/**
 * @program: practice
 * @description:
 * @author: Sansanli
 * @create: 2021-10-04 14:03
 */

public class SortPractice {

    public void insertSort(int[] data,int n){
/*
        插入排序可以分为两种，一种是直接插入还一种是二分法插入，
        直接插入的原理 比较简单，就是往前逐个查找直到找到合适的位置然后插入，
        二分法插入是先折半查找，找到合适的位置然后再插入。
*/
        if(n < 2) return;

        for(int i = 1;i<n;i++){
            if(data[i] < data[i-1]){
                int key = data[i];
                int low = 0;
                int hight = i-1;
                while(low < hight){
                    int mid = ( hight + low ) >> 1; //右移一位，相当于除2
                    if(data[mid] > key)
                        hight = mid-1;
                    else low = mid+1;
                }
                for(int j=i; j>low ;j--){
                    data[j] = data[j-1];
                }
                data[low]=key;
            }
        }



    }

    public void quickSortRecursion(int[] data,int n){
        quickSort(data,0,n-1);
    }

    public void quickSort(int[] data,int start,int end){
        System.out.println("from: "+start+" to: "+end);
        if(start >= end){
            return;
        }
        int key = data[start];
        System.out.println("key: "+ key);
        int pos = start;
        for(int i=pos+1; i<=end; i++){
            System.out.print("i="+i+",pos="+pos);
            if(data[i] < key){
                data[pos++] = data[i];
                for(int j=i; j>pos; j--){
                    data[j] = data[j-1];
                }
                data[pos] = key;
            }
            System.out.println(Arrays.toString(data));
        }
        quickSort(data,start,pos-1);
        quickSort(data,pos+1,end);
    }

    public void heapSort(int[] data,int n){
        buildMaxHeap(data,n);
        for(int i = 0; i < n; i++){
            int max = data[0];
            data[0] = data[n-1-i];
            data[n-1-i] = max;
            maxHeapfy(data,0, n-i-1);
        }
    }

    private void maxHeapfy(int[] data, int i, int heapSize) {
        int left = i * 2 +1;
        int right = i * 2 + 2;
        int max = i;
        System.out.println("i:"+i+" left="+left+" right="+right);
        if (left < heapSize && data[left] > data[max]) {
            max = left;
        }
        if (right < heapSize && data[right] > data[max]) {
            max = right;
        }
        if (max != i) {
            int tmp = data[i];
            data[i] = data[max];
            data[max] = tmp;
            maxHeapfy(data,max,heapSize);
        }

    }

    private void buildMaxHeap(int[] data,  int n) {
        // 从最后一个非叶子节点开始逐个进行最大堆处理
        // 最后一个非叶子节点：
        for(int i = (n-2)/2; i>=0; i--){
            maxHeapfy(data,i,n);
        }
        System.out.println(Arrays.toString(data));
    }

    public void shellSort(int[] data,  int n){

/*
希尔排序也成缩小增量排序，原理是将待排序列划分为若干组，每组都是不连续的，
有间隔step，step可以自己定，但间隔step最后的值一定是1，也就说最后一步是前后两两比较。
间隔为step的默认划分为一组，先在每一组内进行排序，以使整个序列基本有序，
然后再减小间隔step的值，重新分组再排序...不断重复，直到间隔step小于1则停止。
*/

    }



    public static void main(String[] args) {
        SortPractice sortPractice = new SortPractice();
        int[] data = new int[]{5,9,5,7,4,3,6,2,2,0,8};
        //sortPractice.insertSort(data,data.length);
        //sortPractice.quickSortRecursion(data,data.length);
        //sortPractice.heapSort(data,data.length);
        System.out.println(Arrays.toString(data));
    }
}
