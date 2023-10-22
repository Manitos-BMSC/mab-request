package bo.edu.ucb.mabrequest.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "MAB_hospital_doctor")
public class HospitalDoctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public HospitalDoctor() {
    }

    public HospitalDoctor(int id, Hospital hospital, Doctor doctor) {
        this.id = id;
        this.hospital = hospital;
        this.doctor = doctor;
    }
}
