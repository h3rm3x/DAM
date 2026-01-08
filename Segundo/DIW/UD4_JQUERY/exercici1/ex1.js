const numero1 = $('#numero1');
const numero2 = $('#numero2');
const resultat = $('#resultat');
const botoCalcular = $('#calcular');
const operacion = $('#operacion').val();

botoCalcular.on('click', () => {
    if (!isNaN(parseFloat(numero1.val())) && !isNaN(parseFloat(numero2.val()))) {
        switch (operacion) {
            case 'suma':
                resultat.text(`El resultat de la suma és: ${parseFloat(numero1.val()) + parseFloat(numero2.val())}`);
                resultat.css('color', 'green');
                break;
            case 'resta':
                resultat.text(`El resultat de la resta és: ${parseFloat(numero1.val()) - parseFloat(numero2.val())}`);
                resultat.css('color', 'green'); 
                break;
            case 'multiplicacio':
                resultat.text(`El resultat de la multiplicació és: ${parseFloat(numero1.val()) * parseFloat(numero2.val())}`);
                resultat.css('color', 'green');
                break;
            case 'divisio':
                if (parseFloat(numero2.val()) !== 0) {
                    resultat.text(`El resultat de la divisió és: ${parseFloat(numero1.val()) / parseFloat(numero2.val())}`);
                    resultat.css('color', 'green');
                } else {
                    resultat.text('Error: No es pot dividir per zero.');
                    resultat.css('color', 'red');
                }
                break;
        }
    } else {
        resultat.text('Si us plau, introdueix números vàlids.');
        resultat.css('color', 'red');
    }

});