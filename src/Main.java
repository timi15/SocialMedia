import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        SocialMediaPlatform smp = new SocialMediaPlatform();
        HashMap<String, User> users = smp.getUsers();

        smp.registerUser("test1");
        User user1 = users.get("test1");
        Post post1 = new Post(user1.getUsername(), "user1 first post");
        user1.addPost(post1);
        smp.addPost(post1);


        smp.registerUser("test2");
        User user2 = users.get("test2");
        Post post2 = new Post(user2.getUsername(), "user2 first post");
        user2.addPost(post2);
        smp.addPost(post2);

        smp.registerUser("test3");
        User user3 = users.get("test3");
        Post post3 = new Post(user3.getUsername(), "user3 first post");
        Post post31 = new Post(user3.getUsername(), "user3 post");
        user3.addPost(post3);
        user3.addPost(post31);
        smp.addPost(post3);
        smp.addPost(post31);

        user1.follow(user2.getUsername());
        user1.follow(user3.getUsername());
        user2.follow(user3.getUsername());
        user3.addFollower(user2.getUsername());
        user1.unfollow(user3.getUsername());
        user3.follow(user1.getUsername());
        user3.follow(user2.getUsername());

        post1.like(user3.getUsername());
        post31.like(user2.getUsername());
        post3.unlike(user1.getUsername());
        post3.share(user2.getUsername());
        post2.addComment(user3.getUsername(), "first comment");

        System.out.println("\n ------------- Users -------------------- \n");

        for (Map.Entry<String, User> userEntry : users.entrySet()) {
            String key = userEntry.getKey();
            User valus = userEntry.getValue();

            System.out.println(key + " " + valus);
        }


        System.out.println("\n ----------- Users feed -------------- \n");

        System.out.println("Test1's feed");
        ArrayList<Post> feedUser1 = smp.getFeed(user1.getUsername());
        for (Post post : feedUser1) {
            System.out.println(post);
        }

        System.out.println("Test2's feed");
        ArrayList<Post> feedUser2 = smp.getFeed(user2.getUsername());
        for (Post post : feedUser2) {
            System.out.println(post);
        }

        System.out.println("Test3's feed");
        ArrayList<Post> feedUser3 = smp.getFeed(user3.getUsername());
        for (Post post : feedUser3) {
            System.out.println(post);
        }










    }
}