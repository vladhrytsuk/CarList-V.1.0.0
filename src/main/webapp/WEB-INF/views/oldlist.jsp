<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>OLD FACTORY</title>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1251" />
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 5px;
            text-align: left;
        }

        #CarDataTable th{
            background-color:black;
            font-weight:bold;
            color: white;
        }
    </style>

    <script type='text/javascript'>
        function validateAdd(){
            var mark = document.forms['add']['mark'].value;
            var color = document.forms['add']['color'].value;
            var vin = document.forms['add']['vin'].value;
            var miles = document.forms['add']['miles'].value;
            var alpha = new RegExp('[0-9A-z]');
            var digit = new RegExp('[0-9]');

            if (mark.length == 0){
                document.getElementById('mark_f').innerHTML='*данное поле обязательно для заполнения.';
                return false;
            }

            else if (alpha.exec(mark) == null) {
                document.getElementById('mark_f').innerHTML='*данное введены не верно. Только цифры и буквы (0-9, A-z).';
                return false;
            }

            if (color.length == 0){
                document.getElementById('color_f').innerHTML='*данное поле обязательно для заполнения.';
                return false;
            }
            else if (alpha.exec(color) == null) {
                document.getElementById('color_f').innerHTML='*данное введены не верно. Только цифры и буквы (0-9, A-z).';
                return false;
            }

            if (vin.length == 0){
                document.getElementById('vin_f').innerHTML='*данное поле обязательно для заполнения.';
                return false;
            }
            else if (digit.exec(vin) == null) {
                document.getElementById('vin_f').innerHTML='*данное введены не верно. Только цифры(0-9).';
                return false;
            }

            if (miles.length == 0){
                document.getElementById('miles_f').innerHTML='*данное поле обязательно для заполнения.';
                return false;
            }
            else if (digit.exec(miles) == null) {
                document.getElementById('miles_f').innerHTML='*данное введены не верно. Только цифры(0-9).';
                return false;
            }
        }
    </script>
</head>
<body>
<div class="container">
    <form:form action="/oldlist/add" method = "POST" name='add' onsubmit='return validateAdd()'>
        <table align="center">
            <caption>Add car</caption>
            <tr>
                <th>Mark:</th>
                <td><input type="text" name = "mark" value = ${mark}><span style='color:red' id='mark_f'></span></td>
            </tr>
            <tr>
                <th>Color:</th>
                <td><input type="text" name = "color" value = ${color}><span style='color:red' id='color_f'></span></td>

            </tr>
            <tr>
                <th>Vin:</th>
                <td><input type="text" name = "vin" value = ${vin}><span style='color:red' id='vin_f'></span></td>
            </tr>
            <tr>
                <th>Miles</th>
                <td><input type="text" name = "miles" value = ${miles}><span style='color:red' id='miles_f'></span></td>
            </tr>
            <tr>
                <td><input type="submit" name = "add" value = "ADD"></td>
            </tr>
        </table>
    </form:form>
    <hr />
    <table align="center" id="List">
        <caption>Project CarList</caption>
        <tr>
            <td>Mark</td>
            <td>Color</td>
            <td>Vin</td>
            <td>Miles</td>
        </tr>
        <c:forEach items = "${ct.carListTable}" var = "car">
            <tr>
                <td>${car.mark}</td>
                <td>${car.color}</td>
                <td>${car.vin}</td>
                <td>${car.miles}</td>
                <form:form method = "POST" action="/oldlist/edit">
                    <td colspan="2">
                        <input type="hidden" name = "editCar" value = ${car.id}>
                        <input type="submit" id = "edit" value="EDIT" >
                    </td>
                </form:form>
                <form:form method = "POST" action="/oldlist/delete">
                    <td colspan="2">
                        <input type="hidden" id = "deleteCar" value = ${car.id}>
                        <input type="submit" id = "delete" value="DELETE"/>
                    </td>
                </form:form>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
