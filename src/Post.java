import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;

public class Post implements Interactive, Shareable, Comparable<Post> {
    private String id;
    private String authorName;
    private String content;
    private LocalDateTime createdAt;
    private HashSet<String> likes;
    private HashSet<Comment> comments;
    private HashSet<String> shares;

    public Post(String authorName, String content) {
        this.id = UUID.randomUUID().toString();
        this.authorName = authorName;
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.likes = new HashSet<>();
        this.comments = new HashSet<>();
        this.shares = new HashSet<>();
    }

    public int getLikeCount() {
        return likes.size();
    }

    public int getCommentCount() {
        return comments.size();
    }

    @Override
    public void share(String username) {
        shares.add(username);
    }

    @Override
    public void unshare(String username) {
        shares.remove(username);
    }

    @Override
    public void like(String username) {
        likes.add(username);
    }

    @Override
    public void unlike(String username) {
        likes.remove(username);
    }

    @Override
    public void addComment(String username, String content) {
        comments.add(new Comment(username, content));
    }

    @Override
    public void removeComment(String commentId, String username) {
        Optional<Comment> comment = comments.stream().filter(cm -> cm.getAuthorName().equals(username) && cm.getId().equals(commentId)).findFirst();
        if (comment.isPresent()) {
            comments.remove(comment);
        } else {
            Optional.empty();
        }
    }

    public String getId() {
        return id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public int compareTo(Post o) {
        return this.createdAt.compareTo(o.createdAt);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Post{");
        sb.append("id='").append(id).append('\'');
        sb.append(", authorName='").append(authorName).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", createdAt=").append(createdAt);
        sb.append(", likes=").append(likes);
        sb.append(", comments=").append(comments);
        sb.append(", shares=").append(shares);
        sb.append('}');
        return sb.toString();
    }


}
