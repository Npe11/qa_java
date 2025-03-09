package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FelineTest {

    @Test
    public void testGetKittensDefault() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens(), "По умолчанию количество котят должно быть 1");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3, 5})
    public void testGetKittensParameterized(int kittensCount) {
        Feline feline = new Feline();
        assertEquals(kittensCount, feline.getKittens(kittensCount),
                "Количество котят должно совпадать с переданным параметром");
    }

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.eatMeat(), "Метод eatMeat должен возвращать список продуктов для хищника");
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily(), "Метод getFamily должен возвращать \"Кошачьи\"");
    }
}
