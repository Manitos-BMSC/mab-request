package bo.edu.ucb.mabrequest.dao;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "MAB_period")
public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "time_init")
    private Date timeInit;

    @Column(name = "time_end")
    private Date timeEnd;

    @Column(name = "status")
    private int status;

    @OneToMany(mappedBy = "period", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UnavailableSchedule> unavailableSchedules;

    public Period() {
    }

    public Period(int id, Date timeInit, Date timeEnd, int status, List<UnavailableSchedule> unavailableSchedules) {
        this.id = id;
        this.timeInit = timeInit;
        this.timeEnd = timeEnd;
        this.status = status;
        this.unavailableSchedules = unavailableSchedules;
    }
}
