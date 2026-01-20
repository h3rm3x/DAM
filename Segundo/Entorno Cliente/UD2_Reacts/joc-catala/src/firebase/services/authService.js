import { createUserWithEmailAndPassword, signInWithEmailAndPassword, signOut , onAuthStateChanged  } from "firebase/auth";
import { auth } from "../firebase";

// registrar un usuario
export function register(email, password) {
    return createUserWithEmailAndPassword(auth, email, password);
}

export function login(email, password) {
    return signInWithEmailAndPassword(auth, email, password);
}

export function logout() {
    return signOut(auth);
}

// observar el estado de autenticación
export function listenAuthChange(callback) {
    return onAuthStateChanged(auth, callback);
}