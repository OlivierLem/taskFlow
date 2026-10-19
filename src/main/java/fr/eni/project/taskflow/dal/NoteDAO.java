package fr.eni.project.taskflow.dal;

import java.util.List;
import java.util.UUID;

import fr.eni.project.taskflow.bo.Note;

public interface NoteDAO {
    void create(Note note);

    Note findNote(String reference); 

    List<Note> findAllNotes(UUID userId);

    void rename(String reference, String newTitle);

    void updateContent(String reference, String newContent);

    void delete(String reference);
}
