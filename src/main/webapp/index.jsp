<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Add User</title>
    </head>
    <body>
    <h2>Add User</h2>
        <form action="AddUser-servlet" method="post">
            <label for="id">ID:</label>
            <input type="text" id="id" name="id" required><br>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required><br>

            <input type="submit" value="회원가입">
        </form>
    </body>
</html>