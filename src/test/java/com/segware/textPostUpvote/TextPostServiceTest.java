package com.segware.textPostUpvote;


import com.segware.textPostUpvote.model.TextPost;
import com.segware.textPostUpvote.service.TextPostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class TextPostServiceTest {

    @InjectMocks
    private TextPostService service;

    @Mock
    TextPostRepository repository;


    @Test
    public void testServiceFindAll() {
        List<TextPost> listAll = new ArrayList<>();
        TextPost textOne = new TextPost();
        textOne.setText("Lorem Ipsum is simply dummy text of the printing and typesetting " +
                "industry. Lorem Ipsum has been the industry's standard dummy text ever " +
                "since the 1500s, when an unknown printer took a galley of type and scrambled " +
                "it to make a type specimen book.");

        TextPost textTwo = new TextPost();
        textTwo.setText("It is a long established fact that a reader will be distracted by the readable " +
                "content of a page when looking at its layout. The point of using Lorem Ipsum is that it " +
                "has a more-or-less normal distribution of letters, as opposed to using 'Content here, " +
                "content here', making it look like readable English. ");

        listAll.add(textOne);
        listAll.add(textTwo);

        when(repository.findAll()).thenReturn(listAll);

        List<TextPost> textPostListAll = service.findAll();

        assertEquals(2, textPostListAll.size());
        verify(repository, times(1)).findAll();

    }


    @Test
    public void testServiceFindById() {
        when(repository.findById("q1w2e3r4t5")).thenReturn(java.util.Optional.of(new TextPost(
                "q1w2e3r4t5",
                "It is a long established fact that a reader will be distracted by ",
                0)));
        TextPost text = service.findById("q1w2e3r4t5");

        assertEquals("q1w2e3r4t5", text.getId());
        assertEquals("It is a long established fact that a reader will be distracted by ", text.getText());
        assertEquals(0, text.getVote());

    }

    @Test
    public void testServiceCreate() {

        TextPost textPost = new TextPost(
                "q1w2e3r4t5",
                "It is a long established fact that a reader will be distracted by ",
                0);
        service.create(textPost);
        verify(repository, times(1)).save(textPost);

    }


    @Test
    public void testServiceUpdate() {

        when(repository.findById("q1w2e3r4t5")).thenReturn(java.util.Optional.of(new TextPost(
                "q1w2e3r4t5",
                "It is a long established fact that a reader will be distracted by ",
                0)));

        TextPost text = service.findById("q1w2e3r4t5");
        text.setText("Outro text!!!");

        service.update(text);
        assertEquals("Outro text!!!", service.findById("q1w2e3r4t5").getText());

    }


    @Test
    public void testServiceUpVote() {

        when(repository.findById("q1w2e3r4t5")).thenReturn(java.util.Optional.of(new TextPost(
                "q1w2e3r4t5",
                "It is a long established fact that a reader will be distracted by ",
                0)));

        TextPost text = service.findById("q1w2e3r4t5");
        service.upvoteText(text.getId());

        assertEquals(1, service.findById("q1w2e3r4t5").getVote());

    }


    @Test
    public void testServiceDownVote() {
        when(repository.findById("q1w2e3r4t5")).thenReturn(java.util.Optional.of(new TextPost(
                "q1w2e3r4t5",
                "It is a long established fact that a reader will be distracted by ",
                1)));

        TextPost text = service.findById("q1w2e3r4t5");
        service.downVoteText(text.getId());

        assertEquals(0, service.findById("q1w2e3r4t5").getVote());

    }


}
