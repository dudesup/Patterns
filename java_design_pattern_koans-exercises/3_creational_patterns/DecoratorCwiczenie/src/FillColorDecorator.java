/**
 * Created by Technician on 2019-02-02.
 */
public class FillColorDecorator extends ShapeDecorator {

    protected Color color;

    public FillColorDecorator(Shape decoratedShape, Color color) {
        super(decoratedShape);
        this.color = color;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        System.out.println("Fill color: " + color);
    }

    // bez zmian
    @Override
    public void resize() {
        decoratedShape.resize();
    }

    @Override
    public String description() {
        return decoratedShape.description() + " filled with " + color + " color.";
    }

    // bez zmian
    @Override
    public boolean isHidden() {
        return decoratedShape.isHidden();
    }
}
