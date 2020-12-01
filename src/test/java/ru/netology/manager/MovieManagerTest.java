package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {
    private final MovieItem item1 = new MovieItem(1, 1, "Killer", "horror", true);
    private final MovieItem item2 = new MovieItem(2, 2, "Dead", "horror", true);
    private final MovieItem item3 = new MovieItem(3, 3, "Haha", "comedy", false);
    private final MovieItem item4 = new MovieItem(4, 4, "West", "western", true);
    private final MovieItem item5 = new MovieItem(5, 5, "Dead", "horror", true);
    private final MovieItem item6 = new MovieItem(6, 6, "Hehe", "comedy", true);
    private final MovieItem item7 = new MovieItem(7, 7, "Haha", "comedy", false);
    private final MovieItem item8 = new MovieItem(8, 8, "Killer", "horror", true);
    private final MovieItem item9 = new MovieItem(9, 9, "East", "western", true);
    private final MovieItem item10 = new MovieItem(10, 10, "HiHi", "comedy", true);
    private final MovieItem item11 = new MovieItem(11, 11, "Hehe", "comedy", true);
    private final MovieItem item12 = new MovieItem(12, 12, "Killer", "horror", true);

    @Test
    public void Return10() {
        MovieManager manager = new MovieManager();
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
        manager.add(item8);
        manager.add(item9);
        manager.add(item10);
        manager.add(item11);
        manager.add(item12);

        MovieItem[] actual = manager.getFirst();
        MovieItem[] expected = new MovieItem[]{item12, item11, item10, item9, item8, item7, item6, item5, item4, item3};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void ReturnLessThan10() {
        MovieManager manager = new MovieManager();
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
        manager.add(item8);

        MovieItem[] actual = manager.getFirst();
        MovieItem[] expected = new MovieItem[]{item8, item7, item6, item5, item4, item3, item2, item1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void Return4() {
        MovieManager manager = new MovieManager(4);
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);

        MovieItem[] actual = manager.getFirst();
        MovieItem[] expected = new MovieItem[]{item5, item4, item3, item2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void ReturnLessThan5() {
        MovieManager manager = new MovieManager(4);
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);

        MovieItem[] actual = manager.getFirst();
        MovieItem[] expected = new MovieItem[]{item4, item3, item2, item1};

        assertArrayEquals(expected, actual);
    }
}