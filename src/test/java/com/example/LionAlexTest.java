package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {
    private LionAlex lionAlex;
    private final int expectedLionChildren = 0;
    private final List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");
    private final String expectedPlace = "Нью-Йоркский зоопарк";

    @Test
    public void testGetKittens() throws Exception {
        lionAlex = new LionAlex(new Feline());
        int actual = lionAlex.getKittens();

        assertEquals("Количество львят не соответствует ожидаемому",
                expectedLionChildren, actual);
    }

    @Test
    public void testGetFriends() throws Exception {
        lionAlex = new LionAlex(new Feline());
        List<String> actual = lionAlex.getFriends();

        assertEquals("Список друзей не соответствует ожидаемому",
                expectedFriends, actual);
    }

    @Test
    public void testGetPlaceOfLiving() throws Exception {
        lionAlex = new LionAlex(new Feline());
        String actual = lionAlex.getPlaceOfLiving();

        assertEquals("Некорректное место проживания льва",
                expectedPlace, actual);
    }
}
