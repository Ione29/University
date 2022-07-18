public class TestAuthor
{
    public static void main(String args[])
    {
        Author anAuthor = new Author("Author", "Author@upb.ro", 'm');
        System.out.println(anAuthor.toString());

        anAuthor.setEmail("Author@fils.upb.ro");
        System.out.println(anAuthor.toString());
    }
}
