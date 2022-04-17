package service.Proxy;


import service.Animal;
import service.Impl.AnimalImpl;

public class ExcuteMain {
    public static void main(String[] args) {
        AnimalImpl cat = new AnimalImpl();
        Animal catProxy = (Animal) ProxyClass.getProxy(cat);
        catProxy.call();
    }
}
