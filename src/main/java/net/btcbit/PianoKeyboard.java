package net.btcbit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PianoKeyboard {
    private static final List<Note> notes = new ArrayList<>();

    static {
        notes.add(new Note(-3,10));
        notes.add(new Note(-3,11));
        notes.add(new Note(-3,12));

        IntStream.range(1,13).forEach(i -> notes.add(new Note(-2, i)));
        IntStream.range(1,13).forEach(i -> notes.add(new Note(-1, i)));
        IntStream.range(1,13).forEach(i -> notes.add(new Note(-0, i)));
        IntStream.range(1,13).forEach(i -> notes.add(new Note(1, i)));
        IntStream.range(1,13).forEach(i -> notes.add(new Note(2, i)));
        IntStream.range(1,13).forEach(i -> notes.add(new Note(3, i)));
        IntStream.range(1,13).forEach(i -> notes.add(new Note(4, i)));

        notes.add(new Note(5,1));
    }

    public static void validateNote(Note note) {
        if (!notes.contains(note)) {
            throw new RuntimeException("out of range");
        }
    }

    public static Note transpose(Note note, int semitones) {
        validateNote(note);
        int idx = notes.indexOf(note) + semitones;
        if (idx < 0 || idx >= notes.size()) {
            throw new RuntimeException("out of range");
        }
        return notes.get(idx);
    }
}
