public class Producer extends Thread{
    public Candidate candidate;
    private SharedRes sharedRes;

    public Producer(String name, SharedRes vSharedRes ,Candidate vCandidate){
        super(name);
        this.sharedRes = vSharedRes;
        this.candidate = vCandidate;
    }

    @Override
    public void run(){
        sharedRes.produce(candidate);
        System.out.println(this.getName() + " added candidate " + candidate.getName());
    }
}

