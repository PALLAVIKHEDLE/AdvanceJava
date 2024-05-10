<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #f8f9fa; /* Optional: Change background color */
        }
        .registration-form {
            width: 500px;
            padding: 30px;
            border: 1px solid #ced4da;
            border-radius: 5px;
            background-color: #ffffff;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h1 class="text-center mb-4">Welcome to User Registration!</h1>
            <% 
                String error = (String) session.getAttribute("error");
                String existingUsername = (String) session.getAttribute("existingUsername");
                if (error != null && !error.isEmpty()) {
            %>
                <p class="text-danger"> <%= existingUsername %> <%= error %> </p>
            <%
                    session.setAttribute("error", null);
                } 
            %>

            <div class="registration-form">
                <form action="registrationServlet" method="post">
                    <div class="form-group">
                        <label for="firstName">First Name:</label>
                        <input type="text" class="form-control" id="firstName" name="firstName" required>
                    </div>
                    <div class="form-group">
                        <label for="lastName">Last Name:</label>
                        <input type="text" class="form-control" id="lastName" name="lastName" required>
                    </div>
                    <div class="form-group">
                        <label for="userName">Username:</label>
                        <input type="text" class="form-control" id="userName" name="userName" required>
                    </div>
                    <div class="form-group">
                        <label for="password">Password:</label>
                        <input type="password" class="form-control" id="password" name="password" required>
                    </div>
                    <button type="submit" class="btn btn-primary btn-block">Register</button>
                </form>
            </div>
        </div>
    </div>
</div>


</body>
</html>
