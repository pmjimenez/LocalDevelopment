<?xml version="1.0" encoding="UTF-8"?>
<public-part
		 xmlns="http://xml.sap.com/2002/11/PublicPart"
		 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		 xsi:schemaLocation="http://xml.sap.com/2002/11/PublicPart ppdef.xsd"
		 version="1.0.4"
		 xmlns:IDX="urn:sap.com:PublicPart:1.0">
	<name>api</name>
	<purpose>compilation</purpose>
	<caption></caption>
	<description>public</description>
	<entities>
		<entity-ref>
			<dc-ref>
				<name>caf/runtime/api</name>
				<vendor>sap.com</vendor>
			</dc-ref>
			<pp-ref>api</pp-ref>
			<entity-ref-id>fcb39a5f-c3e5-45e3-b634-359c24246b84</entity-ref-id>
		</entity-ref>
		<entity-ref>
			<dc-ref>
				<name>caf/runtime/impl</name>
				<vendor>sap.com</vendor>
			</dc-ref>
			<pp-ref>api</pp-ref>
			<entity-ref-id>34c0d63f-bb29-4ccc-a670-0450b7f77164</entity-ref-id>
		</entity-ref>
		<entity-ref>
			<dc-ref>
				<name>caf/runtime/security</name>
				<vendor>sap.com</vendor>
			</dc-ref>
			<pp-ref>api</pp-ref>
			<entity-ref-id>92366f4c-61ca-42ce-80ca-54b5221a10f3</entity-ref-id>
		</entity-ref>
	</entities>
	<access-control-list>
		<grant forwarding-allowed="true">
			<dc-ref>
				<name>*</name>
				<vendor>*</vendor>
			</dc-ref>
		</grant>
	</access-control-list>
</public-part>