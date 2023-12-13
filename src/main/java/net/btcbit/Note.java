package net.btcbit;

import java.util.Objects;

public class Note {

    private long octaveNumber;
    private long noteNumber;

    public Note(long octaveNumber, long noteNumber) {
        this.octaveNumber = octaveNumber;
        this.noteNumber = noteNumber;
    }

    public long getOctaveNumber() {
        return octaveNumber;
    }

    public void setOctaveNumber(long octaveNumber) {
        this.octaveNumber = octaveNumber;
    }

    public long getNoteNumber() {
        return noteNumber;
    }

    public void setNoteNumber(long noteNumber) {
        this.noteNumber = noteNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return octaveNumber == note.octaveNumber && noteNumber == note.noteNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(octaveNumber, noteNumber);
    }

    @Override
    public String toString() {
        return "[" + octaveNumber + "," + noteNumber + ']';
    }
}
