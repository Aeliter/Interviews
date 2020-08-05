package com.aeliter.bytedance;

/**
 * @description: 思路:递归、分别计算左右子树的最大值，如果左子树的最大值较大就交换两棵子树，然后对左右子树递归调用该算法。
 * @author: caibingqiang
 * @date: 2020-06-29 11:16
 * @version: V1.0
 */
public class RightMaxLeftMax {
    /**
     * 调整一个二叉树，使得右子树的最大值大于左子树的最大值。
     * 思路:先分别算出左子树和右子树的最大值，如果左子树的最大值大，那么交换两个子树即可。
     * 通常而言，调整一棵树的话，还是直接调整子树比较方便。
     *       //我们这里规定假如说一棵树只有左子树、没有右子树，则我们把它的左右子树对调
     * @param root
     */
    /*public static void rightMaxLeftMax(Node root){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        if(root.left != null && root.right == null){
            root.right = root.left;
            root.left = null;
        }
        if(root.left != null && root.right != null){
            Node leftMaxNode = maxOfTree(root.left);
            Node righMaxNode = maxOfTree(root.right);
            if(Integer.parseInt(leftMaxNode.value) > Integer.parseInt(righMaxNode.value)){
                Node tmp = root.left;
                root.left = root.right;
                root.right = tmp;
            }
        }
        rightMaxLeftMax(root.left);
        rightMaxLeftMax(root.right);
    }
    public static Node maxOfTree(Node root){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            return root;
        }
        Node leftMax = maxOfTree(root.left);
        Node rightMax = maxOfTree(root.right);
        Node bigger = null;
        if(leftMax != null && rightMax != null){
            bigger = Integer.parseInt(leftMax.value) > Integer.parseInt(rightMax.value) ? leftMax : rightMax;
        }else if(leftMax != null){
            bigger = leftMax;
        }else{
            bigger = rightMax;
        }
        return Integer.parseInt(bigger.value) > Integer.parseInt(root.value) ? bigger : root;
    }
    //其实返回一棵树的最大节点，直接遍历即可。这个遍历应该是要采用非递归遍历，我们使用先序非递归遍历
    public static Node maxOfTree1(Node root){
        if(root == null){
            return null;
        }
        int max = Integer.MIN_VALUE;
        Node maxNode = null;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            if(Integer.parseInt(node.value) > max){
                max = Integer.parseInt(node.value);
                maxNode = node;
            }
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return maxNode;
    }

    public static void main(String[] args){
        String[] data = {"5","6","4","$","2","$","3"};
        Node root = createBinaryTree(data,0,data.length-1);
        rightMaxLeftMax(root);
        preOrder(root);
        System.out.println();
        inOrderNotRecursive(root);
    }*/

    /*private static int binarySearch(int[] arrary,int findValue,int left,int right){
        if (arrary == null || arrary.length <= 0 || left > right || left <0 || right < 0) {
            return -1;
        }

        int mid = (left+right)/2;

        if (findValue > arrary[mid]){
            binarySearch(arrary,findValue,mid,right);
        }else if (findValue < arrary[mid]){
            binarySearch(arrary,findValue,left,mid);
        }else {
            return mid;
        }
        return -1;
    }*/
    public static void main(String[] args) {


    }

}
