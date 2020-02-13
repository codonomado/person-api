package uk.ac.emblebi.personapi.domain.person.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * TODO: write you class description here
 *
 * @author
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons")
@EntityListeners(AuditingEntityListener.class)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @JsonProperty(value = "first_name")
    private String firstName;

    @NotBlank
    @JsonProperty(value = "last_name")
    private String lastName;

    @NotBlank
    private String age;

    @NotBlank
    @JsonProperty(value = "favourite_colour")
    private String favouriteColour;

    @ElementCollection
    @CollectionTable(name ="hobbies" , joinColumns=@JoinColumn(name="person_id"))
    @Column(name="hobbies")
    private List<String> hobbies = new ArrayList<>();

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public void addHobby(String hobby) {
        this.hobbies.add(hobby);
    }

    public void removeHobby(String hobby) {
        this.hobbies.remove(hobby);
    }
}
