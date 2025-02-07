class Animal {
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void makeSound() {
	System.out.println("Animal name: "+name+ ", Age: "+ age); 
	System.out.println("Animal makes Sounds");
    }
}

class Dog extends Animal {
    Dog(String name, int age) {
        super(name, age);
    }

    void makeSound() {
	System.out.println("Dog's name: "+name+ ", Age: "+ age);
        System.out.println("Sound: barks");
    }
}

class Cat extends Animal {
    Cat(String name, int age) {
        super(name, age);
    }

    void makeSound() {
	System.out.println("Cat's name: "+name+ ", Age: "+ age);
        System.out.println("Sound: Meow Meow");
    }
}

class Bird extends Animal {
    Bird(String name, int age) {
        super(name, age);
    }

    void makeSound() {
	System.out.println("Bird's name: "+name+ ", Age: "+ age);
        System.out.println("Sound: Chirp Chirp");
    }
}

public class AnimalMainClass {
    public static void main(String[] args) {
        Animal dog = new Dog("Junior", 1);
        Animal cat = new Cat("Whiskey", 2);
        Animal bird = new Bird("Sweety", 3);

        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
    }
}
