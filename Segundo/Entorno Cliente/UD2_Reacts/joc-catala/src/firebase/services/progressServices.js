import { doc, setDoc, getDoc, serverTimestamp } from "firebase/firestore";
import { db } from "../firebase";

export async function guardarProgresAnimals(uid, animalID){
    const ref = doc(db, 'progress', uid);
    const snap = await getDoc(ref);

    let vistos = [];
    if(snap.exists()){
        vistos = snap.data().animals.vistos || [];
    }
    if(!vistos.includes(animalID)){
        vistos.push(animalID);
    }
    await setDoc(ref, {
        animals: {
            vistos,
            updatedAt: serverTimestamp()
        }
    }, { merge: true });
}