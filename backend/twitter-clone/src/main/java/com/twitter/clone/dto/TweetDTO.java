package com.twitter.clone.dto;

import com.twitter.clone.model.Tweet;
import java.time.LocalDateTime;

public class TweetDTO {
    
    private Long id;
    private String content;
    private UserDTO author;
    private Integer likesCount;
    private Integer retweetsCount;
    private Integer repliesCount;
    private LocalDateTime createdAt;
    private boolean isLikedByCurrentUser;
    private Long replyToId;

    public TweetDTO() {}

    public TweetDTO(Tweet tweet) {
        this.id = tweet.getId();
        this.content = tweet.getContent();
        this.author = new UserDTO(tweet.getAuthor());
        this.likesCount = tweet.getLikesCount();
        this.retweetsCount = tweet.getRetweetsCount();
        this.repliesCount = tweet.getRepliesCount();
        this.createdAt = tweet.getCreatedAt();
        this.replyToId = tweet.getReplyTo() != null ? tweet.getReplyTo().getId() : null;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public UserDTO getAuthor() { return author; }
    public void setAuthor(UserDTO author) { this.author = author; }

    public Integer getLikesCount() { return likesCount; }
    public void setLikesCount(Integer likesCount) { this.likesCount = likesCount; }

    public Integer getRetweetsCount() { return retweetsCount; }
    public void setRetweetsCount(Integer retweetsCount) { this.retweetsCount = retweetsCount; }

    public Integer getRepliesCount() { return repliesCount; }
    public void setRepliesCount(Integer repliesCount) { this.repliesCount = repliesCount; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public boolean isLikedByCurrentUser() { return isLikedByCurrentUser; }
    public void setLikedByCurrentUser(boolean likedByCurrentUser) { isLikedByCurrentUser = likedByCurrentUser; }

    public Long getReplyToId() { return replyToId; }
    public void setReplyToId(Long replyToId) { this.replyToId = replyToId; }
}
