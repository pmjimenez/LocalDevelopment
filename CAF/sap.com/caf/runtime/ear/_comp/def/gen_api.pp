<?xml version="1.0" encoding="UTF-8"?>
<public-part
		 xmlns="http://xml.sap.com/2002/11/PublicPart"
		 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		 xsi:schemaLocation="http://xml.sap.com/2002/11/PublicPart ppdef.xsd"
		 version="1.0.4"
		 xmlns:IDX="urn:sap.com:PublicPart:1.0">
	<name>gen_api</name>
	<purpose>compilation</purpose>
	<caption></caption>
	<description>public-technical</description>
	<entities>
		<entity-ref>
			<dc-ref>
				<name>caf/runtime/api</name>
				<vendor>sap.com</vendor>
			</dc-ref>
			<pp-ref>gen_api</pp-ref>
			<entity-ref-id>742844d8-2a3b-42f6-8233-03f2f3655917</entity-ref-id>
		</entity-ref>
		<entity-ref>
			<dc-ref>
				<name>caf/runtime/impl</name>
				<vendor>sap.com</vendor>
			</dc-ref>
			<pp-ref>gen_api</pp-ref>
			<entity-ref-id>999b849e-e1e3-4cc5-8d36-fbdb8c238d92</entity-ref-id>
		</entity-ref>
		<entity-ref>
			<dc-ref>
				<name>caf/runtime/security</name>
				<vendor>sap.com</vendor>
			</dc-ref>
			<pp-ref>gen_api</pp-ref>
			<entity-ref-id>d7ab50b4-e433-41bf-8bdb-2043249f7375</entity-ref-id>
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