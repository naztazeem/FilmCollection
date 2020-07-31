package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGenre {
    Genre g1;
    Genre g2;
    Genre g3;
    Genre g4;
    Genre g5;

    @BeforeEach
    void runBefore() {
        g1 = new Genre("Thriller");
        g2 = new Genre("Crime");
        g3 = new Genre("Drama");
        g4 = new Genre("Biography");
        g5 = new Genre("Romance");
    }

    @Test
    void testConstructor() {
        assertEquals("Thriller",g1.getGenre());
        assertEquals("Drama",g3.getGenre());

    }

}
