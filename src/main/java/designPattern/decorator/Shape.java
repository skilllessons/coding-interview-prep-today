package main.java.designPattern.decorator;

interface Shape {

    String draw();
}


class Triangle implements Shape {

    @Override
    public String draw() {
        return "Triangle";
    }
}


class Circle implements Shape {

    @Override
    public String draw() {
        return "Circle";
    }
}


abstract class ShapeDecorator implements Shape {

    Shape shape;

    ShapeDecorator(Shape shape){
        this.shape = shape;
    }
}

class ColorDecorator extends ShapeDecorator{

    String color;


    ColorDecorator(String color,Shape shape) {
        super(shape);
        this.color = color;
    }

    @Override
    public String draw() {
        return color+" "+shape.draw();
    }
}



class BorderDecorator extends ShapeDecorator{


    BorderDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public String draw() {
        return shape.draw()+ "Draw with a border" ;
    }
}

class Test{

    public static void main(String[] args) {
        Shape circle = new Circle();
        System.out.println(circle.draw());

        Shape redCircle = new ColorDecorator("red", circle);
        System.out.println(redCircle.draw());

        Shape redCircleWithBorder = new BorderDecorator( redCircle);
        System.out.println(redCircleWithBorder.draw());

    }
}