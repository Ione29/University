public class Main {
    public static void main(String[] args) {
        MapImpl<Integer, String> intMap = new MapImpl<Integer, String>(); 
        
        intMap.add(1, "Alex");
        intMap.add(2, "Nicu");
        intMap.add(3, "Vlad");

        intMap.print();
        intMap.remove(2);
        System.out.println();
        intMap.print();
    }
}
