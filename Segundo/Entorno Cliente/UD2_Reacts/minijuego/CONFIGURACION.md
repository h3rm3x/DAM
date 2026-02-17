# 🎮 Minijuegos con Premios - Guía de Configuración

## 📋 Descripción del Proyecto

Este proyecto contiene dos minijuegos interactivos donde los usuarios pueden ganar premios mediante una ruleta:

1. **Juego de Memoria** 🎴 - Encuentra los pares de productos
2. **Juego de Palabras** 📝 - Adivina palabras con pistas

Al completar cualquiera de los juegos, el usuario puede girar una ruleta para ganar premios (cupones de descuento o descuentos porcentuales).

---

## 🚀 Instalación

### 1. Instalar dependencias

```bash
npm install
```

### 2. Estructura de carpetas requerida

Asegúrate de tener la siguiente estructura:

```
minijuego/
├── public/
│   └── img/
│       ├── logo_con_slogan.PNG      (Logo para el reverso de las cartas)
│       ├── producto1.jpg            (Imágenes de productos 1-8)
│       ├── producto2.jpg
│       ├── producto3.jpg
│       ├── producto4.jpg
│       ├── producto5.jpg
│       ├── producto6.jpg
│       ├── producto7.jpg
│       └── producto8.jpg
├── src/
│   ├── components/
│   ├── pages/
│   ├── services/
│   └── ...
└── ...
```

---

## 🖼️ Configuración de Imágenes

### Imágenes Requeridas

#### **Logo (Reverso de cartas)**
- **Archivo**: `public/img/logo_con_slogan.PNG`
- **Descripción**: Logo que aparece en el reverso de las cartas del juego de memoria
- **Dimensiones recomendadas**: 400x400px
- **Formato**: PNG, JPG

#### **Productos (Frente de cartas)**
Se necesitan **8 imágenes de productos** para el juego de memoria:

- `public/img/producto1.jpg` - Producto 1
- `public/img/producto2.jpg` - Producto 2
- `public/img/producto3.jpg` - Producto 3
- `public/img/producto4.jpg` - Producto 4
- `public/img/producto5.jpg` - Producto 5
- `public/img/producto6.jpg` - Producto 6
- `public/img/producto7.jpg` - Producto 7
- `public/img/producto8.jpg` - Producto 8

**Especificaciones:**
- **Dimensiones recomendadas**: 400x400px o proporción 1:1
- **Formato**: JPG, PNG
- **Tamaño de archivo**: Máximo 200KB por imagen (optimizadas para web)
- **Contenido**: Imágenes de productos de tu tienda online

### Cómo agregar las imágenes:

1. Crea la carpeta `public/img/` si no existe:
   ```bash
   mkdir -p public/img
   ```

2. Coloca todas las imágenes en `public/img/`

3. Asegúrate de que los nombres coincidan exactamente con los especificados arriba

### Placeholder Temporal

Si no tienes las imágenes todavía, puedes usar imágenes temporales:

