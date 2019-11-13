/**
 * Created by Technician on 2019-02-02.
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }

    @Override
    public void resize() {
        System.out.println("Resizing Circle");
    }

    @Override
    public String description() {
        return "Circle object";
    }

    @Override
    public boolean isHidden() {
        return false;
    }
}
