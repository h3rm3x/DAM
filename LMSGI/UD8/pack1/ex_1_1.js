const nomsMascotes = ["Max", "Bella", "Charlie", "Luna"];
const edatsMascotes = [5, 3, 7, 2];

const mascotas = { nomsMascotes, edatsMascotes };
console.log(mascotas);

function mediaEdats(edatsMascotes) {
    let suma = 0;
    for (let i = 0; i < edatsMascotes.length; i++) {
        suma += edatsMascotes[i];
    }
    return suma / edatsMascotes.length;
}
console.log(mediaEdats(edatsMascotes)); // 4.25