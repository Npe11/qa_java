package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

public class LionTest {

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    public void testDoesHaveMane(String sex, boolean expectedMane) throws Exception {
        Feline felineMock = mock(Feline.class);
        when(felineMock.getKittens()).thenReturn(1);
        Lion lion = new Lion(sex, felineMock);
        assertEquals(expectedMane, lion.doesHaveMane(), "Наличие гривы должно соответствовать ожидаемому значению");
    }

    @Test
    public void testGetFood() throws Exception {
        Feline felineMock = mock(Feline.class);
        List<String> mockFood = List.of("Мясо", "Рыба");
        when(felineMock.eatMeat()).thenReturn(mockFood);
        Lion lion = new Lion("Самец", felineMock);
        assertEquals(mockFood, lion.getFood(), "Метод getFood должен возвращать список продуктов, полученный от зависимости");
    }

    @Test
    public void testGetKittens() throws Exception {
        Feline felineMock = mock(Feline.class);
        when(felineMock.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", felineMock);
        assertEquals(3, lion.getKittens(), "Метод getKittens должен возвращать количество котят, полученное от зависимости");
    }

    @Test
    public void testInvalidSex() {
        Feline felineMock = mock(Feline.class);
        Exception exception = assertThrows(Exception.class, () -> new Lion("Неверный", felineMock));
        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage(),
                "При недопустимом значении пола должна быть ошибка");
    }
}
