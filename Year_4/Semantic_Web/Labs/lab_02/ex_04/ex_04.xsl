<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes"/>

    <xsl:template match="/movies">
        <html>
            <head>
                <title>Schedule</title>
            </head>
            <body>
                <h1>Scheduling Table</h1>
                <table border="1">
                    <tr>
                        <th>Date</th>
                        <th>Hours</th>
                        <th>Hall</th>
                        <th>Chair Type</th>
                        <th>Capacity</th>
                    </tr>
                    <xsl:apply-templates select="movie[title='Baby Driver']"/>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="movie">
        <xsl:for-each select="schedules/schedule">
            <tr>
                <td>
                    <xsl:value-of select="date"/>
                </td>
                <td>
                    <xsl:for-each select="hours/hour">
                        <xsl:value-of select="."/>
                        <xsl:if test="position() != last()">, </xsl:if>
                    </xsl:for-each>
                </td>
                <td>
                    <xsl:for-each select="../../cinema_halls/hall">
                        Hall <xsl:value-of select="id"/>
                        <xsl:if test="position() != last()">, </xsl:if>
                    </xsl:for-each>
                </td>
                <td>
                    <xsl:for-each select="../../cinema_halls/hall">
                        <xsl:value-of select="chair_type"/>
                        <xsl:if test="position() != last()">, </xsl:if>
                    </xsl:for-each>
                </td>
                <td>
                    <xsl:for-each select="../../cinema_halls/hall">
                        <xsl:value-of select="capacity"/>
                        <xsl:if test="position() != last()">, </xsl:if>
                    </xsl:for-each>
                </td>
            </tr>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>