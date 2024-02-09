package classes;

import com.example.realisatiebp2.classes.Database;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DatabaseTest {
    private static Database database;


    @BeforeAll
    public static void setUpClass() {
        database = new Database();
    }

    @BeforeEach
    public void setUp() {
        // Herinitialiseer de gebruikersnaam voor elke test
        database.setGebruikersnaam("testgebruiker");
    }

    @Test
    void testGebruikerRegistratie() {
        // Testgeval 1: Gebruiker registratie
        assertTrue(database.opslaanGebruiker("testgebruiker", "testwachtwoord"));
        assertNotNull(database.haalGebruikerOp("testgebruiker"));
    }

    @Test
    void testInkomstenUitgavenRegistratie() {
        // Testgeval 2: Inkomsten/Uitgaven registreren
        database.setGebruikersnaam("testgebruiker");
        assertTrue(database.opslaanGebruiker("testgebruiker", "testwachtwoord"));
        assertTrue(database.opslaanTransactie(50.0));
        assertNotNull(database.laadTransacties());
    }

    @Test
    void testBudgetInstellen() {
        // Testgeval 3: Budgetten instellen
        database.setGebruikersnaam("testgebruiker");
        database.opslaanGebruiker("testgebruiker", "testwachtwoord");
        assertTrue(database.opslaanBudget(100.0));
        assertNotNull(database.haalBudgetOp("testgebruiker"));
    }
}


