import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.*;

public class ProductRepositoryTest {
    Product item1 = new Book(1, "Преступление и наказание", 350, "Достоевский");
    Product item2 = new Book(2, "На дне", 250, "Горький");
    Product item3 = new Book(3, "Евгений Онегин", 320, "Пушкин");
    Product item4 = new Smartphone(4, "Realme 8 X", 12_000, "Китай");
    Product item5 = new Smartphone(5, "Iphone 6", 25_000, "США");
    Product item6 = new Smartphone(6, "Iphone 13", 50_000, "США");
    Product item7 = new Smartphone(7, "Huawei Smart", 20_000, "Корея");

    @Test
    public void shouldSaveItems() {
        ProductRepository repo = new ProductRepository();

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);
        repo.save(item7);

        Product[] expected = {item1, item2, item3, item4, item5, item6, item7};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        ProductRepository repo = new ProductRepository();

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);
        repo.save(item7);
        repo.removeById(item2.getId());

        Product[] expected = {item1, item3, item4, item5, item6, item7};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGiveErrorRemoveById() {
        ProductRepository repo = new ProductRepository();

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);
        repo.save(item7);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(15);
        });
    }
}
