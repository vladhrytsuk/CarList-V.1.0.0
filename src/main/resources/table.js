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