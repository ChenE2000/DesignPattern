/*
 * @AUTHOR: chenE2000
 * 将形状和颜色分离，根据需要对形状和颜色进行组合
 */

interface IShape {
    void draw();
}


interface IColor {
    String getColor();
}


class Red implements IColor {
    @Override
    public String getColor() {
        return "红";
    }
}


class Blue implements IColor {
    @Override
    public String getColor() {
        return "蓝";
    }
}


class Yellow implements IColor {
    @Override
    public String getColor() {
        return "黄";
    }
}


class Green implements IColor {
    @Override
    public String getColor() {
        return "绿";
    }
}


// 在每个形状类中，桥接 IColor 接口：
class Rectangle implements IShape {

    private IColor color;

    void setColor(IColor color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("绘制" + color.getColor() + "矩形");
    }
}


class Round implements IShape {

    private IColor color;

    void setColor(IColor color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("绘制" + color.getColor() + "圆形");
    }
}


class Triangle implements IShape {

    private IColor color;

    void setColor(IColor color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("绘制" + color.getColor() + "三角形");
    }
}


public class exp_04_bridge {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setColor(new Red());
        rectangle.draw();

        Round round = new Round();
        round.setColor(new Blue());
        round.draw();

        Triangle triangle = new Triangle();
        triangle.setColor(new Yellow());
        triangle.draw();
    }
}
