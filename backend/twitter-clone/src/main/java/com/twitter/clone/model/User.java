package com.twitter.clone.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(unique = true)
    String username;

    @NotBlank
    @Email
    @Column(unique = true)
    String email;

    @NotBlank
    @Size(min = 6)
    String password;

    @Size(max = 100)
    String displayName;

    @Size(max = 500)
    String bio;

    String avatarUrl;

    @Builder.Default
    @Column(name = "followers_count")
    Integer followersCount = 0;

    @Builder.Default
    @Column(name = "following_count")
    Integer followingCount = 0;

    @Builder.Default
    @Column(name = "tweets_count")
    Integer tweetsCount = 0;

    @Builder.Default
    Boolean verified = false;

    @Column(name = "created_at")
    LocalDateTime createdAt;

    @Column(name = "updated_at")
    LocalDateTime updatedAt;

    @OneToMany(
        mappedBy = "author",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    @Builder.Default
    List<Tweet> tweets = new ArrayList<>();
    
    @ManyToMany
    @JoinTable(
        name = "user_follows",
        joinColumns = @JoinColumn(name = "follower_id"),
        inverseJoinColumns = @JoinColumn(name = "following_id")
    )
    @Builder.Default
    Set<User> following = new HashSet<>();

    @Builder.Default
    @ManyToMany(mappedBy = "following")
    Set<User> followers = new HashSet<>();

    @Enumerated(EnumType.STRING)
    Role role;


    // UserDetails implementation
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((role.name())));
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}