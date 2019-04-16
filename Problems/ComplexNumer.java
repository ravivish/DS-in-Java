package CN;

public class ComplexNumer {
    private int real;
    private int imaginary;

    public ComplexNumer(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getImaginary() {
        return imaginary;
    }

    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }

    public void print() {

        System.out.println(real+" + i"+imaginary);

    }

    public void add(ComplexNumer c) {
        this.real=this.real+c.real;
        this.imaginary=this.imaginary+c.imaginary;
    }
    public void multiply(ComplexNumer c){
        int r=this.getReal(),im=this.getImaginary();
        this.real=(r*c.real)-(im*c.imaginary);
        this.imaginary=(r*c.imaginary)+(im*c.real);
    }

    public static ComplexNumer add(ComplexNumer c1, ComplexNumer c2) {

        int newReal = c1.real + c2.real;
        int newImaginary = c1.imaginary + c2.imaginary;
        ComplexNumer c3 = new ComplexNumer(newReal, newImaginary);
        return c3;
    }
    public ComplexNumer conjugate(){
        int r=this.real,im=-this.imaginary;
        ComplexNumer c1=new ComplexNumer(r,im);
        return c1;
    }
}
