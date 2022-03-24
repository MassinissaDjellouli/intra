package Intra.Service;

import Intra.Models.Post;
import Intra.Models.PostComments;
import Intra.Models.PostUser;
import Intra.Persistance.DAOInterface;
import Intra.Persistance.DAOPost;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class PostService {
    private DAOInterface postDAO;

    public PostService() {
        this.postDAO = new DAOPost();
    }

    public long createUser(String name){
        PostUser user = PostUser.builder().name(name).build();
        postDAO.save(user);
        return user.getId();
    }
    public long post(long userId, String postData){
        PostUser user = postDAO.findUserById(userId);
        DAOPost.throwIfNull(user);
        Post post = Post.builder()
                .postData(postData)
                .user(user)
                .dateTime(LocalDateTime.now())
                .build();
        postDAO.save(post);
        return post.getId();
    }
    public long addComment(long postId, long commenterId, String comment){
        Post post = postDAO.findPostById(postId);
        DAOPost.throwIfNull(post);
        PostUser commenter = postDAO.findUserById(commenterId);
        DAOPost.throwIfNull(commenter);
        PostComments commentaire = PostComments.builder()
                .comment(comment)
                .commentateur(commenter)
                .build();
        postDAO.addCommentaireToPost(commentaire,post);
        return commentaire.getId();
    }
    public Post getPost(long postId){
        Post post = postDAO.findPostById(postId);
        DAOPost.throwIfNull(post);
        return post;
    }

}
