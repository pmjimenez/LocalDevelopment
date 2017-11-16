<?xml version="1.0" encoding="UTF-8"?>
<public-part
		version="1.0.5"
		xmlns="http://xml.sap.com/2002/11/PublicPart"
		xmlns:IDX="urn:sap.com:PublicPart:1.0"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="http://xml.sap.com/2002/11/PublicPart ppdef.xsd">
	<name>test_api</name>
	<purpose>compilation</purpose>
	<caption>Public Part to allow access from test DC</caption>
	<entities>
		<entity>
			<name>com</name>
			<package>com</package>
			<caption>com</caption>
			<description>com</description>
			<entity-type>Java Package Tree</entity-type>
			<entity-sub-type>Class</entity-sub-type>
		</entity>
		<entity>
			<name>com</name>
			<package>com</package>
			<caption>com</caption>
			<description>com</description>
			<entity-type>Java Package Tree</entity-type>
			<entity-sub-type>Source</entity-sub-type>
		</entity>
		<entity-ref>
			<dc-ref>
				<name>tc/bi/framework</name>
				<vendor>sap.com</vendor>
			</dc-ref>
			<pp-ref>api</pp-ref>
			<entity-ref-id>c7b0eba8-4e2d-4283-9ce7-e4f1a587a17c</entity-ref-id>
		</entity-ref>
	</entities>
	<access-control-list>
		<grant forwarding-allowed="true">
			<dc-ref>
				<name>bie/sca/scdl/gen/test</name>
				<vendor>test.sap.com</vendor>
			</dc-ref>
		</grant>
	</access-control-list>
</public-part>
