function defineOpcion(opcion, form) {
    document.getElementById(form).opcion.value = opcion;
    document.getElementById(form).submit();
}

function defineOpcion(opcion){
    document.getElementById('menu').opcion.value = opcion;
    document.getElementById('menu').submit();
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

function validarNombre(){
      var nombre = document.getElementById("nombre").value;
      
}
function traerLista(controlador, opcion) {
    $.post(controlador, {
        opcion: opcion
    }, function(responseText) {
        $('#contenedorIzquierdo').html(responseText);
    });
}


function insertar(controlador, opcion) {
    $.post(controlador, {
        opcion: opcion
    }, function(responseText){
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

function insertarPedido(controlador, opcion) {
    var id = document.forms[1].idDetalleActual.value; 
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

function eliminar(opcion,formulario) {
    var idActual = document.getElementById(formulario).idDetalleActual.value ;
    if (idActual === "") {
        alert("Debe seleccionar un elemento para eliminar");
    } else if (confirm("¿Esta seguro de borrar al id " + idActual + "?")) {
        document.getElementById(formulario).opcion.value = opcion;
        document.getElementById(formulario).id.value = idActual;
        document.getElementById(formulario).submit();
    }
}

function cargaDetalle(controlador, id, opcion, formulario) {
    $.post(controlador, {
        id: id,
        opcion: opcion
    },function(responseText) {
        $('#infoDerecho').html(responseText);
    });

    //modificar el estilo
    
    //asignar el valor del id a un campo oculto 
    document.getElementById(formulario).idDetalleActual.value = id;
}

function responder(opcion) {
    var id = document.forms[1].idDetalleActual.value;
    document.forms[1].id.value = id;
    document.forms[1].opcion.value = opcion;
    document.forms[1].submit();
}



