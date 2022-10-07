public class Test
{
    public static void main(String[] args)
    {
        University universitate = new University();

        Author autor1 = new Author();
        Author autor2 = new Author();

        Journal jurnal1 = new Journal("jurn1", 5, 3.6, "Expeditions");
        Journal jurnal2 = new Journal("jurn2", 2, 4.2, "Cooking");
        Journal jurnal3 = new Journal("jurn3", 1, 4.8, "Solidarity");
        Journal jurnal4 = new Journal("jurn4", 6, 3, "Board Games");
        ConferenceProceeding conferinta1 = new ConferenceProceeding("publ1", 7, true, "Geometry");
        ConferenceProceeding conferinta2 = new ConferenceProceeding("publ2", 5, false, "Calculus");
        ConferenceProceeding conferinta3 = new ConferenceProceeding("publ3", 3, true,"Algebra");
        ConferenceProceeding conferinta4 = new ConferenceProceeding("publ4", 2, false, "Java");

        autor1.addPublication(jurnal1);
        autor1.addPublication(jurnal2);
        autor1.addPublication(conferinta1);
        autor1.addPublication(conferinta2);

        autor2.addPublication(jurnal3);
        autor2.addPublication(jurnal4);
        autor2.addPublication(conferinta3);
        autor2.addPublication(conferinta4);

        universitate.addAuthor(autor1);
        universitate.addAuthor(autor2);

        System.out.println("The score of the first author is " + autor1.computeScore());
        System.out.println("The score of the second author is " + autor2.computeScore());
        System.out.println("The overall score of the university is " + universitate.computeScore());
    }
}
