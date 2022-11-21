import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.time.LocalDate;
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
        
        Photo p1 = new Photo("family1.jpeg", LocalDate.of(2002, 9, 20), 4);
        Photo p2 = new Photo("family2.jpeg", LocalDate.of(2002, 9, 21), 5);
        Photo p3 = new Photo("family3.jpeg", LocalDate.of(2002, 10, 1), 2);
        Photo p4 = new Photo("work1.jpeg", LocalDate.of(2002, 3, 30), 1);
        Photo p5 = new Photo("work2.jpeg", LocalDate.of(2002, 3, 30), 3);
        Photo p6 = new Photo("work3.jpeg", LocalDate.of(2002, 3, 30), 2);
        Photo p7 = new Photo("holiday1.jpeg", LocalDate.of(2002, 6, 10), 5);
        Photo p8 = new Photo("holiday2.jpeg", LocalDate.of(2002, 6, 11), 2);
        Photo p9 = new Photo("holiday3.jpeg", LocalDate.of(2002, 12, 24), 3);

        Folder f1 = new Folder("School Opening Day");
        f1.addPhoto(p1);
        f1.addPhoto(p2);
        Folder f2 = new Folder("My Birthday");
        f2.addPhoto(p3);

        Folder f3 = new Folder("Corporate TeamBuilding");
        f3.addPhoto(p4);
        f3.addPhoto(p5);
        f3.addPhoto(p6);
        
        Folder f4 = new Folder("Thasos holiday");
        f4.addPhoto(p7);
        f4.addPhoto(p8);
        Folder f5 = new Folder("Sinaia holiday");
        f5.addPhoto(p5);

        Album a1 = new Album("family");
        a1.addFolder(f1);
        a1.addFolder(f2);
        Album a2 = new Album("work");
        a2.addFolder(f3);
        Album a3 = new Album("holiday");
        a3.addFolder(f4);
        a3.addFolder(f5);

        a1.toString();

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
