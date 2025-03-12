<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <style>
                    .parte{
                    display:flex;
                    justify-content: space-around;
                    margin-bottom:40px;
                    text-align: center;
                    }
                </style>
            </head>

            <body>
                <div class="parte">
                    <p>
                        <b>Ticket para el evento:</b>
                    </p>
                    <xsl:for-each select="pelicula/info">
                        <p>
                            <xsl:value-of select="ticket" />
                        </p>
                    </xsl:for-each>

                    <p>
                        <b>Código:</b>
                    </p>
                    <xsl:for-each select="pelicula/info">
                        <p>
                            <xsl:value-of select="codigo" />
                        </p>
                    </xsl:for-each>
                </div>

                <div class="parte">
                    <img width="400px"
                        src="https://i.scdn.co/image/ab67616d00001e0216def719d967c94789136dae"
                        alt="foto" />
                    <div>
                        <p style="background-color:blue; padding:10px; border-radius:15px; color:white">Datos de Evento</p>
                        <table border="1">
                            <tr>
                                <th>Fecha:</th>
                                <xsl:for-each select="pelicula/datos">
                                    <td>
                                        <xsl:value-of select="fecha" />
                                    </td>
                                </xsl:for-each>
                            </tr>

                            <tr>
                                <th>Lugar:</th>
                                <xsl:for-each select="pelicula/datos">
                                    <td>
                                        <xsl:value-of select="lugar" />
                                    </td>
                                </xsl:for-each>
                            </tr>

                            <tr>
                                <th>Ciudad:</th>
                                <xsl:for-each select="pelicula/datos">
                                    <td>
                                        <xsl:value-of select="ciudad" />
                                    </td>
                                </xsl:for-each>
                            </tr>

                            <tr>
                                <th>Precio:</th>
                                <xsl:for-each select="pelicula/datos">
                                    <td>
                                        <xsl:value-of select="precio" />
                                    </td>
                                </xsl:for-each>
                            </tr>
                        </table>

                        <img width="350px" src="https://images.vexels.com/media/users/3/158114/isolated/preview/473403ce8dee60dab42b0497450711de-product-barcode-design-element.png" alt="foto"/>
                    </div>


                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>   