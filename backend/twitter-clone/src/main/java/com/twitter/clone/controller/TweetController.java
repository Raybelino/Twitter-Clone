package com.twitter.clone.controller;

import com.twitter.clone.dto.TweetDTO;
import com.twitter.clone.dto.TweetRequest;
import com.twitter.clone.service.TweetService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tweets")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class TweetController {

    private final TweetService tweetService;  

    @PostMapping
    public ResponseEntity<TweetDTO> createTweet(@Valid @RequestBody TweetRequest request) {
       
        TweetDTO response = tweetService.createTweet(request.getContent());
        return ResponseEntity.ok(response);
    }

     @GetMapping("/{id}")
    public ResponseEntity<TweetDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(tweetService.findById(id));
    }

    @PostMapping("/{id}/like")
    public ResponseEntity<TweetDTO> like(@PathVariable Long id) {
        TweetDTO response = tweetService.likeTweet(id);
        System.out.println("Liked Tweet ID: " + response.getId());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}/like")
    public ResponseEntity<TweetDTO> unlike(@PathVariable Long id) {
        return ResponseEntity.ok(tweetService.unlikeTweet(id));
    }

    // ----------- GET /api/tweets/timeline --------------------------
    @GetMapping("/timeline")
    public ResponseEntity<Page<TweetDTO>> getTimeline(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        return ResponseEntity.ok(tweetService.getTimeline(PageRequest.of(page, size)));
    }

    // ----------- GET /api/tweets/user/{userId} ----------------------
    @GetMapping("/user/{userId}")
    public ResponseEntity<Page<TweetDTO>> getUserTweets(
            @PathVariable Long userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        return ResponseEntity.ok(tweetService.getUserTweets(userId, PageRequest.of(page, size)));
    }

    // ----------- GET /api/tweets/public ----------------------------
    @GetMapping("/public")
    public ResponseEntity<Page<TweetDTO>> getPublic(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        return ResponseEntity.ok(tweetService.getPublicTweets(PageRequest.of(page, size)));
    }

    // ----------- GET /api/tweets/search ----------------------------
    @GetMapping("/search")
    public ResponseEntity<Page<TweetDTO>> search(
            @RequestParam String q,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        return ResponseEntity.ok(tweetService.searchTweets(q, PageRequest.of(page, size)));
    }
}