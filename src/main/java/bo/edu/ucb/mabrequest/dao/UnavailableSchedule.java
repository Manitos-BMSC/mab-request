package bo.edu.ucb.mabrequest.dao;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "MAB_unavailable_schedule")
public class UnavailableSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "period_id")
    private Period period;
    @Column(name = "date_from")
    private Date dateFrom;

    @Column(name = "date_to")
    private Date dateTo;

    @Column(name = "week_day")
    private String weekDay;

    @Column(name = "status")
    private boolean status;


    public UnavailableSchedule() {
    }

    public UnavailableSchedule(int id, Doctor doctor, Period period, Date dateFrom, Date dateTo, String weekDay, boolean status) {
        this.id = id;
        this.doctor = doctor;
        this.period = period;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.weekDay = weekDay;
        this.status = status;
    }
}
