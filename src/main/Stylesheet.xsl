<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
<xsl:template match="/">
    <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
      <fo:layout-master-set>
        <fo:simple-page-master master-name="simpleA4" page-height="29.7cm" page-width="21cm" margin-top="2cm" margin-bottom="2cm" margin-left="2cm" margin-right="2cm">
          <fo:region-body/>
        </fo:simple-page-master>
      </fo:layout-master-set>
      <fo:page-sequence master-reference="simpleA4">
        <fo:flow flow-name="xsl-region-body">
          <fo:block border-top-style="solid" font-size="20pt" font-weight="bold" space-after="5mm" text-align="center">Curriculum Vitae</fo:block>
          <fo:block text-align="center"><fo:external-graphic content-height="scale-to-fit" content-width="scale-to-fit" height="2.5in" width="2.5in" src="url(file:{CV/basicInformation/pictureLink})"></fo:external-graphic></fo:block>
          <fo:block border-bottom-style="solid" font-size="16pt" font-weight="bold" space-after="5mm">Personal information</fo:block>
          <fo:block font-size="12pt">Name: <xsl:value-of select="CV/basicInformation/fullName"/></fo:block>
          <fo:block font-size="12pt">Birthdate: <xsl:value-of select="CV/basicInformation/birthdate"/></fo:block>
          <fo:block font-size="12pt">City: <xsl:value-of select="CV/basicInformation/city"/></fo:block>
          <fo:block font-size="12pt">Phone number: <xsl:value-of select="CV/basicInformation/phoneNumber"/></fo:block>          
          <fo:block></fo:block>
          <xsl:if test="CV/education/college != ''">
              <fo:block border-bottom-style="solid" font-size="16pt" font-weight="bold" space-after="5mm">Education</fo:block>
	          <xsl:for-each select="CV/education">
	            <fo:block></fo:block>   
		  	    <fo:block font-size="12pt">College: <xsl:value-of select="college/string"/></fo:block>
		  	  	<fo:block font-size="12pt">Field of study: <xsl:value-of select="fieldOfStudy/string"/></fo:block>	  
		      	<fo:block font-size="12pt">Start date: <xsl:value-of select="studyStartDate/string"/></fo:block>	  
		      	<fo:block font-size="12pt">End date: <xsl:value-of select="studyEndDate/string"/></fo:block>
		  	  </xsl:for-each>
		      <fo:block></fo:block>  	  
		  </xsl:if>
          <xsl:if test="CV/experience/company != ''">
              <fo:block border-bottom-style="solid" font-size="16pt" font-weight="bold" space-after="5mm">Professional experience</fo:block>
	          <xsl:for-each select="CV/experience">
	            <fo:block></fo:block>
		  	    <fo:block font-size="12pt">Company: <xsl:value-of select="company/string"/></fo:block>
		  	  	<fo:block font-size="12pt">Post: <xsl:value-of select="post/string"/></fo:block>	  
		      	<fo:block font-size="12pt">Start date: <xsl:value-of select="jobStartDate/string"/></fo:block>	  
		      	<fo:block font-size="12pt">End date: <xsl:value-of select="jobEndDate/string"/></fo:block>
		  	  </xsl:for-each>
		      <fo:block></fo:block>	  
		  </xsl:if>
          <xsl:if test="CV/language/languageName != ''">
              <fo:block border-bottom-style="solid" font-size="16pt" font-weight="bold" space-after="5mm">Skills</fo:block>
	          <xsl:for-each select="CV/language">
		  	    <fo:block font-size="12pt">Language: <xsl:value-of select="languageName/string"/></fo:block>
		  	  	<fo:block font-size="12pt">Level: <xsl:value-of select="languageLevel/string"/></fo:block>	  
		  	  </xsl:for-each>
		  </xsl:if>
		  <xsl:if test="CV/skills != ''">
		  <fo:block font-size="12pt">Skills: <xsl:value-of select="CV/skills"/></fo:block>
		  </xsl:if>
	     </fo:flow>          
      </fo:page-sequence>
     </fo:root>
</xsl:template>
</xsl:stylesheet>

