<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <style>
                    .parte{
                    display:flex;
                    justify-content: space-around;
                    margin-bottom:10px;
                    }
                </style>
            </head>

            <body>

                <div class="parte">
                    <div>
                        <p>1. Bulbasur</p>
                        <img width="150px"
                            src="https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/001.png"
                            alt="foto" />

                    </div>

                    <div>
                        <p
                            style="background-color:blue; padding:10px; border-radius:15px; color:white">Datos
                            Generales</p>

                        <table border="1">
                            <tr>
                                <th>Altura:</th>
                                <xsl:for-each select="pokedex/pokemon/datos_generales">
                                    <td>
                                        <xsl:value-of select="altura" />
                                    </td>
                                </xsl:for-each>
                            </tr>

                            <tr>
                                <th>Peso:</th>
                                <xsl:for-each select="pokedex/pokemon/datos_generales">
                                    <td>
                                        <xsl:value-of select="peso" />
                                    </td>
                                </xsl:for-each>
                            </tr>

                            <tr>
                                <th>Sexo:</th>
                                <xsl:for-each select="pokedex/pokemon/datos_generales">
                                    <td>
                                        <xsl:value-of select="sexo" />
                                    </td>
                                </xsl:for-each>
                            </tr>

                            <tr>
                                <th>Categoría:</th>
                                <xsl:for-each select="pokedex/pokemon/datos_generales">
                                    <td>
                                        <xsl:value-of select="categoria" />
                                    </td>
                                </xsl:for-each>
                            </tr>

                            <tr>
                                <th>Habilidad:</th>
                                <xsl:for-each select="pokedex/pokemon/datos_generales">
                                    <td>
                                        <xsl:value-of select="habilidad" />
                                    </td>
                                </xsl:for-each>

                            </tr>

                        </table>
                    </div>

                    <div>
                        <p
                            style="background-color:blue; padding:10px; border-radius:15px; color:white">Stats
                            Base</p>
                        <table border="1">
                            <tr>
                                <th>PS:</th>
                                <xsl:for-each select="pokedex/pokemon/stats_base">
                                    <td>
                                        <xsl:value-of select="ps" />
                                    </td>
                                </xsl:for-each>
                            </tr>

                            <tr>
                                <th>AT:</th>
                                <xsl:for-each select="pokedex/pokemon/stats_base">
                                    <td>
                                        <xsl:value-of select="at" />
                                    </td>
                                </xsl:for-each>
                            </tr>

                            <tr>
                                <th>DEF:</th>
                                <xsl:for-each select="pokedex/pokemon/stats_base">
                                    <td>
                                        <xsl:value-of select="def" />
                                    </td>
                                </xsl:for-each>
                            </tr>

                            <tr>
                                <th>SPAT:</th>
                                <xsl:for-each select="pokedex/pokemon/stats_base">
                                    <td>
                                        <xsl:value-of select="spat" />
                                    </td>
                                </xsl:for-each>
                            </tr>

                            <tr>
                                <th>SPDE:</th>
                                <xsl:for-each select="pokedex/pokemon/stats_base">
                                    <td>
                                        <xsl:value-of select="spde" />
                                    </td>
                                </xsl:for-each>
                            </tr>


                            <tr>
                                <th>VEL:</th>
                                <xsl:for-each select="pokedex/pokemon/stats_base">
                                    <td>
                                        <xsl:value-of select="vel" />
                                    </td>
                                </xsl:for-each>
                            </tr>


                        </table>
                    </div>

                </div>

                <div class="parte">
                    <div>
                        <p
                            style="background-color:blue; padding:10px; border-radius:15px; color:white">
                            Debilidades</p>
                        <table border="1">
                            <tr>
                                <th>Fuego:</th>
                                <xsl:for-each
                                    select="pokedex/pokemon/tipologia/debilidades/debilidad">
                                    <td>
                                        <xsl:value-of select="efectividad" />
                                    </td>
                                </xsl:for-each>
                            </tr>
                        </table>
                    </div>

                    <div>
                        <p
                            style="background-color:blue; padding:10px; border-radius:15px; color:white">
                            Nº Evoluciones</p>
                        <table border="1">
                            <tr>
                                <xsl:for-each
                                    select="pokedex/pokemon/evoluciones/evolucion">
                                    <td>
                                        <xsl:value-of select="num_pokedex"/>
                                    </td>
                                </xsl:for-each>
                            </tr>
                        </table>
                    </div>

                </div>

            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>            