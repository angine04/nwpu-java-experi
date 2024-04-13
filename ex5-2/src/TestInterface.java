abstract class Speakable {
    public void speak(){};
}

interface Runner {
    public void run();
}

class Bird extends Speakable {
    public void speak() {
        System.out.println("鸟的声音:啾、啾！");
    }
}

class Dog extends Speakable implements Runner {
    public void speak() {
        System.out.println("狗的声音:汪、汪！");
    }

    public void run() {
        System.out.println("狗用四肢跑步");
    }
}

class Person extends Speakable implements Runner {
    public void speak() {
        System.out.println("人们见面时经常说:您好！");
    }

    public void run() {
        System.out.println("人用两腿跑步");
    }
}

public class TestInterface {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.speak();
        d.run();
        Person p = new Person();
        p.speak();
        p.run();
        Bird b = new Bird();
        b.speak();
    }
}