public class Main {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.add("test");
        linkedList.add("text");
        linkedList.add("rest");
        linkedList.add("vest");
        linkedList.add("chest");

        linkedList.add("added", 2);
        linkedList.remove();
    }
}
