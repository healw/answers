package day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Package:day3
 * @Author: wyb
 * @DATE:2022/8/31
 * @Description:
 */
public class preorder589 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public void main(String[] args) {
        List<Node> children = new ArrayList<>();
        Node root =new Node(1,children);
        List<Integer> nodes = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        preorder(root,nodes);
        preorder2(nodes,stack);
    }

    public static void preorder(Node root,List<Integer> nodes) {
        if(root == null){
            return ;
        }
        nodes.add(root.val);
        for (Node node : root.children){
            preorder(node,nodes);
        }
    }

    public static void preorder2(List<Integer> nodes,Stack<Node> stack) {
        if(stack.isEmpty()){
            return ;
        }
        Node node = stack.peek();
        nodes.add(node.val);
        if (node.children != null){
            for (int i = node.children.size() - 1; i >= 0; i--){
                stack.push(node.children.get(i));
            }
        }
        preorder2(nodes, stack);
    }
}
