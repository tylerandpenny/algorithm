package service.Impl;

import service.Animal;

public class AnimalImpl implements Animal {

    /**
     * 待增强功能的方法
     */
    @Override
    public void call() {
        System.out.println("待增强功能的方法--- A");
    }
}
