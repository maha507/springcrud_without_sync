<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Register Form </title>
    <!-- Include Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
 
<div class="container mt-5">
    <h1> Edit Laptop Form</h1>
    <form:form action="/update/${laptop.id}" method="post" modelAttribute="laptop">
        <div class="form-group">
            <label for="id">ID</label>
            <form:input path="id" class="form-control" id="id" name="id" placeholder="Enter ID" readonly="true"/><br>
        </div>
        <div class="form-group">
            <label for="brand">BRAND</label>
            <form:input path="brand" type="text" class="form-control" id="brand" name="brand" placeholder="Enter brand"/><br>
        </div>
        <div class="form-group">
            <label for="price">PRICE</label>
           <form:input path="price" type="text" class="form-control" id="price" name="price" placeholder="Enter price"/><br>
        </div>
        
        <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>
</div>
 
 
 
</body>
</html>
 