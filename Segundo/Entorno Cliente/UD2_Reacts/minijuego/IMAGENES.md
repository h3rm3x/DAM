# 🖼️ Guía de Imágenes Requeridas

Esta guía detalla todas las imágenes que necesitas para que el proyecto funcione correctamente.

---

## 📁 Ubicación

Todas las imágenes deben estar en:
```
minijuego/public/img/
```

---

## 📋 Lista de Imágenes Requeridas

### 1. Logo (Reverso de cartas)

**Nombre del archivo:** `logo_con_slogan.PNG`

- **Uso:** Aparece en el reverso de las cartas del juego de memoria
- **Dimensiones recomendadas:** 400x400px
- **Formato:** PNG o JPG
- **Descripción:** Logo de tu tienda online con slogan

### 2. Imágenes de Productos (Frente de cartas)

Se necesitan **8 imágenes de productos**:

| Archivo | Producto |
|---------|----------|
| `producto1.jpg` | Producto 1 de tu tienda |
| `producto2.jpg` | Producto 2 de tu tienda |
| `producto3.jpg` | Producto 3 de tu tienda |
| `producto4.jpg` | Producto 4 de tu tienda |
| `producto5.jpg` | Producto 5 de tu tienda |
| `producto6.jpg` | Producto 6 de tu tienda |
| `producto7.jpg` | Producto 7 de tu tienda |
| `producto8.jpg` | Producto 8 de tu tienda |

**Especificaciones:**
- **Dimensiones recomendadas:** 400x400px (proporción 1:1)
- **Formato:** JPG o PNG
- **Tamaño de archivo:** Máximo 200KB por imagen
- **Fondo:** Preferiblemente blanco o transparente
- **Calidad:** Alta resolución pero optimizada para web

---

## 🎨 Recomendaciones de Diseño

### Para el Logo

1. Debe incluir el nombre de tu tienda
2. Puede incluir un slogan o tagline
3. Colores que contrasten bien con el fondo oscuro del juego
4. Centrado y bien visible

### Para los Productos

1. **Fotografía clara** del producto
2. **Buena iluminación**
3. **Sin textos superpuestos** (precios, etiquetas)
4. **Fondo uniforme** (blanco preferiblemente)
5. **Producto centrado** en la imagen
6. **Productos variados** para que sean fácilmente distinguibles

---

## 🔧 Cómo Añadir las Imágenes

### Paso 1: Crear la carpeta (si no existe)

```bash
# En Windows (PowerShell)
mkdir public\img

# En Mac/Linux (Terminal)
mkdir -p public/img
```

### Paso 2: Copiar las imágenes

1. Prepara tus 9 imágenes (1 logo + 8 productos)
2. Renombra las imágenes según la nomenclatura especificada
3. Copia todas las imágenes a `public/img/`

### Paso 3: Verificar

Estructura final:
```
minijuego/
└── public/
    └── img/
        ├── logo_con_slogan.PNG
        ├── producto1.jpg
        ├── producto2.jpg
        ├── producto3.jpg
        ├── producto4.jpg
        ├── producto5.jpg
        ├── producto6.jpg
        ├── producto7.jpg
        └── producto8.jpg
```

---

## 🆓 Recursos para Imágenes Temporales

Si aún no tienes las imágenes de tus productos, puedes usar placeholders temporales:

### Sitios con imágenes gratuitas:

1. **Unsplash** - https://unsplash.com/
   - Imágenes de alta calidad
   - Libres de derechos
   - Gran variedad de productos

2. **Pexels** - https://www.pexels.com/
   - Fotos y videos gratuitos
   - Buena calidad
   - Fácil descarga

3. **Pixabay** - https://pixabay.com/
   - Millones de imágenes
   - Libre de derechos
   - Búsqueda por categorías

4. **Placeholder.com** - https://placeholder.com/
   - Placeholders simples
   - Personalizable por tamaño
   - Útil para testing

### Ejemplo de búsqueda:

Busca términos como:
- "product white background"
- "ecommerce product"
- "online shop item"
- "store product"

---

## 🎯 Optimización de Imágenes

### Herramientas online gratuitas:

1. **TinyPNG** - https://tinypng.com/
   - Comprime PNG y JPG
   - Mantiene la calidad
   - Gratis hasta 20 imágenes

2. **Squoosh** - https://squoosh.app/
   - By Google
   - Muy potente
   - Control total de la compresión

3. **ImageOptim** - https://imageoptim.com/
   - Para Mac
   - Muy fácil de usar
   - Arrastra y suelta

### Pasos para optimizar:

1. **Redimensionar** a 400x400px
2. **Comprimir** para reducir el tamaño de archivo
3. **Convertir** a JPG si son fotos (PNG si necesitas transparencia)
4. **Verificar** que el peso sea menor a 200KB

---

## ✅ Checklist Final

Antes de iniciar el proyecto, verifica:

- [ ] La carpeta `public/img/` existe
- [ ] Existe el archivo `logo_con_slogan.PNG`
- [ ] Existen los archivos `producto1.jpg` a `producto8.jpg`
- [ ] Los nombres coinciden exactamente (mayúsculas/minúsculas importan)
- [ ] Las imágenes son de buena calidad
- [ ] Las imágenes están optimizadas (< 200KB cada una)
- [ ] Todas las imágenes tienen proporción 1:1

---

## ❓ Preguntas Frecuentes

### ¿Puedo usar PNG en lugar de JPG?

Sí, ambos formatos funcionan. Solo asegúrate de cambiar la extensión en el nombre del archivo.

### ¿Los nombres son case-sensitive?

Sí, en sistemas Linux/Mac sí importan las mayúsculas. Es mejor usar siempre minúsculas excepto para `logo_con_slogan.PNG`.

### ¿Puedo tener más de 8 productos?

Sí, pero deberás modificar el código en `src/services/dbService.js` y ajustar el número de productos.

### ¿Qué pasa si falta una imagen?

El navegador mostrará un ícono de imagen rota. Es importante tener todas las imágenes antes de ejecutar.

### ¿Puedo usar diferentes tamaños?

Sí, pero las cartas se verán mejor si todas tienen el mismo tamaño y proporción (1:1 recomendado).

---

## 📞 Soporte

Si tienes problemas con las imágenes:

1. Verifica los nombres de archivo
2. Comprueba que estén en la carpeta correcta
3. Borra la caché del navegador (Ctrl + Shift + R)
4. Revisa la consola del navegador para errores

---

¡Listo! Una vez tengas todas las imágenes, tu proyecto estará completo. 🎉
