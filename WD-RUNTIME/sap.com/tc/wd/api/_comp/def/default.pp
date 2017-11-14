<?xml version="1.0" encoding="UTF-8"?>
<public-part
		 xmlns="http://xml.sap.com/2002/11/PublicPart"
		 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		 xsi:schemaLocation="http://xml.sap.com/2002/11/PublicPart ppdef.xsd"
		 version="1.0.3"
		 xmlns:IDX="urn:sap.com:PublicPart:1.0">
	<name>default</name>
	<purpose>compilation</purpose>
	<caption>API for Web Dynpro Applications</caption>
	<description>The contents of this API is provided for application development to get access to Web Dynpro Runtime.i This public part also contains the default Web Dynpor metamodel content to be able to define Web Dynpro applications.</description>
	<entities>
		<entity-ref>
			<dc-ref>
				<name>tc/wd/pack/api</name>
				<vendor>sap.com</vendor>
			</dc-ref>
			<pp-ref>default</pp-ref>
		</entity-ref>
		<entity-ref>
			<dc-ref>
				<name>tc/wdp/metamodel/content</name>
				<vendor>sap.com</vendor>
			</dc-ref>
			<pp-ref>default</pp-ref>
		</entity-ref>
	</entities>
	<access-control-list>
		<grant>
			<sc-ref>
				<name>*</name>
				<vendor>*</vendor>
			</sc-ref>
		</grant>
	</access-control-list>
</public-part>
