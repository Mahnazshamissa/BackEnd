package at.nacs.bew3.exe06;

import org.hamcrest.collection.IsMapContaining;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SpringBootTest
class LibraryTest {

    @Autowired
    Library library;

    @ParameterizedTest
    @CsvSource({
            "HarryPotter, 3",
            "TheFoundation, 2",
            "TheLordOfTheRings, 4"
    })
    void getIndividualBook(String title, Integer copies) {

        Map<String, Integer> books = library.getBook();

        //assertEquals(copies,books.get(title));

        assertThat(books, IsMapContaining.hasEntry(title,copies));


    }
}