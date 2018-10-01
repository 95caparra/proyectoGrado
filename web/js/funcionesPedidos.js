var cnn = {
    ajax: function(params) {

        var data = {
            'url': 'controladorPedidos',
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

var proveedores = {
     cargarLista: function() {
        cnn.ajax({
            'data': {'opcion': 3},
            'success': proveedores.onCargarLista
        });
    },
    
    onCargarLista: function(resultado) {
        var divProveedores = $('#listaProveedores').html('');
        $.each(resultado, function(i, item) {
            var checkBox = $('<input type="checkbox" name="proveedor[]" value="' + item.id_proveedor + '">' +
                    item.razon_social + '</input><hr>').appendTo(divProveedores);
        });
    }
};

var pedido = {
    guardar: function (){
        var productos = [];
        var cuerpoTabla = $('#tablaProductos tbody tr');
        var nombreProducto;
        var cantProducto;
        
        cuerpoTabla.each(function(index) {
            $(this).children("td").each(function(index2) {
                if (index2 === 0) {
                    nombreProducto = $(this).text();
                }else if(index2 === 1){
                    cantProducto = $(this).find('[type=text]').val();
                }
            });
            
            productos.push({'nomProducto':nombreProducto,'cantProducto':cantProducto});
        });
        
        console.log(JSON.stringify(productos));
        cnn.ajax({
            'data':{
                'opcion':3,
                'idProveedor': $('#selectProveedores').val(),
                'productos': JSON.stringify(productos),
                'observaciones':$('#txtObservaciones').val()
            },
            'success':function (){
                alert('No se si se envio');
                $.fancybox.close();
            }
        });
    }
};

var productos = {
    listaProductos: function(){
        cnn.ajax({
            'data':{
                'opcion': 1,
                'success': productos.listarProducto
            }
        });
    },
    
    listarProducto: function(){
        
    }
};



