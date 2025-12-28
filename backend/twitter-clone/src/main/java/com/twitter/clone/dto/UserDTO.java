package com.twitter.clone.dto;

import com.twitter.clone.model.User;
import java.time.LocalDateTime;

public class UserDTO {
    
    private Long id;
    private String username;
    private String email;
    private String displayName;
    private String bio;
    private String avatarUrl;
    private Integer followersCount;
    private Integer followingCount;
    private Integer tweetsCount;
    private Boolean verified;
    private LocalDateTime createdAt;

    public UserDTO() {}

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.displayName = user.getDisplayName();
        this.bio = user.getBio();
        this.avatarUrl = user.getAvatarUrl();
        this.followersCount = user.getFollowersCount();
        this.followingCount = user.getFollowingCount();
        this.tweetsCount = user.getTweetsCount();
        this.verified = user.getVerified();
        this.createdAt = user.getCreatedAt();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    public String getAvatarUrl() { return avatarUrl; }
    public void setAvatarUrl(String avatarUrl) { this.avatarUrl = avatarUrl; }

    public Integer getFollowersCount() { return followersCount; }
    public void setFollowersCount(Integer followersCount) { this.followersCount = followersCount; }

    public Integer getFollowingCount() { return followingCount; }
    public void setFollowingCount(Integer followingCount) { this.followingCount = followingCount; }

    public Integer getTweetsCount() { return tweetsCount; }
    public void setTweetsCount(Integer tweetsCount) { this.tweetsCount = tweetsCount; }

    public Boolean getVerified() { return verified; }
    public void setVerified(Boolean verified) { this.verified = verified; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
