public class TestAuthor{
    public static void main(String []args){
        Author anAuthor=new Author("Author","author@upb.ro","f");
        System.out.println(anAuthor.toString());

        anAuthor.setEmail("Author@fils.upb.ro");
        System.out.println(anAuthor.toString());
    }
}