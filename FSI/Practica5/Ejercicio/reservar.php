<?php
header('Content-Type: application/json');

$host = 'localhost';
$user = 'root'; 
$password = ''; 
$dbname = 'the_imperial_db';

$conn = new mysqli($host, $user, $password, $dbname);

if ($conn->connect_error) {
    die(json_encode(['success' => false, 'message' => 'Error de conexión: ' . $conn->connect_error]));
}

$data = json_decode(file_get_contents('php://input'), true);
$nombre = $conn->real_escape_string($data['nombre']);
$correo = $conn->real_escape_string($data['correo']);
$tipo_habitacion = $conn->real_escape_string($data['tipo_habitacion']);
$fecha_checkin = $conn->real_escape_string($data['fecha_checkin']);
$fecha_checkout = $conn->real_escape_string($data['fecha_checkout']);

$sql = "INSERT INTO reservaciones (nombre, correo, tipo_habitacion, fecha_checkin, fecha_checkout) VALUES 
('$nombre', '$correo', '$tipo_habitacion', '$fecha_checkin', '$fecha_checkout')";

if ($conn->query($sql) === TRUE) {
    echo json_encode(['success' => true]);
} else {
    echo json_encode(['success' => false, 'message' => 'Error: ' . $conn->error]);
}

$conn->close();
?>
