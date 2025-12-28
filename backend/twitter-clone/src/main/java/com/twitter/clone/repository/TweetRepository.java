package com.twitter.clone.repository;

import com.twitter.clone.model.Tweet;
import com.twitter.clone.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
    
    @Query("SELECT t FROM Tweet t WHERE t.author IN :followedUsers OR t.author = :currentUser ORDER BY t.createdAt DESC")
    Page<Tweet> findTimelineTweets(@Param("followedUsers") List<User> followedUsers, 
                                  @Param("currentUser") User currentUser, 
                                  Pageable pageable);
    
    Page<Tweet> findByAuthorOrderByCreatedAtDesc(User author, Pageable pageable);
    
    Page<Tweet> findByReplyToIsNullOrderByCreatedAtDesc(Pageable pageable);
    
    List<Tweet> findByReplyToOrderByCreatedAtAsc(Tweet replyTo);
    
    @Query("SELECT t FROM Tweet t WHERE t.content LIKE %:query% ORDER BY t.createdAt DESC")
    Page<Tweet> searchTweets(String query, Pageable pageable);

    List<Tweet> findAllByOrderByCreatedAtDesc();
}