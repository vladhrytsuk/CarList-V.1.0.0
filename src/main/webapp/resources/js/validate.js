function validateAdd(){
        var mark = document.getElementById('mark').value;
        var color = document.getElementById('color').value;
        var vin = document.getElementById('vin').value;
        var miles = document.getElementById('miles').value;
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
    return true;
    }