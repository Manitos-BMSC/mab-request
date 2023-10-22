package bo.edu.ucb.mabrequest.dao;

import org.springframework.stereotype.Service;
import jakarta.persistence.*;
import java.util.Date;

@Service
@Entity
@Table(name = "MAB_person")
public class Person {
    @Id
    @Column(name = "id_keycloack")
    private String idKeycloack;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "user_mail")
    private String userMail;

    @Column(name = "username")
    private String username;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "document_type")
    private boolean documentType;

    @Column(name = "document_number")
    private String documentNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "address")
    private String address;

    @Column(name = "personal_document")
    private String personalDocument;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "tx_user")
    private String txUser;

    @Column(name = "tx_host")
    private String txHost;

    @Temporal(TemporalType.DATE)
    @Column(name = "tx_date")
    private Date txDate;

    @Column(name = "status")
    private boolean status;


    public Person() {
    }

    public Person(String idKeycloack, City city, String name, String lastname, String userMail, String username, String phoneNumber, boolean documentType, String documentNumber, Date birthDate, String address, String personalDocument, boolean gender, String txUser, String txHost, Date txDate, boolean status) {
        this.idKeycloack = idKeycloack;
        this.city = city;
        this.name = name;
        this.lastname = lastname;
        this.userMail = userMail;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.birthDate = birthDate;
        this.address = address;
        this.personalDocument = personalDocument;
        this.gender = gender;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
        this.status = status;
    }

    public String getIdKeycloack() {
        return idKeycloack;
    }

    public void setIdKeycloack(String idKeycloack) {
        this.idKeycloack = idKeycloack;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isDocumentType() {
        return documentType;
    }

    public void setDocumentType(boolean documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPersonalDocument() {
        return personalDocument;
    }

    public void setPersonalDocument(String personalDocument) {
        this.personalDocument = personalDocument;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getTxUser() {
        return txUser;
    }

    public void setTxUser(String txUser) {
        this.txUser = txUser;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idKeycloack='" + idKeycloack + '\'' +
                ", city=" + city +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", userMail='" + userMail + '\'' +
                ", username='" + username + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", documentType=" + documentType +
                ", documentNumber='" + documentNumber + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", personalDocument='" + personalDocument + '\'' +
                ", gender=" + gender +
                ", txUser='" + txUser + '\'' +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                ", status=" + status +
                '}';
    }
}
