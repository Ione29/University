public class BSRTMain {
  public static void main(String[] args) {
    BST<Integer> bst = new BST<Integer>();

    bst.add(7);
    bst.add(8);
    bst.add(10);
    bst.add(4);
    bst.add(5);
    bst.add(9);

    String text = bst.toString();
    System.out.println(text);
    
  }
}
