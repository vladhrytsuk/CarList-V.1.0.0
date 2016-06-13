<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <title>Edit</title>
</head>
<body>
    <form:form action="/list/edit/save" method = "POST" var="car">
        <table align="center">
            <caption>Edit car</caption>
            <tr>
                <th>№:</th>
                <td><input type="text" name = "id" readonly="readonly" value = ${car.id}><span style='color:red' id='idCar_f'></span></td>
            </tr>
            <tr>
                <th>Mark:</th>
                <td><input type="text" name = "mark" value = ${car.mark}><span style='color:red' id='mark_f'></span></td>
            </tr>
            <tr>
                <th>Color:</th>
                <td><input type="text" name = "color" value = ${car.color}><span style='color:red' id='color_f'></span></td>

            </tr>
            <tr>
                <th>Vin:</th>
                <td><input type="text" name = "vin" value = ${car.vin}><span style='color:red' id='vin_f'></span></td>
            </tr>
            <tr>
                <th>Miles</th>
                <td><input type="text" name = "miles" value = ${car.miles}><span style='color:red' id='miles_f'></span></td>
            </tr>
            <tr>
                <td><input type="submit" value = "SAVE"></td>
                <td><input type="submit"  onclick="location.href='/list'" value="CANCEL" ></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
