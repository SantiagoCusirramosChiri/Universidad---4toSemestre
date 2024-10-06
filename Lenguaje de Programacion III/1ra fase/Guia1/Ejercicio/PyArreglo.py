class Arreglo:
    def __init__(self, *arreglo):
        self.arreglo = arreglo

    def sumaArreglo(self):
        suma = 0
        for i in self.arreglo:
            suma += i
        return suma

def main():
    numlist = [1,2,3,4,5,6,7,8,9]
    are = Arreglo(*numlist)
    sumaTotal = are.sumaArreglo()
    print(sumaTotal)

if __name__ == "__main__":
    main()
