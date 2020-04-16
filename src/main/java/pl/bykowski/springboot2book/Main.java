package pl.bykowski.springboot2book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.bykowski.springboot2book.model.Backpack;
import pl.bykowski.springboot2book.model.Cleaner;
import pl.bykowski.springboot2book.model.Note;
import pl.bykowski.springboot2book.model.Notepad;
import pl.bykowski.springboot2book.model.Professor;
import pl.bykowski.springboot2book.model.Room;
import pl.bykowski.springboot2book.model.Student;
import pl.bykowski.springboot2book.repo.BackpackRepo;
import pl.bykowski.springboot2book.repo.CleanerRepo;
import pl.bykowski.springboot2book.repo.NoteRepo;
import pl.bykowski.springboot2book.repo.NotepadRepo;
import pl.bykowski.springboot2book.repo.ProfessorRepo;
import pl.bykowski.springboot2book.repo.RoomRepo;
import pl.bykowski.springboot2book.repo.StudentRepo;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Main {

    @Autowired
    public Main(StudentRepo studentRepo, BackpackRepo backpackRepo, NotepadRepo notepadRepo, ProfessorRepo professorRepo,
                NoteRepo noteRepo, RoomRepo roomRepo, CleanerRepo cleanerRepo) {

        //backpacks
        Backpack backpackNike = new Backpack("Nike");
        Backpack backpackAdidas = new Backpack("Adidas");

        backpackRepo.save(backpackNike);
        backpackRepo.save(backpackAdidas);

        //notes
        Note note1 = new Note(1);
        Note note2 = new Note(2);
        Note note3 = new Note(3);
        Note note4 = new Note(4);
        Note note5 = new Note(5);
        Set<Note> noteHistorySet = Stream.of(note1, note2, note3).collect(Collectors.toSet());
        Set<Note> noteItSet = Stream.of(note4, note5).collect(Collectors.toSet());

        //notepads
        Notepad notepadHistory = new Notepad("History");
        Notepad notepadIt = new Notepad("It");
        notepadHistory.setBackpack(backpackNike);
        notepadHistory.setNote(noteHistorySet);
        notepadIt.setBackpack(backpackNike);
        notepadIt.setNote(noteItSet);

        note1.setNotepad(notepadHistory);
        note2.setNotepad(notepadHistory);
        note3.setNotepad(notepadHistory);
        note4.setNotepad(notepadIt);
        note5.setNotepad(notepadIt);

        notepadRepo.save(notepadHistory);
        notepadRepo.save(notepadIt);

        noteRepo.save(note1);
        noteRepo.save(note2);
        noteRepo.save(note3);
        noteRepo.save(note4);
        noteRepo.save(note5);


        // students
        Student studentNcb = new Student("Karol", "Zdolny", "165 NCB");
        studentNcb.setBackpack(backpackNike);
        Student studentNca = new Student("Janusz", "Leniuch", "175 NCA");
        studentNca.setBackpack(backpackAdidas);
        Set<Student> studentSet = Stream.of(studentNcb, studentNca).collect(Collectors.toSet());

        //cleaners
        Cleaner cleaner1 = new Cleaner("Jan", "Kowalski");
        Cleaner cleaner2 = new Cleaner("Dominik", "Dominikański");
        Cleaner cleaner3 = new Cleaner("Mariola", "Malinowska");
        Cleaner cleaner4 = new Cleaner("Marianna", "Nowak");
        Set<Cleaner> cleaner3Set = Stream.of(cleaner1, cleaner2).collect(Collectors.toSet());
        Set<Cleaner> cleaner4Set = Stream.of(cleaner3, cleaner4).collect(Collectors.toSet());


        //rooms
        Room room101 = new Room(101);
        Room room102 = new Room(102);
        Room room103 = new Room(103);
        Room room104 = new Room(104);
        Room room105 = new Room(105);
        Set<Room> rooms1Set = Stream.of(room101, room102).collect(Collectors.toSet());
        Set<Room> rooms2Set = Stream.of(room103, room104, room105).collect(Collectors.toSet());

        room101.setCleanerSet(cleaner3Set);
        room102.setCleanerSet(cleaner4Set);

        cleaner1.setRoomSet(rooms1Set);
        cleaner2.setRoomSet(rooms2Set);


        // professors
        Professor professorPh = new Professor("Jan", "Springowski", "Ph.D.");
        Professor professorProf = new Professor("Karolina", "Bazodanowska", "Prof.");
        Set<Professor> professorSet = Stream.of(professorPh, professorProf).collect(Collectors.toSet());


        professorPh.setStudentSet(studentSet);
        professorProf.setStudentSet(studentSet);
        professorProf.setRoom(room101);

        studentNcb.setProfessorSet(professorSet);
        studentNca.setProfessorSet(professorSet);



        professorRepo.save(professorPh);

        roomRepo.save(room101);
        roomRepo.save(room102);
        roomRepo.save(room103);
        roomRepo.save(room104);
        roomRepo.save(room105);


        professorRepo.save(professorProf);

        cleanerRepo.save(cleaner1);
        cleanerRepo.save(cleaner2);
        cleanerRepo.save(cleaner3);
        cleanerRepo.save(cleaner4);

        studentRepo.save(studentNcb);
        studentRepo.save(studentNca);

    }
}
