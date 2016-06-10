<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href='http://fonts.googleapis.com/css?family=Finger+Paint' rel='stylesheet' type='text/css'>
<style>
    h2 {
        font-family: 'Finger Paint', cursive;
    }
</style>
<head>
    <title>Main Index</title>
</head>
<body>

<p>
<h2 align="center">Project CarList</h2>
<h3 align="center">Please, enter param</h3>
    <form action="AddToCarList" align="center" method="POST">
    <input type="text" name="addNewCar"><br><br>
    <input type="submit" name="AddToList" value="SEND"><br><br>
    </form>
</p>

</body>
</html>
