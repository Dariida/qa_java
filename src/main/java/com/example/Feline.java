package com.example;

import java.util.List;

public class Feline extends Animal implements Predator {

    @Override
    public List<String> eatMeat() throws Exception {
        return getFood("Хищник");
    }

    @Override
    public String getFamily() {
        return "Кошачьи";
    }

    /**Проверка кол-ва без параметров**/
    public int getKittens() {
        return getKittens(1);
    }

    /**Проверка кол-ва с параметрами**/
    public int getKittens(int kittensCount) {
        return kittensCount;
    }

}
