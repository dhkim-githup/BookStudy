package com.web.chapter04.repository;

import com.web.chapter04.domain.Board;
import com.web.chapter04.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByUser(User user);
}
