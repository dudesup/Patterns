/**
 * Created by Technician on 2019-02-02.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Creating Simple Shape Objects...");
        Shape rectangle = new Rectangle();
        Shape circle = new Circle();

        System.out.println("Drawing Simple Shape Objects...");
        System.out.println();
        rectangle.draw();
        circle.draw();
        System.out.println();

        System.out.println("Creating Decorated Circle with Red Color, Blue Lines in dash pattern and thickness of 2...");
        Shape circle1 = new FillColorDecorator(
                new LineColorDecorator(
                        new LineStyleDecorator(
                                new LineThicknessDecorator(
                                        new Circle(),
                                        2.0d),
                                LineStyle.DASH),
                        Color.BLUE),
                Color.RED);

        circle1.draw();
        System.out.println();

        Circle circle2 = new Circle();
        LineThicknessDecorator lt = new LineThicknessDecorator(circle2, 1.7d);
        LineStyleDecorator ls = new LineStyleDecorator(lt, LineStyle.DOUBLE_DASH);
        FillColorDecorator fc = new FillColorDecorator(ls, Color.BLACK);
//        LineColorDecorator lc = new LineColorDecorator(fc, Color.GREEN);
        Shape circle3 = fc;
        circle3.draw();
        System.out.println();
    }
}
