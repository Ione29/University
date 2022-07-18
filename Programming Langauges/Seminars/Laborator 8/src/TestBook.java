public class TestBook{
    public static void main(String []args){
        Author anAuthor=new Author("Student","student@upb.ro","m");
        Book aBook = new Book("Java for dummies", anAuthor, 19.95,1000);
        Book anotherBook = new Book("C for dummies", new Author("Teacher","teacher@upb.ro","m"), 19.95,1000);

        System.out.println(aBook.toString());
        System.out.println(anotherBook.toString() + "\n");

        System.out.println(aBook.getAuthor().getName() + " " + aBook.getAuthor().getEmail());
        System.out.println(anotherBook.getAuthor().getName() + " " + anotherBook.getAuthor().getEmail() + "\n");

        System.out.println(aBook.getAuthorName() + " " + aBook.getAuthorEmail() + " " + aBook.getAuthorGender());
        System.out.println(anotherBook.getAuthorName() + " " + anotherBook.getAuthorEmail() + " " + anotherBook.getAuthorGender());

    }
}