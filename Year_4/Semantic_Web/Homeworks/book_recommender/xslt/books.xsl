<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:param name="userLevel"/>
  <xsl:template match="/books">
    <table border="1" cellpadding="5" cellspacing="0">
      <tr>
        <th>ID</th><th>Title</th><th>Themes</th><th>Reading Level</th>
      </tr>
      <xsl:for-each select="book">
        <tr>
          <xsl:attribute name="style">
            <xsl:choose>
              <xsl:when test="readingLevel = $userLevel">
                background-color:yellow;
              </xsl:when>
              <xsl:otherwise>
                background-color:lightgreen;
              </xsl:otherwise>
            </xsl:choose>
          </xsl:attribute>
          <td><xsl:value-of select="@id"/></td>
          <td>
            <a href="/book/{@id}">
              <xsl:value-of select="title"/>
            </a>
          </td>
          <td>
            <xsl:value-of select="themes/theme[1]"/>,
            <xsl:value-of select="themes/theme[2]"/>
          </td>
          <td><xsl:value-of select="readingLevel"/></td>
        </tr>
      </xsl:for-each>
    </table>
  </xsl:template>
</xsl:stylesheet>
