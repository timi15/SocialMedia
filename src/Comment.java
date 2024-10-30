import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Comment {
    private String id;
    private String authorName;
    private String content;
    private LocalDateTime createdAt;

    public Comment(String authorName, String content) {
        this.id = UUID.randomUUID().toString();
        this.authorName = authorName;
        this.content = content;
        this.createdAt = LocalDateTime.now();
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment comment)) return false;
        return Objects.equals(id, comment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Comment{");
        sb.append("id='").append(id).append('\'');
        sb.append(", authorName='").append(authorName).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", createdAt=").append(createdAt);
        sb.append('}');
        return sb.toString();
    }
}
