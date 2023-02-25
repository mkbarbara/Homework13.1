import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.*;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class ProductManagerTest {

    ProductRepository repo = Mockito.mock(ProductRepository.class);
    ProductManager manager = new ProductManager(repo);

    Product item1 = new Book(1, "Преступление и наказание", 350, "Достоевский");
    Product item2 = new Book(2, "На дне", 250, "Горький");
    Product item3 = new Book(3, "Евгений Онегин", 320, "Пушкин");
    Product item4 = new Smartphone(4, "Realme 8 X", 12_000, "Китай");
    Product item5 = new Smartphone(5, "Iphone 6", 25_000, "США");
    Product item6 = new Smartphone(6, "Iphone 13", 50_000, "США");
    Product item7 = new Smartphone(7, "Huawei Smart", 20_000, "Корея");

    @Test
    public void shouldSearchByExist() {
        Product[] items = {item1, item2, item3, item4, item5, item6, item7};
        doReturn(items).when(repo).findAll();

        Product[] expected = {item5, item6};
        Product[] actual = manager.searchBy("Iphone");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchByNotExist() {
        Product[] items = {item1, item2, item3, item4, item5, item6, item7};
        doReturn(items).when(repo).findAll();

        Product[] expected = {};
        Product[] actual = manager.searchBy("Цветы");

        Assertions.assertArrayEquals(expected, actual);
    }
}
