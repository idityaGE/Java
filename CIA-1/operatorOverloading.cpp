#include <iostream>
using namespace std;

class Complex {
 public:
  int real, imag;

  Complex(int r, int i)
      : real(r), imag(i) {}

  // Operator Overloading of `+`
  Complex operator+(const Complex& obj) {
    return Complex(real + obj.real, imag + obj.imag);
  }

  void display() {
    cout << real << " + " << imag << "i" << endl;
  }
};

int main() {
  Complex c1(3, 4), c2(1, 2);
  Complex c3 = c1 + c2;  // Calls overloaded `operator+`
  c3.display();          // Output: 4 + 6i
  return 0;
}
