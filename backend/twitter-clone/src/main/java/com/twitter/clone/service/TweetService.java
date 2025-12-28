package com.twitter.clone.service;

import com.twitter.clone.dto.TweetDTO;
import com.twitter.clone.model.Tweet;
import com.twitter.clone.model.User;
import com.twitter.clone.repository.TweetRepository;
import com.twitter.clone.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TweetService {

    private final TweetRepository tweetRepository;
    private final UserRepository userRepository;

    /** Obtiene el usuario autenticado desde el contexto */
    private User getAuthenticatedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !(auth.getPrincipal() instanceof User user)) {
            throw new SecurityException("No authenticated user");
        }
        return user;
    }

    /** Crea un tweet con el usuario autenticado */
    public TweetDTO createTweet(String content) {
        User author = getAuthenticatedUser();

        Tweet saved = tweetRepository.save(
                Tweet.builder()
                        .content(content)
                        .author(author)
                        .build()
        );

        // Actualiza contador de tweets
        author.setTweetsCount(author.getTweetsCount() + 1);
        userRepository.save(author);

        return new TweetDTO(saved);
    }

    /** Recupera un tweet por id, marcando si está likeado por el actual */
    public TweetDTO findById(Long id) {
        User current = getAuthenticatedUser();
        Tweet tweet = tweetRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tweet not found"));

        TweetDTO dto = new TweetDTO(tweet);
        dto.setLikedByCurrentUser(tweet.getLikedBy().contains(current));
        return dto;
    }

    /** Like */
    @Transactional
    public TweetDTO likeTweet(Long tweetId) {
        User current = getAuthenticatedUser();
        current.getFollowers().size();
        Tweet tweet = tweetRepository.findById(tweetId)
                .orElseThrow(() -> new EntityNotFoundException("Tweet not found"));

        System.err.println("Tweet to Like ID: " + tweet.getId());
        System.err.println("Current User: " + current.getUsername());

        if (!tweet.getLikedBy().contains(current)) {
            tweet.getLikedBy().add(current);
            tweet.setLikesCount(tweet.getLikesCount() + 1);
            tweetRepository.save(tweet);
        }

        TweetDTO dto = new TweetDTO(tweet);
        dto.setLikedByCurrentUser(true);
        return dto;
    }

    /** Unlike */
    public TweetDTO unlikeTweet(Long tweetId) {
        User current = getAuthenticatedUser();
        Tweet tweet = tweetRepository.findById(tweetId)
                .orElseThrow(() -> new EntityNotFoundException("Tweet not found"));

        if (tweet.getLikedBy().remove(current)) {
            tweet.setLikesCount(tweet.getLikesCount() - 1);
            tweetRepository.save(tweet);
        }

        TweetDTO dto = new TweetDTO(tweet);
        dto.setLikedByCurrentUser(false);
        return dto;
    }

    /** Timeline de usuarios seguidos + propio */
    public Page<TweetDTO> getTimeline(Pageable pageable) {
        User current = getAuthenticatedUser();
        List<User> followed = List.copyOf(current.getFollowing());

        Page<Tweet> tweets = tweetRepository.findTimelineTweets(followed, current, pageable);

        return tweets.map(t -> {
            TweetDTO dto = new TweetDTO(t);
            dto.setLikedByCurrentUser(t.getLikedBy().contains(current));
            return dto;
        });
    }

    /** Tweets de un usuario específico */
    public Page<TweetDTO> getUserTweets(Long userId, Pageable pageable) {
        User target = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        User current = getAuthenticatedUser();

        Page<Tweet> tweets = tweetRepository.findByAuthorOrderByCreatedAtDesc(target, pageable);

        return tweets.map(t -> {
            TweetDTO dto = new TweetDTO(t);
            dto.setLikedByCurrentUser(t.getLikedBy().contains(current));
            return dto;
        });
    }

    /** Tweets públicos */
    public Page<TweetDTO> getPublicTweets(Pageable pageable) {
        User current = getAuthenticatedUser();

        Page<Tweet> tweets = tweetRepository.findByReplyToIsNullOrderByCreatedAtDesc(pageable);

        return tweets.map(t -> {
            TweetDTO dto = new TweetDTO(t);
            dto.setLikedByCurrentUser(t.getLikedBy().contains(current));
            return dto;
        });
    }

    /** Buscar tweets */
    public Page<TweetDTO> searchTweets(String query, Pageable pageable) {
        User current = getAuthenticatedUser();

        Page<Tweet> tweets = tweetRepository.searchTweets(query, pageable);

        return tweets.map(t -> {
            TweetDTO dto = new TweetDTO(t);
            dto.setLikedByCurrentUser(t.getLikedBy().contains(current));
            return dto;
        });
    }
}