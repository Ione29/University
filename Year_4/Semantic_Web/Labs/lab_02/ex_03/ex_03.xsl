<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes"/>

    <xsl:template match="/movies">
        <html>
            <head>
                <title>Sorted Movie List (by title)</title>
            </head>
            <body>
                <h1>Movie List</h1>
                <ul>
                    <xsl:apply-templates select="movie">
                        <xsl:sort select="title"/>

                    </xsl:apply-templates>
                </ul>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="movie">
        <li><xsl:value-of select="title"/></li>
    </xsl:template>
</xsl:stylesheet>