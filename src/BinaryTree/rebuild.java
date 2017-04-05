package BinaryTree;

import sun.applet.Main;

/**
 * Created by MOMO on 2017/3/28.
 */
public class rebuild {
    public static void main(String[] args) {
        int [] pre={1,2,4,7,3,5,6,8};
        int [] in={4,7,2,1,5,3,8,6};
        rebuild rebuild=new rebuild();
        TreeNode treeNode=rebuild.reConstructBinaryTree(pre,in);
        rebuild.pre_order(treeNode);

    }
    public void printNode(TreeNode node){
        System.out.println(node.val+" ");

    }

    public void pre_order(TreeNode node){
        this.printNode(node);//D
        if(node.left!=null){//L
            this.pre_order(node.left);
        }
        if(node.right!=null){
            this.pre_order   (node.right);
        }
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {

        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);
        //找到in中的根节点

        for(int i=startIn;i<=endIn;i++)
            if(in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
            }
        return root;
    }

}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}