import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundTest() {
        Cat cat = new Cat(feline);
        Assertions.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodCatTest() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);
        List<String> actualFood = cat.getFood();
        Mockito.verify(feline).eatMeat();
        Assertions.assertEquals(expectedFood, actualFood, "Еда для кота должна соответствовать ожидаемому списку");

    }
}

