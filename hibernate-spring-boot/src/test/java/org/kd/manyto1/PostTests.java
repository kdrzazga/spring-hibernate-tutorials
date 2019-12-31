package org.kd.manyto1;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kd.manyto1.entity.Post;
import org.kd.manyto1.service.DataFactory;
import org.kd.manyto1.service.PostDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

@SpringBootTest(classes = {ManyTo1Application.class})
@ExtendWith(SpringExtension.class)
public class PostTests {

    @Autowired
    private PostDaoService postDaoService;

    @Test
    public void testReadingPostsTitlesFromDb() {

        var newPosts = new DataFactory().createNewPosts();
        postDaoService.addToDatabase(newPosts);

        var allPostsTitles = postDaoService.getAllPosts().stream().map(Post::getTitle).collect(Collectors.toList());

        newPosts.forEach(
                post -> assertTrue(allPostsTitles.contains(post.getTitle()))
        );
    }

    @Test
    public void testReadingPostCommentsFromDb() {
        var newPosts = new DataFactory().createNewPosts();
        postDaoService.addToDatabase(newPosts);

        var allPostComments = postDaoService.getAllPosts().stream().map(Post::getComments).collect(Collectors.toList());

        newPosts.forEach(
                post -> assertTrue(allPostComments.containsAll(post.getComments()))
        );
    }
}
