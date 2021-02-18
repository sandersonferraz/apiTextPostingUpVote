package com.segware.textPostUpvote;

import com.segware.textPostUpvote.model.TextPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TextPostRepository extends MongoRepository<TextPost, String> {
}
