#include <iostream>
using namespace std;

template <typename T> // T - имя шаблонного типа
class Vector { // Создаём класс с именем Vector
    private: // Закрытые члены класса
        T* v; // Указатель на массив с координатами
        int n; // Длина массива с координатами (размерность вектора)
    public: // Открытые члены класса
        Vector(int n = 3) { // Конструктор с параметром по умолчанию
            this->v = new T[n];
            this->n = n;
            for(int i=0; i<n; i++) v[i] = 0;
        }
        Vector(const Vector& a) { // Копирующий конструктор
            n = a.n;
            v = new T[a.n];
            for(int i=0; i < a.n; i++) v[i] = a.v[i];
        }
        ~Vector() { // Деструктор
            delete[] v; // Освобождает память, удаляя динамический массив
        }
        void printVector() { // Метод печатающий вектор
            for(int i=0; i<n; i++) cout << v[i] << ' ';
            cout << endl;
        }
        void fillVector(T a) { // Метод заполняющий вектор координатами
            for(int i=0; i<n; i++) v[i] = a;
        }

};

int main() {
    Vector <int> a(3), b; // Создание объектов, вместо шаблонного типа используем int
    a.fillVector(3);
    a.printVector(); // 3 3 3
    b.fillVector(5);
    Vector <int> c(b); // Создание объекта копирующим конструктором
    c.printVector(); // 5 5 5
    Vector <float> d; // Создание объекта, вместо шаблонного типа используем float
    d.fillVector(3.141592); // 3.141592 3.141592 3.141592
    d.printVector();
}