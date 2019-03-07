package at.nacs.bew3.exe06;

import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@SpringBootTest
class LiberaryTest {

    @Autowired
    Liberary liberary;

    @ParameterizedTest
    @CsvSource({
            "Harry Potter, 3",
            "The Foundation, 2",
            "The Lord of the Rings, 4"
    })
    void getBook(String book, Integer copies) {

        Map<String, Integer> books = liberary.getBook();

        //assertEquals([3,2,4],books);

        //assertThat(books, IsMapContaining.hasEntry(book, copies));


    }
}