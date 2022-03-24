package Intra;

import Intra.Service.PostService;

public class Main {
    public static void main(String[] args) {
        PostService service = new PostService();

        long posterId = service.createUser("user");
        long commenterId = service.createUser("commenter");
        long postId = service.post(posterId,"Un post");
        service.addComment(postId, commenterId, "Un commentaire");

        System.out.println(service.getPost(postId));
    }
}
