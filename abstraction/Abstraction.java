package abstraction;

public class Abstraction {
    public static void main(String[] args) {
        Dog dog = new Dog(2);
        Car car = new Car();
        System.out.println(dog.age);
        dog.eat();
        dog.sleep();
        car.refuel();
    }
}

abstract class Animal {
    int age = 0;

    Animal(int age) {
        this.age = age;
    }

    public void eat() {
        System.out.print("Animal is eating");
    }

    public void sleep() {
        System.out.print("Animal is sleeping");
    }
}

class Dog extends Animal {
    Dog(int age) {
        super(age);
    }

    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }
}

class Car implements Vehicle {

    @Override
    public void refuel() {
        System.out.println("Car is getting refueled");
    }

}