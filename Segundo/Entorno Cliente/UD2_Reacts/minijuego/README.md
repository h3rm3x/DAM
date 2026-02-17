# 🎮 Minijuegos con Premios

Proyecto de minijuegos interactivos con sistema de recompensas mediante ruleta. Desarrollado con React + Vite.

## ✨ Características

- **Juego de Memoria** 🎴: Encuentra los pares de productos de la tienda
- **Juego de Palabras** 📝: Adivina palabras con pistas (tipo ahorcado)
- **Ruleta de Premios** 🎰: Gira la ruleta al ganar y obtén cupones o descuentos
- **Interfaz dinámica y responsive**
- **Conexión a base de datos** (con datos de ejemplo de fallback)

## 🚀 Inicio Rápido

### 1. Instalar dependencias

```bash
npm install
```

### 2. Configurar imágenes

Crea las siguientes imágenes en `public/img/`:
- `logo_con_slogan.PNG` - Logo para el reverso de las cartas
- `producto1.jpg` hasta `producto8.jpg` - Imágenes de productos

### 3. Configurar base de datos (Opcional)

#### Opción A: JSON Server (Recomendado para desarrollo)

```bash
# Instalar json-server globalmente
npm install -g json-server

# Iniciar el servidor (el archivo db.json ya está incluido)
json-server --watch db.json --port 3000
```

#### Opción B: Usar datos de ejemplo

Si no configuras una base de datos, el proyecto usará datos de ejemplo automáticamente.

### 4. Iniciar la aplicación

```bash
npm run dev
```

La aplicación estará disponible en [http://localhost:5173](http://localhost:5173)

## 📚 Documentación Completa

Para instrucciones detalladas de configuración, consulta **[CONFIGURACION.md](./CONFIGURACION.md)**

Incluye:
- ✓ Configuración de imágenes
- ✓ Configuración de base de datos (JSON Server, Firebase, API REST)
- ✓ Personalización de productos, palabras y premios
- ✓ Solución de problemas
- ✓ Estructura del proyecto

## 🎯 Cómo Jugar

1. **Elige un juego** desde el menú principal
2. **Completa el desafío**:
   - **Memoria**: Encuentra todos los pares de productos
   - **Palabras**: Adivina la palabra antes de completar el dibujo
3. **Gira la ruleta** para ganar tu premio
4. **Recibe tu cupón o descuento**

## 🛠️ Tecnologías Utilizadas

- **React 19.2.0** - Biblioteca de UI
- **Vite 7.2.4** - Build tool y dev server
- **CSS3** - Estilos y animaciones
- **JSON Server** - Base de datos de desarrollo (opcional)

## 📂 Estructura del Proyecto

```
minijuego/
├── public/
│   └── img/                    # Imágenes del juego
├── src/
│   ├── components/             # Componentes reutilizables
│   │   ├── Carta.jsx          # Carta del juego de memoria
│   │   └── Ruleta.jsx         # Ruleta de premios
│   ├── pages/                  # Páginas de los juegos
│   │   ├── JuegoMemory.jsx    # Juego de memoria
│   │   └── JuegoPalabras.jsx  # Juego de palabras
│   ├── services/               # Servicios
│   │   └── dbService.js       # Conexión a base de datos
│   ├── App.jsx                 # Componente raíz
│   └── main.jsx                # Punto de entrada
├── db.json                     # Base de datos JSON Server
└── CONFIGURACION.md            # Documentación detallada
```

## 🎨 Personalización

### Cambiar colores

Edita las variables CSS en `src/index.css`:

```css
:root {
  --orange: #ff8800;
  --dark_blue: #1b1523;
  --anti-flash-white: #f0f0f0;
}
```

### Modificar productos

Edita `db.json` o tu base de datos para cambiar productos, palabras o premios.

## 🧪 Scripts Disponibles

```bash
npm run dev      # Modo desarrollo
npm run build    # Compilar para producción
npm run preview  # Vista previa de la build
npm run lint     # Ejecutar linter
```

## 📝 Notas Importantes

- **Imágenes**: Asegúrate de añadir las imágenes en `public/img/` antes de ejecutar
- **Base de datos**: Si no configuras una base de datos, se usarán datos de ejemplo
- **JSON Server**: Debe ejecutarse en puerto 3000 si lo usas

## 🐛 Solución de Problemas

### Las imágenes no aparecen
- Verifica que estén en `public/img/`
- Verifica que los nombres coincidan exactamente
- Borra la caché del navegador

### No se conecta a la base de datos
- Verifica que json-server esté ejecutándose
- Comprueba la URL en `src/services/dbService.js`
- Los datos de ejemplo se usarán como fallback

## 📄 Licencia

Proyecto educativo - Desarrollo de Aplicaciones Web

---

Desarrollado con ❤️ usando React + Vite

```js
export default defineConfig([
  globalIgnores(['dist']),
  {
    files: ['**/*.{ts,tsx}'],
    extends: [
      // Other configs...

      // Remove tseslint.configs.recommended and replace with this
      tseslint.configs.recommendedTypeChecked,
      // Alternatively, use this for stricter rules
      tseslint.configs.strictTypeChecked,
      // Optionally, add this for stylistic rules
      tseslint.configs.stylisticTypeChecked,

      // Other configs...
    ],
    languageOptions: {
      parserOptions: {
        project: ['./tsconfig.node.json', './tsconfig.app.json'],
        tsconfigRootDir: import.meta.dirname,
      },
      // other options...
    },
  },
])
```

You can also install [eslint-plugin-react-x](https://github.com/Rel1cx/eslint-react/tree/main/packages/plugins/eslint-plugin-react-x) and [eslint-plugin-react-dom](https://github.com/Rel1cx/eslint-react/tree/main/packages/plugins/eslint-plugin-react-dom) for React-specific lint rules:

```js
// eslint.config.js
import reactX from 'eslint-plugin-react-x'
import reactDom from 'eslint-plugin-react-dom'

export default defineConfig([
  globalIgnores(['dist']),
  {
    files: ['**/*.{ts,tsx}'],
    extends: [
      // Other configs...
      // Enable lint rules for React
      reactX.configs['recommended-typescript'],
      // Enable lint rules for React DOM
      reactDom.configs.recommended,
    ],
    languageOptions: {
      parserOptions: {
        project: ['./tsconfig.node.json', './tsconfig.app.json'],
        tsconfigRootDir: import.meta.dirname,
      },
      // other options...
    },
  },
])
```
