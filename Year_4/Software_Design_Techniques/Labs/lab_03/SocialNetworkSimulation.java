import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// observer interface
interface Observer {
    void update(String status, User subject);
}

// subject interface
interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String status);
}

// user class implementing both Observer and Subject
class User implements Subject, Observer {
    private String name;
    private List<Observer> followers;

    public User(String name) {
        this.name = name;
        followers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // we implement the methods for the observer & subject interfaces
    @Override
    public void registerObserver(Observer o) {
        followers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        followers.remove(o);
    }

    @Override
    public void notifyObservers(String status) {
        for (Observer o : followers) {
            o.update(status, this);
        }
    }

    public void postStatus(String status) {
        System.out.println(name + " posted the status: '" + status + "'");
        notifyObservers(status);
    }

    @Override
    public void update(String status, User subject) {
        System.out.println(name + " was notified that " + subject.getName() + " posted the status: '" + status + "'");
    }
}

// main class
public class SocialNetworkSimulation {
    public static void main(String[] args) {
        // define some users
        User user1 = new User("User1");
        User user2 = new User("User2");
        User user3 = new User("User3");
        User user4 = new User("User4");
        User user5 = new User("User5");

        // add some followers
        // user2 and user3 follow user1
        user1.registerObserver(user2);
        user1.registerObserver(user3);

        // user1 follows user2
        user2.registerObserver(user1);

        // user3 follows everyone
        user1.registerObserver(user3);
        user2.registerObserver(user3);
        user4.registerObserver(user3);
        user5.registerObserver(user3);

        // user4 follows user1 and user2
        user1.registerObserver(user4);
        user2.registerObserver(user4);

        // user5 follows user3
        user3.registerObserver(user5);

        // create list of users
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        // Sample statuses
        String[] statuses = {
            "Made omelette, looks delicious",
            "I'm on a seafood diet. I see food and I eat it!",
            "Why is it that my phone battery lasts longer than my will to socialize?",
            "I just finished binge-watching my favorite series and now I have no idea what to do with my life!",
            "Some days, the best thing about my job is that the chair spins.",
            "Relationships always start out as \"You're smart and funny.\" and end up as \"You think you know everything and it's all a joke to you!\"",
            "Chasing dreams and catching moments! ",
        };

        Random random = new Random();

        // simulate random statuses
        int numberOfPosts = 5;
        for (int i = 0; i < numberOfPosts; i++) {
            System.out.println("\nPost " + i + ":");
            // randomly select a user
            User poster = users.get(random.nextInt(users.size()));
            // randomly select a status
            String status = statuses[random.nextInt(statuses.length)];
            // user posts the status
            poster.postStatus(status);
            // simulate time passing (optional)
            try {
                Thread.sleep(500); // Sleep for 0.5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
