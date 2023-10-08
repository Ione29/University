public class Main {
    public static <T extends Comparable<T>> void sort (T[] arr) {
        int n = arr.length;

        while (n > 0)
        {
            int lastModified = 0;
            for(int i=0; i < n; i++){  
                for(int j=1; j < (n-i); j++){  
                    if(arr[j-1].compareTo(arr[j]) > 0){   
                        T temp = arr[j-1];  
                        arr[j-1] = arr[j];  
                        arr[j] = temp;
                    }  
                              
                }  
            }

            n = lastModified;
        }
    }

    public static void main(String[] args) {
        Integer[] arr1 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        String[] arr2 ={"test", "vest", "text", "chest", "apple"};

        sort(arr1);
        sort(arr2);

        System.out.println("arr1:");
        for(Integer nr : arr1)
            System.out.print(nr + " ");
        
        System.out.println("\narr2:");
        for(String nr : arr2)
            System.out.print(nr + " ");

    }
}
