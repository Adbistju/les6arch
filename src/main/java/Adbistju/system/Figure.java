package Adbistju.system;

import java.util.Objects;

public class Figure {
    private int id;
    private float area;
    private float width;
    private float height;
    private int angle;

    public Figure(int id, float width, float height, int angle) {
        this.id = id;

        this.width = width;
        this.height = height;
        this.angle = angle;
    }

    public Figure() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public float getSquare() {
        return area;
    }

    public void setSquare() {
        this.area = 0;
        if(angle == 4){
            this.area = width*height;
        } else if(angle == 2){
            this.area = width+height;
        }else if (angle == 3){
            this.area = width*height/2;
        } else if ( angle == 0) {
            this.area = width*height*3.14159f;
        } else if(angle >= 5){
            this.area = width*height*3.14159f;
        }
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
        this.setSquare();
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
        this.setSquare();
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "id=" + id +
                ", area=" + area +
                ", width=" + width +
                ", height=" + height +
                ", angle=" + angle +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return Float.compare(figure.area, area) == 0 &&
                Float.compare(figure.width, width) == 0 &&
                Float.compare(figure.height, height) == 0 &&
                angle == figure.angle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, width, height, angle);
    }

}
