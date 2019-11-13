/**
 * Created by Technician on 2019-02-02.
 */
public class LineStyleDecorator extends ShapeDecorator {

    protected LineStyle style;

    public LineStyleDecorator(Shape decoratedShape, LineStyle style) {
        super(decoratedShape);
        this.style = style;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        System.out.println("Line style: " + style);
    }

    // bez zmian
    @Override
    public void resize() {
    decoratedShape.resize();
    }

    @Override
    public String description() {
        return decoratedShape.description() + " drawn with " + style + " lines.";
    }

    @Override
    public boolean isHidden() {
        return decoratedShape.isHidden();
    }
}
