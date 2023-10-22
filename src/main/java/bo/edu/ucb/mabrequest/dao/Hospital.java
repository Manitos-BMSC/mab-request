package bo.edu.ucb.mabrequest.dao;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "MAB_hospital")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hospital")
    private int idHospital;

    @Column(name = "name")
    private String name;

    @Column(name = "direction")
    private String direction;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "status")
    private boolean status;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<HospitalDoctor> hospitalDoctors;

    public Hospital() {
    }

    public Hospital(int idHospital, String name, String direction, String contactNumber, boolean status, List<HospitalDoctor> hospitalDoctors) {
        this.idHospital = idHospital;
        this.name = name;
        this.direction = direction;
        this.contactNumber = contactNumber;
        this.status = status;
        this.hospitalDoctors = hospitalDoctors;
    }
}
