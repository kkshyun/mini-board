package com.example.member_board.repository;

import com.example.member_board.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findAllPostsByUserId(Long userId);
    List<Post> findAll();
}
