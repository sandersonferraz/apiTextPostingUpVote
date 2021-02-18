package com.segware.textPostUpvote;


import com.segware.textPostUpvote.model.TextPost;
import com.segware.textPostUpvote.service.TextPostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TextPostServiceTest {

    @Autowired
    private TextPostService service;

    @Test
    public void testServiceCreate() {

        TextPost newText = new TextPost();
        newText.setText("Lorem Ipsum is simply dummy text of the printing and typesetting " +
                "industry. Lorem Ipsum has been the industry's standard dummy text ever " +
                        "since the 1500s, when an unknown printer took a galley of type and scrambled " +
                        "it to make a type specimen book.");

        service.create(newText);
    }


    @Test
    public void testServiceFindAll() {
       service.findAll();
    }



}
