<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="../../js/funciones.js"></script>

        <!-- Add jQuery library -->
        <script type="text/javascript" src="../../js/jquery-1.7.2.min.js"></script>
        <!--libreria para arrastrar-->
        <script language="javascript" src="../../js/jquery-ui-personalized-1.6rc6.min.js"></script>


        <link rel="stylesheet" href="../../css/estilosForm.css"/>
        <title>Insertar Paquete</title>
        <style type="text/css">
            h1{
                color: #993399;
            }
            #lista2, #lista1{
                border: solid #993399;
                width: 900px;
                height: 100px;
                overflow-y: scroll;
            }
            #contenedor{
                width: 700px ;
                height: 600px; 
                border: solid 1px;
                margin-left: 380px;
            }
            textarea{
                margin-top: 30px;
                width: 200px;
                height: 50px;
                border: solid black;
            }
            #contenido{
                width: 940px;
                height: 230px;
                overflow: auto;
            }
            #button {
                margin: 0 auto;
            }
            #button li {
                display: inline;
            }
            #imagenes{
                display: inline;
            }
            #button li a {
                font-family: Arial;
                font-size:11px;
                text-decoration: none;
                float:left;
                padding: 10px;
                background-color: #993399;
                color: #fff;
            }
            #button li a:hover{
                background-color: #cccccc;
                margin-top:-2px;
                padding-bottom:12px;
                cursor: pointer;
            }
        </style>

    </head>
    <body>


        <div id="contenedor">
            <center>
                <h1>Insertar Paquete</h1>

                <ul id="button">
                    <li><a onclick="cargaCategoria('controladorProductos', 1, 13)" class="selected">Alimentos</a></li>
                    <li><a onclick="cargaCategoria('controladorProductos', 2, 13)">Bebidas</a></li>
                </ul>

                <div id="demo-frame">
                    <ul id="lista1" class="gallery">
                    </ul>
                    <ul id="lista2">
                        <a id="total">Total: <span id="totalprice" style="color: red;"></span></a>                            
                    </ul>
                </div>

                <form method="POST" action="controladorCargaArchivo" enctype="multipart/form-data" id="formularioPaquete" novalidate autocomplete="off" class="idealforms" onsubmit="guardarPaquete();"  >
                    <table>
                        <tr>
                            <td>
                                Nombre:
                            </td>
                            <td>
                                <input type="text" name="nombre" id="txtNombre" class="estiloForm"/>   
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Descripcion:
                            </td>
                            <td>
                                <input type="text" name="descripcion" id="txtDescripcion" class="estiloForm"/>
                            </td>
                        </tr>               


                        <tr>
                            <td>Foto:</td>
                            <td>
                                <input type="file" name="foto" multiple id="txtFoto" class="estiloForm"/>
                            </td>
                        </tr>
                        <tr>  
                            <td colspan="2">
                                <div id="gif"></div>
                                <input type="submit" value="Guardar" class="btnActionForm"/>
                            <td>    
                        </tr>
                    </table>
                </form>
            </center>

        </div>
        <script type="text/javascript">
            function retrasarEvento() {
                var timer = nioos.timer;
                clearTimeout(timer);
                timer = setTimeout(guardarPaquete, 3000);
                nioos.timer = timer;
            }
            function guardarPaquete() {
                 $.ajax({
                    url: 'controladorCargaArchivo',
                    type: 'POST',
                    success: function(respuesta) {
                    }
                });
                
                
                
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

                console.log(productos);


                $.ajax({
                    url: 'controladorPaquetes',
                    type: 'POST',
                    data: {
                        'opcion': 3,
                        'productos': productos,
                        'cantidades': cantidades
                    },
                    success: function(respuesta) {
                        if (respuesta === false) {
                            // realizarPeticion(datos, 'controladorClientes');
                        } else {
                            // alert(respuesta);
                            //new Messi(respuesta, {title: 'Mensaje', titleClass: 'info', buttons: [{id: 0, label: 'Aceptar', val: 'X'}]});
                        }
                    }
                });
                //}
            }
            function cargaCategoria(controlador, tipo, opcion) {
                $.post(controlador, {
                    tipo: tipo,
                    opcion: opcion
                }, function(respuesta) {
                    cargaLista(respuesta);
                });
            }

            function cargaLista(respuesta) {
                var divLista = $('#lista1').html('');


                $.each(respuesta, function(i, item) {
                    var div = '<a id="imagen" class="img" ><img src="archivos/imagenesProductos/' + item.foto + '"  width="80" height="80" / ><input style="width:30px" type="number" class="cantidadP" id="cantidadP" name="cantidad" min="1" size="1" value="1" ><input style="border:none" type="text" class="valor" value="' + item.precioUnidad + '" size="4"><input type="hidden" class="idProducto" value="' + item.idProducto + '" ></a>';
                    divLista.append(div);
                });

                cargarProductos();

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
                    var $data = $('#lista2').find('.img');
                    var pricefinal = 0;
                    var pricefinal2 = 0;
                    var precioTotal = 0;
                    var precio = 0;
                    var cantidad = 0;
                    $.each($data, function(i, $d) {
                        cantidad = parseInt($($d).find('.cantidadP').val());
                        precio = parseInt($($d).find('.valor').val());

                        pricefinal += precio * cantidad;

                        $('.cantidadP').bind('click keyup', function() {
                            recalcularPrecios();
                        });
                    });
                    $('#totalprice').html(utiles.formatValue(pricefinal, '$'));
                }

                //Calculamos el precio de los items agregados a la lista2.
                function recalcularPrecios() {
                    var $data = $('#lista2').find('.img');
                    var pricefinal = 0;
                    var precio = 0;
                    var cantidad = 0;
                    $.each($data, function(i, $d) {
                        cantidad = parseInt($($d).find('.cantidadP').val());
                        precio = parseInt($($d).find('.valor').val());
                        pricefinal += precio * cantidad;

                    });
                    $('#totalprice').html(utiles.formatValue(pricefinal, '$'));
                }

                var $lista1 = $('#lista1'), $lista2 = $('#lista2');
                // lista 1
                $('#imagen', $lista1).draggable({
                    revert: 'invalid',
                    helper: 'clone',
                    cursor: 'move'
                });
                $lista1.droppable({
                    accept: '#lista2 #imagen',
                    drop: function(ev, ui) {
                        deleteLista2(ui.draggable);
                    }
                });
                /* lista2 */
                $('#imagen', $lista2).draggable({
                    revert: 'invalid',
                    helper: 'clone',
                    cursor: 'move'
                });

                $lista2.droppable({
                    accept: '#lista1 > #imagen',
                    drop: function(ev, ui) {
                        deleteLista1(ui.draggable);
                    }
                });

                // listas	
                function deleteLista1($item) {
                    $item.fadeOut(function() {
                        $($item).appendTo($lista2).fadeIn();
                        ;
                        calcularPrecios();
                    });
                    $item.fadeIn();
                    //CALCULAMOS EL PRECIO TOTAL.		
                }

                function deleteLista2($item) {
                    $item.fadeOut(function() {
                        $item.appendTo($lista1).fadeIn();
                        //En esta parte podriamos aprovechar este callback para obtener el elemento $item 
                        //y buscar su valor, de esta manera: 
                        //$($item).find('.valor').val();
                        //de esta forma ir sumando o restando el valor según sea el caso a una variable global, PERO EN ESTE CASO;
                        //para no desaprovechar la función que he creado para conocer los precios de los productos cargados inicialmente, simplemente la llamaré en cada caso.
                        //así logramos calcular el precio sin tener nada más en cuenta.
                        //
                        //CALCULAMOS EL PRECIO TOTAL
                        calcularPrecios();
                    });
                }

                //Llamamos la función al cargar el DOM, pues debemos asegurar mostrar el precio si existen items agregados.
                calcularPrecios();

            }

            /*(function() {
             
             
             $('#btnEnviar').on('click', function() {
             var vali;
             var bandera;
             if ($('input[name=idPaquete]').is(':checked')) {
             vali = false;
             } else {
             alert("El paquete no está seleccionado");
             vali = true;
             }
             
             if ($('#mensaje').val() === '') {
             bandera = true;
             alert("Por favor digite algo en el campo");
             } else {
             bandera = false;
             }
             
             if (vali === false && bandera === false) {
             jQuery.fn.getCheckboxValues = function() {
             var values = [];
             var i = 0;
             this.each(function() {
             // guarda los valores en un array
             values[i++] = $(this).val();
             });
             // devuelve un array con los checkboxes seleccionados 
             return values;
             };
             var paquetes = $("input:checked").getCheckboxValues();
             var datos = {
             'opcion': 6,
             'idPaquete': paquetes,
             'idSolicitud': $('#idSolicitud').val(),
             'mail': $('#mail').val(),
             'mensaje': $('#mensaje').val()
             };
             
             $('#gif').html('<img src="images/ajax-loader.gif"/>');
             realizarPeticion(datos, 'controladorSolicitudes');
             }
             });
             }
             )();*/
        </script>
    </body>
</html>