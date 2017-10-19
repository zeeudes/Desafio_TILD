package com.tild.desafio.blog.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tild.desafio.blog.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
