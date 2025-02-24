class Animal {
    void makeSound() {
        System.out.println("Animal makes sound");
    }

    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.makeSound();
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Bark");
    }
}
