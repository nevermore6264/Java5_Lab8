<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/13/2018
  Time: 9:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Quản lý sinh viên</title>
    <style type="text/css">
        *[id$=errors] {
            color: red;
            font-style: italic;
        }
    </style>
</head>
<body>
<form:form action="/form2" modelAttribute="student">
    <div>Họ và tên</div>
    <form:input path="name"/>
    <form:errors path="name"/>

    <div>Điểm</div>
    <form:input path="mark"/>
    <form:errors path="mark"/>

    <div>Chuyên ngành</div>
    <form:radiobutton path="major" value="APP" label="Ứng dụng phần mềm"/>
    <form:radiobutton path="major" value="WEB" label="Thiết kế trang web"/>
    <form:errors path="major"/>
    <h4>${message}</h4>

    <div>
        <button>Validate 2</button>
    </div>
</form:form>
</body>
</html>
