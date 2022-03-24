package Intra.Models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostUser {
    @GeneratedValue
    @Id
    private long id;
    private String name;
}
