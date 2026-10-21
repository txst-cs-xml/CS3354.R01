
// AFTER: see README.md for the design comparison.
public class LSPAfter {
    interface Shape {
        // Contract: return this shape's area; no independent resizing promised.
        int area();
    }

    static class Rectangle implements Shape {
        private final int width;
        private final int height;

        Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public int area() { return width * height; }
    }

    static class Square implements Shape {
        private final int side;
        Square(int side) { this.side = side; }

        @Override
        public int area() { return side * side; }
    }

    // This client relies only on the contract both shapes actually support.
    static void printArea(Shape shape) {
        System.out.println("Area: " + shape.area());
    }

    public static void main(String[] args) {
        printArea(new Rectangle(5, 4));
        printArea(new Square(4));
    }
}
