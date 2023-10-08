public class Main
{
    public static void main(String[] args)
    {
        Song song1 = new Song("Highway to Hell", "AC/DC", 2.15, "Rock");
        Song song2 = new Song("Highway to Hell", "AC/DC", 2.15, "Rock");
        Song song3 = new Song("Highway to Hell", "AC/DC", 2.15, "Rock");
        Song song4 = new Song("Highway to Hell", "AC/DC", 2.15, "Rock");
        Song song5 = new Song("Highway to Hell", "AC/DC", 2.15, "Rock");
        Song song6 = new Song("Highway to Hell", "AC/DC", 2.15, "Rock");
        Playlist Music = new Playlist();

        Music.addSong(song1);
        Music.addSong(song2);
        Music.addSong(song3);
        Music.addSong(song4);
        Music.addSong(song5);
        Music.addSong(song6);

        Music.printSongs();
        Music.removeByTitle("Highway to Hell");
        Music.printSongs();
        Music.removeByArtist("AC/DC");
        Music.printSongs();

        song1 = new Song("Pala Mande", "Azteca", 2.15, "Muzica occulta");
        song2 = new Song("Janes Romanes", "Cristi Mega", 2.15, "Muzica culta");
        song3 = new Song("Banii", "Tzanca Uraganu", 2.15, "Muzica culta");
        song4 = new Song("Afaceri Ilegale", "Dani Mocanu", 2.15, "Muzica culta");
        song5 = new Song("Za Arabia", "Florin Salam", 2.15, "Muzica culta");
        song6 = new Song("Moonlight Sonata Movement 3", "Beethoven", 2.15, "Ceva classic");

        Music.addSong(song1);
        Music.addSong(song2);
        Music.addSong(song3);
        Music.addSong(song4);
        Music.addSong(song5);
        Music.addSong(song6);

        Music.printSongs();
        Music.Shuffle();
        Music.printSongs();
    }
}