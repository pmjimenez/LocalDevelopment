<?xml version="1.0" encoding="UTF-8"?>
<public-part
		version="1.0.4"
		xmlns="http://xml.sap.com/2002/11/PublicPart"
		xmlns:IDX="urn:sap.com:PublicPart:1.0"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="http://xml.sap.com/2002/11/PublicPart ppdef.xsd">
	<name>persistence</name>
	<purpose>assembly</purpose>
	<entities>
		<entity-ref>
			<dc-ref>
				<name>caf/core/ejbmodule</name>
				<vendor>sap.com</vendor>
			</dc-ref>
			<pp-ref>persistence</pp-ref>
			<entity-ref-id>e5e16535-e27d-4bb7-bf5a-3f87e3e53b87</entity-ref-id>
		</entity-ref>
	</entities>
	<access-control-list>
		<grant forwarding-allowed="false">
			<dc-ref>
				<name>*</name>
				<vendor>*</vendor>
			</dc-ref>
		</grant>
	</access-control-list>
</public-part>
