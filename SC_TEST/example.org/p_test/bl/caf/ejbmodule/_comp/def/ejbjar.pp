<?xml version="1.0" encoding="UTF-8"?>
<public-part
		version="1.0.5"
		xmlns="http://xml.sap.com/2002/11/PublicPart"
		xmlns:IDX="urn:sap.com:PublicPart:1.0"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="http://xml.sap.com/2002/11/PublicPart ppdef.xsd">
	<name>ejbjar</name>
	<purpose>assembly</purpose>
	<entities>
		<entity>
			<name>example.org~p_test~bl~caf~ejbmodule</name>
			<entity-type>EJB-JAR</entity-type>
		</entity>
		<entity>
			<name>p_test/bl/caf/ejbmodule</name>
			<caption>Composite Descriptor Entity</caption>
			<description>Composite Descriptor Entitiy Description</description>
			<entity-type>Composite Entity</entity-type>
		</entity>
		<entity>
			<name>p_test/bl/caf/ejbmodule</name>
			<caption>Xlf2Prop Descriptor Entity</caption>
			<description>Xlf2Prop Descriptor Entitiy Description</description>
			<entity-type>Xlf2Prop Entity</entity-type>
		</entity>
	</entities>
	<access-control-list>
		<grant forwarding-allowed="false">
			<dc-ref>
				<name>p_test/bl/caf/ear</name>
				<vendor>example.org</vendor>
			</dc-ref>
		</grant>
	</access-control-list>
</public-part>
