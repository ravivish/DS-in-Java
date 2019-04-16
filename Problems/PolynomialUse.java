package CN;

public class PolynomialUse {
    public static void main(String[] args) {
        Polynomial p1=new Polynomial();

        p1.setCoefficient(2,1);
        p1.setCoefficient(3,2);
        p1.setCoefficient(6,4);
        System.out.print("P1 : ");
        p1.print();
//
        Polynomial p2=new Polynomial();
        p2.setCoefficient(4,3);
        p2.setCoefficient(2,1);
        System.out.print("P2 : ");
        p2.print();
//
        Polynomial p3=p1.add(p2);
        System.out.print("Addition : ");
        p3.print();
//
        Polynomial p4=p1.subtract(p2);
        System.out.print("Subtraction : ");
        p4.print();
//
        Polynomial p5=p1.multiply(p2);
        System.out.print("Multiplication : ");
        p5.print();


    }
}
