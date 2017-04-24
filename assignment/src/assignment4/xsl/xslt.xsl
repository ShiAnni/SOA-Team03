<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:jw="http://jw.nju.edu.cn/schema">

	<xsl:template match="/">

		<课程成绩列表 xmlns="http://jw.nju.edu.cn/schema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://jw.nju.edu.cn/schema ../schema/ScoreList.xsd">
			<xsl:for-each select="//jw:学生[1]//jw:课程成绩">
				<课程成绩>
					<xsl:attribute name="课程编号">
							<xsl:value-of select="@课程编号" />
						</xsl:attribute>
					<xsl:attribute name="成绩性质">
							<xsl:value-of select="@成绩性质" />
						</xsl:attribute>
					<xsl:call-template name="score">
						<xsl:with-param name="courseNo" select="@课程编号" />
						<xsl:with-param name="scoreType" select="@成绩性质" />
					</xsl:call-template>
				</课程成绩>
			</xsl:for-each>
		</课程成绩列表>
	</xsl:template>

	<xsl:template name="score">
		<xsl:param name="courseNo" />
		<xsl:param name="scoreType" />
		<xsl:for-each select="//jw:课程成绩[@成绩性质 = $scoreType and @课程编号 = $courseNo]">
			<xsl:sort select="./jw:成绩/jw:得分" data-type="number" order="descending"></xsl:sort>

			<xsl:copy-of select="./jw:成绩"></xsl:copy-of>
		</xsl:for-each>
	</xsl:template>


</xsl:stylesheet>