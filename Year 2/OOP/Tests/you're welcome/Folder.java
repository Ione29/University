import java.util.ArrayList;

public class Folder{
    private ArrayList<Photo> photos = new ArrayList<Photo>();    
    private String name;

    public Folder(String vName){
        this.name = vName;
    }

    public ArrayList<Photo> getPhotos(){
        return this.photos;
    }

    public String getName(){
        return this.name;
    }

    public void addPhoto(Photo vPhoto){
        photos.add(vPhoto);
    }

    public String toString(){
        String text = "";
        for(Photo photo : photos)
            text += photo.toString() + "\n";

        return text;
        
    }
}
