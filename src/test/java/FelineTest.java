import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FelineTest {

    @Test
    void eatMeatTestReturnsExpectedFoodTest() throws Exception {
        Feline feline = new Feline();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        assertEquals(expected, actual);
    }

    @Test
    public void  getFamilyTest() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    /**Проверка логики метода без параметров**/
    @Test
    void getKittensWithoutParametersTest() {
        Feline feline = new Feline();
        int actual = feline.getKittens();
        assertEquals(1, actual, "Метод без параметров должен возвращать 1");
    }

    /**Проверка логики метода с параметрами**/
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 10,15})
    void getKittensWithArgShouldReturnArgTest(int kittensCount) {
        Feline feline = new Feline();
        int actual = feline.getKittens(kittensCount);
        assertEquals(kittensCount, actual);
    }
}



