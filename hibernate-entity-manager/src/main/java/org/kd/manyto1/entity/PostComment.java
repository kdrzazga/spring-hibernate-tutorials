package org.kd.manyto1.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "PostComment")
@Table(name = "post_comment")
public class PostComment {

    @Id
    @GeneratedValue
    private Long id;

    private String review;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    private PostComment(){}

    public PostComment(String review){
        this.review = review;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Long getId() {
        return id;
    }

    public Post getPost() {
        return post;
    }

    public String getReview() {
        return review;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostComment)) return false;
        PostComment that = (PostComment) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getReview(), that.getReview()) &&
                Objects.equals(getPost(), that.getPost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getReview(), getPost());
    }
}
