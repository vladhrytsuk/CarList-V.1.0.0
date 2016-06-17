var cararray = [];
var byf = {};
var byfIndex;

/*Запрос на обновление страницы*/
function show() 
{
    $.ajax({
        url: '/showlist',
        type: 'GET',
        contentType: 'application/json',
        success: function(data)
        {
            for (var i = 0; i < data.length; ++i)
            {
                cararray.push(data[i]);
                AddRow('CarDataTable', data[i]);
            }
        }
    });
}

/*Запрос на добавление новой записи*/
function addToTable()
{
    var mark = document.getElementById('mark').value;
    var color = document.getElementById('color').value;
    var vin = document.getElementById('vin').value;
    var miles = document.getElementById('miles').value;

    $.ajax(
        {
        url: '/list/add',
        type: 'POST',
        contentType : 'application/json',
        data: JSON.stringify(
            {
            'mark': mark,
            'color': color,
            'vin': vin,
            'miles': miles
        }),
        success: function(data)
        {
            cararray.push(data);
            AddRow('CarDataTable', data);
            clearAddInput();
        },
            error: function (data)
            {
                alert('ОШИБКА!');
            }
        }
    );
}

/*Запрос на редактирование записи*/
function EditToTable(edit)
{
    $.ajax(
        {
            url: '/list/edit',
            type: 'POST',
            contentType : 'application/json',
            data: JSON.stringify(edit),
            success: function(data)
            {
                cararray.push(data);
                SaveRow('CarDataTable', data);
            }
        });
}

/*Метод добавление строки*/
function SaveRow(tableID, data)
{
    var saveRow = document.getElementById(tableID).insertRow(byfIndex);

    addCol(saveRow, 0, data.id);
    addCol(saveRow, 1, data.mark);
    addCol(saveRow, 2, data.color);
    addCol(saveRow, 3, data.vin);
    addCol(saveRow, 4, data.miles);
    addCol(saveRow, 5, 'edit');
    addCol(saveRow, 5, 'delete');

    document.getElementById(tableID).deleteRow(byfIndex + 1);
}

