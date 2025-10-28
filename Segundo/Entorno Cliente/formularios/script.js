const form = document.getElementById('form');
const nombreusuario = document.getElementById('nombreusuario');
const email = document.getElementById('email');
const password = document.getElementById('password');
const password2 = document.getElementById('password2');

//funciones
function mostarError(input, mensaje) {
    const formControl = input.parentElement;
    formControl.className = 'form-control error';
    const label = formControl.querySelector('label');
    const small = formControl.querySelector('small');
    small.innerText = label.innerText + ' ' + mensaje;
}

function mostarCorrecto(input) {
    const formControl = input.parentElement;
    formControl.className = 'form-control correcto';
}

function validarEmail(email) {
    const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

function esObligatorio(inputArray) {
    inputArray.forEach(input => {
        if(input.value.trim() === '') {
            mostarError(input, 'es obligatorio');
        } else {
            mostarCorrecto(input);
        }
    });
}

// event listener
form.addEventListener('submit', (e) => {
    e.preventDefault();


    
    if (!validarEmail(email.value)) {
        mostarError(email, 'El email no es válido');
    } else {
        mostarCorrecto(email);
    }
    esObligatorio([nombreusuario, password, password2]);
});