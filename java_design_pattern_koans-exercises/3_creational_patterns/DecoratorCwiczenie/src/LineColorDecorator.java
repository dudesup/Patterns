/**
 * Created by Technician on 2019-02-02.
 */
public class LineColorDecorator extends ShapeDecorator {

    protected Color color;

    public LineColorDecorator(Shape decoratedShape, Color color) {
        super(decoratedShape);
        this.color = color;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        System.out.println("Line color: " + color);
    }

    // znowu nic nie zmieniamy
    @Override
    public void resize() {
        decoratedShape.resize();
    }

    @Override
    public String description() {
        return decoratedShape.description() + " drawn with " + color + " color.";
    }

    // znowu nic nie zmieniamy
    @Override
    public boolean isHidden() {
        return decoratedShape.isHidden();
    }
}
