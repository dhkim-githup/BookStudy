package com.web.chapter04;

import com.web.chapter04.domain.Board;
import com.web.chapter04.domain.User;
import com.web.chapter04.domain.enums.BoardType;
import com.web.chapter04.repository.BoardRepository;
import com.web.chapter04.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaMappingTest {

    private final String boardTestTitle = "테스트";
    private final String email = "test@gmail.com";

    @Autowired
    UserRepository userRepository;

    @Autowired
    BoardRepository boardRepository;

    @Before
    public void init(){
        User user = userRepository.save(User.builder()
                .name("havi")
                .password("test")
                .email(email)
                .createdDate(LocalDateTime.now())
                .build()
        );

        boardRepository.save(Board.builder()
                .title(boardTestTitle)
                .subTitle("서브 타이틀")
                .content("콘텐츠")
                .boardType(BoardType.free)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .user(user).build()
        );
    }

    @Test
    public void doChapterTest(){
        System.out.println("Hello Test");

        User user = userRepository.findByEmail(email);
                assertEquals(user.getName(),"havi");
                assertEquals(user.getPassword(),"test");
                assertEquals(user.getEmail(),email);

        Board board = boardRepository.findByUser(user);
                assertEquals(board.getTitle(),boardTestTitle);
                assertEquals(board.getSubTitle(), "서브 타이틀");
                assertEquals(board.getContent(), "콘텐츠");
                assertEquals(board.getBoardType(), BoardType.free);


    }


}
