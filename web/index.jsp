<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8" >
        <title>BLUMMER</title>
        
        <link rel="icon" type="image/png" href="images/favicon.png" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="dxthemes.com">

        <!-- Add jQuery library -->
        <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>

        <!--librerias mensajes-->
        <link rel="stylesheet" href="css/messi.min.css" />
        <script src="js/messi.min.js"></script>

        <!-- Le styles -->
        <link href="css/bootstrap.css" rel="stylesheet">    
        <link href="css/styles.css" rel="stylesheet">

        <!--estilos menu fotos-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <link rel="stylesheet" type="text/css" href="css/style_common.css" />
        <link rel="stylesheet" type="text/css" href="css/style9.css" />
        <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css' />
        <!--estilos galerias-->
        <link rel='stylesheet' id='prettyphoto-css'  href="css/prettyPhoto.css" type='text/css' media='all'>
        <meta name="keywords" content="css3, lightbox, overlay, effect, images, thumbnails" />

        <!-- Les Google Fonts -->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300,700' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Oswald:400,300,700' rel='stylesheet' type='text/css'>
        <style>
            body {
                padding-top: 60px;
            }
        </style>
        <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

        <!-- JQuery -->
        <script type="text/javascript" src="js/jquery.js"></script>


        <!-- prettyPhoto Initialization -->
        <script type="text/javascript" charset="utf-8">
            $(document).ready(function() {
                $("a[rel^='prettyPhoto']").prettyPhoto();
            });

            // Please don't use this code on your site, use your own GA code
            var _gaq = _gaq || [];
            _gaq.push(['_setAccount', 'UA-7243260-2']);
            _gaq.push(['_trackPageview']);

            (function() {
                var ga = document.createElement('script');
                ga.type = 'text/javascript';
                ga.async = true;
                ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
                var s = document.getElementsByTagName('script')[0];
                s.parentNode.insertBefore(ga, s);
            })();
        </script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
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

                $("#fechaEvento").datepicker({minDate: "1D", maxDate: "+12M +10D"});

            });
        </script>

    </head>

    <body>
        <%  if (session.getAttribute("mensaje") != null) {%>            
        <script type=text/javascript>new Messi('<%=session.getAttribute("mensaje")%>', {title: 'Mensaje', titleClass: 'info', buttons: [{id: 0, label: 'Aceptar', val: 'X'}]});</script>
        <%
                session.setAttribute("mensaje", null);
            } //Ciero el if
