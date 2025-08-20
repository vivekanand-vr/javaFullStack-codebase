<%@ taglib prefix="myTag" uri="/WEB-INF/hello.tld" %>

<h1>Hello this is index.jsp page</h1>

<myTag:hello name='sachin'>
	<h1>This is the body of custom tag</h1>
</myTag:hello>

<myTag:hello>
	<h1>This is the body of custom tag</h1>
</myTag:hello>

<h1>This is after the custom tag invocation</h1>