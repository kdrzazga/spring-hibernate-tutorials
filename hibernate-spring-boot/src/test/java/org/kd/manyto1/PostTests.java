package org.kd.manyto1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kd.manyto1.entity.Post;
import org.kd.manyto1.service.DataFactory;
import org.kd.manyto1.service.PostDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertTrue;

@SpringBootTest(classes = {ManyTo1Application.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PostTests {

    @Autowired
    private PostDaoService postDaoService;

    @Test
    public void testReadingPostsTitlesFromDb() {

        var newPosts = new DataFactory().createNewPosts();
        postDaoService.addToDatabase(newPosts);

        assertTrue(postDaoService.getAllPosts().containsAll(newPosts));
        //fail("implement not finished");//TODO finish this
        //
    }
    @Test
    public void testReadingPostCommentsFromDb() {

        var newPosts = new DataFactory().createNewPostComments();
       // postDaoService.addToDatabase(newPosts);
        var allCommentsFromDb = postDaoService.getAllPosts().stream().map(Post::getComments).collect(Collectors.toList());

        assertThat(allCommentsFromDb, hasItems(newPosts));
    }
}
