package com.msrm.tricky;

class Cat {

    public static void meow() {
	System.out.println("Meow");
    }

}

class Munchkin extends Cat {

    public static void meow() {
	System.out.println("yown");
    }

}

public class Tricky11 {

    public static void main(String[] args) {
	Cat kitty = new Cat();
	Cat munch = new Munchkin();
	kitty.meow();
	munch.meow();
    }

}
