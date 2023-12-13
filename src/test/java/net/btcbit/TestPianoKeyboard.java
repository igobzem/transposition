package net.btcbit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestPianoKeyboard {
    @Test
    public void testSimpleOk() {
        Note note = new Note(0, 5);
        note = PianoKeyboard.transpose(note, -4);
        assertEquals(note.getNoteNumber(), 1);
        assertEquals(note.getOctaveNumber(), 0);
        note = PianoKeyboard.transpose(note, -4);
        assertEquals(note.getNoteNumber(), 9);
        assertEquals(note.getOctaveNumber(), -1);
    }

    @Test
    public void testSimpleFail() {
        assertThrows(RuntimeException.class, () -> {
            PianoKeyboard.validateNote(new Note(0, 13));
        });
        Note note = new Note(5, 1);
        assertDoesNotThrow(() -> {
            PianoKeyboard.validateNote(note);
        });
        assertThrows(RuntimeException.class, () -> {
            PianoKeyboard.transpose(note, 1);
        });
    }

}
