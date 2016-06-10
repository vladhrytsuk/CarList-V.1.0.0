<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href='http://fonts.googleapis.com/css?family=Finger+Paint' rel='stylesheet' type='text/css'>
<style>
    h2 {
        font-family: 'Finger Paint', cursive;
    }
</style>
<head>
    <title>CarList</title>
</head>
<body>

    <h2 align="center">LIST:</h2>
    <h4 align="center">${CarList}</h4>>
    <form action="/" align="center" method="GET">
        <input type="submit" name="ReturnToAddList" value="ADD"><br><br>
    </form>

    <form action="RemoveToCarList" align="center" method="POST">
        Enter index car for delete: <input type="text" name="deleteCar"><br>
        <input type="submit" name="DeleteToList" value="DELETE"><br><br>
    </form>

    <form action="EditToCarList" align="center" method="POST">
        Enter index car for edit: <input type="text" name="idEditCar"><br>
        Enter car for edit:       <input type="text" name="editCar"><br>
        <input type="submit" name="EditToList" value="EDIT"><br><br>
    </form>
</body>
</html>
