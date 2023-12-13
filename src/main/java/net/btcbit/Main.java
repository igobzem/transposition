package net.btcbit;

import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter file name:");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.next();
        FileWriter writer = null;
        try {
            FileReader reader = new FileReader(fileName);
            List<Note> piece = PieceReader.parser(reader);
            System.out.println("Enter number of semitones:");
            long i = scanner.nextLong();
            piece = piece.stream().map(n -> PianoKeyboard.transpose(n, (int)i)).toList();
            System.out.println("Enter output file name:");
            fileName = scanner.next();
            writer = new FileWriter(fileName);
            writer.write(piece.toString());
        } catch (IOException | ParseException | RuntimeException e) {
            System.out.println("Error:"+e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Error:"+e.getMessage());
                }
            }
        }
    }
}