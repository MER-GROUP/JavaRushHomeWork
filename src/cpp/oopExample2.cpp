#include <iostream>
#include <cmath> // Этот заголовочный файл содержит функцию sqrt для вычисления корня
using namespace std;

class Complex {

    private:

        double real; 
        double img; 

    public:

        Complex() { // Конструктор по умолчанию
            real = 0;
            img = 0;
        }
        Complex(const Complex& c) { // Копирующий конструктор
            this->real = c.real;
            this->img = c.img;
        }
        
        Complex(double, double); // Конструктор объявлен в классе, а определен будет вне его

        void operator = (Complex c) { // Перегрузка оператора присваивания
            this->real = c.real;
            this->img = c.img;
        }

        bool operator == (Complex c) { // Перегрузка оператора сравнения
            if (this->real == c.real && this->img == c.img) {
                return true;
            } else {
                return false;
            }
        }

        Complex operator + (Complex c) { // Перегрузка оператора сложения
            Complex tmp;
            tmp.real = this->real + c.real;
            tmp.img = this->img + c.img;
            return tmp;
        }

        Complex operator * (Complex c); // Перегрузка оператора умножения
        // В классе только прототип, определение будет за пределами класса

        double module(); // Модуль комплексного числа, в классе только прототип

        void invert() { // Обращение комплексного числа в сопряженное
            img = -img;
        }

        void printComplex() { // Вывод комплексного числа
            cout << real << '+' << img << 'i' << endl;
        }

};

Complex::Complex(double a, double b) { // Конструктор определен будет вне класса
    real = a;
    img = b;
}

double Complex::module() { // Метод определен вне класса
    return sqrt(real*real + img*img);
}

Complex Complex::operator * (Complex c) { //  Оператор определен вне класса
    Complex tmp;
    tmp.real=(real*c.real)-(img*c.img);
    tmp.img=(real*c.img)+(img*c.real);
    return tmp;
}

int main() {
    Complex a(2,3);
    Complex b(3,2);
    a.printComplex();
    b.printComplex();
    Complex c;
    c = a+b; // Перегруженный оператор сложения в действии
    c.printComplex();
    Complex z; // Создастся нулевое число конструктором по умолчанию
    z.printComplex();
    return 0;
}