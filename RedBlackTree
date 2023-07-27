import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RedBlackTree {

    private Node root;

    private class Node {
        private int value;
        private Color color;
        private Node left, right;

        Node(int value){
            this.value = value;
            left = null;
            right = null;
            color = Color.RED;
        }
    }
    private enum Color{
        RED, BLACK
    }
    public boolean add(int value){
        if (root != null){
            boolean result = addNode(root, value);
            root = rebalnce(root);
            root.color = Color.BLACK;
            return result;
        } else{
            root = new Node(value);
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }
    private boolean addNode(Node node, int value){
       if (node.value == value) return false;
       else{
           if (node.value > value) {
               if (node.left != null){
                   boolean result = addNode(node.left, value);
                   node.left = rebalnce(node.left);
                   return result;
               } else{
                   node.left = new Node(value);
                   node.left.color = Color.RED;
                   node.left.value = value;
                   return true;
               }
           } else{
               if (node.right != null){
                   boolean result = addNode(node.right, value);
                   node.right = rebalnce(node.right);
                   return result;
               } else{
                   node.right = new Node(value);
                   node.right.color = Color.RED;
                   node.right.value = value;
                   return true;
               }
           }
       }
    }

    private Node rebalnce(Node node) {
        Node result = node;
        boolean needRebalance;
        do{
            needRebalance = false;
            if (result.right != null && result.right.color == Color.RED &&
                    (result.left == null || result.left.color == Color.BLACK)){
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
                    result.left.left != null && result.left.left.color == Color.RED){
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
                    result.right!= null && result.right.color == Color.RED){
                needRebalance = true;
                colorSwap(result);
            }
        } while (needRebalance);
        return result;
    }
    private void colorSwap(Node node){
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;
    }
    private Node rightSwap(Node node){
        Node rigth = node.right;
        Node between = rigth.left;
        rigth.left = node;
        node.right = between;
        rigth.color = node.color;
        node.color = Color.RED;
        return rigth;
    }
    private Node leftSwap(Node node){
        Node left = node.left;
        Node between = left.right;
        left.right = node;
        node.left = between;
        left.color = node.color;
        node.color = Color.RED;
        return left;
    }


    public static void main(String[] args) {
        final RedBlackTree tree = new RedBlackTree();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while(true){
                try{
                    int value = Integer.parseInt(reader.readLine());
                    tree.add(value);
                    System.out.println("finish");
                } catch (Exception ignored){

                }
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
