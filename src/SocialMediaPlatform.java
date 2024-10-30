import java.time.LocalDateTime;
import java.util.*;

public class SocialMediaPlatform {
    private HashMap<String, User> users;
    private TreeMap<LocalDateTime, Post> timeline;

    public SocialMediaPlatform() {

        this.users = new HashMap<>();
        this.timeline = new TreeMap<>(new Comparator<LocalDateTime>() {
            @Override
            public int compare(LocalDateTime o1, LocalDateTime o2) {
                return o2.compareTo(o1);
            }
        });
    }
    public void registerUser(String username){
        if(!users.containsKey(username)){
            users.put(username, new User(username));
        }else{
            System.err.println("This username is already used");
        }
    }

    public void addPost(Post post){
        timeline.put(post.getCreatedAt(), new Post(post.getAuthorName(), post.getContent()));

        if(users.containsKey(post.getAuthorName())){
            User user = users.get(post.getAuthorName());
            user.addPost(post);
        }else{
            System.err.println("This user does not exist");
        }
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public ArrayList<Post> getFeed(String username){
        ArrayList<Post> interestedPosts = new ArrayList<>();
        User currenctUser;

        if(!users.containsKey(username)){
            return interestedPosts;
        }
        else{
            currenctUser= users.get(username);
        }
        for (Post value : timeline.values()) {
            if(currenctUser.getFollowing().contains(value.getAuthorName())){
                interestedPosts.add(value);
            }
        }
        interestedPosts.sort(Comparator.comparingInt(post -> post.getCommentCount() + post.getLikeCount()));
        interestedPosts.reversed();
        return interestedPosts;
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SocialMediaPlatform{");
        sb.append("users=").append(users);
        sb.append(", timeline=").append(timeline);
        sb.append('}');
        return sb.toString();
    }
}
