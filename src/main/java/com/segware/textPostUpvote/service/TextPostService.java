package com.segware.textPostUpvote.service;

import com.segware.textPostUpvote.repository.TextPostRepository;
import com.segware.textPostUpvote.model.TextPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TextPostService {

    @Autowired
    TextPostRepository textPostRepository;

    public TextPost create(@PathVariable TextPost textPost){
        textPost.setVote(0);
        return textPostRepository.save(textPost);
    }

    public List<TextPost> findAll(){
        return textPostRepository.findAll();
    }

    public TextPost findById(@PathVariable String id) {
        return textPostRepository.findById(id).orElse(null);
    }

    public TextPost update(@RequestBody TextPost updateText) {
        TextPost text = textPostRepository.findById(updateText.getId()).orElse(null);
        text.setText(updateText.getText());
        textPostRepository.save(text);
        return text;
    }


    public String delete(@PathVariable String id) {
        textPostRepository.deleteById(id);
        return id;
    }

    public String upvoteText(@PathVariable String id) {
        TextPost textPost = textPostRepository.findById(id).orElse(null);
        textPost.setVote(textPost.getVote() + 1);
        textPostRepository.save(textPost);
        return id;

    }
    public String downVoteText(@PathVariable String id) {
        TextPost textPost = textPostRepository.findById(id).orElse(null);
        textPost.setVote(textPost.getVote() - 1);
        textPostRepository.save(textPost);
        return id;

    }
}
