package com.segware.textPostUpvote.controller;

import com.segware.textPostUpvote.model.TextPost;
import com.segware.textPostUpvote.service.TextPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TextPostController {

    @Autowired
    TextPostService textPostService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<TextPost> findAll() {
        return textPostService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TextPost findById(@PathVariable String id) {
        return textPostService.findById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public TextPost create(@RequestBody TextPost textPost) {
        return textPostService.create(textPost);
    }

    @PutMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public TextPost update(@RequestBody TextPost newTextPost) {
        TextPost textPost = textPostService.findById(newTextPost.getId());
        textPost.setText(newTextPost.getText());
        textPostService.update(textPost);
        return textPost;
    }

    @DeleteMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@RequestBody String id) {
        textPostService.delete(id);
        return id;
    }

    @GetMapping("/upvote/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String upvote(@PathVariable String id){
        textPostService.upvoteText(id);
        return id;
    }

    @GetMapping("/downVote/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String downVote(@PathVariable String id){
        textPostService.downVoteText(id);
        return id;
    }


}
