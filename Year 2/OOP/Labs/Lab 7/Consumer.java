import java.io.FileWriter;
import java.io.IOException;

public class Consumer extends Thread{
    private SharedRes sharedRes;
    
    public Consumer(String name, SharedRes vSharedRes){
        super(name);
        this.sharedRes = vSharedRes;
    }

    @Override
    public void run(){
        while(true){
            Candidate candidate = sharedRes.remove();
            System.out.println(getName() + " removed " + candidate.getName() + " from queue");
            if(candidate.getEducationLevel() > 3)
                try{
                    System.out.println("Candidate " + candidate.getName() + " passed...");

                    FileWriter writer = new FileWriter(candidate.getName());
                    writer.write(candidate.toString());
                    writer.close();

                }catch(IOException e){
                    System.out.println("There was an error in writing the file of candidate " + candidate.getName());
                    e.printStackTrace();
                }
            else{
                try {
                    System.out.println("Candidate " + candidate.getName() + " didn't pass: education level not high enough...");
                    FileWriter rejectWriter = new FileWriter("rejected_candidates.txt", true);
                    rejectWriter.write(candidate.toString());
                    rejectWriter.close();
                } catch (IOException e) {
                    System.out.println("Error writing in the \"rejected_candidates\" file.");
                }
            }
        }           
    }
}
