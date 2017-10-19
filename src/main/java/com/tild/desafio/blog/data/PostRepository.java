package com.tild.desafio.blog.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tild.desafio.blog.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
