package net.btcbit;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestPieceReader {
    @Test
    public void testRead() {
        URL resource = getClass().getClassLoader().getResource("piece.json");
        try {
            List<Note> piece = PieceReader.parser(new FileReader(new File(resource.toURI())));
            assertEquals(piece.size(), 82);
            assertEquals(piece.get(0), new Note(2,1));
        } catch (IOException | URISyntaxException | ParseException e) {
            fail();
        }
    }

    @Test
    public void testPieceTransposition() {
        URL resourceBefore = getClass().getClassLoader().getResource("piece.json");
        URL resourceAfter = getClass().getClassLoader().getResource("pieceTransposed.json");
        try {
            List<Note> piece = PieceReader.parser(new FileReader(new File(resourceBefore.toURI())));
            List<Note> pieceTransposed = PieceReader.parser(new FileReader(new File(resourceAfter.toURI())));
            piece = piece.stream().map(n -> PianoKeyboard.transpose(n, -3)).toList();
            assertEquals(piece, pieceTransposed);
        } catch (IOException | URISyntaxException | ParseException e) {
            fail();
        }
    }

    @Test
    public void testFileValidation() {
        URL resource = getClass().getClassLoader().getResource("wrongFormat.json");
        try {
            List<Note> piece = PieceReader.parser(new FileReader(new File(resource.toURI())));
            fail("Expected exception was not thrown");
        } catch (IOException | URISyntaxException | ParseException | RuntimeException e) {
            assertNotNull(e);
        }
    }
}