1. Descarga imágenes placeholder de:
   - [Unsplash](https://unsplash.com/)
   - [Pexels](https://www.pexels.com/)
   - [Placeholder.com](https://placeholder.com/)

2. Renombra las imágenes según la nomenclatura especificada

---

## 🗄️ Configuración de Base de Datos

### Paso 1: Elegir tu tipo de base de datos

El proyecto soporta múltiples opciones:

#### Opción A: JSON Server (Local - Recomendado para desarrollo)

1. Instalar json-server:
   ```bash
   npm install -g json-server
   ```

2. Crear archivo `db.json` en la raíz del proyecto:
   ```json
   {
     "productos": [
       { "id": 1, "nombre": "Producto 1", "imagen": "/img/producto1.jpg", "precio": 29.99 },
       { "id": 2, "nombre": "Producto 2", "imagen": "/img/producto2.jpg", "precio": 39.99 },
       { "id": 3, "nombre": "Producto 3", "imagen": "/img/producto3.jpg", "precio": 19.99 },
       { "id": 4, "nombre": "Producto 4", "imagen": "/img/producto4.jpg", "precio": 49.99 },
       { "id": 5, "nombre": "Producto 5", "imagen": "/img/producto5.jpg", "precio": 24.99 },
       { "id": 6, "nombre": "Producto 6", "imagen": "/img/producto6.jpg", "precio": 34.99 },
       { "id": 7, "nombre": "Producto 7", "imagen": "/img/producto7.jpg", "precio": 44.99 },
       { "id": 8, "nombre": "Producto 8", "imagen": "/img/producto8.jpg", "precio": 54.99 }
     ],
     "palabras": [
       { "id": 1, "palabra": "TIENDA", "pista": "Lugar donde se compra" },
       { "id": 2, "palabra": "PRODUCTO", "pista": "Artículo que se vende" },
       { "id": 3, "palabra": "DESCUENTO", "pista": "Reducción del precio" },
       { "id": 4, "palabra": "COMPRA", "pista": "Acción de adquirir" },
       { "id": 5, "palabra": "CLIENTE", "pista": "Persona que compra" },
       { "id": 6, "palabra": "PRECIO", "pista": "Valor monetario" },
       { "id": 7, "palabra": "OFERTA", "pista": "Promoción especial" },
       { "id": 8, "palabra": "PEDIDO", "pista": "Solicitud de productos" },
       { "id": 9, "palabra": "ENVIO", "pista": "Transporte del producto" },
       { "id": 10, "palabra": "CARRITO", "pista": "Contenedor de compras" }
     ],
     "premios": [
       { "id": 1, "tipo": "cupon", "valor": 10, "nombre": "Cupón 10€", "color": "#FFD700" },
       { "id": 2, "tipo": "descuento", "valor": 15, "nombre": "15% Descuento", "color": "#FF6347" },
       { "id": 3, "tipo": "cupon", "valor": 25, "nombre": "Cupón 25€", "color": "#4CAF50" },
       { "id": 4, "tipo": "descuento", "valor": 20, "nombre": "20% Descuento", "color": "#2196F3" },
       { "id": 5, "tipo": "cupon", "valor": 5, "nombre": "Cupón 5€", "color": "#9C27B0" },
       { "id": 6, "tipo": "descuento", "valor": 10, "nombre": "10% Descuento", "color": "#FF9800" },
       { "id": 7, "tipo": "cupon", "valor": 15, "nombre": "Cupón 15€", "color": "#E91E63" },
       { "id": 8, "tipo": "descuento", "valor": 25, "nombre": "25% Descuento", "color": "#00BCD4" }
     ],
     "premios-ganados": []
   }
   ```

3. Iniciar json-server:
   ```bash
   json-server --watch db.json --port 3000
   ```

4. En `src/services/dbService.js`, verifica que la URL sea:
   ```javascript
   const URL_BASE_DATOS = "http://localhost:3000";
   ```

#### Opción B: Firebase

1. Crear proyecto en [Firebase Console](https://console.firebase.google.com/)

2. Configurar Firestore Database

3. Instalar Firebase:
   ```bash
   npm install firebase
   ```

4. Crear `src/firebase/config.js`:
   ```javascript
   import { initializeApp } from 'firebase/app';
   import { getFirestore } from 'firebase/firestore';

   const firebaseConfig = {
     apiKey: "TU_API_KEY",
     authDomain: "TU_AUTH_DOMAIN",
     projectId: "TU_PROJECT_ID",
     storageBucket: "TU_STORAGE_BUCKET",
     messagingSenderId: "TU_MESSAGING_SENDER_ID",
     appId: "TU_APP_ID"
   };

   const app = initializeApp(firebaseConfig);
   export const db = getFirestore(app);
   ```

5. Actualizar `src/services/dbService.js` para usar Firebase

#### Opción C: API REST Propia

1. En `src/services/dbService.js`, cambia la URL:
   ```javascript
   const URL_BASE_DATOS = "https://tu-api.com/api";
   ```

2. Asegúrate de que tu API tenga los endpoints:
   - `GET /productos`
   - `GET /palabras`
   - `GET /premios`
   - `POST /premios-ganados`

---

## 🎮 Uso

### Desarrollo

1. Iniciar el servidor de desarrollo:
   ```bash
   npm run dev
   ```

2. Si usas JSON Server, inícialo en otra terminal:
   ```bash
   json-server --watch db.json --port 3000
   ```

3. Abre [http://localhost:5173](http://localhost:5173) en tu navegador

### Producción

1. Construir el proyecto:
   ```bash
   npm run build
   ```

2. El proyecto compilado estará en la carpeta `dist/`

---

## 📝 Personalización

### Modificar Productos

Edita `db.json` (si usas JSON Server) o tu base de datos:

```json
{
  "productos": [
    {
      "id": 1,
      "nombre": "Tu Producto",
      "imagen": "/img/tuproducto.jpg",
      "precio": 99.99
    }
  ]
}
```

### Modificar Palabras

Agrega o modifica palabras en tu base de datos:

```json
{
  "palabras": [
    {
      "id": 1,
      "palabra": "PALABRA",
      "pista": "Tu pista aquí"
    }
  ]
}
```

### Modificar Premios

Personaliza los premios de la ruleta:

```json
{
  "premios": [
    {
      "id": 1,
      "tipo": "cupon",           // "cupon" o "descuento"
      "valor": 50,                // Valor numérico
      "nombre": "Cupón 50€",      // Nombre descriptivo
      "color": "#FFD700"          // Color hexadecimal
    }
  ]
}
```

---

## 🎨 Colores del Proyecto

El proyecto usa variables CSS que puedes modificar en `src/index.css`:

```css
:root {
  --orange: #ff8800;           /* Color principal (naranja)
  --dark_blue: #1b1523;         /* Fondo oscuro */
  --anti-flash-white: #f0f0f0; /* Texto claro */
}
```

---

## 🐛 Solución de Problemas

### Las imágenes no se muestran

1. Verifica que las imágenes estén en `public/img/`
2. Verifica que los nombres coincidan exactamente
3. Borra la caché del navegador (Ctrl + Shift + R)

### Error de conexión a la base de datos

1. Verifica que json-server esté ejecutándose
2. Comprueba que la URL en `dbService.js` sea correcta
3. Revisa la consola del navegador para errores específicos

### Los datos de ejemplo se muestran en lugar de los reales

Esto es normal si la conexión a la base de datos falla. El proyecto usa datos de ejemplo como fallback para que puedas seguir trabajando.

---

## 📦 Estructura del Proyecto

```
minijuego/
├── public/
│   └── img/                    # Imágenes del juego
├── src/
│   ├── components/             # Componentes reutilizables
│   │   ├── Carta.jsx          # Componente de carta para memoria
│   │   ├── Carta.css
│   │   ├── Ruleta.jsx         # Componente de ruleta de premios
│   │   └── Ruleta.css
│   ├── pages/                  # Páginas de los juegos
│   │   ├── JuegoMemory.jsx    # Juego de memoria
│   │   ├── JuegoMemory.css
│   │   ├── JuegoPalabras.jsx  # Juego de palabras
│   │   └── JuegoPalabras.css
│   ├── services/               # Servicios de datos
│   │   └── dbService.js       # Servicio de base de datos
│   ├── App.jsx                 # Componente principal
│   ├── App.css
│   ├── main.jsx
│   └── index.css
├── db.json                     # Base de datos local (JSON Server)
└── package.json
```

---

## 🔐 Variables de Entorno (Opcional)

Para mayor seguridad, puedes usar variables de entorno:

1. Crear archivo `.env` en la raíz:
   ```
   VITE_API_URL=http://localhost:3000
   ```

2. En `dbService.js`:
   ```javascript
   const URL_BASE_DATOS = import.meta.env.VITE_API_URL || "http://localhost:3000";
   ```

---

## 📞 Soporte

Si tienes problemas o preguntas:

1. Revisa esta documentación
2. Consulta la consola del navegador para errores
3. Verifica que todas las dependencias estén instaladas
4. Asegúrate de que json-server esté ejecutándose (si lo usas)

---

## 📄 Licencia

Este proyecto es parte del curso de Desarrollo Web. Úsalo libremente para aprender y practicar.

---

¡Disfruta creando tu aplicación de minijuegos! 🎮🎉
