<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <title>BLUMMER</title>
        <link rel="icon" type="image/png" href="images/favicon.png" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="dxthemes.com">

        <!-- Add jQuery library -->
        <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>        
        <script language="javascript" src="js/jquery-ui-personalized-1.6rc6.min.js"></script>

        <!-- Le styles -->
        <link href="css/bootstrap.css" rel="stylesheet">    

        <!--estilos menu fotos-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <link rel="stylesheet" type="text/css" href="css/style_common.css" />
        <link rel="stylesheet" type="text/css" href="css/style9.css" />
        <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css' />

        <link  href="css/font-awesome.min.css" rel="stylesheet">
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <style>
            body {
                padding-top: 60px;
            }
            body,td,th {
                color: #333333;
            }
            #imagen{
                color: #333;
                display: block;
                padding: .3em;
                text-decoration: none;                
            }
            #lista1{
                border: solid #993399;
                width: 900px;
                height: 200px;
                overflow-y: scroll;
            }   
            #demo-frame{
                padding-top: 1cm;
            }
            #lista2{               
                overflow-y: scroll;
                width: 450px;
                height: 500px;
                float: left;
                margin: 15px 20px 0px 0px;
                background-color: #ffffff;
                border: 1px solid black;
                border-radius: 10px;
                -webkit-border-radius: 10px;
            }
            #lista1{
                width: 500px;
                height: 500px;
                float: right;
                margin: 15px 20px 0px 0px;
                background-color: #ffffff;
                border: 1px solid black;
                border-radius: 10px;
                -webkit-border-radius: 10px;               
                overflow-y: scroll;
            }
            #listaProductos{
                border: solid #993399;  
                margin-left: 500px;
                margin-top: -515px;
                width: 400px;
                height: 500px;                
                overflow-y: scroll;
            }
            #contenedor{
                margin: 0 auto;
                width: 1024px;
                min-height: 900px;
                background-color: #ffffff;
            }
            #total{
                padding-top: 1cm;
                font-size: 2em;
                font-variant-position: super;
                color: #993399;
                text-align: center;
                padding-top: 80px;
                font-family: Verdana;
            }
            #titulo{
                font-size: 2em;
                font-variant-position: super;
                color: #993399;
                text-align: center;
                padding-left: 15px;
                font-family: Verdana;
            }
            #subtitulo{
                font-size: 2em;
                font-variant-position: super;
                color: #993399;
                text-align: center;
                padding-left: 15px;
                padding-bottom: 30px;
                font-family: Verdana;
            }
            input{
                border: none;
            }

            button {
                border: none;
                background: #3a7999;
                color: #f2f2f2;
                padding: 10px;
                font-size: 18px;
                border-radius: 5px;
                position: relative;
                box-sizing: border-box;
                transition: all 500ms ease; 
            }

            button{ 
                padding: 10px 35px;  
                overflow:hidden;
            }

            button:before {
                font-family: FontAwesome;
                content:"\f07a";
                position: absolute;
                top: 11px;
                left: -30px;
                transition: all 200ms ease;
            }

            button:hover:before {
                left: 7px;
            }

        </style>

        <script type="text/javascript">
            $(document).ready(function() {
                var $myNewElement = $('<spam>Paquetes</spam>');
                $myNewElement.appendTo('#titulo');

                $('#lista1').hide();
                $('#lista2').hide();
                $('#boton').hide();
                $('#formulario').hide();

                var paquetes = $.ajax({
                    'url': 'controladorPaquetes',
                    'type': 'POST',
                    'data': {
                        'opcion': 10
                    },
                    dataType: 'json',
                    async: false
                }).responseText;

                paquetes = JSON.parse(paquetes);

                var divLista2 = $('#contenedorPaquetes').html('');

                var div1 = '<div class="container">';

                $.each(paquetes, function(i, item) {
                    div1 += '<div class="view view-ninth"><img src="archivos/imagenesProductos/' + item.foto + '" />'
                            + '<div class="mask mask-1"></div><div class="mask mask-2"></div><div class="content" onclick="cargarPaquete(' + item.idPaquete + ')" >'
                            + '<h2>' + item.nombre + '</h2><p>' + item.descripcion + '</p>'
                            + '</div></div>';
                });

                div1 += '</div>';

                divLista2.append(div1);
            });
        </script>

        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
        
        <!--<script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>-->
        <script>
            $(function() {
                //Array para dar formato en espaÃ±ol
                $.datepicker.regional['es'] =
                        {
                            closeText: 'Cerrar',
                            prevText: 'Previo',
                            nextText: 'PrÃ³ximo',
                            monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
                                'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
                            monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
                                'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
                            monthStatus: 'Ver otro mes', yearStatus: 'Ver otro aÃ±o',
                            dayNames: ['Domingo', 'Lunes', 'Martes', 'MiÃ©rcoles', 'Jueves', 'Viernes', 'SÃ¡bado'],
                            dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'SÃ¡b'],
                            dayNamesMin: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sa'],
                            dateFormat: 'dd/mm/yy', firstDay: 0,
                            initStatus: 'Selecciona la fecha', isRTL: false};
                $.datepicker.setDefaults($.datepicker.regional['es']);

                //miDate: fecha de comienzo D=dÃ­as | M=mes | Y=aÃ±o
                //maxDate: fecha tope D=dÃ­as | M=mes | Y=aÃ±o

                $("#txtFechaEvento").datepicker({minDate: "1D", maxDate: "+12M +10D"});

            });
        </script>

    </head>

    <body>

        <div id="titulo"></div>

        <div class="main" id="contenedorPaquetes" style="margin-left: 80px"> 
        </div>

        <div id="contenedor">
            <div id="lista1">  
            </div>
            <div id="lista2">
                <a id="total">Precio: <span id="totalprice" style="color: red;"></span></a>                                                     
            </div>   

            <button id="boton">Comprar</button>

            <div id="formulario">
                <h2 id="titulo">Comprar Evento</h2>
                <table>
                    <tr>
                        <td><b>Nombre:</b></td>
                        <td><input type="text" name="txtNombre" id="txtNombre"></td>
                    </tr>
                    <tr>
                        <td><b>Correo:</b></td>
                        <td><input type="text" name="txtCorreo" id="txtCorreo" ></td>
                    </tr>
                    <tr>
                        <td><b>Telefono:</b></td>
                        <td><input type="number" name="txtTelefono" id="txtTelefono"></td>
                    </tr>
                    <tr>
                        <td><b>Fecha Evento:</b></td>
                        <td><input type="date" name="txtFechaEvento" id="txtFechaEvento"></td>
                    </tr>
                </table>
            </div>
        </div>
    </body>

    <script type="text/javascript">
        $('#boton').on('click', function() {
            $('#lista1').hide();
            $('#lista2').hide();
            $('#titulo').hide();
            $('#formulario').show('slow');
            var $data = $('#lista2').find('.img');
            var productos = [];
            var cont = 0;
            var ids = 0;
            var cantidades = [];
            $.each($data, function(i, $d) {
                ids = parseInt($($d).find('.idProducto').val());
                productos[cont] = ids;
                cantidades[cont] = parseInt($($d).find('.cantidadP').val());
                cont++;
            });

            var texto = $("#txtNombre").val();

            if (texto === "") {
            } else {
                $.post('controladorEventos', {
                    opcion: 4,
                    txtNombre: $('#txtNombre').val(),
                    txtCorreo: $('#txtCorreo').val(),
                    txtTelefono: $('#txtTelefono').val(),
                    txtFechaEvento: $('#txtFechaEvento').val(),
                    productos:productos,
                    cantidades:cantidades
                }, function(responseText) {
                    
                });
            }
        });

        function realizarPeticion(datos, url) {
            con.ajax({
                'url': url,
                'data': (datos) ? datos : null,
                'success': function(respuesta) {
                }
            });
        }

        function cargarPaquete(idPaquete) {
            $('#titulo').html('');
            $('#contenedorPaquetes').hide();
            $('#lista2').show('slow');
            $('#lista1').show('slow');
            $('#boton').show('slow');
            var paquetes = $.ajax({
                'url': 'controladorPaquetes',
                'type': 'POST',
                'data': {
                    'opcion': 11,
                    'id': idPaquete
                },
                dataType: 'json',
                async: false
            }).responseText;

            var objetoPaquetes = JSON.parse(paquetes);

            var bandera = 0;

            $.each(objetoPaquetes, function(i, item) {
                if (bandera === 0) {
                    for (i = 0; i < 1; i++) {
                        ponerNombre(item.paqueteVO.nombre);
                        bandera = 1;
                    }
                }
            });

            function ponerNombre(nombre) {
                var $myNewElement = $('<spam> Paquete: ' + nombre + '</spam><img style="cursor:pointer" src="img/volver.png" onclick="volverPaquete();">');
                $myNewElement.appendTo('#titulo');
            }

            var listaProductos = $('#lista2').html('<a id="total">Precio:<span id="totalprice" style="color: red;"></span></a>');

            var div1 = '<table id="productos">';

            $.each(objetoPaquetes, function(i, item) {

                div1 += '<tr id="imagen" class="img" style="cursor:pointer"><td><img src="archivos/imagenesProductos/' + item.productoVO.foto + '" width="200" height="200" /></td>';
                div1 += '<td>cantidad:<input style="width:30px" type="number" class="cantidadP" id="cantidadP" name="cantidad" min="1" size="1" value="' + item.cantidad + '" ></td>';
                div1 += '<td class="valor">Precio: $' + item.productoVO.precioUnidad + '</td>';
                div1 += '<td><input type="hidden" class="idProducto" value="' + item.productoVO.idProducto + '" ></td></tr>';

            });

            div1 += '</table>';
            listaProductos.append(div1);

            cargarProductos();
            cargarCategorias();
        }
        function cargarCategorias() {
            var categorias = $.ajax({
                'url': 'controladorCategoria',
                'type': 'POST',
                'data': {
                    'opcion': 10
                },
                dataType: 'json',
                async: false
            }).responseText;

            var objetoCategorias = JSON.parse(categorias);

            var divLista3 = $('#lista1').html('<span id="subtitulo">Categorias:</span>');

            $.each(objetoCategorias, function(i, item) {
                var div2 = '<div class="container"><div class="view view-ninth">'
                        + '<img src="archivos/imagenesProductos/' + item.foto + '" />'
                        + '<div class="mask mask-1"></div><div class="mask mask-2">'
                        + '</div><div class="content" onclick="cargaProductoSegun(' + item.idCategoria + ')" >'
                        + '<h2>' + item.nombre + '</h2></div></div></div>';
                divLista3.append(div2);
            });
        }

        function cargaProductoSegun(idCategoria) {
            $('.container').hide();
            var productosCategorias = $.ajax({
                'url': 'controladorProductos',
                'type': 'POST',
                'data': {
                    'opcion': 13,
                    'tipo': idCategoria
                },
                dataType: 'json',
                async: false
            }).responseText;

            var objetoProductosCategorias = JSON.parse(productosCategorias);

            var listaProductos2 = $('#lista1').html('<span id="subtitulo">Productos</span><img style="cursor:pointer" src="img/volver.png" onclick="volverCategoria();">');

            var div3 = '<table id="productos2">';

            $.each(objetoProductosCategorias, function(i, item) {

                div3 += '<tr id="imagen" class="img" style="cursor:pointer" ><td><img src="archivos/imagenesProductos/' + item.foto + '" width="200" height="200" /></td>';
                div3 += '<td style="background-color:rgb(236, 248, 224);">cantidad:<input style="width:30px" type="number" class="cantidadP" id="cantidadP" name="cantidad" min="1" size="1" value="1" ></td>';
                div3 += '<td style="background-color:rgb(236, 248, 224);" class="valor">Precio: $' + item.precioUnidad + '</td>';
                div3 += '<td style="background-color:rgb(236, 248, 224);"><input type="hidden" class="idProducto" value="' + item.idProducto + '" ></td></tr>';

            });

            div3 += '</table>';
            listaProductos2.append(div3);
            $('#productos2').show('slow');
            cargarProductos();

        }

        function volverCategoria() {
            cargarCategorias();
        }

        function volverPaquete() {
            window.location.reload();
        }

        function cargarProductos() {
            var utiles = {
                formatValue: function(num, prefix)
                {
                    var splitStr = num.toString().split('.');
                    return (prefix || '') + splitStr[0].toString().split('').reverse().join('').replace(/(?=\d*\.?)(\d{3})/g, '$1.').split('').reverse().join('').replace(/^[\.]/, '') + ((splitStr.length > 1) ? ',' + splitStr[1] : '');
                },
                unformatNum: function(num) {
                    var splitStr = num.split(',');
                    return ((splitStr[0].toString().replace(/\./g, '')) + ((splitStr.length > 1) ? '.' + splitStr[1] : '')) * 1;
                },
            };

//Calculamos el precio de los items agregados a la lista2.
            function calcularPrecios() {
                var pricefinal = 0;
                var cantidades = [];
                var precios = [];
                var cantidad = 0;
                var precio = 0;
                var subtotal = 0;
                var cont = 0;
                var cont1 = 0;
                var str;
                $("#productos tbody tr").each(function(index)
                {
                    var campo1, campo2, campo3;
                    $(this).children("td").each(function(index2)
                    {
                        switch (index2)
                        {
                            case 0:
                                /*campo1 = $(this).text();
                                 if (campo1 !== "") {
                                 cant = /cantidad/;
                                 pre = /Precio/;
                                 
                                 if (cant.test(campo1)) {
                                 cantidades [cont] = $(this).find('.cantidadP').val();
                                 cont++;
                                 } else if (pre.test(campo1)) {
                                 str = campo1.replace("Precio:", "");
                                 precios [cont1] = parseInt(str.replace("$", ""));
                                 cont1++;
                                 }
                                 }*/
                                break;

                            case 1:
                                cantidades [cont] = $(this).find('.cantidadP').val();
                                cont++;
                                break;

                            case 2:
                                campo2 = $(this).text();
                                str = campo2.replace("Precio:", "");
                                precios [cont1] = parseInt(str.replace("$", ""));
                                cont1++;
                                break;
                        }
                        $(this).css("background-color", "#ECF8E0");
                    });
                });

                for (var i = 0; i < cont; i++) {
                    cantidad = parseInt(cantidades[i]);
                    precio = parseInt(precios[i]);
                    subtotal += cantidad * precio;
                }
                pricefinal = subtotal;
                $('#totalprice').html(utiles.formatValue(pricefinal, '$'));

                $('.cantidadP').bind('click keyup', function() {
                    recalcularPrecios();
                });

            }

            function recalcularPrecios() {
                var pricefinal = 0;
                var cantidades = [];
                var precios = [];
                var cantidad = 0;
                var precio = 0;
                var subtotal = 0;
                var cont = 0;
                var cont1 = 0;
                var str;
                $("#productos tbody tr").each(function(index)
                {
                    var campo1, campo2, campo3;
                    $(this).children("td").each(function(index2)
                    {
                        switch (index2)
                        {
                            case 0:
                                /*campo1 = $(this).text();
                                 if (campo1 !== "") {
                                 cant = /cantidad/;
                                 pre = /Precio/;
                                 
                                 if (cant.test(campo1)) {
                                 cantidades [cont] = $(this).find('.cantidadP').val();
                                 cont++;
                                 } else if (pre.test(campo1)) {
                                 str = campo1.replace("Precio:", "");
                                 precios [cont1] = parseInt(str.replace("$", ""));
                                 cont1++;
                                 }
                                 }*/
                                break;

                            case 1:
                                cantidades [cont] = $(this).find('.cantidadP').val();
                                cont++;
                                break;

                            case 2:
                                campo2 = $(this).text();
                                str = campo2.replace("Precio:", "");
                                precios [cont1] = parseInt(str.replace("$", ""));
                                cont1++;
                                break;
                        }

                        $(this).css("background-color", "#ECF8E0");

                    });

                });

                for (var i = 0; i < cont; i++) {
                    cantidad = parseInt(cantidades[i]);
                    precio = parseInt(precios[i]);
                    subtotal += cantidad * precio;
                }

                pricefinal = subtotal;
                $('#totalprice').html(utiles.formatValue(pricefinal, '$'));

                $('.cantidadP').bind('click keyup', function() {
                    recalcularPrecios();
                });

            }

            var $lista1 = $('#lista1'), $lista2 = $('#lista2');
            // lista 1
            $('#imagen', $lista1).draggable({
                revert: 'invalid',
                helper: 'clone',
                cursor: 'move'
            });

            $('#imagen', $lista2).draggable({
                revert: 'invalid',
                helper: 'clone',
                cursor: 'move'
            });

            /*$lista1.droppable({
                accept: '#lista2 #imagen',
                drop: function(ev, ui) {
                    deleteLista2(ui.draggable);
                }
            });*/

            $lista2.droppable({
                accept: '#lista1 #imagen',
                drop: function(ev, ui) {
                    deleteLista1(ui.draggable);
                }
            });

            function deleteLista1($item) {
                var tabla = $('#productos tbody');
                $item.fadeOut(function() {
                    $($item).appendTo(tabla).fadeIn();
                    calcularPrecios();
                });
                $item.fadeIn();
                //CALCULAMOS EL PRECIO TOTAL.		
            }

            function deleteLista2($item) {
                var tabla2 = $('#productos2 tbody');
                $item.fadeOut(function() {
                    $item.appendTo(tabla2).fadeIn();
                    calcularPrecios();
                });
            }
            //Llamamos la función al cargar el DOM, pues debemos asegurar mostrar el precio si existen items agregados.
            calcularPrecios();
        }//cierra cargar productos    
    </script>
</html>