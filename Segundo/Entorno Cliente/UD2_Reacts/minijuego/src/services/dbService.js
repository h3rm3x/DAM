const URL_BASE_DATOS = "https://remotehost.es/student024/Shop/backend/endpoints/minijuego/api_productos.php";
/**
 * Obtiene los productos de la tienda online para el juego de memoria
 * @returns {Promise<Array>} Array de productos con id, nombre, imagen, precio
 */
export const obtenerProductos = async () => {
  try {
    const response = await fetch(`${URL_BASE_DATOS}`);
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
  return obtenerPalabrasEjemplo();
};

/**
 * Obtiene los premios disponibles para la ruleta
 * @returns {Promise<Array>} Array de premios con id, tipo, valor, nombre
 */
export const obtenerPremios = async () => {
  return obtenerPremiosEjemplo();
};


function obtenerProductosEjemplo() {
  return [
    { id: 1, nombre: "Camiseta Básica", imagen: "https://via.placeholder.com/150/FF6347/FFFFFF?text=Camiseta", precio: 19.99 },
    { id: 2, nombre: "Pantalón Vaquero", imagen: "https://via.placeholder.com/150/4CAF50/FFFFFF?text=Pantalon", precio: 39.99 },
    { id: 3, nombre: "Zapatillas Running", imagen: "https://via.placeholder.com/150/2196F3/FFFFFF?text=Zapatillas", precio: 59.99 },
    { id: 4, nombre: "Sudadera con Capucha", imagen: "https://via.placeholder.com/150/9C27B0/FFFFFF?text=Sudadera", precio: 34.99 },
    { id: 5, nombre: "Chaqueta Deportiva", imagen: "https://via.placeholder.com/150/FF9800/FFFFFF?text=Chaqueta", precio: 49.99 },
    { id: 6, nombre: "Gorra de Béisbol", imagen: "https://via.placeholder.com/150/E91E63/FFFFFF?text=Gorra", precio: 14.99 },
    { id: 7, nombre: "Mochila Escolar", imagen: "https://via.placeholder.com/150/00BCD4/FFFFFF?text=Mochila", precio: 29.99 },
    { id: 8, nombre: "Reloj Digital", imagen: "https://via.placeholder.com/150/FFD700/000000?text=Reloj", precio: 79.99 }
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
