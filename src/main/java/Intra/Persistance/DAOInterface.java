package Intra.Persistance;

import Intra.Models.Post;
import Intra.Models.PostComments;
import Intra.Models.PostUser;

import java.util.List;

public interface DAOInterface {
    <T> void save(T toSave);

    <T> T findPostById(long id);

    <T> T findUserById(long id);

    void addCommentaireToPost(PostComments commentaire, Post post);
}
