package Intra.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
    @GeneratedValue
    @Id
    private long id;
    private String postData;
    @OneToOne
    private PostUser user;
    private LocalDateTime dateTime;
    @OneToMany
    private List<PostComments> comments;
}
