package Intra.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostComments {
    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private PostUser commentateur;
    private String comment;
}
