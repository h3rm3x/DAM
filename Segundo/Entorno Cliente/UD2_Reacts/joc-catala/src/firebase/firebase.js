import { initializeApp } from "firebase/app";
import { getAuth } from "firebase/auth";
import { getFirestore } from "firebase/firestore";

const firebaseConfig = {
  apiKey: "AIzaSyASdmk9EMxk-naxwmVAs8_Jqxg3xU8jqb8",
  authDomain: "joc-catala-alan.firebaseapp.com",
  projectId: "joc-catala-alan",
  storageBucket: "joc-catala-alan.firebasestorage.app",
  messagingSenderId: "435601572506",
  appId: "1:435601572506:web:2a53ff90194d81955b9523"
};

const app = initializeApp(firebaseConfig);
export const auth = getAuth(app);
export const db = getFirestore(app);

