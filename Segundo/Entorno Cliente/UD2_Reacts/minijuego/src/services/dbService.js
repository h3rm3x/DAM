/**
 * SERVICIO DE BASE DE DATOS
 * 
 * INSTRUCCIONES DE CONFIGURACIÓN:
 * 
 * 1. Reemplaza la URL_BASE_DATOS con la URL real de tu base de datos
 * 2. Si usas Firebase:
 *    - Importa las funciones necesarias de Firebase
 *    - Configura tu objeto de configuración de Firebase
 *    - URL_BASE_DATOS = "https://tu-proyecto.firebaseio.com"
 * 
 * 3. Si usas otra API REST:
 *    - URL_BASE_DATOS = "https://tu-api.com/api"
 * 
 * 4. Si usas json-server local:
 *    - URL_BASE_DATOS = "http://localhost:3000"
 * 
 * Estructura esperada de la base de datos:
 * {
 *   "productos": [
 *     { "id": 1, "nombre": "Producto 1", "imagen": "/img/producto1.jpg", "precio": 29.99 },
 *     { "id": 2, "nombre": "Producto 2", "imagen": "/img/producto2.jpg", "precio": 39.99 },
 *     ...
 *   ],
 *   "palabras": [
 *     { "id": 1, "palabra": "TIENDA", "pista": "Lugar donde se compra" },
 *     { "id": 2, "palabra": "PRODUCTO", "pista": "Artículo que se vende" },
 *     ...
 *   ],
 *   "premios": [
 *     { "id": 1, "tipo": "cupon", "valor": 10, "nombre": "Cupón 10€" },
 *     { "id": 2, "tipo": "descuento", "valor": 15, "nombre": "15% Descuento" },
 *     { "id": 3, "tipo": "cupon", "valor": 25, "nombre": "Cupón 25€" },
 *     { "id": 4, "tipo": "descuento", "valor": 20, "nombre": "20% Descuento" },
 *     { "id": 5, "tipo": "cupon", "valor": 5, "nombre": "Cupón 5€" },
 *     { "id": 6, "tipo": "descuento", "valor": 10, "nombre": "10% Descuento" }
 *   ]
 * }
 */

// PLACEHOLDER: Reemplaza con tu URL real
const URL_BASE_DATOS = "http://remotehot.es/student024/Shop/endpoints/minijuego/api_productos.php";
/**
 * Obtiene los productos de la tienda online para el juego de memoria
 * @returns {Promise<Array>} Array de productos con id, nombre, imagen, precio
 */
export const obtenerProductos = async () => {
  try {
    const response = await fetch(`${URL_BASE_DATOS}/productos`);
    if (!response.ok) {
      throw new Error(`Error HTTP: ${response.status}`);
    }
    const productos = await response.json();
    return productos;
  } catch (error) {
    console.error("Error al obtener productos:", error);
    // Retorna datos de ejemplo si falla la conexión
    return obtenerProductosEjemplo();
  }
};

/**
 * Obtiene las palabras para el juego de palabras
 * @returns {Promise<Array>} Array de palabras con id, palabra, pista
 */
export const obtenerPalabras = async () => {
  try {
    const response = await fetch(`${URL_BASE_DATOS}/palabras`);
    if (!response.ok) {
      throw new Error(`Error HTTP: ${response.status}`);
    }
    const palabras = await response.json();
    return palabras;
  } catch (error) {
    console.error("Error al obtener palabras:", error);
    // Retorna datos de ejemplo si falla la conexión
    return obtenerPalabrasEjemplo();
  }
};

/**
 * Obtiene los premios disponibles para la ruleta
 * @returns {Promise<Array>} Array de premios con id, tipo, valor, nombre
 */
