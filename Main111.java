class Animal {
    void sound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Bark");
    }
}

public class Main111 {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.sound(); // Output: Bark

      Animal a1 = new Dog();
        a1.sound();

      Dog a2 = new Dog();
        a2.sound();
        
    }
}
