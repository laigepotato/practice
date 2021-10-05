package algorithm.binarytree;

import apple.laf.JRSUIUtils;

import java.util.*;

/**
 * @program: practice
 * @description:
 * @author: Sansanli
 * @create: 2021-10-01 11:57
 */

public class BinaryTreePractice {


    /*

    时间复杂度：O(n)，其中 n 是二叉树的节点数。每一个节点恰好被遍历一次。
    空间复杂度：O(n)，为递归过程中栈的开销，平均情况下为 O(logn)，最坏情况下树呈现链状为 O(n)。

    */

    public List<Object> preorderTraversalRecursion(TreeNode root) {
        List<Object> res = new ArrayList<Object>();
        preOrder(root,res);
        return res;
    }

    public void preOrder(TreeNode root,List<Object> res){
        if(root == null){
            return;
        }
        res.add(root.value);
        preOrder(root.leftNode,res);
        preOrder(root.rightNode,res);
    }


    public List<Object> preorderTraversalIteration(TreeNode root) {

/*

        我们也可以用迭代的方式实现方法一的递归函数，两种方式是等价的，
        区别在于递归的时候隐式地维护了一个栈，
        而我们在迭代的时候需要显式地将这个栈模拟出来

*/

        List<Object> res = new ArrayList<Object>();

        if(root == null){
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.value);
            if(node.rightNode!=null)
                stack.push(node.rightNode);
            if(node.leftNode!=null)
                stack.push(node.leftNode);
        }

        return res;
    }

    public List<Object> inorderTraversalIteration(TreeNode root) {

        List<Object> res = new ArrayList<Object>();
        if(root==null) return res;

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode curNode = root;
        while (curNode!=null || !stack.isEmpty()){
            while (curNode!=null){
                stack.push(curNode);
                curNode = curNode.leftNode;
            }
            curNode = stack.pop();
            res.add(curNode.value);
            curNode = curNode.rightNode;
        }

        return res;
    }

    public List<Object> postorderTraversalIteration(TreeNode root) {

        List<Object> res = new ArrayList<Object>();
        if(root==null) return res;

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode curNode = root;
        TreeNode preNode = null;
        while (curNode!=null || !stack.isEmpty()){
            while (curNode!=null){
                stack.push(curNode);
                curNode = curNode.leftNode;
            }
            curNode = stack.pop();
            if( curNode.rightNode==null || curNode.rightNode==preNode){
                res.add(curNode.value);
                preNode = curNode;
                curNode = null;
            }else {
                stack.push(curNode);
                curNode = curNode.rightNode;
            }

        }

        return res;
    }

/*
    层序遍历就是逐层遍历树结构。

    广度优先搜索是一种广泛运用在树或图这类数据结构中，遍历或搜索的算法。 该算法从一个根节点开始，首先访问节点本身。 然后遍历它的相邻节点，其次遍历它的二级邻节点、三级邻节点，以此类推。

    当我们在树中进行广度优先搜索时，我们访问的节点的顺序是按照层序遍历顺序的。

    */
    public List<List<Object>> levelOrderTraversalRecursion(TreeNode root) {
        List<List<Object>> res = new ArrayList<>();
        if(root==null) return res;

        Queue<TreeNode> currentQueue = new LinkedList<TreeNode>();
        currentQueue.offer(root);
        levelOrder(currentQueue,res);
        return res;
    }

    public void levelOrder(Queue<TreeNode> currentQueue, List<List<Object>> res){
        if(currentQueue.size()==0)
            return;
        int queueSize = currentQueue.size();
        TreeNode node;
        List<Object> levelNodes = new ArrayList<Object>();
        for(int i=0;i<queueSize;i++){
           node = currentQueue.poll();
           levelNodes.add(node.value);
           if(node.leftNode!=null)
               currentQueue.offer(node.leftNode);
           if(node.rightNode!=null)
               currentQueue.offer(node.rightNode);
        }
        res.add(levelNodes);
        levelOrder(currentQueue,res);
    }


    }
