package pl.bykowski.springboot2book.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bykowski.springboot2book.model.Note;

@Repository
public interface NoteRepo extends JpaRepository<Note, Long> {
}
