
var cnn = {
    ajax: function(params) {

        var data = {
            'url': 'cotizacion',
            'type': 'POST',
            'data': (params.data) ? params.data : null,
            'success': params.success,
            'error': cnn.error,
            'beforeSend': cnn.beforeSend
        };
        $.ajax(data);

    },
    error: function(error) {
        console.error(error);
    },
    beforeSend: function() {
        console.log('Enviando Petición');
    }
};

var clientes = {
    cargarLista: function() {
        cnn.ajax({
            'data': {'opcion': 2},
            'success': clientes.onCargarLista
        });
    },
    onCargarLista: function(resultado) {
        var divClientes = $('#listaClientes').html('');

        $.each(resultado, function(i, item) {
            var radioButton = $('<input type="radio" name="cliente[]" value="' + item.numeroIdentificacion + '">' +
                    item.nombre + ' ' + item.apellido + '</input><hr>').appendTo(divClientes);
        });

    },
    agregarCliente: function() {
        var idCliente = $("input[name='cliente[]']:checked").val();
        if (typeof (idCliente) !== "undefined") {
            cnn.ajax({
                'data': {'opcion': 4, 'id': idCliente},
                'success': clientes.onCargarCliente
            });

        } else {
            new Messi('No ha seleccionado ningún cliente', {title: 'Mensaje', titleClass: 'info', buttons: [{id: 0, label: 'Aceptar', val: 'X'}]});
        }
    },
    onCargarCliente: function(resultado) {
        $('#txtNDoc').val(resultado.numeroIdentificacion);
        $('#txtTipoDoc').val(resultado.documentoVO.nombreDocumento);
        $('#txtNomCliente').val(resultado.nombre);
        $('#txtApeCliente').val(resultado.apellido);

        $.fancybox.close();
    }

};

var meseros = {
    precioMeseros: function() {
        var cantMeseros = parseFloat($('#txtCantMeseros').val());
        var precioHora = parseFloat($('#txtValorHora').val());


        if (isNaN(cantMeseros) || isNaN(precioHora)) {
            $('#lblTotalMeseros').text(0);
        } else {
            $('#lblTotalMeseros').text(parseInt(precioHora * cantMeseros));
            $('#lblPrecioTotal').text(parseInt($('#lblTotalCatalogos').text()) + parseInt($('#lblTotalMeseros').text()));
        }

    }
};

var catalogo = {
    cargarLista: function() {
        cnn.ajax({
            'data': {'opcion': 3},
            'success': catalogo.onCargarLista
        });
    },
    onCargarLista: function(resultado) {
        var divCatalogos = $('#listaCatalogos').html('');
        $.each(resultado, function(i, item) {
            var checkBox = $('<input type="checkbox" name="catalogo[]" value="' + item.idCatalogo + '">' +
                    item.nombre + '</input><hr>').appendTo(divCatalogos);
        });
    },
    agregarCatalogos: function() {
        var catalogosSeleccionados = $("input[name='catalogo[]']:checked");
        if (typeof (catalogosSeleccionados.val()) !== "undefined") {
            catalogosSeleccionados.each(function() {
                alert($(this).val());
                cnn.ajax({
                    'data': {'opcion': 5, 'id': $(this).val()},
                    'success': catalogo.onAgregar
                });
            });

            $.fancybox.close();
        } else {
            new Messi('No ha seleccionado ningún catálogo', {title: 'Mensaje', titleClass: 'info', buttons: [{id: 0, label: 'Aceptar', val: 'X'}]});
        }


    },
    onAgregar: function(info) {

        if (info !== null) {
            var tabla = $('#tablaCatalogos tbody');

            var fila = '<tr>'
                    + '<td>'
                    + '<input type="hidden" id="idCatalogo" value="' + info.idCatalogo + '" />'
                    + info.nombre
                    + '</td>'
                    + '<td>'
                    + info.tipoVO.nombre
                    + '</td>'
                    + '<td>'
                    + '<label id="precioCatalogo' + info.idCatalogo + '" >' + info.precioUnidad + ' </label>'
                    + '</td>'
                    + '<td>'
                    + '<input type="text" id="cantCatalogo' + info.idCatalogo + '" name="cantCatalogo" value="0" '
                    + ' onchange="totalCatalogos(' + info.idCatalogo + ')" />'
                    + '</td>'
                    + '<td>'
                    + '<label id="lblTotalCatalogo' + info.idCatalogo + '">0</label>'
                    + '</td>'
                    + '<td class = "opciones"> '
                    + '<input type="button" name="btnEliminar" value=" - "/>'
                    + '</td>'
                    + '</tr>';

            tabla.append(fila);
        }

    },
    eliminar: function(parent) {
        var precioCatalogo;
        var precioTotal = $('#lblPrecioTotal').text();
        var precioCatalogos = $('#lblTotalCatalogos').text();

        parent.children("td").each(function(index) {
            if (index === 4) {
                precioCatalogo = parseInt($(this).text());
            }
        });

        $('#lblTotalCatalogos').text(parseInt(precioCatalogos - precioCatalogo));
        $('#lblPrecioTotal').text(parseInt(precioTotal - precioCatalogo));

    }

};

