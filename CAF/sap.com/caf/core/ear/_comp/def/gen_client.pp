<?xml version="1.0" encoding="UTF-8"?>
<public-part
		version="1.0.4"
		xmlns="http://xml.sap.com/2002/11/PublicPart"
		xmlns:IDX="urn:sap.com:PublicPart:1.0"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="http://xml.sap.com/2002/11/PublicPart ppdef.xsd">
	<name>gen_client</name>
	<purpose>compilation</purpose>
	<entities>
		<entity-ref>
			<dc-ref>
				<name>caf/core/ejbmodule</name>
				<vendor>sap.com</vendor>
			</dc-ref>
			<pp-ref>gen_client</pp-ref>
			<entity-ref-id>132be922-3342-4bc3-b7f8-9b39e2d4de75</entity-ref-id>
		</entity-ref>
		<entity-ref>
			<dc-ref>
				<name>caf/runtime/api</name>
				<vendor>sap.com</vendor>
			</dc-ref>
			<pp-ref>bi_api</pp-ref>
			<entity-ref-id>c7a4e653-5cc7-4c8b-b1d0-53ba1cffb0ed</entity-ref-id>
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
