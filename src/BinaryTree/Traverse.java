package BinaryTree;

import java.util.*;

import static javafx.scene.input.KeyCode.Q;

/**
 * Created by MOMO on 2017/3/28.
 */
public class Traverse {
    class TreeNode<T>{
        private T data;
        private TreeNode<T> leftNode;
        private TreeNode<T> rightNode;
        public TreeNode(T data,TreeNode<T> leftNode,TreeNode<T> rightNode){
            this.data=data;
            this.leftNode=leftNode;
            this.rightNode=rightNode;
        }
        public T getData(){
            return data;

        }
        public void setData(T data){

        }
        public TreeNode<T> getLeftNode(){
            return leftNode;
        }
        public void setLeftNode(TreeNode<T> leftNode){
            this.leftNode=leftNode;

        }
        public TreeNode<T> getRightNode(){
            return rightNode;
        }
        public void setRightNode(TreeNode<T> rightNode){
            this.rightNode=rightNode;
        }

    }
    public  TreeNode<String> init(){
        TreeNode<String> D=new TreeNode<String>("D",null,null);
        TreeNode<String> H=new TreeNode<String>("H",null,null);
        TreeNode<String> I=new TreeNode<String>("I",null,null);
        TreeNode<String> J=new TreeNode<String>("J",null,null);
        TreeNode<String> P=new TreeNode<String>("P",null,null);
        TreeNode<String> G=new TreeNode<String>("G",P,null);
        TreeNode<String> F=new TreeNode<String>("F",null,J);
        TreeNode<String> E=new TreeNode<String>("E",H,I);
        TreeNode<String> B=new TreeNode<String>("B",D,E);
        TreeNode<String> C=new TreeNode<String>("C",F,G);
        TreeNode<String> A=new TreeNode<String>("A",B,C);
        return A;
    }

    public void printNode(TreeNode<String> node){
        System.out.println(node.getData()+" ");;

    }

    //先序遍历
    public void pre_order(TreeNode<String> node){
        this.printNode(node);//D
        if(node.getLeftNode()!=null){//L
            this.pre_order(node.getLeftNode());
        }
        if(node.getRightNode()!=null){
            this.pre_order   (node.getRightNode());
        }
    }

    //中序遍历
    public void in_order(TreeNode<String> node){
        if(node.getLeftNode()!=null){//L
            this.in_order(node.getLeftNode());
        }
        this.printNode(node);//D
        if(node.getRightNode()!=null){//R
            this.in_order(node.getRightNode());
        }
    }

    //后序遍历
    public void post_order(TreeNode<String> node){
        if(node.getLeftNode()!=null){//L
            this.post_order(node.getLeftNode());
        }
        if(node.getRightNode()!=null){//R
            this.post_order(node.getRightNode());
        }
        this.printNode(node);//D
    }

    public void level(TreeNode<String> node){
        Queue<TreeNode<String>> queue=new ArrayDeque<TreeNode<String>>();
        queue.add(node);
        while(!queue.isEmpty()){
            TreeNode<String> n=queue.poll();
            this.printNode(n);
            if(n.getLeftNode()!=null){
                queue.add(n.getLeftNode());
            }
            if(n.getRightNode()!=null){
                queue.add(n.getRightNode());

            }

        }
    }

    public static void main(String[] args) {
        Traverse Tree=new Traverse();
        TreeNode<String> node=Tree.init();
        System.out.println("先序遍历DLR的情况");
        Tree.pre_order(node);

        System.out.println("中序LDR遍历的情况");
        Tree.in_order(node);

        System.out.println("后序遍历LRD的情况");
        Tree.post_order(node);
        Tree.level(node);
    }
}