%>
        <!-- Navigation Bar -->
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <!--<a class="logo" href="#">RESTAURANT</a>-->
                    <div class="social-container">

                        <a class="s-icon" id="login" href="login.jsp">Login</a>
                        <a class="s-icon-instagram" href="#"><img src="img/instagram.png"></a>
                        <a class="s-icon-twitter" href="#"><img src="img/twitter.png"></a>
                        <a class="s-icon-facebook" href="#"><img src="img/facebook.png"></a>         
                    </div>
                    <div class="nav-collapse pull-left collapse">
                        <ul class="nav">
                            <li><a href="#">Inicio</a></li>
                            <li><a href="#quienessomos">Quienes Somos</a></li>
                            <li><a href="#menus">Servicios</a></li>
                            <li><a href="crearEvento.jsp">Crea tu Evento</a></li>
                            <li><a href="#contact">Contactenos</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>

        <!-- Header Image and Logo -->
        <div id="headerwrap">
            <header class="clearfix">
                <div class="container">
                    <img src="img/logoBlummer.png">
                    <div id="titulo">
                        <hgroup>
                            <h1>BLUMMER</h1>
                            <h2>Comercializadora de Alimentos</h2>
                        </hgroup>
                    </div>
                </div>
            </header>
        </div>

        <!-- Welcome -->
        <div id="quienessomos">
            <header class="clearfix">
                <div class="container">
                    <div class="span12">
                        <h2 id="bienvenida">Sean Bienvenidos a nuestro  sitio  web, un lugar  ideal en el cual encontrarÃ¡s las mejores opciones para realizar  tus eventos. </h2>
                    </div>
                </div>
            </header>
        </div>

        <!-- Section Services Begins -->
        <section id="services"><br><br></section>

        <div id="servicewrap">
            <div class="container">
                <div class="row">


                    <div class="span3">
                        <div class="mask">
                            <img src="images/mision.png" alt="">
                            <h4>MISIÃ“N</h4>
                            <p>Nuestra misiÃ³n, ofrecer a nuestros clientes, el mÃ¡s selecto servicio y asesorÃ­a integral, en el manejo y organizaciÃ³n de eventos familiares, sociales y empresariales, nuestro profesionalismo e idoneidad, nos permite asegurar el Ã©xito de nuestros eventos, de esta manera lograr, la confianza y preferencia de nuestros clientes.</p>

                        </div>
                    </div><!-- span3 -->

                    <div class="span3">
                        <div class="mask">
                            <img src="images/vision.png" alt="">
                            <h4>VISIÃ“N</h4>
                            <p>Ser lÃ­deres en el mercado de recepciÃ³n de eventos a nivel regional y nacional, aplicando permanentemente el mejoramiento de nuestros procesos, de calidad y servicio, para satisfacer a nuestros clientes. El futuro de nuestra empresa, estÃ¡ comprometido en sustentar nuestro Ã©xito en la atenciÃ³n, asesorÃ­a y organizaciÃ³n, de eventos, competir con excelentes estrategias. Mantener nuestro respeto integral por la satisfacciÃ³n de nuestros clientes y seguir comprometidos con el desarrollo de nuestra regiÃ³n.</p>

                        </div>
                    </div><!-- span3 -->


                </div><!-- row -->
            </div><!-- container -->
        </div><!-- servicewrap -->


        <!-- Single Item Image -->
        <div id="example">
            <div class="container">
                <br>
                <h2>GalerÃ­a</h2>

                <div class="row">
                    <div class="span12">
                        <div id="myCarousel" class="carousel slide" style="width: 850px ; height: 900px; margin-left: 150px;">
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img src="img/portada.png" alt="">
                                </div>
                                <div class="item">
                                    <img src="imagenes/f2.png" alt="">
                                </div>
                                <div class="item">
                                    <img src="imagenes/f3.png" alt="">
                                </div>
                            </div>
                            <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a><!-- Carousel Control -->
                            <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
                        </div><!-- myCarousel -->
                    </div>

                </div><!-- End row -->
                <br>
            </div><!-- container -->
        </div><!-- example -->
        <br>
        <br>





        <!-- Menu  -->
        <section id="menus"></section>

        <div id="menuwrap" style="margin-left: 100px;">
            <header class="clearfix">
                <div class="container">
                    <div class="span12">
                        <div class="boxcolor">
                            <h1>SERVICIOS</h1>
                        </div>
                    </div><!-- span12 -->
                </div><!-- container -->
            </header>
        </div>


        <!-- Menus Fotos -->

        <div class="container">

            <div class="main" style="margin-left: 80px">
                <!-- NINTH EXAMPLE -->
                <div class="view view-ninth">
                    <img src="imagenes/f1.png" />
                    <div class="mask mask-1"></div>
                    <div class="mask mask-2"></div>
                    <div class="content">
                        <h2>Reuniones</h2>
                        <p>Estos son unos de los servicios mas solicitados de nuestra clientela</p>

                    </div>
                </div>
                <div class="view view-ninth">
                    <img src="imagenes/f2.png" />
                    <div class="mask mask-1"></div>
                    <div class="mask mask-2"></div>
                    <div class="content">
                        <h2>Reuniones</h2>
                        <p>Estos son unos de los servicios mas solicitados de nuestra clientela</p>

                    </div>
                </div>
                <div class="view view-ninth">
                    <img src="imagenes/f3.png" />
                    <div class="mask mask-1"></div>
                    <div class="mask mask-2"></div>
                    <div class="content">
                        <h2>Reuniones</h2>
                        <p>Estos son unos de los servicios mas solicitados de nuestra clientela</p>

                    </div>
                </div>

                <div class="view view-ninth">
                    <img src="imagenes/f4.png" />
                    <div class="mask mask-1"></div>
                    <div class="mask mask-2"></div>
                    <div class="content">
                        <h2>Reuniones</h2>
                        <p>Estos son unos de los servicios mas solicitados de nuestra clientela</p>

                    </div>
                </div>

                <div class="view view-ninth">
                    <img src="imagenes/f5.png" />
                    <div class="mask mask-1"></div>
                    <div class="mask mask-2"></div>
                    <div class="content">
                        <h2>Reuniones</h2>
                        <p>Estos son unos de los servicios mas solicitados de nuestra clientela</p>

                    </div>
                </div>

                <div class="view view-ninth">
                    <img src="imagenes/f6.png" />
                    <div class="mask mask-1"></div>
                    <div class="mask mask-2"></div>
                    <div class="content">
                        <h2>Reuniones</h2>
                        <p>Estos son unos de los servicios mas solicitados de nuestra clientela</p>

                    </div>
                </div>
            </div>
        </div>
        <!-- Menus Fotos -->		


        <!-- Contact Section Begins -->
        <section id="contact"><br><br></section>

        <div id="footerwrap">
            <div class="container">
                <br>
                <h2>COTIZACIÃ“N</h2>
                <div class="span8">
                    <form method="POST" action="controladorSolicitudes" onsubmit= "return esperar()">

                        <input type="hidden" value="3" name="opcion"/>
                        <fieldset>
                            <div class="control-group">
                                <div class="controls">
                                    <input class="span12" type="text" placeholder="Nombre cliente" name="nombre" id="txtNombre" required>
                                </div>
                                <div class="controls">
                                    <input class="span12" type="email" placeholder="Correo ElÃ©ctronico" id="txtCorreo" name="correo" pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$"  required>
                                </div>
                                <div class="controls">
                                    <input class="span12" type="text" placeholder="TelÃ©fono" name="telefono" pattern="[0-9]{7,10}" required>
                                </div>
                                <div class="controls">
                                    <select class="span12"  name="tipoEvento" id="slcTipoEvento" style="background-color: #2B2929; border: none;" >
                                        <option  value="0" >--Tipo evento--</option>
                                    </select>
                                </div>
                                <div class="controls">

                                    <input class="span12" type="text" placeholder="Fecha Evento" id="fechaEvento" name="fechaEvento" required>
                                </div>
                                <div class="controls">
                                    <input class="span12" type="time" placeholder="Hora Evento" name="horaEvento" required>
                                </div>

                                <div class="controls">
                                    <input class="span12" type="text" placeholder="Cantidad Personas" name="cantidadPersonas" pattern="[0-9]{2,10}" required>
                                </div>                                

                                <div class="controls">
                                    <textarea class="span12" id="textarea" rows="6" placeholder="Observaciones: Describa el evento a realizar" name="observaciones" required></textarea>
                                </div>
                                <input  class="btn btn-default pull-left" type="submit" name="Enviar"/>

                            </div>
                        </fieldset>
                    </form>
                </div><!-- span4 -->

            </div><!-- row -->
        </div><!-- container -->

        <script type="text/javascript">
            (function() {
                $.ajax({
                    url: 'controladorSolicitudes',
                    type: 'POST',
                    dataType: 'json',
                    data: {opcion: 8},
                    success: function(resultado) {
                        for (var i in resultado) {
                            var opcion = $('<option>');
                            opcion.attr('value', resultado[i].idTipoEvento);
                            opcion.text(resultado[i].nombreTipoEvento);

                            $('#slcTipoEvento').append(opcion);
                        }
                    },
                    error: function(error) {
                        console.error(error);
                    },
                    beforeSend: function() {
                        console.log(" Enviando peticion ");
                    }
                });
            })();

            function esperar() {
                var tipo = $('#slcTipoEvento').val();
                if (tipo === "0") {
                    alert("Por favor seleccione una opciÃ³n");
                    return false;
                } else {
                    return true;
                }

                var nombre = $('#txtNombre').val();
                var correo = $('#txtCorreo').val();

                var bandera2 = validarSiTexto(nombre); 
                var bandera3 = validarSiCorreo(correo);
                
                if(bandera2 === false && bandera3 === false){
                    return true;
                }

            }

            function validarSiCorreo(texto) {
                var emailReg = /^([\da-z_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
                if (emailReg.test(texto)) {
                    return false;
                } else {
                    alert("El valor " + texto + " no es un correo valido");
                    return true;
                }
            }

            function validarSiTexto(texto) {
                if (!/^([a-zA-Z])*$/.test(texto)) {
                    alert("El valor " + texto + " no es un texto valido");
                    return true;
                } else {
                    return false;
                }
            }

        </script>
        <!-- Bottom Map -->
        <div id="map"><iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d63617.48203922678!2d-74.0855312!3d4.753930100000001!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8e3f84eb69303c49%3A0x2618009c7a8f6bb4!2sSuba%2C+Bogot%C3%A1%2C+Colombia!5e0!3m2!1ses!2ses!4v1408581538759" width="1903" height="476" frameborder="0" style="border:0"></iframe><br /><small>ÃÂŸÃ‘Â€ÃÂ¾Ã‘ÂÃÂ¼ÃÂ¾Ã‘Â‚Ã‘Â€ÃÂµÃ‘Â‚Ã‘ÂŒ <a href="https://maps.google.com/maps/ms?ie=UTF8&amp;oe=UTF8&amp;msa=0&amp;msid=216545906525293155641.0004622c5d252f318c2f1&amp;t=m&amp;ll=55.599344,13.00214&amp;spn=0.035799,0.053339&amp;source=embed" style="color:#0000FF;text-align:left">Sunfleet MalmÃƒÂ¶</a>;-)</small></div>

        <!-- Le javascript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/jquery.prettyPhoto.js"></script>
        <script type="text/javascript" src="js/theme.js"></script>


    </body>
</html>