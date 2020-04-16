package pl.bykowski.springboot2book.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "room_number")
    private Integer roomNumber;

    @OneToOne(mappedBy = "room")
    private Professor professor;

    @ManyToMany(mappedBy = "roomSet")
    private Set<Cleaner> cleanerSet;

    public Room() {
    }

    public Set<Cleaner> getCleanerSet() {
        return cleanerSet;
    }

    public void setCleanerSet(Set<Cleaner> cleanerSet) {
        this.cleanerSet = cleanerSet;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Room(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
}
