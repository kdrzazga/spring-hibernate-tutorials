package org.kd.manyto1.service;

import org.kd.manyto1.entity.Post;
import org.kd.manyto1.entity.PostComment;

import java.util.List;

public class DataFactory {

    public List<PostComment> createNewPostComments(){
        return List.of(new PostComment("My first review"),
                new PostComment("My second review"),
                new PostComment("My 3rd review"));
    }

    public List<Post> createNewPosts(){
        return List.of(new Post("Litwo, Ojczyzno moja"),
                new Post("Tys jest jak zdrowie"),
                new Post("Ile Cie trzeba cenic"));
    }
}
