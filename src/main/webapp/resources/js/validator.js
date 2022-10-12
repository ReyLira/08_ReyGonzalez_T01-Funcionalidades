function validarDNIcliente() {
    var dnicliente = document.getElementById("DNICLI").value;
    if (dnicliente.length === 8) {
        PF('btnregistrarcli').enable();
//        alert("DNI COMPLETADO")
    } else {
        PF('btnregistrarcli').disable();
    }
}

function validarCelularCliente() {
    var celularcliente = document.getElementById("TELCLI").value;
    if (celularcliente.length === 9) {
        PF('btnregistrarcli').enable();
    } else {
        PF('btnregistrarcli').disable();
    }
}
