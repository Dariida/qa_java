import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    Feline feline;

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void getManeDependsOnSexTest(String sex, boolean expectedResult) throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(expectedResult, lion.doesHaveMane());
    }
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "Неизвестно", "null", "андрогин"})
    void shouldThrowExceptionForInvalidSexTest(String invalidSex) {
        assertThrows(Exception.class, () -> new Lion(invalidSex, feline));
    }

    @Test
    void getKittensLionTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int expectedKittens = 5;
        Mockito.when(feline.getKittens()).thenReturn(expectedKittens);
        int actualKittens = lion.getKittens();
        assertEquals(expectedKittens, actualKittens);
        Mockito.verify(feline).getKittens();
    }

    @Test
    void getFoodTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
        Mockito.verify(feline).getFood("Хищник");
    }
}
