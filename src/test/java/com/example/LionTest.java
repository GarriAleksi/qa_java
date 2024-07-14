package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private static final String MALE = "Самец";
    private static final String UNSUPPORTED_SEX = "unsupported sex";
    private static final String TEXT_EXCEPTION = "Используйте допустимые значения пола животного - самей или самка";

    @Mock
    private Feline feline;

    private Lion lion;

    @Before
    public void setUp() {
        lion = null; // Reset lion before each test
    }

    @Test
    public void testGetKittens() throws Exception {
        lion = new Lion(MALE, feline);

        lion.getKittens();

        Mockito.verify(feline).getKittens();
    }

    @Test
    public void testDoesHaveManeException() {
        try {
            lion = new Lion(UNSUPPORTED_SEX, feline);
        } catch (Exception e) {
            assertEquals(TEXT_EXCEPTION, e.getMessage());
        }
    }

    @Test
    public void testGetFood() throws Exception {
        lion = new Lion(MALE, feline);

        lion.getFood();

        Mockito.verify(feline).getFood(Mockito.anyString());
    }
}
