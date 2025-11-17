// simulacion de un servidor con tiempo de espera
function fetchProductSync() {
    const start = Date.now();
    while (Date.now() - start < 10000) {
        console.log("cargando productos...");
    }
    return [{ id: 1, name: "Pelota de Futbol", price: 20 }, { id: 2, name: "Raqueta de Tenis", price: 50 }];
}
// mostrar productos sin asincronía
function displayProducts() {
    const products = document.getElementById("products");
    products.innerHTML = "<p>Cargando productos...</p>";

    // llamada bloqueante
    const productsFunction = fetchProductSync();
    products.innerHTML = productsFunction.map(p => `<p>${p.name} - ${p.price}€</p>`).join("");

}

document.getElementById("product-form").addEventListener('submit', (e) => {
    e.preventDefault
    console.log("no se pueden añadir productos mientras se cargan las existencias");
})

