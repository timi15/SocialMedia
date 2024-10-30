import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.TreeSet;

public class User {
    private String username;
    private HashSet<String> followers ;
    private HashSet<String> following;
    private TreeSet<Post> posts;

    public User(String username) {
        this.username = username;
        this.followers = new HashSet<>();
        this.following = new HashSet<>();
        this.posts = new TreeSet<>(Comparator.comparing(Post::getCreatedAt).reversed());
    }

    public void follow(String username) {
        following.add(username);
    }

    public void unfollow(String username) {
        following.remove(username);
    }

    public void addFollower(String username) {
        followers.add(username);
    }

    public void removeFollower(String username) {
        followers.remove(username);
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public String getUsername() {
        return username;
    }

    public TreeSet<Post> getPosts() {
        return posts;
    }

    public HashSet<String> getFollowing() {
        return following;
    }

    public HashSet<String> getFollowers() {
        return followers;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("username='").append(username).append('\'');
        sb.append(", followers=").append(followers);
        sb.append(", following=").append(following);
        sb.append(", posts=").append(posts);
        sb.append('}');
        return sb.toString();
    }
}
