document.getElementById("reservationForm").addEventListener("submit", function(event) {
    event.preventDefault(); 

    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    let roomType = document.getElementById("roomType").value;
    let checkIn = document.getElementById("checkIn").value;
    let checkOut = document.getElementById("checkOut").value;

    if (new Date(checkIn) >= new Date(checkOut)) {
        displayMessage("La fecha de Check-Out debe ser posterior a la de Check-In.", "error");
    } else {
        
        fetch('reservar.php', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                nombre: name,
                correo: email,
                tipo_habitacion: roomType,
                fecha_checkin: checkIn,
                fecha_checkout: checkOut
            })
        })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                displayMessage("¡Reservación exitosa! Te esperamos en Raffles Hotel.", "success");
                clearForm();
            } else {
                displayMessage("Error al realizar la reservación. Inténtalo de nuevo.", "error");
            }
        })
        .catch(error => {
            console.error('Error:', error);
            displayMessage("Error al realizar la reservación. Inténtalo de nuevo.", "error");
        });
    }
});

function displayMessage(message, type) {
    let messageDiv = document.getElementById("confirmationMessage");
    messageDiv.textContent = message;
    messageDiv.className = type;
}

function clearForm() {
    document.getElementById("reservationForm").reset();
}