<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<body>
<h2>Hello World!</h2>
<%--是否认证通过 认证通过则显示内容 --%>
<shiro:authenticated>
    <h1>认证通过</h1>
    欢迎您：${user} <a href="${pageContext.request.contextPath}/login.jsp">登出</a>
    <a href="${pageContext.request.contextPath}/manager/queryAllManager">测试注解版</a>
</shiro:authenticated>

<shiro:notAuthenticated>
    <a href="${pageContext.request.contextPath}/login.jsp">[登陆]</a><a href="#">[注册]</a>
</shiro:notAuthenticated>

<%--游客，类似未认证 --%>
<shiro:guest>
    
</shiro:guest>

<%--记住我 --%>
<shiro:user></shiro:user>

<shiro:hasRole name="root">
    <h1>拥有root角色</h1>
</shiro:hasRole>

<shiro:hasPermission name="user:add">
    <h1>拥有用户新增权限</h1>
</shiro:hasPermission>
</body>
</html>
