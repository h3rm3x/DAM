const numero1 = $('#numero1');
const numero2 = $('#numero2');
const resultat = $('#resultat');
const msgError = $('#msgError');
const botoCalcular = $('#calcular');
botoCalcular.on('click', () => {
    const operacion = $('#operacion').val();
    if (isNumeric(numero1.val()) && isNumeric(numero2.val())) {
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
    setTimeout(() => {
        resultat.text('');
    }, 5000);

});

numero1.on('keyup', () => {
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

numero2.on('keyup', () => {
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