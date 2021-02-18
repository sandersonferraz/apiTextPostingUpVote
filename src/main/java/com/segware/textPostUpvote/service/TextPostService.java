package com.segware.textPostUpvote.service;

import com.segware.textPostUpvote.TextPostRepository;
import com.segware.textPostUpvote.model.TextPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class TextPostService {

    @Autowired
    TextPostRepository textPostRepository;

    public TextPost create(@PathVariable TextPost textPost){
        return textPostRepository.save(textPost);
    }

    public List<TextPost> findAll(){
        return textPostRepository.findAll();
    }
}
