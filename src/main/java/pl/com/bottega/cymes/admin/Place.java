package pl.com.bottega.cymes.admin;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Write a summarising sentence of this class first. Explain its responsibility afterwards. Don't explain how it works,
 * but rather what its purpose is. You may want to give usage examples, if helpful.
 * <p/>
 * TODO(KJANOWSK) Write sensible documentation for this class.
 * <p/>
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Place {
    @Id
    @GeneratedValue
    private UUID id;
    private int rowIndex;
    private int columnIndex;
    @Setter
    private String seatNo;

}