export const obtenerPremios = async () => {
  try {
    const response = await fetch(`${URL_BASE_DATOS}/premios`);
    if (!response.ok) {
      throw new Error(`Error HTTP: ${response.status}`);
    }
    const premios = await response.json();
    return premios;
  } catch (error) {
    console.error("Error al obtener premios:", error);
    // Retorna datos de ejemplo si falla la conexión
    return obtenerPremiosEjemplo();
  }
};

/**
 * Guarda el premio ganado por el usuario
 * @param {Object} premio - El premio ganado
 * @param {string} juego - El juego donde se ganó (memory o palabras)
 * @returns {Promise<Object>} Respuesta del servidor
 */
export const guardarPremioGanado = async (premio, juego) => {
  try {
    const response = await fetch(`${URL_BASE_DATOS}/premios-ganados`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        premio,
        juego,
        fecha: new Date().toISOString()
      })
    });
    
    if (!response.ok) {
      throw new Error(`Error HTTP: ${response.status}`);
    }
    
    return await response.json();
  } catch (error) {
    console.error("Error al guardar premio:", error);
    return { success: false, error: error.message };
  }
};

// ========== DATOS DE EJEMPLO (Fallback) ==========
// Estos datos se usan si la base de datos no está disponible

function obtenerProductosEjemplo() {
  return [
    { id: 1, nombre: "Producto 1", imagen: "/img/producto1.jpg", precio: 29.99 },
    { id: 2, nombre: "Producto 2", imagen: "/img/producto2.jpg", precio: 39.99 },
    { id: 3, nombre: "Producto 3", imagen: "/img/producto3.jpg", precio: 19.99 },
    { id: 4, nombre: "Producto 4", imagen: "/img/producto4.jpg", precio: 49.99 },
    { id: 5, nombre: "Producto 5", imagen: "/img/producto5.jpg", precio: 24.99 },
    { id: 6, nombre: "Producto 6", imagen: "/img/producto6.jpg", precio: 34.99 },
    { id: 7, nombre: "Producto 7", imagen: "/img/producto7.jpg", precio: 44.99 },
    { id: 8, nombre: "Producto 8", imagen: "/img/producto8.jpg", precio: 54.99 }
  ];
}

function obtenerPalabrasEjemplo() {
  return [
    { id: 1, palabra: "TIENDA", pista: "Lugar donde se compra" },
    { id: 2, palabra: "PRODUCTO", pista: "Artículo que se vende" },
    { id: 3, palabra: "DESCUENTO", pista: "Reducción del precio" },
    { id: 4, palabra: "COMPRA", pista: "Acción de adquirir" },
    { id: 5, palabra: "CLIENTE", pista: "Persona que compra" },
    { id: 6, palabra: "PRECIO", pista: "Valor monetario" },
    { id: 7, palabra: "OFERTA", pista: "Promoción especial" },
    { id: 8, palabra: "PEDIDO", pista: "Solicitud de productos" },
    { id: 9, palabra: "ENVIO", pista: "Transporte del producto" },
    { id: 10, palabra: "CARRITO", pista: "Contenedor de compras" }
  ];
}

function obtenerPremiosEjemplo() {
  return [
    { id: 1, tipo: "cupon", valor: 10, nombre: "Cupón 10€", color: "#FFD700" },
    { id: 2, tipo: "descuento", valor: 15, nombre: "15% Descuento", color: "#FF6347" },
    { id: 3, tipo: "cupon", valor: 25, nombre: "Cupón 25€", color: "#4CAF50" },
    { id: 4, tipo: "descuento", valor: 20, nombre: "20% Descuento", color: "#2196F3" },
    { id: 5, tipo: "cupon", valor: 5, nombre: "Cupón 5€", color: "#9C27B0" },
    { id: 6, tipo: "descuento", valor: 10, nombre: "10% Descuento", color: "#FF9800" },
    { id: 7, tipo: "cupon", valor: 15, nombre: "Cupón 15€", color: "#E91E63" },
    { id: 8, tipo: "descuento", valor: 25, nombre: "25% Descuento", color: "#00BCD4" }
  ];
}
