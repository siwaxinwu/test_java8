package org.roy.inter;

import javax.lang.model.type.ReferenceType;
import java.util.Objects;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2022/3/17 17:24
 */
public class TestFanXing {

  public static void main(String[] args) {
      final  Biology carnivore = getCarnivore();
      final  Biology spawn = carnivore.spawn();
      ((Carnivore)spawn).takeFood(null);


      final  Carnivore carnivore2 =new Carnivore();
      final  Biology carnivore3 = carnivore2.spawn();
      ((Carnivore)carnivore3).takeFood(null);

  }

    //生物的抽象类
    static abstract class Biology<T extends Biology<T>>{
        //繁殖
        abstract T spawn();
    }


    static abstract class Animal<S extends Biology<?>> extends Biology<Animal<S>>{
        //繁殖
        abstract Animal spawn();

        abstract void takeFood(S food);
    }

    //食肉动物
    static class Carnivore extends Biology<Carnivore>{
        @Override
        Carnivore spawn() {
            return new Carnivore();
        }

        void takeFood(Hebivore food){

        }
    }

    //食草动物
    static class Hebivore extends Biology<Hebivore>{
        @Override
        Hebivore spawn() {
            return new Hebivore();
        }

        void takeFood(Object obj){

        }
    }

    static class Botany extends Biology<Botany>{

        @Override
        Botany spawn() {
            return null;
        }
    }

    public static <T extends Biology<T>> Biology<T> getCarnivore(){
        return (Biology<T>) new Carnivore();
    }


}
