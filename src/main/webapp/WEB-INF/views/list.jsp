<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/table.css">
    <title>CarList</title>
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
                <td><input type="button" id = "addrow" value = "ADD" /></td>
            </tr>
        </table> <br><br>

 <div class = "center" id="addList" class =  >
    <table align="center" id="CarDataTable">
        <caption>Project CarList</caption>
        <tr>
            <th width="330">Id</th>
            <th width="158">Mark</th>
            <th width="128">Color</th>
            <th width="161">Vin</th>
            <th width="108">Miles</th>
            <th width="182" colspan="2">Delete/Edit</th>
        </tr>
    </table>
</div>

<meta http-equiv="Content-Type" content="text/html; charset=windows-1251" />
<script type="text/javascript" src="/resources/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="/resources/js/table.js"></script>
<script type="text/javascript" src="/resources/js/validate.js"></script>
<script type="text/javascript">
/*    $(window).load(function ()
    {
        $.ajax({
            url: '/showlist',
            type: 'GET',
            contentType: 'application/json',
            success: function(data)
            {
                for (var i = 0; i < data.length; ++i)
                {
                    AddRow('CarDataTable', data[i]);
                }
            }
        });
    });*/

    $("#addrow").click(function ()
    {
        if (validateAdd() == true)
        {
            addToTable();
        }
     });

    window.onload = function()
    {
        show();
    };

</script>

</body>
</html>
