import vocabulariAnimals from "./vocabulari"; 
import { vocabulariAliments, vocabulariPreguntes } from "./vocabulari";


export function fetchVocabulariAnimals(tipo) {
    return new Promise((resolve) => {
        setTimeout(() => {
            if (tipo==1){
                 resolve(vocabulariAnimals);
            }
            else if (tipo==2){
                resolve(vocabulariAliments);
            }
            else if (tipo==3){
                resolve(vocabulariPreguntes);
            } else {
                resolve(vocabulariAnimals);
            }

        }, 1000);
    })
}