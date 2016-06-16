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

function addCol(newRow, columnNum, value) {
    var col = newRow.insertCell(columnNum);

    var DeleteBotton = document.createElement('BUTTON');
    DeleteBotton.innerHTML = 'DELETE';
    //DeleteBotton.setAttribute('indexButton', car[car.length - 1].id);
    DeleteBotton.setAttribute('class', 'deleterow');
    DeleteBotton.addEventListener('click', function() {
        x = confirm('Вы действительно хотите удалить данный элемент?');
        if (x == true) {
            document.write('<script type="text/javascript" src="/resources/js/table.js"></script>').DeleteRow('CarDataTable', this);
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
