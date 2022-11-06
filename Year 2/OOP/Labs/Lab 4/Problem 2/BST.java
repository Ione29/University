import java.lang.Comparable;

public class BST<T extends Comparable<T>> {
    private Node<T> root = null;
    
    private static class Node<U>{
        U val;
        Node<U> left, right;
        public Node(U val) {
            this.val = val;
        }
    }

    public void add(T val) {
        root = insertRec(root, val);
    }

    private Node<T> insertRec(Node<T> root, T val) {
        if (root == null) {
            Node<T> newNode= new Node<T>(val);
            return newNode;
        }

        if (val.compareTo(root.val) < 0)
            root.left = insertRec(root.left, val);
        else if (val.compareTo(root.val) > 0)
            root.right = insertRec(root.right, val);
        return root;
    }

    public void inOrder(){
        inOrderRec(root);
    }

    private void inOrderRec(Node<T> curr) {
        if (curr.left != null)
            inOrderRec(curr.left);
        System.out.print(curr.val+" ");
        if (curr.right != null)
            inOrderRec(curr.right);
    }
}

