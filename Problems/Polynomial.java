package CN;

public class Polynomial {

    private int coefficient[] = new int[100];
    /* This function sets coefficient for a particular degree value, if degree is not there in the polynomial
     *  then corresponding term(with specified degree and value is added int the polynomial. If the degree
     *  is already present in the polynomial then previous coefficient is replaced by
     *  new coefficient value passed as function argument
     */


    public void setCoefficient(int degree, int coefficient) {
        if (degree < 0) {
            return;
        } else {
            this.coefficient[degree] = coefficient;
        }


    }

    // Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of degree.
    public void print() {

        for (int i= 0; i < coefficient.length; i++) {
            if (coefficient[i] == 0)
                continue;
            System.out.print(coefficient[i] + "x" + i+" ");
        }
        System.out.println();
    }


    //     Adds two polynomials and returns a new polynomial which has result
    public Polynomial add(Polynomial p) {

        Polynomial p1 = new Polynomial();
        for (int i = 0; i < this.coefficient.length; i++) {
            p1.coefficient[i]+=this.coefficient[i];
        }
        for (int i = 0; i < p.coefficient.length; i++) {
            p1.coefficient[i]+=p.coefficient[i];
        }
        return p1;
    }

    // Subtracts two polynomials and returns a new polynomial which has result
    public Polynomial subtract(Polynomial p) {

        Polynomial p1 = new Polynomial();
        for (int i = 0; i < this.coefficient.length; i++) {
            p1.coefficient[i]+=this.coefficient[i];
        }
        for (int i = 0; i < p.coefficient.length; i++) {
            p1.coefficient[i]-=p.coefficient[i];
        }
        return p1;
    }

    // Multiply two polynomials and returns a new polynomial which has result
    public Polynomial multiply(Polynomial p) {

        Polynomial p1 = new Polynomial();
        for (int i = 0; i < this.coefficient.length; i++) {
            if(this.coefficient[i]!=0)
                for (int j = 0; j < p.coefficient.length; j++) {
                    if(p.coefficient[j]!=0)
                        p1.coefficient[i+j]+=p.coefficient[j]*this.coefficient[i];
                }

        }
        return p1;
    }
}