function totalCatalogos(idCatalogo) {
    var cantidad = parseInt($('#cantCatalogo' + idCatalogo).val());
    var precio = parseInt($('#precioCatalogo' + idCatalogo).text());

    if (!isNaN(cantidad)) {
        $('#lblTotalCatalogo' + idCatalogo).text(cantidad * precio);
    } else {
        $('#lblTotalCatalogo' + idCatalogo).text('0');
    }

    var precioTotal = 0;

    var cuerpoTabla = $('#tablaCatalogos tbody tr');

    cuerpoTabla.each(function(index) {
        $(this).children("td").each(function(index2) {
            if (index2 === 4) {
                precioTotal += parseInt($(this).text());
            }
        });
    });

    if (!isNaN(precioTotal)) {
        $('#lblTotalCatalogos').text(parseInt(precioTotal));
        $('#lblPrecioTotal').text(parseInt($('#lblTotalCatalogos').text()) + parseInt($('#lblTotalMeseros').text()));
    } else {
        $('#lblTotalCatalogos').text(parseInt(0));
    }
}


function crearCotizacion() {
    var catalogos = [];
    
    var idCatalogo;
    var nomCatalogo;
    var cantidad;
    
    var cuerpoTabla = $('#tablaCatalogos tbody tr');

    cuerpoTabla.each(function(index) {
        $(this).children("td").each(function(index2) {
            if (index2 === 0) {
                idCatalogo = $(this).find('[type=hidden]').val();
                nomCatalogo = $(this).text();
            }else if(index2 === 3){
                cantidad = $(this).find('[type=text]').val();
            }
        });
        
        catalogos.push({'idCatalogo':idCatalogo,'nomCatalogo':nomCatalogo,'cantidad':cantidad});
    });
    
    
    cnn.ajax({
        'data': {'opcion': 1, 
            'idSolicitud': $('#hiddenIdSolicitud').val(),
            'numIdenCliente':$('#txtNDoc').val(),
            'tipoEvento':$('#txtTipoEvento').val(),
            'lugar':$('#txtLugar').val(),
            'cantPersonas':$('#txtCantPersonas').val(),
            'cantMeseros':$('#txtCantMeseros').val(),
            'horaInicio':$('#txtHoraInicio').val(),
            'horaFin':$('#txtHoraFin').val(),
            'fecha':$('#txtFecha').val(),
            'precio':$('#lblPrecioTotal').text(),
            'observaciones': $('#txtAreaObser').val(),
            'catalogos': JSON.stringify(catalogos)
        },
        'success': function(respuesta){
            document.getElementById('formCotizacion').submit();
        }
    });
}









