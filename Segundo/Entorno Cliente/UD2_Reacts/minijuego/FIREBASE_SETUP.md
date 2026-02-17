# Configuración de Firebase para Minijuegos

Este documento describe cómo configurar Firebase para el sistema de autenticación y almacenamiento de premios.

## 📋 Requisitos Previos

- Cuenta de Google/Firebase
- Node.js instalado
- Proyecto de Firebase creado

## 🔧 Pasos de Configuración

### 1. Crear Proyecto en Firebase Console

1. Ve a [Firebase Console](https://console.firebase.google.com/)
2. Haz clic en "Agregar proyecto"
3. Introduce el nombre del proyecto (ej: "minijuego-shop")
4. Sigue los pasos del asistente

### 2. Habilitar Authentication

1. En el menú lateral, ve a **Build > Authentication**
2. Haz clic en "Comenzar"
3. Habilita el método **Email/Contraseña**
4. Guarda los cambios

### 3. Configurar Firestore Database

1. En el menú lateral, ve a **Build > Firestore Database**
2. Haz clic en "Crear base de datos"
3. Selecciona el modo de inicio:
   - **Modo producción** (recomendado para producción)
   - **Modo prueba** (solo para desarrollo)
4. Selecciona la ubicación (ej: europe-west)

### 4. Configurar Reglas de Seguridad

Ve a la pestaña **Reglas** en Firestore y configura las siguientes reglas:

```javascript
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    // Usuarios: solo pueden leer/escribir sus propios datos
    match /usuarios/{userId} {
      allow read: if request.auth != null && request.auth.uid == userId;
      allow write: if request.auth != null && request.auth.uid == userId;
    }
    
    // Historial de premios: solo lectura para el propietario
    match /historialPremios/{premioId} {
      allow read: if request.auth != null && 
                     resource.data.userId == request.auth.uid;
      allow create: if request.auth != null;
    }
  }
}
```

### 5. Obtener Credenciales de Firebase

1. Ve a **Configuración del proyecto** (icono de engranaje)
2. En la pestaña **General**, baja hasta "Tus apps"
3. Haz clic en el icono **</>** (Web)
4. Registra tu app con un nombre (ej: "Minijuegos Web")
5. Copia las credenciales de `firebaseConfig`

### 6. Actualizar el Archivo de Configuración

Edita el archivo `src/firebase/firebase.js` y reemplaza las credenciales:

```javascript
const firebaseConfig = {
  apiKey: "TU_API_KEY",
  authDomain: "tu-proyecto.firebaseapp.com",
  projectId: "tu-proyecto-id",
  storageBucket: "tu-proyecto.firebasestorage.app",
  messagingSenderId: "123456789",
  appId: "1:123456789:web:abc123def456"
};
```

## 📁 Estructura de la Base de Datos

### Colección: `usuarios`

```json
{
  "userId": {
    "email": "usuario@ejemplo.com",
    "nombre": "Nombre Usuario",
    "fechaRegistro": "2024-01-15T10:30:00.000Z",
    "premiosGanados": [
      {
        "id": 1,
        "tipo": "cupon",
        "valor": 10,
        "nombre": "Cupón 10€",
        "color": "#FFD700",
        "juego": "memory",
        "puntuacion": 15,
        "fecha": "2024-01-15T12:45:00.000Z",
        "usado": false
      }
    ]
  }
}
```

### Colección: `historialPremios`

```json
{
  "premioId": {
    "userId": "abc123",
    "id": 1,
    "tipo": "descuento",
    "valor": 15,
    "nombre": "15% Descuento",
    "color": "#FF6347",
    "juego": "palabras",
    "puntuacion": 3,
    "fecha": "2024-01-15T12:45:00.000Z",
    "usado": false
  }
}
```

## 🚀 Despliegue

### Firebase Hosting

Si deseas desplegar en Firebase Hosting:

```bash
# Instalar Firebase CLI
npm install -g firebase-tools

# Login en Firebase
firebase login

# Inicializar (ya hecho)
# firebase init

# Construir la aplicación
npm run build

# Desplegar
firebase deploy
```

## 🔐 Seguridad

### Buenas Prácticas

1. **Nunca compartas** tu archivo `.env` o credenciales en repositorios públicos
2. **Usa variables de entorno** para producción:
   ```javascript
   const firebaseConfig = {
     apiKey: import.meta.env.VITE_FIREBASE_API_KEY,
     authDomain: import.meta.env.VITE_FIREBASE_AUTH_DOMAIN,
     // ...
   };
   ```

3. **Revisa las reglas de seguridad** regularmente
4. **Monitorea el uso** en Firebase Console

## 🔄 Integración con la Tienda Online

El sistema utiliza la misma autenticación de usuarios que la tienda online principal. Los usuarios pueden:

- Registrarse/Iniciar sesión con su cuenta de la tienda
- Ganar premios (cupones y descuentos)
- Ver su historial de premios
- Usar los premios en la tienda online

## 📖 Funcionalidades Implementadas

### Autenticación
- ✅ Registro de usuarios
- ✅ Inicio de sesión
- ✅ Cierre de sesión
- ✅ Persistencia de sesión
- ✅ Contexto de autenticación global

### Premios
- ✅ Guardar premios ganados por usuario
- ✅ Historial de premios
- ✅ Marcado de premios como usados
- ✅ Visualización de premios ganados

### Juegos
- ✅ Juego de Memoria (Memory)
- ✅ Juego de Palabras (Ahorcado)
- ✅ Ruleta de premios
- ✅ Integración con sistema de premios

## 🆘 Solución de Problemas

### Error: "Firebase not initialized"
- Verifica que las credenciales en `firebase.js` son correctas
- Asegúrate de que Firebase está instalado: `npm install firebase`

### Error: "Permission denied"
- Revisa las reglas de seguridad en Firestore
- Verifica que el usuario está autenticado

### Los premios no se guardan
- Abre la consola del navegador para ver errores
- Verifica que Firestore esté habilitado
- Comprueba las reglas de seguridad

## 📞 Soporte

Para más información, consulta la [documentación oficial de Firebase](https://firebase.google.com/docs).
