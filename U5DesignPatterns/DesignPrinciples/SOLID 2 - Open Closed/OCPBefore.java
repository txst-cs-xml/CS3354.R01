
// BEFORE: see README.md for the design comparison.
public class OCPBefore {
    static class Shape {
        final int type;
        Shape(int type) { this.type = type; }
    }

    static class GraphicEditor {
        void drawShape(Shape shape) {
            // Every new shape requires another branch in the editor.
            if (shape.type == 1) {
                System.out.println("Drawing rectangle");
            } else if (shape.type == 2) {
                System.out.println("Drawing circle");
            } else {
                System.out.println("Unsupported shape type: " + shape.type);
            }
        }
    }

    public static void main(String[] args) {
        GraphicEditor editor = new GraphicEditor();
        editor.drawShape(new Shape(1));
        editor.drawShape(new Shape(2));
        editor.drawShape(new Shape(3)); // The editor cannot draw a triangle yet.
    }
}
