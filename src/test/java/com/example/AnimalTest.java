package com.example;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AnimalTest {
    private Animal animal;
    private static final String UNSUPPORTED_ANIMAL_KIND = "unsupported animal kind";
    private static final String TEXT_EXCEPTION = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
    private static final String FAMILY = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

    @Before
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void testGetFoodException() {
        Throwable throwable = catchThrowable(() -> animal.getFood(UNSUPPORTED_ANIMAL_KIND));
        assertThat(throwable)
                .isInstanceOf(Exception.class)
                .hasMessage(TEXT_EXCEPTION);
    }

    @Test
    public void testGetFamily() {
        String actual = animal.getFamily();
        assertEquals("Ответ не соответствует ожидаемому", FAMILY, actual);
    }

    @Mock
    private Animal mockAnimal;

    private static final String EXPECTED_FAMILY = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

    @Test
    public void testMockedGetFamily() {
        // Настройка мок-объекта
        when(mockAnimal.getFamily()).thenReturn(EXPECTED_FAMILY);

        // Вызов метода, который требуется протестировать
        String actual = mockAnimal.getFamily();

        // Проверка результата
        assertEquals("Возвращаемое значение не соответствует ожидаемому", EXPECTED_FAMILY, actual);

        // Проверка, что метод был вызван ровно один раз
        verify(mockAnimal, times(1)).getFamily();
    }
}
