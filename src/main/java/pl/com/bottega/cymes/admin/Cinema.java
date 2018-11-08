package pl.com.bottega.cymes.admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(indexes = {
    @Index(columnList = "name, city", unique = true)
})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cinema {

    @Id
    private UUID id;
    private String name;
    private String city;

}
