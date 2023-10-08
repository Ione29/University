import java.util.ArrayList;

public class Album{
    private ArrayList<Folder> folders = new ArrayList<Folder>();    
    private String name;

    public Album(String vName){
        this.name = vName;
    }

    public void addPhoto(Photo vPhoto, Folder vFolder){
        if(folders.contains(vFolder) == false)
            System.out.println("The folder in which you wish to add the photo could not be found.");
        else
        {
            int index = folders.indexOf(vFolder);
            Folder copy = folders.get(index);
            folders.remove(index);

            copy.addPhoto(vPhoto);
            folders.add(copy);
        }
    }

    public void addFolder(Folder vFolder){
        folders.add(vFolder);
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Folder> getFolders(){
        return this.folders;
    }

    public String toString(){
        String text = "";
        for(Folder folder : folders)
            text += folder.toString() + "\n";

        return text;
    }
}
