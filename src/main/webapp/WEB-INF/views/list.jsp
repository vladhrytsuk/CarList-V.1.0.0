<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>CarList</title>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1251" />
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="validate.js"></script>

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

        .center {
            margin: auto;
            width: 1000px;
            height: 400px;
            border: 3px solid #73AD21;
            padding: 10px;
        }

        .deleterow{
            cursor:pointer
        }
    </style>

    <script type='text/javascript'>
        function addToTable() {
            var mark = document.getElementById('mark').value;
            var color = document.getElementById('color').value;
            var vin = document.getElementById('vin').value;
            var miles = document.getElementById('miles').value;
            var car = [];

        $.ajax({
            url: '/list/add',
            type: 'POST',
            contentType : 'application/json',
            data: JSON.stringify({
                    'mark': mark,
                    'color': color,
                    'vin': vin,
                    'miles': miles }),
            success: function(data) {
                car.push(data);
                AddRow('CarDataTable', data);
            }
        });

            function addCol(newRow, columnNum, value) {
                var col = newRow.insertCell(columnNum);

                var DeleteBotton = document.createElement('BUTTON');
                DeleteBotton.innerHTML = 'DELETE';
                //DeleteBotton.setAttribute('indexButton', car[car.length - 1].id);
                DeleteBotton.setAttribute('class', 'deleterow');
                DeleteBotton.addEventListener('click', function() {
                    DeleteRow('CarDataTable', this);
                });

                var EditBotton = document.createElement("BUTTON")
                EditBotton.setAttribute('indexButton', car[car.length - 1].id);
                EditBotton.innerHTML = "EDIT";
                EditBotton.addEventListener('click', function() {
                    alert('I\'m button');
                });

                if(value == 'delete') {
                    col.appendChild(DeleteBotton);
                }
                        else if(value == 'edit') {
                    col.appendChild(EditBotton);
                }
                else col.innerHTML = value;
            }

            function DeleteRow(tableID, $this) {
                var tableElem = document.getElementById(tableID);
                var index = $this.parentNode.parentNode.rowIndex;
                tableElem.deleteRow(index);
            }

            function AddRow(tableID, data) {
                var tableElem = document.getElementById(tableID);
                var newRow = tableElem.insertRow(-1);

                addCol(newRow, 0, data.id);
                addCol(newRow, 1, data.mark);
                addCol(newRow, 2, data.color);
                addCol(newRow, 3, data.vin);
                addCol(newRow, 4, data.miles);
                addCol(newRow, 5, 'edit');
                addCol(newRow, 5, 'delete');
            }

        }
    </script>
</head>
<body>

<table align="center">
            <caption>Add</caption>
            <tr>
                <th>Mark:</th>
                <td><input type="text" id = "mark" value = ${mark}><span style='color:red' id='mark_f'></span></td>
            </tr>
            <tr>
                <th>Color:</th>
                <td><input type="text" id = "color" value = ${color}><span style='color:red' id='color_f'></span></td>

            </tr>
            <tr>
                <th>Vin:</th>
                <td><input type="text" id = "vin" value = ${vin}><span style='color:red' id='vin_f'></span></td>
            </tr>
            <tr>
                <th>Miles</th>
                <td><input type="text" id = "miles" value = ${miles}><span style='color:red' id='miles_f'></span></td>
            </tr>
            <tr>
                <td><input type="submit" id = "add" value = "ADD" onclick="addToTable()"></td>
            </tr>
        </table> <br><br>

 <div class = "center" id="addList" >
    <table align="center" id="CarDataTable">
        <caption>Project CarList</caption>
        <tr>
            <th width="330">Id</th>
            <th width="158">Mark</th>
            <th width="128">Color</th>
            <th width="161">Vin</th>
            <th width="108">Miles</th>
            <th width="142" colspan="2">Delete/Edit</th>
        </tr>
    </table>
</div>

</body>
</html>
