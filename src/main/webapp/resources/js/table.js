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

    function deleteToTable() {
        var id = car[0].id;
        $.ajax({
            url: '/list/delete',
            type: 'POST',
            contentType : 'application/json',
            data: JSON.stringify({
                'id': id}),
            success: function(data) {
                if(data == true) {
                    DeleteRow('CarDataTable', this);
                } 
            },
            error: function(data) {
                if(data == false) {
                    alert('Ошибка на сервере!');
                }
            }
        });
    }

    function addCol(newRow, columnNum, value) {
        var col = newRow.insertCell(columnNum);

        var DeleteBotton = document.createElement('BUTTON');
        DeleteBotton.innerHTML = 'DELETE';
        //DeleteBotton.setAttribute('indexButton', car[car.length - 1].id);
        DeleteBotton.setAttribute('class', 'deleterow');
        DeleteBotton.addEventListener('click', function() {
            x = confirm('Вы действительно хотите удалить данный элемент?');
            if (x == true) {
                deleteToTable();
            }
        });

        var EditBotton = document.createElement("BUTTON")
        EditBotton.innerHTML = "EDIT";
        EditBotton.addEventListener('click', function() {
            EditRow('CarDataTable', this, car);
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
        delete car[index - 1];
    }

    function EditRow(tableID, $this, car) {
        var tableElem = document.getElementById(tableID);
        var index = $this.parentNode.parentNode.rowIndex;
        var oldRow = tableElem.insertRow(index);

        var EditInputTextMARK = document.createElement('input');
        EditInputTextMARK.setAttribute('type', 'text');
        EditInputTextMARK.setAttribute('id', 'mark');
        EditInputTextMARK.setAttribute('value', '');

        var EditInputTextCOLOR = document.createElement('input');
        EditInputTextCOLOR.setAttribute('type', 'text');
        EditInputTextCOLOR.setAttribute('id', 'color');
        EditInputTextCOLOR.setAttribute('value', '');

        var EditInputTextVIN = document.createElement('input');
        EditInputTextVIN.setAttribute('type', 'text');
        EditInputTextVIN.setAttribute('id', 'vin');
        EditInputTextVIN.setAttribute('value', '');

        var EditInputTextMILES = document.createElement('input');
        EditInputTextMILES.setAttribute('type', 'text');
        EditInputTextMILES.setAttribute('id', 'miles');
        EditInputTextMILES.setAttribute('value', '');

        editCol(oldRow, 0, car[0].id);
        editCol(oldRow, 1, EditInputTextMARK);
        editCol(oldRow, 2, EditInputTextCOLOR);
        editCol(oldRow, 3, EditInputTextVIN);
        editCol(oldRow, 4, EditInputTextMILES);
        editCol(oldRow, 5, 'save');
        editCol(oldRow, 5, 'cancel');

        var tableElem = document.getElementById(tableID);
        var index = $this.parentNode.parentNode.rowIndex;
        tableElem.deleteRow(index);
        delete car[index - 1];
    }

    function editCol(oldRow, columnNum, value) {
        var col = oldRow.insertCell(columnNum);

        var SaveBotton = document.createElement('BUTTON');
        SaveBotton.innerHTML = 'SAVE';
        SaveBotton.setAttribute('class', 'deleterow');
        SaveBotton.addEventListener('click', function() {
            x = confirm('Вы действительно хотите редактировать данный элемент?');
            if (x == true) {
                alert('Редактирование');
            }
        });

        var CancelBotton = document.createElement("BUTTON")
        CancelBotton.innerHTML = "CANCEL";
        CancelBotton.addEventListener('click', function() {
            alert('Отмена');
        });

        if(value == 'save') {
            col.appendChild(SaveBotton);
        }
        else if(value == 'cancel') {
            col.appendChild(CancelBotton);
        }
            else if (value == car[0].id){
            col.innerHTML = value;
        }
        else col.appendChild(value);
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