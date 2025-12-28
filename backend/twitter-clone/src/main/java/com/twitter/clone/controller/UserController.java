package com.twitter.clone.controller;

import com.twitter.clone.dto.UserDTO;
import com.twitter.clone.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

//    @Autowired
//    private UserService userService;

//    @GetMapping("/{id}")
//    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
//        return userService.findById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }

//    @GetMapping("/{username}/profile")
//    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
//        return userService.findByUsername(username)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }

//    @PostMapping("/{id}/follow")
//    public ResponseEntity<UserDTO> followUser(@PathVariable Long id, Authentication authentication) {
//        User currentUser = (User) authentication.getPrincipal();
//        UserDTO followedUser = userService.followUser(currentUser.getId(), id);
//        return ResponseEntity.ok(followedUser);
//    }

//    @DeleteMapping("/{id}/follow")
//    public ResponseEntity<UserDTO> unfollowUser(@PathVariable Long id, Authentication authentication) {
//        User currentUser = (User) authentication.getPrincipal();
//        UserDTO unfollowedUser = userService.unfollowUser(currentUser.getId(), id);
//        return ResponseEntity.ok(unfollowedUser);
//    }

//    @GetMapping("/{id}/following-status")
//    public ResponseEntity<Map<String, Boolean>> getFollowingStatus(@PathVariable Long id, Authentication authentication) {
//        User currentUser = (User) authentication.getPrincipal();
//        boolean isFollowing = userService.isFollowing(currentUser.getId(), id);

//        Map<String, Boolean> response = new HashMap<>();
//        response.put("isFollowing", isFollowing);
//        return ResponseEntity.ok(response);
//    }

//    @GetMapping("/search")
//    public ResponseEntity<Page<UserDTO>> searchUsers(
//            @RequestParam String q,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "20") int size) {

//        Pageable pageable = PageRequest.of(page, size);
//        Page<UserDTO> users = userService.searchUsers(q, pageable);
//        return ResponseEntity.ok(users);
//    }
}
