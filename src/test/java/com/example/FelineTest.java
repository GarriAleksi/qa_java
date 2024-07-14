package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    private static final String EXPECTED_FAMILY = "Кошачьи";
    private static final int EXPECTED_KITTENS_COUNT_FOR_MOCK = 1;
    private static final int KITTENS_COUNT = 5;

    @Spy
    private Feline feline;

    @Test
    public void testEatMeat() throws Exception {
        feline.eatMeat();
        verify(feline, times(1)).getFood("Хищник");
    }

    @Test
    public void testGetFamily() {
        String actual = feline.getFamily();
        verify(feline, times(1)).getFamily();
        assertEquals("Expected family does not match actual", EXPECTED_FAMILY, actual);
    }

    @Test
    public void testGetKittens() {
        int actual = feline.getKittens();
        verify(feline).getKittens(EXPECTED_KITTENS_COUNT_FOR_MOCK);
        assertEquals("Expected kittens count does not match actual", EXPECTED_KITTENS_COUNT_FOR_MOCK, actual);
    }

    @Test
    public void testGetKittensWithCount() {
        int actual = feline.getKittens(KITTENS_COUNT);
        verify(feline).getKittens(KITTENS_COUNT);
        assertEquals("Expected kittens count does not match actual", KITTENS_COUNT, actual);
    }
}
