package Actividad.Model;

public class Container {

    public String[] teachers = {
            "('T001', '12345678', 'Juan', 'Pérez', 'juan.perez@gmail.com')",
            "('T002', '23456789', 'María', 'Gómez', 'maria.gomez@gmail.com')",
            "('T003', '34567890', 'Luis', 'Martínez', 'luis.martinez@gmail.com')",
            "('T004', '45678901', 'Ana', 'Lopez', 'ana.lopez@gmail.com')",
            "('T005', '56789012', 'Carlos', 'Hernández', 'carlos.hernandez@gmail.com')",
            "('T006', '67890123', 'Laura', 'Ramírez', 'laura.ramirez@gmail.com')",
            "('T007', '78901234', 'Pedro', 'Torres', 'pedro.torres@gmail.com')",
            "('T008', '89012345', 'Sofía', 'Ríos', 'sofia.rios@gmail.com')",
            "('T009', '90123456', 'Diego', 'Mendoza', 'diego.mendoza@gmail.com')",
            "('T010', '01234567', 'Clara', 'Fernández', 'clara.fernandez@gmail.com')"
    };

    public String[] courses = {
            "('C001', 'Matemáticas', 'T001')",
            "('C002', 'Física', 'T002')",
            "('C003', 'Química', 'T003')",
            "('C004', 'Historia', 'T004')",
            "('C005', 'Geografía', 'T005')",
            "('C006', 'Literatura', 'T006')",
            "('C007', 'Biología', 'T007')",
            "('C008', 'Educación Física', 'T008')",
            "('C009', 'Arte', 'T009')",
            "('C010', 'Música', 'T010')"
    };

    public String[] students = {
            "('S001', '87654321', 'Fernando', 'Sánchez', 'fernando.sanchez@gmail.com')",
            "('S002', '76543210', 'Gina', 'Vega', 'gina.vega@gmail.com')",
            "('S003', '65432109', 'Andrés', 'Alvarez', 'andres.alvarez@gmail.com')",
            "('S004', '54321098', 'Elena', 'González', 'elena.gonzalez@gmail.com')",
            "('S005', '43210987', 'Jorge', 'Cruz', 'jorge.cruz@gmail.com')",
            "('S006', '32109876', 'Natalia', 'Castillo', 'natalia.castillo@gmail.com')",
            "('S007', '21098765', 'Oscar', 'Pérez', 'oscar.perez@gmail.com')",
            "('S008', '10987654', 'Silvia', 'Díaz', 'silvia.diaz@gmail.com')",
            "('S009', '09876543', 'Pablo', 'Jiménez', 'pablo.jimenez@gmail.com')",
            "('S010', '98765432', 'Lina', 'Mora', 'lina.mora@gmail.com')"
    };

    public String[] records = {
            "('C001', 'S001')",
            "('C001', 'S002')",
            "('C002', 'S003')",
            "('C002', 'S004')",
            "('C003', 'S005')",
            "('C003', 'S006')",
            "('C004', 'S007')",
            "('C004', 'S008')",
            "('C005', 'S009')",
            "('C005', 'S010')"
    };

    public String[] universities = {
            "('Facultad de Ciencias', 2023, 'P001')",
            "('Facultad de Ingeniería', 2023, 'P002')",
            "('Facultad de Artes', 2023, 'P003')",
            "('Facultad de Medicina', 2023, 'P004')",
            "('Facultad de Derecho', 2023, 'P005')",
            "('Facultad de Educación', 2023, 'P006')",
            "('Facultad de Ciencias Sociales', 2023, 'P007')",
            "('Facultad de Economía', 2023, 'P008')",
            "('Facultad de Psicología', 2023, 'P009')",
            "('Facultad de Arquitectura', 2023, 'P010')"
    };

    public String[] registers = {
            "('P001', 'S001', '{\"C001\": \"Matemáticas\", \"C002\": \"Física\"}')",
            "('P001', 'S002', '{\"C003\": \"Química\"}')",
            "('P002', 'S003', '{\"C004\": \"Historia\", \"C005\": \"Geografía\"}')",
            "('P002', 'S004', '{\"C006\": \"Literatura\"}')",
            "('P003', 'S005', '{\"C007\": \"Biología\"}')",
            "('P003', 'S006', '{\"C008\": \"Educación Física\", \"C009\": \"Arte\"}')",
            "('P004', 'S007', '{\"C010\": \"Música\"}')",
            "('P004', 'S008', '{\"C001\": \"Matemáticas\"}')",
            "('P005', 'S009', '{\"C002\": \"Física\"}')",
            "('P005', 'S010', '{\"C003\": \"Química\"}')"
    };


}