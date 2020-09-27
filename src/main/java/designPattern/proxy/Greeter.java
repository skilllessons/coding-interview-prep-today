package main.java.designPattern.proxy;

abstract class Greeter {
    abstract String greet();
}


class RealGreater extends Greeter {


    @Override
    String greet() {
        return "Hi there!";
    }
}


class GreeterProxy extends Greeter {

    Greeter greeter;

    @Override
    String greet() {

        if(greeter == null) greeter = new RealGreater();
        return greeter.greet();
    }
}

class Test{
    public static void main(String[] args) {
        Greeter greeter = new GreeterProxy();
        System.out.println(greeter.greet());
        System.out.println(greeter.greet());

    }

}
