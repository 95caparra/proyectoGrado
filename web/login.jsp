<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <!--META-->
        <meta charset="UTF-8" >
        <title>Login</title>
        <link rel="icon" type="image/png" href="images/favicon.png" />

        <!--STYLESHEETS-->
        <link href="css/estiloLogin.css" rel="stylesheet" type="text/css" />

        <!--SCRIPTS-->
        <!-- Add jQuery library -->
        <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>

        <!-- Add fancyBox main JS and CSS files -->
        <script type="text/javascript" src="js/jquery.fancybox.js"></script>
        <link rel="stylesheet" type="text/css" href="css/jquery.fancybox.css" media="screen" />
        
        <!--librerias mensajes-->
        <link rel="stylesheet" href="css/messi.min.css" />
        <script src="js/messi.min.js"></script>

        <!--Slider-in icons-->
        <script type="text/javascript">
            $(document).ready(function() {
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

                $(".username").focus(function() {
                    $(".user-icon").css("left", "-48px");
                });
                $(".username").blur(function() {
                    $(".user-icon").css("left", "0px");
                });

                $(".password").focus(function() {
                    $(".pass-icon").css("left", "-48px");
                });
                $(".password").blur(function() {
                    $(".pass-icon").css("left", "0px");
                });

            });
        </script>

    </head>
    <body>
        <%  if (session.getAttribute("mensaje") != null) {%>            
            <script type=text/javascript>new Messi('<%=session.getAttribute("mensaje")%>', {title: 'Mensaje', titleClass: 'info', buttons: [{id: 0, label: 'Aceptar', val: 'X'}]});</script>
        <%
            } //Ciero el if
        %>
        
        <!--WRAPPER-->
        <div id="wrapper">

            <!--SLIDE-IN ICONS-->
            <div class="user-icon"></div>
            <div class="pass-icon"></div>
            <!--END SLIDE-IN ICONS-->
            
            <!--LOGIN FORM-->
            <form id="formLogin" class="login-form" action="login" method="POST">
                <input type="hidden" name="opcion" value="1" />
                <!--HEADER-->
                <div class="header">
                    <img src="images/LogoQuotEvent.png">
                </div>
                <!--END HEADER-->

                <!--CONTENT-->
                <div class="content">
                    <!--USERNAME--><input name="username" type="text" class="input username" placeholder="Nombre de Usuario" onfocus="this.value = ''" /><!--END USERNAME-->
                    <!--PASSWORD--><input name="password" type="password" class="input password" placeholder="Contraseña" onfocus="this.value = ''" /><!--END PASSWORD-->
                </div>
                <!--END CONTENT-->

                <!--FOOTER-->
                <div class="footer">

                    <a class="fancybox" href="#inline1">
                        <input type="button" value="¿Olvido su contraseña?" class="register"/>
                    </a>
                    <input type="submit" value="Ingresar" class="button" />
                </div>
                <!--END FOOTER-->

            </form>
            <!--END LOGIN FORM-->

        </div>
        <!--END WRAPPER-->

        <!--GRADIENT--><div class="gradient"></div><!--END GRADIENT-->

        <!-- Formulario para recuperar contraseña  -->
        <div id="inline1">    
            <form id="formRecuperarClave" method="POST" action="login">
                <input type="hidden" name="opcion" value="3" />
                <table>
                    <tr>
                        <td colspan="2">
                            Para restablecer su contraseña, por favor digite su nombre de usuario a continuación:
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" name="nomUsuario" id="textNomUsuario"/>
                        </td>
                        <td>
                            <input type="submit" name="btnRestablecer" id="btnAceptar" value="Aceptar" />
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>