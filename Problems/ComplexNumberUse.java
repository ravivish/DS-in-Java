package CN;

public class ComplexNumberUse {
    public static void main(String[] args) {
        ComplexNumer c1=new ComplexNumer(2,3);
        c1.print();
//
        c1.setReal(10);
        c1.setImaginary(30);
        c1.print();
//
        ComplexNumer c2=new ComplexNumer(1,5);
        c1.add(c2);
        c1.print();
        c2.print();
//
        ComplexNumer c3=new ComplexNumer(3,2);
        c3.multiply(c2);
        c3.print();
        c2.print();
//
        ComplexNumer c4=ComplexNumer.add(c1,c3);
        c1.print();
        c3.print();
        c4.print();
//
       ComplexNumer c5=c1.conjugate();
       c5.print();

    }


}
