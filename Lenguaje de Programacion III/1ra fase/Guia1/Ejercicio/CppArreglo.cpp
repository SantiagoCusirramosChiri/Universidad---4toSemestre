#include <iostream>
#include <vector>
using namespace std;

class Arreglo {
private:
    vector <int> arreglo;

public:

    Arreglo(vector <int> _arreglo) : arreglo(_arreglo) {};

    int sumaVector() {
        int suma = 0;
        for(size_t i = 0; i < arreglo.size(); i++){
            suma += arreglo[i];
        }
        return suma;
    }
};


int main() {
    vector<int> arreglo = {1,2,3,4,5,6,7,8,9};

    Arreglo are(arreglo);
    cout << "La suma del vector es: " << are.sumaVector() << endl;
    return 0;
}