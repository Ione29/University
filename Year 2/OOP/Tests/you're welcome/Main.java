import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static Map<Integer, Set<Photo>> mapByScore(Album vAlbum){
        Map<Integer, Set<Photo>> scoreMap = new HashMap<Integer,Set<Photo>>();

        Set<Photo> scoreOne = new HashSet<Photo>();
        Set<Photo> scoreTwo = new HashSet<Photo>();
        Set<Photo> scoreThree = new HashSet<Photo>();
        Set<Photo> scoreFour = new HashSet<Photo>();
        Set<Photo> scoreFive = new HashSet<Photo>();

        for(Folder folder : vAlbum.getFolders())
            for(Photo photo : folder.getPhotos())
                switch (photo.getScore()) {
                    case 1:
                        scoreOne.add(photo);        
                        break;
                    case 2:
                        scoreTwo.add(photo);
                        break;
                    case 3:
                        scoreThree.add(photo);
                        break;
                    case 4:
                        scoreFour.add(photo);
                        break;
                    case 5:
                        scoreFive.add(photo);
                        break;
                }

        scoreMap.put(1, scoreOne);
        scoreMap.put(2, scoreTwo);
        scoreMap.put(3, scoreThree);
        scoreMap.put(4, scoreFour);
        scoreMap.put(5, scoreFive);

        return scoreMap;
    }

    public static Map<String, List<Photo>> albumMap(ArrayList<Album> vAlbums){
        Map<String, List<Photo>> albumMap = new HashMap<String, List<Photo>>();

        for(Album album : vAlbums){
            //make the list with photos for each album
            ArrayList<Photo> photoList = new ArrayList<Photo>();
            for(Folder folder : album.getFolders())
                for(Photo photo : folder.getPhotos())
                    photoList.add(photo);

            //sort the list 
            Collections.sort(photoList,
            new Comparator<Photo>(){
                public int compare(Photo p1, Photo p2){
                    return p1.getScore().compareTo(p2.getScore());
                }
            });

            //add the key:value combo album name:photoList to the map
            albumMap.put(album.getName(), photoList);
        }

        return albumMap;
    }

    public static void main(String[] args) {
        


        Album a1 = new Album("family");
        Album a2 = new Album("work");
        Album a3 = new Album("holiday");

        Map<Integer, Set<Photo>> scoreMap1 = new HashMap<Integer,Set<Photo>>();
        Map<Integer, Set<Photo>> scoreMap2 = new HashMap<Integer,Set<Photo>>();
        Map<Integer, Set<Photo>> scoreMap3 = new HashMap<Integer,Set<Photo>>();
        scoreMap1 = mapByScore(a1);
        scoreMap2 = mapByScore(a2);
        scoreMap3 = mapByScore(a3);

        ArrayList<Album> albums = new ArrayList<Album>();
        albums.add(a1);
        albums.add(a2);
        albums.add(a3);
        Map<String, List<Photo>> sortedAlbumsMap = new HashMap<String, List<Photo>>();
        sortedAlbumsMap = albumMap(albums);


    }
}
