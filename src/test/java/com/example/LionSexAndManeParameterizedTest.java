package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionSexAndManeParameterizedTest {

    private static final String MALE = "Самец";
    private static final String FEMALE = "Самка";

    @Parameterized.Parameter(0)
    public String sex;

    @Parameterized.Parameter(1)
    public boolean hasMane;

    @Mock
    private Feline feline;

    private Lion lion;

    @Before
    public void setUp() throws Exception {
        // Инициализация моков
        MockitoAnnotations.openMocks(this);
        // Создание экземпляра Lion с использованием мока Feline
        lion = new Lion(sex, feline);
    }

    @Parameterized.Parameters(name = "Sex: {0}, hasMane: {1}")
    public static Object[][] getParameters() {
        return new Object[][] {
                {MALE, true},
                {FEMALE, false}
        };
    }

    @Test
    public void testDoesHaveMane() {
        boolean actual = lion.doesHaveMane();
        assertEquals("Expected doesHaveMane() to return " + hasMane + " for sex " + sex, hasMane, actual);
    }

    @Test
    public void testGetKittens() {
        // Настройка поведения мока для метода getKittens
        when(feline.getKittens()).thenReturn(3);

        // Вызов метода и проверка результата
        assertEquals(3, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> foodForPredator = Arrays.asList("Животные", "Птицы", "Рыба");

        // Настройка поведения мока для метода getFood
        when(feline.getFood("Хищник")).thenReturn(foodForPredator);

        // Вызов метода и проверка результата
        assertEquals(foodForPredator, lion.getFood());
    }
}
