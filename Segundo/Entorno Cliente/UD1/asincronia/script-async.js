// promise, async / await
// simular un servidor con asincronia
function fetchProductsAsync() {
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve([
                { id: 1, name: "Pelota de Futbol", price: 20 },
                { id: 2, name: "Raqueta de Tenis", price: 50 },
            ]);
        }, 3000);
    });
}

// mostrar productos con asincronía
async function displayProducts() {
    const products = document.getElementById("products");
    products.innerHTML = "<p>Cargando productos...</p>";

    // llamada no bloqueante
    const productsFunction = await fetchProductsAsync();
    products.innerHTML = productsFunction.map(p => `<p>${p.name} - ${p.price}€</p>`).join("");

}

document.getElementById("product-form").addEventListener('submit', async (e) => {
    e.preventDefault();
    const name = document.getElementById("product-name").value;
    const price = parseFloat(document.getElementById("product-price").value);

    // simular el gurdado del producto en el servidor
    await new Promise((resolve) => setTimeout(resolve, 2000));
    console.log(`Producto añadido: ${name} - ${price}€`);
    document.getElementById("product-form").reset();
    displayProducts();
});

fetchProductsAsync()

