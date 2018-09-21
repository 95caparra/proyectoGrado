function cerraSesion(opcion) {
    document.getElementById('formCerrarSesion').opcion.value = opcion;
    document.getElementById('formCerrarSesion').submit();
}

function defineOpcion(opcion) {
    document.getElementById('menu').opcion.value = opcion;
    document.getElementById('menu').submit();
}

function crearCotizacion(opcion) {
    var idSolicitud = document.getElementById('formSolicitudes').idDetalleActual.value;
    if(idSolicitud === ""){
        alert('Debe seleccionar una solicitud para cotizar');
    }else{
        document.getElementById('formSolicitudes').id.value = idSolicitud;
        document.getElementById('formSolicitudes').opcion.value = opcion;
        document.getElementById('formSolicitudes').submit();
    }
}

function insertarPedido(controlador, opcion) {
    var id = document.getElementById().idDetalleActual.value;
    alert(id);
        $.post(controlador, {
            opcion: opcion,
            id:id            
        }, function(responseText) {
            $('#inline3').html(responseText);
        });

        $(".fancybox").fancybox({
            padding: 0,
            openEffect: 'elastic',
            openSpeed: 150,
            closeEffect: 'elastic',
            closeSpeed: 150,
            helpers: {
                overlay: null
            }
        });
}


function buscar(controlador, opcion) {
    alert(controlador + opcion);
    $.post(controlador, {
        opcion: opcion,
        txtNombre: nombre
    }, function(responseText) {
        $('.contenedorIz').html(responseText);
    });
}

function traerLista(controlador, opcion) {
    $.post(controlador, {
        opcion: opcion
    }, function(responseText) {
        $('.contenedorLista').html(responseText);
    });
}


function insertar(controlador, opcion) {
    $.post(controlador, {
        opcion: opcion
    }, function(responseText) {
        $('#inline1').html(responseText);
    });

    $(".fancybox").fancybox({
        padding: 0,
        openEffect: 'elastic',
        openSpeed: 150,
        closeEffect: 'elastic',
        closeSpeed: 150,
        helpers: {
            overlay: null
        }
    });
}

function oculta() {
    //Función para ocultar el div que contiene la imagen Loading
    div = document.getElementsByClassName('contenedorDe');
    div.style.display = 'none';
}


function actualizar(controlador, opcion, formulario) {
    var id = document.getElementById(formulario).idDetalleActual.value;
    if (id === "") {
        alert("Debe seleccionar un elemento para actualizar");
    } else {
        $.post(controlador, {
            id: id,
            opcion: opcion
        }, function(responseText) {
            $('#inline2').html(responseText);
        });

        $(".fancybox").fancybox({
            padding: 0,
            openEffect: 'elastic',
            openSpeed: 150,
            closeEffect: 'elastic',
            closeSpeed: 150,
            helpers: {
                overlay: null
            }
        });
    }
}


function cargarDivision(controlador, opcion, division) {
    $.post(controlador, {
        opcion: opcion
    }, function(responseText) {
        $(division).html(responseText);
    });

    $('.fancybox').fancybox();
}

function eliminar(opcion, formulario) {
    var idActual = document.getElementById(formulario).idDetalleActual.value;
    if (idActual === "") {
        alert("Debe seleccionar un elemento para eliminar");
    } else if (confirm("¿Esta seguro de borrar al id " + idActual + "?")) {
        document.getElementById(formulario).opcion.value = opcion;
        document.getElementById(formulario).id.value = idActual;
        document.getElementById(formulario).submit();
    }
}

function cargaDetalle(controlador, id, opcion, formulario, objeto) {
    $.post(controlador, {
        id: id,
        opcion: opcion
    }, function(responseText) {
        $('#infoDerecho').html(responseText);
    });

    //modificar el estilo
    objeto.removeClass("elemento");
    objeto.addClass("elemento2");

    objeto.siblings("div.elemento2").removeClass("elemento2").addClass("elemento");

    //asignar el valor del id a un campo oculto 
    document.getElementById(formulario).idDetalleActual.value = id;
}

function responder(controlador, opcion) {
    var id = document.getElementById('formSolicitudes').idDetalleActual.value;
    if (id === "") {
        alert("Debe seleccionar un elemento para responder la solicitud");
    } else {
        $.post(controlador, {
            id: id,
            opcion: opcion
        }, function(responseText) {
            $('#inline2').html(responseText);
        });

        $(".fancybox").fancybox({
            padding: 0,
            openEffect: 'elastic',
            openSpeed: 150,
            closeEffect: 'elastic',
            closeSpeed: 150,
            helpers: {
                overlay: null
            }
        });
    }
}



function eliminarProveedor(opcion, formulario) {
    var idActual = document.getElementById(formulario).idDetalleActual.value;
    if (idActual === "") {
        alert("Debe seleccionar un proveedor para eliminar");
    } else if (confirm("Â¿Esta seguro de borrar este proveedor? ")) {
        document.getElementById(formulario).opcion.value = opcion;
        document.getElementById(formulario).id.value = idActual;
        document.getElementById(formulario).submit();
    }
}

function reporte(controlador, opcion) {
    $.post(controlador, {
        opcion: opcion
    }, function(responseText) {
        $('#inline2').html(responseText);
    });

    $(".fancybox").fancybox({
        padding: 0,
        openEffect: 'elastic',
        openSpeed: 150,
        closeEffect: 'elastic',
        closeSpeed: 150,
        helpers: {
            overlay: null
        }
    });
}


function traerLista(controlador, opcion) {
    $.post(controlador, {
        opcion: opcion
    }, function(responseText) {
        $('.contenedorLista').html(responseText);
    });
}





