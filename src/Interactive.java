public interface Interactive {
    void like(String username);
    void unlike(String username);
    void addComment(String username, String content);
    void removeComment(String commentId, String username);
}
