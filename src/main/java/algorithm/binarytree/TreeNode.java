package algorithm.binarytree;

/**
 * @program: practice
 * @description:
 * @author: Sansanli
 * @create: 2021-10-01 11:58
 */

public class TreeNode {

    TreeNode leftNode;
    TreeNode rightNode;
    Object value;

    public TreeNode(Object value){
        this.value = value;
    }

    public TreeNode(TreeNode leftNode, TreeNode rightNode, Object value) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.value = value;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
