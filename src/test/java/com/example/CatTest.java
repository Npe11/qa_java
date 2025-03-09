package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

public class CatTest {

    @Test
    public void testGetSound() {
        Feline felineMock = mock(Feline.class);
        Cat cat = new Cat(felineMock);
        assertEquals("Мяу", cat.getSound(), "Звук кота должен быть 'Мяу'");
    }

    @Test
    public void testGetFood() throws Exception {
        Feline felineMock = mock(Feline.class);
        List<String> mockFood = List.of("Мясо", "Рыба");
        when(felineMock.eatMeat()).thenReturn(mockFood);
        Cat cat = new Cat(felineMock);
        assertEquals(mockFood, cat.getFood(), "Метод getFood должен возвращать список, полученный от зависимости");
    }
}
