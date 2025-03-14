<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <style>
                    .entero{
                    border-radius: 40px;
                    border: 1px solid black;
                    margin-left:150px;
                    margin-right:150px;
                    }

                    .parte{
                    display:flex;
                    justify-content: space-around;
                    margin-bottom:50px;
                    }

                    p{
                    color:white;
                    background-color:blue;
                    text-align:center;
                    padding: 5px;
                    border-radius: 10px;
                    border: 2px solid black;
                    }

                    h2{
                    color:white;
                    background-color:red;
                    text-align:center;
                    padding: 5px;
                    border-radius: 10px;
                    border: 2px solid black;
                    width:150px;
                    margin-left:850px;
                    }

                    th{
                    border: 2px solid black;
                    padding:10px;
                    }

                </style>
            </head>

            <body>

                <h2>Piratas</h2>
                <div class="entero">
                    <div class="parte">
                        <div>
                            <p>Actor</p>
                            <table style="border: 5px solid black; padding:10px ">
                                <tr>
                                    <td>
                                        <b>Nombre Completo :</b>
                                    </td>
                                    <xsl:for-each select="piratas/pirata/datos_actor">
                                        <td>
                                            <xsl:value-of select="nombre" />
                                            <xsl:value-of select="apellidos" />
                                        </td>
                                    </xsl:for-each>
                                </tr>
                                <tr>
                                    <td>
                                        <b>Sexo :</b>
                                    </td>
                                    <xsl:for-each select="piratas/pirata/datos_actor">
                                        <td>
                                            <xsl:value-of select="sexo" />
                                        </td>
                                    </xsl:for-each>
                                </tr>
                                <tr>
                                    <td>
                                        <b>Fecha Nacimiento :</b>
                                    </td>
                                    <xsl:for-each select="piratas/pirata/datos_actor">
                                        <td>
                                            <xsl:value-of select="nacimiento" />
                                        </td>
                                    </xsl:for-each>
                                </tr>
                            </table>

                        </div>

                        <div>
                            <p>Jack Sparrow</p>
                            <img width="150px"
                                src="https://hips.hearstapps.com/hmg-prod/images/piratas-del-caribe-cicatriz-sparro-1594963381.jpg?resize=980:*"
                                alt="foto" />

                        </div>
                    </div>

                    <div class="parte">
                        <div>
                            <p>Películas</p>
                            <div class="tablas">
                                <table>
                                    <tr>
                                        <th style="background-color:yellow">
                                            TÍTULO
                                        </th>

                                        <th style="background-color:yellow">
                                            SAGA
                                        </th>

                                    </tr>

                                    <tr>
                                        <xsl:for-each
                                            select="piratas/pirata/peliculas/pelicula/datos">
                                            <th>
                                                <xsl:value-of select="titulo" />
                                            </th>
                                        </xsl:for-each>
                                        <xsl:for-each
                                            select="piratas/pirata/peliculas/pelicula/datos">
                                            <th>
                                                <xsl:value-of select="saga" />
                                            </th>
                                        </xsl:for-each>
                                    </tr>

                                    <tr>
                                        <xsl:for-each
                                            select="piratas/pirata/peliculas/pelicula/datos">
                                            <th>
                                                En el fin del mundo
                                            </th>
                                        </xsl:for-each>
                                        <xsl:for-each
                                            select="piratas/pirata/peliculas/pelicula/datos">
                                            <th>
                                                <xsl:value-of select="saga" />
                                            </th>
                                        </xsl:for-each>
                                    </tr>

                                </table>
                            </div>
                        </div>

                        <div>
                            <p>Roles</p>
                            <div class="tablas">
                                <table>
                                    <tr>
                                        <th style="background-color:yellow">
                                            TIPO
                                        </th>

                                        <th style="background-color:yellow">
                                            BARCO
                                        </th>

                                    </tr>

                                    <tr>
                                        <xsl:for-each select="piratas/pirata/roles/rol">
                                            <th>
                                                <xsl:value-of select="tipo_rol" />
                                            </th>
                                        </xsl:for-each>
                                        <xsl:for-each select="piratas/pirata/roles/rol">
                                            <th>
                                                <xsl:value-of select="barco" />
                                            </th>
                                        </xsl:for-each>
                                    </tr>

                                    <tr>

                                        <th>
                                            TRIPULANTE
                                        </th>

                                        <th>
                                            El Holandés Errante
                                        </th>
                                    </tr>

                                </table>
                            </div>
                        </div>


                    </div>


                </div>

            </body>

        </html>
    </xsl:template>
</xsl:stylesheet>         