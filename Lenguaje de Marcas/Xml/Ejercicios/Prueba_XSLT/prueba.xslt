<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Canasta</h2>
                <table border = "1">
                    <tr bgcolor = "#a0a0ff">
                        <th>Id Producto</th>
                        <th>Nombre</th>
                        <th>Origen</th>
                        <th>Cantidad</th>
                        <th>Precio</th>
                    </tr>

                    <xsl:for-each select="canasta/producto">
                       
                            <tr>
                                <td>
                                    <xsl:value-of select="@IdProducto"/>
                                </td>
                                <td>
                                    <xsl:value-of select="nombre"/>
                                </td>
                                <td>
                                    <xsl:value-of select="origen"/>
                                </td>
                                <td>
                                    <xsl:value-of select="cantidad"/>
                                </td>
                                <td>
                                    <xsl:value-of select="precio"/>
                                </td>
                            </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>