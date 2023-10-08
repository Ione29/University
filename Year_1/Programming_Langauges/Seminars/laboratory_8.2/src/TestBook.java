public class TestBook
{
    public static void main(String args[])
    {
        Author anAuthor = new Author("Student", "student@upb.ro.", 'm');
        Book aBook = new Book("Java for dummies", anAuthor, 19.95, 1000);

        Book anotherBook = new Book("C for dummies", new Author("Teacher", "Teacher@upb.ro", 'm'), 29.95, 999);
        //a)
        System.out.println("a)");
        System.out.println(aBook.toString());
        System.out.println(anotherBook.toString());
        //b)
        System.out.println("\nb)");
        System.out.println(aBook.getAuthor().getName());
        System.out.println(aBook.getAuthor().getEmail());
        System.out.println();
        System.out.println(anotherBook.getAuthor().getName());
        System.out.println(anotherBook.getAuthor().getEmail());
        //c)
        System.out.println("\nc)");
        System.out.println(aBook.getAuthorName());
        System.out.println(aBook.getAuthorEmail());
        System.out.println(aBook.getAuthorGender());

        System.out.println();

        System.out.println(anotherBook.getAuthorName());
        System.out.println(anotherBook.getAuthorEmail());
        System.out.println(anotherBook.getAuthorGender());
    }
}
