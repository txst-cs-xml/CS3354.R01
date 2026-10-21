
// BEFORE: see README.md for the design comparison.
public class LSPBefore {
    static class Rectangle {
        private int width;
        private int height;

        // Contract: each setter changes only its own dimension.
        void setWidth(int width) { this.width = width; }
        void setHeight(int height) { this.height = height; }
        int area() { return width * height; }
    }

    static class Square extends Rectangle {
        @Override
        void setWidth(int width) {
            super.setWidth(width);
            super.setHeight(width);
        }

        @Override
        void setHeight(int height) {
            super.setWidth(height);
            super.setHeight(height);
        }
    }

    static void resizeAndReport(Rectangle rectangle) {
        rectangle.setWidth(5);
        rectangle.setHeight(4);
        // A Rectangle client reasonably expects 5 * 4, even for a subtype.
        System.out.println("Expected area: 20, actual: " + rectangle.area());
    }

    public static void main(String[] args) {
        resizeAndReport(new Rectangle());
        resizeAndReport(new Square()); // Compiles, but violates the contract.
    }
}
