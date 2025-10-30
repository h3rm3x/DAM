const contenedorPopup = document.querySelector('.contenedor-popup');
const button = document.querySelector('button');
const popup = document.querySelector('.popup');
const cerrarPopup = document.querySelector('.cierra-popup');
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

function validarEmail(input) {
    const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    //return re.test(String(input.value).toLowerCase());
    if (re.test(String(input.value).toLowerCase())) {
        mostarCorrecto(input);
    } else {
        mostarError(input, 'El email no es válido');
    }
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

function validarLongitud(input, min, max) {
    if(input.value.length < min) {
        mostarError(input, `debe tener al menos ${min} caracteres`);
    } else if(input.value.length > max) {
        mostarError(input, `debe tener menos de ${max} caracteres`);
    } else {
        mostarCorrecto(input);
    }
}

function comprobarPasswords(password1, password2) {
    if(password1.value !== password2.value) {
        mostarError(password2, 'Las contraseñas no coinciden');
    }
}

function comprobarlongitud(arrayLongitud) {
    arrayLongitud.forEach(obj => {
        validarLongitud(obj.input, obj.min, obj.max);
    });
}

// event listener
form.addEventListener('submit', (e) => {
    e.preventDefault();  

    if (document.querySelectorAll('.form-control.error').length === 0) {
        contenedorPopup.style.display = 'none';
        
        const mensajeExito = document.createElement('div');
        mensajeExito.innerText = 'Formulario enviado correctamente: '+ nombreusuario.value+', '+email.value;
        document.body.appendChild(mensajeExito);
        document.body.style.fontSize = '20px';
        mensajeExito.style.color = 'green';
        mensajeExito.style.display = 'inline';
        setTimeout(() => {
            mensajeExito.style.display = 'none';
        }, 10000);
    }
    form.reset();

});

form.addEventListener('input', () => {
    esObligatorio([nombreusuario, email, password, password2]);
    comprobarlongitud([
        {input: nombreusuario, min: 3, max: 15},
        {input: password, min: 8, max: 16},
        {input: password2, min: 8, max: 16}
    ]);
    validarEmail(email);
    comprobarPasswords(password, password2);
});


button.addEventListener('click', () => {
    contenedorPopup.style.display = 'flex';
});

cerrarPopup.addEventListener('click', () => {
    contenedorPopup.style.display = 'none';
    form.reset();
    
});
contenedorPopup.addEventListener('click', (event) => {
    if (popup.contains(event.target) === false) {
        contenedorPopup.style.display = 'none';
    }
});