<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="./css/estilo.css">
    <title>Formulario</title>
</head>
 
<body>
 
     
    <h1>Formulario Alumno</h1>
     
    <form:form method="POST" modelAttribute="alumno" >
 
                <label for="firstName">Nombre</label>
                <form:input type="text" path="firstName" id="firstName"/>
                <form:errors path="firstName" class="errorsp"/><br><br>
                
                <label for="lastName">Apellido</label>
                <form:input type="text" path="lastName" id="lastName" />
                <form:errors path="lastName" class="errorsp"/><br><br>
                 
       
                <label  for="sex">Sexo</label>
                <form:radiobutton path="sex" value="M" />Hombre 
                <form:radiobutton path="sex" value="F" />Mujer
                <form:errors path="sex" class="errorsp"/><br><br>
       
                <label for="cumple">Fecha de nacimiento (dd/mm/aaaa)</label>
                <form:input type="text" path="cumple" id="cumple" />
                <form:errors path="cumple" class="errorsp"/><br><br>
        
                <label for="email">Email</label>
                <form:input type="text" path="email" id="email" />
                <form:errors path="email" class="errorsp"/><br><br>
    
                <label class="col-md-3 control-lable" for="firstAttempt">¿Primera matrícula?</label>
                <form:checkbox path="firstAttempt" />
                <form:errors path="firstAttempt" class="errorsp"/><br><br>
 
                <label  for="subjects">Asignaturas</label>
                <form:select path="subjects" items="${asignaturas}" multiple="true" />
                <form:errors path="subjects" class="errorsp"/><br><br>
 
                <input type="submit" value="Registro" >
    </form:form>
</body>
</html>