/*Метод добавление строки*/
function AddRow(tableID, data)
{
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

/*Метод добавление столбца*/
function addCol(newRow, columnNum, value)
{
    var col = newRow.insertCell(columnNum);

    var DeleteBotton = document.createElement('BUTTON');
    DeleteBotton.innerHTML = 'DELETE';
    DeleteBotton.addEventListener('click', function()
    {
        x = confirm('Вы действительно хотите удалить данный элемент?');
        if (x == true)
        {
            var index = this.parentNode.parentNode.rowIndex;
            var idCar = cararray[index - 1].id;
            $.ajax(
                {
                    url: '/list/delete',
                    type: 'POST',
                    contentType : 'application/json',
                    data: JSON.stringify(
                        {
                            'id': idCar
                        }),
                    success: function(data)
                    {
                        if(data == true)
                        {
                            DeleteRow('CarDataTable', index);
                            alert('Удаление успешно!' + cararray[index - 1].id);
                            delete cararray[index - 1];
                        }
                    },
                    error: function(data)
                    {
                        if(data == false)
                        {
                            alert('Ошибка на сервере!');
                        }
                    }
                });
        }
    });

    var EditBotton = document.createElement("BUTTON")
    EditBotton.innerHTML = "EDIT";
    EditBotton.addEventListener('click', function()
    {
        var index = this.parentNode.parentNode.rowIndex;
        byfIndex = this.parentNode.parentNode.rowIndex;;
        byf = {'id': cararray[index - 1].id, 'mark': cararray[index - 1].mark, 'color': cararray[index - 1].color, 'vin': cararray[index - 1].vin, 'miles': cararray[index - 1].miles};
        EditRow('CarDataTable', index, byf);
    });

    if(value == 'delete')
    {
        col.appendChild(DeleteBotton);
    }

    else if(value == 'edit')
    {
        col.appendChild(EditBotton);
    }

    else col.innerHTML = value;
}

/*Метод для редактирования строки*/
function EditRow(tableID, index, byf)
{
    var tableElem = document.getElementById(tableID);
    var oldRow = tableElem.insertRow(index);

    var EditInputTextMARK = document.createElement('input');
    EditInputTextMARK.setAttribute('type', 'text');
    EditInputTextMARK.setAttribute('id', 'saveMark');
    EditInputTextMARK.setAttribute('value', '');

    var EditInputTextCOLOR = document.createElement('input');
    EditInputTextCOLOR.setAttribute('type', 'text');
    EditInputTextCOLOR.setAttribute('id', 'saveColor');
    EditInputTextCOLOR.setAttribute('value', '');

    var EditInputTextVIN = document.createElement('input');
    EditInputTextVIN.setAttribute('type', 'text');
    EditInputTextVIN.setAttribute('id', 'saveVin');
    EditInputTextVIN.setAttribute('value', '');

    var EditInputTextMILES = document.createElement('input');
    EditInputTextMILES.setAttribute('type', 'text');
    EditInputTextMILES.setAttribute('id', 'saveMiles');
    EditInputTextMILES.setAttribute('value', '');

    editCol(oldRow, 0, byf.id);
    editCol(oldRow, 1, EditInputTextMARK);
    editCol(oldRow, 2, EditInputTextCOLOR);
    editCol(oldRow, 3, EditInputTextVIN);
    editCol(oldRow, 4, EditInputTextMILES);
    editCol(oldRow, 5, 'save');
    editCol(oldRow, 5, 'cancel');

    var tableElem = document.getElementById(tableID);
    tableElem.deleteRow(index + 1);
}

/*Метод для редактирования столбца*/
function editCol(oldRow, columnNum, value)
{
    var col = oldRow.insertCell(columnNum);

    var SaveBotton = document.createElement('BUTTON');
    SaveBotton.innerHTML = 'SAVE';
    SaveBotton.addEventListener('click', function()
    {
        x = confirm('Вы действительно хотите редактировать данный элемент?');
        if (x == true)
        {
            var id = byf.id;
            var mark = document.getElementById('saveMark').value;
            var color = document.getElementById('saveColor').value;
            var vin = document.getElementById('saveVin').value;
            var miles = document.getElementById('saveMiles').value;
            var edit = {'id': id, 'mark': mark, 'color': color, 'vin': vin, 'miles': miles};
            EditToTable(edit);
        }
    });

    var CancelBotton = document.createElement("BUTTON")
    CancelBotton.innerHTML = "CANCEL";
    CancelBotton.addEventListener('click', function()
    {
        var cancleRow = document.getElementById('CarDataTable').insertRow(byfIndex);

        addCol(cancleRow, 0, byf.id);
        addCol(cancleRow, 1, byf.mark);
        addCol(cancleRow, 2, byf.color);
        addCol(cancleRow, 3, byf.vin);
        addCol(cancleRow, 4, byf.miles);
        addCol(cancleRow, 5, 'edit');
        addCol(cancleRow, 5, 'delete');

        document.getElementById('CarDataTable').deleteRow(byfIndex + 1);

    });

    if(value == 'save')
    {
        col.appendChild(SaveBotton);
    }

    else if(value == 'cancel')
    {
        col.appendChild(CancelBotton);
    }

    else if (value == byf.id)
    {
        col.innerHTML = value;
    }
    else col.appendChild(value);
}

/*Метод удаления строки*/
function DeleteRow(tableID, index)
{
    var tableElem = document.getElementById(tableID);
    tableElem.deleteRow(index);
}

function clearAddInput()
{
    document.getElementById('mark').value='';
    document.getElementById('color').value='';
    document.getElementById('vin').value='';
    document.getElementById('miles').value='';
}
