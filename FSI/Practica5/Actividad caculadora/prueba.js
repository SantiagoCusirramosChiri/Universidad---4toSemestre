function sumar() {

    let num1 = document.getElementById("numero1");
    let num2 = document.getElementById("numero2");
    let solucion = document.getElementById("respuesta");

    respuesta = parseInt(num1.value) + parseInt(num2.value);
    console.log(respuesta);

    solucion.innerHTML = "Resultado" + respuesta;

}

function resta() {

    let num1 = document.getElementById("numero1");
    let num2 = document.getElementById("numero2");
    let solucion = document.getElementById("respuesta");

    respuesta = parseInt(num1.value) - parseInt(num2.value);
    console.log(respuesta);

    solucion.innerHTML = "Resultado" + respuesta;

}

function multiplicacion() {

    let num1 = document.getElementById("numero1");
    let num2 = document.getElementById("numero2");
    let solucion = document.getElementById("respuesta");

    respuesta = parseInt(num1.value) * parseInt(num2.value);
    console.log(respuesta);

    solucion.innerHTML = "Resultado" + respuesta;

}

function division() {

    let num1 = document.getElementById("numero1");
    let num2 = document.getElementById("numero2");
    let solucion = document.getElementById("respuesta");

    respuesta = parseInt(num1.value) / parseInt(num2.value);
    console.log(respuesta);

    solucion.innerHTML = "Resultado" + respuesta;

}