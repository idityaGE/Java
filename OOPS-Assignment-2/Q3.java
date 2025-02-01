
class ComplexNum {

    double real, img;

    ComplexNum(double real, double img) {
        this.real = real;
        this.img = img;
    }

    ComplexNum() {
        this(0, 0);
    }

    void display() {
        if (img < 0) {
            System.out.println(real + " - " + Math.abs(img) + "i");
        } else {
            System.out.println(real + " + " + img + "i");
        }
    }

    static ComplexNum addition(ComplexNum a, ComplexNum b) {
        return new ComplexNum(a.real + b.real, a.img + b.img);
    }

    static ComplexNum addition(double real1, double img1, double real2, double img2) {
        return new ComplexNum(real1 + real2, img1 + img2);
    }

    ComplexNum addition(ComplexNum b) {
        this.real += b.real;
        this.img += b.img;
        return this;
    }
}

class Q3 {

    public static void main(String[] args) {
        ComplexNum c1 = new ComplexNum(3, 4);
        ComplexNum c2 = new ComplexNum(1, 2);
        ComplexNum c3 = new ComplexNum();

        System.out.println("Complex Number 1:");
        c1.display();
        System.out.println("Complex Number 2:");
        c2.display();
        System.out.println("Complex Number 3:");
        c3.display();

        ComplexNum result1 = ComplexNum.addition(3, 4, 1, 2);
        System.out.println("Addition using four parameters:");
        result1.display();

        ComplexNum result2 = ComplexNum.addition(c1, c2);
        System.out.println("Addition using two ComplexNumber objects:");
        result2.display();

        System.out.println("Addition using one ComplexNumber object:");
        c1.addition(c2).display();
    }
}
