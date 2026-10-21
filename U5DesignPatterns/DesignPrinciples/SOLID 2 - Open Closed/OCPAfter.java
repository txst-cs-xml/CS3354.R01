
// AFTER: see README.md for the design comparison.
public class OCPAfter {
    abstract static class Shape {
        abstract void draw();
    }

    static class Rectangle extends Shape {
        @Override
        void draw() { System.out.println("Drawing rectangle"); }
    }

    static class Circle extends Shape {
        @Override
        void draw() { System.out.println("Drawing circle"); }
    }

    // Extension: no change to GraphicEditor is needed.
    static class Triangle extends Shape {
        @Override
        void draw() { System.out.println("Drawing triangle"); }
    }

    static class GraphicEditor {
        void drawShape(Shape shape) { shape.draw(); }
    }

    public static void main(String[] args) {
        GraphicEditor editor = new GraphicEditor();
        editor.drawShape(new Rectangle());
        editor.drawShape(new Circle());
        editor.drawShape(new Triangle());
    }
}
