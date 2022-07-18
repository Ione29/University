import java.util.Random;

public class Playlist
{
    private Song[] songs;

    public Playlist()
    {
        songs = new Song[0];
    }

    private void copy(Song[] target, Song[] array)
    {
        for(int i = 0; i < Math.min(target.length, array.length); i++)
            target[i] = array[i];
    }

    public void addSong(Song song)
    {
        if(songs.length == 0)
        {
            songs = new Song[1];
            songs[0] = song;
        }
        else
        {
            Song temp[] = new Song[songs.length + 1];
            copy(temp, songs);
            temp[songs.length] = song;
            songs = new Song[temp.length];
            copy(songs, temp);
            temp = null;
        }
    }

    public void removeByTitle(String title)
    {
        int i = 0, n = songs.length;
        while(i < n)
            if(songs[i].getTitle() == title)
            {
                for(int j = 0; j < n - 1; j++)
                    songs[j] = songs[j + 1];
                n--;
            }
            else
                i++;
        Song[] temp = new Song[n];
        copy(temp, songs);
        songs = temp.clone();
    }

    public void removeByArtist(String artist)
    {
        int i = 0, n = songs.length;
        while(i < n)
            if(songs[i].getArtist() == artist)
            {
                for(int j = 0; j < n - 1; j++)
                    songs[j] = songs[j + 1];
                n--;
            }
            else
                i++;
        Song[] temp = new Song[n];
        copy(temp, songs);
        songs = temp.clone();
    }

    public double albumDuration()
    {
        double sum = 0;
        for(Song song : songs)
            sum += song.getDuration();
        return sum;
    }

    private static boolean checkExistance(Song[] songs, Song song)
    {
        if(songs[0] == null)
            return false;
        for(int i = 0; i < songs.length; i++)
            if(songs[i] != null && songs[i] == song)
                return true;
        return false;
    }

    public void Shuffle()
    {
        Song[] temp = new Song[songs.length];
        for(int i = 0; i < songs.length; i++)
        {
            Random rand = new Random();
            int poz = rand.nextInt(songs.length);
            while(checkExistance(temp, songs[poz]) == true)
                poz = rand.nextInt(songs.length);
            temp[i] = songs[poz];
        }
        songs = temp.clone();
    }

    public void printSongs()
    {
        System.out.println(songs.length);
        for(int i = 0; i < songs.length; i++)
            System.out.println(songs[i]);
    }

}