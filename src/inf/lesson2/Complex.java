package inf.lesson2;

public class Complex implements INumber<Complex> {
    private double x;
    private double y;

    public Complex(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public Complex sum1(Complex obj) {
        return new Complex(
                this.x + obj.x,
                this.y + obj.y
        );
    }

    @Override
    public void sum2(Complex obj) {
        this.x += obj.x;
        this.y += obj.y;
    }

    @Override
    public Complex dis1(Complex obj) {
        return new Complex(
                this.x - obj.x,
                this.y - obj.y
        );
    }

    @Override
    public void dis2(Complex obj) {
        this.x -= obj.x;
        this.y -= obj.y;
    }

    @Override
    public Complex mult1(Complex obj) {
        return new Complex(
                this.x * obj.x + (-1) * this.y * obj.y,
                this.x * obj.y + this.y * obj.x
        );
    }

    @Override
    public void mult2(Complex obj) {
        this.x = this.x * obj.x + (-1) * this.y * obj.y;
        this.y = this.x * obj.y + this.y * obj.x;
    }

    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }
}
