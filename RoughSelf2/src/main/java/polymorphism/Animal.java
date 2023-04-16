package polymorphism;

import org.w3c.dom.ls.LSOutput;

class Animal {
    void eat(){
        System.out.println("I am animal eat");};
}

class Dog extends Animal{
    void eat(){
        System.out.println("I am dog eat");}
}

class Cow extends Animal{
    void eat(){
        System.out.println("I am cow eat");}

    void sound(){
        System.out.println("I am cow sound");
    }
}

class Main{
    public static void main(String[]args){
        Animal a = new Cow();
        Cow b = new Cow();
        a.eat();
        b.eat();
        b.sound();

    }
}


