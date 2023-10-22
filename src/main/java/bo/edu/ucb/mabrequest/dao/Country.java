package bo.edu.ucb.mabrequest.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import org.springframework.stereotype.Service;

@Service
@Entity
@Table(name = "MAB_country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    public Country() {
    }

    public Country(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
