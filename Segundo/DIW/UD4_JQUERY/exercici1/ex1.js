const numero1 = $('#numero1');
const numero2 = $('#numero2');
const resultat = $('#resultat');
const msgError = $('#msgError');
const botoCalcular = $('#calcular');
if (numero2.val() === '' || numero2.val() === null) {
    numero2.val('0');
}
if (numero1.val() === '' || numero1.val() === null) {
    numero1.val('0');
}
botoCalcular.on('click', () => {
    const operacion = $('#operacion').val();
    if (isNumeric(numero1.val()) && isNumeric(numero2.val())) {
        switch (operacion) {
            case 'suma':
                resultat.text(`El resultat de la suma és: ${parseFloat(numero1.val()) + parseFloat(numero2.val())}`);
                break;
            case 'resta':
                resultat.text(`El resultat de la resta és: ${parseFloat(numero1.val()) - parseFloat(numero2.val())}`);
                break;
            case 'multiplicacio':
                resultat.text(`El resultat de la multiplicació és: ${parseFloat(numero1.val()) * parseFloat(numero2.val())}`);
                break;
            case 'divisio':
                if (parseFloat(numero2.val()) !== 0) {
                    resultat.text(`El resultat de la divisió és: ${parseFloat(numero1.val()) / parseFloat(numero2.val())}`);
                } else {
                    msgError.text('Error: No es pot dividir per zero.');
                    resultat.text('Resultat:'+ NaN);
                    resultat.css('color', 'red');
                    msgError.css('color', 'red');
                }
                break;
        }
    } else {
        msgError.text('Si us plau, introdueix números vàlids.');
        msgError.css('color', 'red');
        resultat.text('Resultat:');
    }

});

numero1.on('blur', () => {
    if (!isNumeric(numero1.val())) {
        msgError.text('Si us plau, introdueix números vàlids.');
        resultat.text('Resultat:' + NaN);
        resultat.css('color', 'red');
        botoCalcular.prop('disabled', true);
        msgError.css('color', 'red');
        numero1.css('border-color', 'red');
    } else {
        msgError.text('');
        numero1.css('border-color', '');
    }
    
});

numero2.on('blur', () => {
    if (!isNumeric(numero2.val())) {
        msgError.text('Si us plau, introdueix números vàlids.');
        msgError.css('color', 'red');
        resultat.text('Resultat:' + NaN);
        numero2.css('border-color', 'red');
        botoCalcular.prop('disabled', true);
    } else {    
        msgError.text('');
        numero2.css('border-color', '');
        botoCalcular.prop('disabled', false);
    }
});

function isNumeric(numero) {
    return !isNaN(parseFloat(numero)) && isFinite(numero);
}