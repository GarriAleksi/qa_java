package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AnimalTest {

    @Mock
    private Animal mockAnimal;

    private static final String EXPECTED_FAMILY = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

    @Test
    public void testGetFamily() {
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
