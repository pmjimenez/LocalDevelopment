<?xml version="1.0" encoding="UTF-8"?>
<public-part
		version="1.0.4"
		xmlns="http://xml.sap.com/2002/11/PublicPart"
		xmlns:IDX="urn:sap.com:PublicPart:1.0"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="http://xml.sap.com/2002/11/PublicPart ppdef.xsd">
	<name>client</name>
	<purpose>compilation</purpose>
	<entities>
		<entity-ref>
			<dc-ref>
				<name>caf/core/ejbmodule</name>
				<vendor>sap.com</vendor>
			</dc-ref>
			<pp-ref>client</pp-ref>
			<entity-ref-id>83f6f804-b0b9-41bb-989e-e9b3adf08da9</entity-ref-id>
		</entity-ref>
		<entity-ref>
			<dc-ref>
				<name>caf/runtime/api</name>
				<vendor>sap.com</vendor>
			</dc-ref>
			<pp-ref>bi_api</pp-ref>
			<entity-ref-id>048a0d09-7537-4cf4-8c00-f5a9f402622d</entity-ref-id>
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
