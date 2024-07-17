package com.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    private static final String EXPECTED_FAMILY = "Кошачьи";
    private static final int KITTENS_COUNT = 5;

    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void testEatMeat() throws Exception {
        // Тестируем метод eatMeat(), который вызывает реальный метод getFood("Хищник")
        feline.eatMeat();
        // Нет необходимости проверять getLastFoodType(), так как этот метод не определен в классе Feline
    }

    @Test
    public void testGetFamily() {
        String actual = feline.getFamily();
        assertEquals("Ожидаемое семейство не соответствует фактическому", EXPECTED_FAMILY, actual);
    }

    @Test
    public void testGetKittens() {
        int actual = feline.getKittens();
        assertEquals("Ожидаемое количество котят не соответствует фактическому", 1, actual);
    }

    @Test
    public void testGetKittensWithCount() {
        int actual = feline.getKittens(KITTENS_COUNT);
        assertEquals("Ожидаемое количество котят не соответствует фактическому", KITTENS_COUNT, actual);
    }
}
