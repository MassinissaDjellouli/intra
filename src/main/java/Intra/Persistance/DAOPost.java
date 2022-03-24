package Intra.Persistance;

import Intra.Models.Post;
import Intra.Models.PostComments;
import Intra.Models.PostUser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.lang.reflect.Type;
import java.util.List;

public class DAOPost implements DAOInterface{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("intra");
    EntityManager em;
    @Override
    public <T> void save(T toSave) {
        begin();
        em.persist(toSave);
        finish();
    }

    @Override
    public Post findPostById(long id) {
        begin();
        TypedQuery<Post> query = em.createQuery(
                "select p from Post p left join fetch p.comments com where p.id = :id",
                Post.class);
        query.setParameter("id",id);
        Post post = query.getSingleResult();
        finish();
        return post;
    }
    @Override
    public PostUser findUserById(long id) {
        begin();
        PostUser user = em.find(PostUser.class,id);
        finish();
        return user;
    }

    @Override
    public void addCommentaireToPost(PostComments commentaire, Post post) {
        begin();
        em.persist(commentaire);
        List<PostComments> postList = post.getComments();
        postList.add(commentaire);
        post.setComments(postList);
        em.merge(post);
        finish();
    }

    private void begin(){
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }
    private void finish(){
        throwIfNull(em);
        em.getTransaction().commit();
        em.close();
    }
    public static <T> void throwIfNull(T obj){
        if(obj == null) throw new IllegalArgumentException();
    }
}
