# UI now not Later
## **Building the Procrastinot UI”**

---

### 🎯 **Goal**

By the end of this lab and follow-up work, you’ll have:

* A connected Firebase project
* A working Google login flow
* A reusable `api.js` that attaches your Firebase Auth token to every backend request
* The first pass of your real UI connected to live API endpoints

---

## 🪜 **Step 1 — Create or Open Your Firebase Project**

1. Go to [https://console.firebase.google.com](https://console.firebase.google.com).
2. Click **Add Project** (or open your existing one).
3. Once inside, click the **`</>` (Web)** icon labeled **“Add app”**.
4. Give your app a nickname like `ProcrastinotUI` → click **Register app**.
5. Copy your **Firebase config snippet** (the `firebaseConfig` block).
6. If you already added a web app before:

   * Go to **Project Settings → Your apps → SDK setup and configuration → Config** tab.
   * Copy the config snippet from there.

---

## 🪜 **Step 2 — Update `/src/firebase.js`**

Update the contents of your existing `firebase.js` to include the at least following:

```js
// src/firebase.js
import { initializeApp } from "firebase/app";
import { getAuth, GoogleAuthProvider } from "firebase/auth";

// 👇 Paste your own config here from the Firebase console
const firebaseConfig = {
  apiKey: "YOUR_API_KEY",
  authDomain: "your-app.firebaseapp.com",
  projectId: "your-app",
  storageBucket: "your-app.appspot.com",
  messagingSenderId: "SENDER_ID",
  appId: "APP_ID"
};


// Initialize Firebase
const app = initializeApp(firebaseConfig);
const db = getFirestore(app);
const functions = getFunctions(app);
const auth = getAuth(app);
const googleProvider = new GoogleAuthProvider();

// Connect to emulators if running locally
if (window.location.hostname === "localhost") {
  console.log("Development mode: Connecting to local Firebase emulators...");
  connectFirestoreEmulator(db, 'localhost', 8080);
  connectFunctionsEmulator(functions, 'localhost', 5001);
  connectAuthEmulator(auth, 'http://localhost:9099');
} else {
  console.log("Production mode: Connecting to live Firebase services.");
}

export { app, db, functions, auth, googleProvider };
```

✅ This file initializes Firebase **once** and exports both the auth instance and Google sign-in provider.

---

## 🪜 **Step 3 — Create `/src/components/Login.jsx`**

Create a folder named `components` inside `src`, then create a file:
`/src/components/Login.jsx`

Paste this code:

```jsx
import { useState, useEffect } from "preact/hooks";
import { signInWithPopup, signOut, onAuthStateChanged } from "firebase/auth";
import { auth, googleProvider } from "../firebase";

export function Login() {
  const [user, setUser] = useState(null);

  useEffect(() => {
    const unsubscribe = onAuthStateChanged(auth, setUser);
    return () => unsubscribe();
  }, []);

  async function handleGoogleLogin() {
    try {
      await signInWithPopup(auth, googleProvider);
    } catch (err) {
      console.error("Login failed:", err.message);
    }
  }

  async function handleLogout() {
    await signOut(auth);
  }

  if (!user) {
    return (
      <div class="flex flex-col items-center justify-center h-screen space-y-4">
        <h2 class="text-2xl font-bold">Welcome to Procrastinot</h2>
        <button
          onClick={handleGoogleLogin}
          class="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700"
        >
          Sign in with Google
        </button>
      </div>
    );
  }

  return (
    <div class="flex flex-col items-center justify-center h-screen space-y-4">
      {user.photoURL && (
        <img src={user.photoURL} alt="Profile" class="rounded-full w-16 h-16" />
      )}
      <p class="text-lg">Hello, {user.displayName || user.email}!</p>
      <button
        onClick={handleLogout}
        class="bg-gray-700 text-white px-4 py-2 rounded hover:bg-gray-800"
      >
        Sign Out
      </button>
    </div>
  );
}
```

✅ Test it later after enabling Google Sign-In in Firebase:

* Go to **Build → Authentication → Sign-in Method → Google → Enable**.
* Add `localhost` and your deployed URL (0.0.0.0) to **Authorized Domains**.

---

## 🪜 **Step 4 — Update `/src/app.jsx`**

Replace your “Welcome to Preact” boilerplate with:

```jsx
import { Login } from "./components/Login";

export function App() {
  return (
    <main>
      <Login />
    </main>
  );
}
```

---

## 🪜 **Step 5 — Create `/src/api.js`**

This file will handle all backend communication and automatically attach your Firebase Auth token.

```js
// src/api.js
import { getAuth } from "firebase/auth";

const API_BASE = import.meta.env.VITE_API_BASE_URL || window.location.origin;

async function fetchWithAuth(endpoint, options = {}) {
  const user = getAuth().currentUser;
  if (!user) throw new Error("User not authenticated");

  const token = await user.getIdToken();

  const headers = {
    ...(options.headers || {}),
    "Content-Type": "application/json",
    Authorization: `Bearer ${token}`,
  };

  const res = await fetch(`${API_BASE}${endpoint}`, { ...options, headers });
  if (!res.ok) throw new Error(`API error: ${res.statusText}`);

  try {
    return await res.json();
  } catch {
    return null;
  }
}

// Export reusable API calls (replace with your endpoints)
export const api = {
  getRooms: () => fetchWithAuth("/api/rooms"),
  createRoom: (data) =>
    fetchWithAuth("/api/rooms", {
      method: "POST",
      body: JSON.stringify(data),
    }),
  joinRoom: (inviteCode) =>
    fetchWithAuth("/api/rooms/join", {
      method: "POST",
      body: JSON.stringify({ inviteCode }),
    }),
  startSession: (roomId, mode) =>
    fetchWithAuth(`/api/rooms/${roomId}/sessions`, {
      method: "POST",
      body: JSON.stringify({ mode }),
    }),
};
```

✅ Every API call should now:

* Include a valid Firebase token.
* Return JSON directly to your UI components.
* Centralize all network logic.

---

## 🪜 **Step 6 — Hook Your UI to the Backend**

Now start replacing your mock UIs with **real data** from `api.js`.

For example, inside a `RoomList.jsx` component:

```jsx
import { useEffect, useState } from "preact/hooks";
import { api } from "../api";

export function RoomList() {
  const [rooms, setRooms] = useState([]);

  useEffect(() => {
    api.getRooms().then(setRooms).catch(console.error);
  }, []);

  return (
    <div>
      <h2>My Rooms</h2>
      <ul>
        {rooms.map((r) => (
          <li key={r.id}>{r.name}</li>
        ))}
      </ul>
    </div>
  );
}
```

---

## 🪜 **Step 7 — Build Out Your First-Pass UI**

Now it’s your turn. Build out pages and components for your Procrastinot user stories:

* **Focus Rooms:** create/join/see all rooms
* **Sessions:** start, join, or view session progress
* **Friends:** list focus friends and active sessions
* **Accountability:** view peer progress and nudges

Each component should call into `api.js` and display data dynamically.

---

## 🚀 **Run & Test**

```bash
build.sh;run.sh
```

Then open [http://localhost:5173](http://localhost:5173).

* Log in with Google.
* Test API calls in the console.
* Watch your data flow from backend → API → UI.

---

## 🧾 **Deliverables**

* Working Google Auth login.
* Functional API integration with token passing.
* One complete UI flow built out (e.g., “Join Room” or “Start Session”).
* Code in GitHub.
---

Would you like me to add a **short starter checklist + grading rubric** (e.g., 10 pts per milestone) to make it submission-ready for Canvas or your LMS?
