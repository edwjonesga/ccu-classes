# Procrastinot Final Project – Student-Friendly Rubric

This rubric explains exactly how your Procrastinot final project will be graded. It is designed to be clear, transparent, and tied directly to the learning goals of our full‑stack course. Your project grade is based on **three layers**: the API, the UI, and the Backend.

At a high level:

| Layer             | Percentage | Description                                                                                                                                                  |
| ----------------- | ---------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **API Layer**     | **65%**    | Your API is the brain of the system. It must implement the agreed‑upon spec, enforce strong security, and demonstrate correct behavior across all endpoints. |
| **UI Layer**      | **20%**    | Your UI must work, authenticate users, correctly call your API, and implement user stories. Bonus points for good design and usability.                      |
| **Backend Layer** | **15%**    | Your backend must use Firestore for real persistence and show defense‑in‑depth thinking.                                                                     |

Below is the complete breakdown.

---

# 📘 1. API Layer – 65% of Total Grade

Your API is the most important part of this project. It must correctly implement the agreed‑upon API contract and follow strong security practices.

The API layer grade is divided as follows:

* **30 of the 65%** → Security (CORS, JWT auth, Never‑Trust‑the‑Client)
* **35 of the 65%** → Endpoint Coverage & Functionality

This adds up to the full **65% API score**.

---

## **A. Security – 30 of the 65% API Grade (30/65 ≈ 46% of API grade)**

Security is essential. Because this is an API‑first course, treating security seriously is non‑negotiable.

### **1. CORS Implementation – 10 of the 65% API grade**

To earn this portion you must:

* Correctly implement CORS in your API.
* Only allow appropriate HTTP methods.
* Respond properly to preflight (OPTIONS) requests.

### **2. API Authentication (JWT Checking) – 10 of the 65% API grade**

You must:

* Accept a valid Firebase authentication token on every request.
* Reject requests missing or containing invalid/expired tokens.
* Verify tokens on the server — not the client.

### **3. "Never Trust the Client" Checks – 10 of the 65% API grade**

You must:

* Never trust IDs sent by the client (userId, roomId, etc.).
* Look up ownership/permissions in the backend.
* Validate *all* sensitive operations on the server.

Examples:

* A user claims to be owner of a room → **verify through Firestore**, not the request body.
* A user attempts to join a session → confirm their identity matches the auth token.

---

## **B. Endpoint Implementation & Functionality – 35 of the 65% API Grade**

Your API must implement **all required endpoints from the class API spec**.

Grading is proportional:

* If there are 15 required endpoints…

  * Implementing all 15 → full points
  * Implementing 8 → 50% of these 35 points
  * Implementing 4 → 25% of these 35 points

To count as "implemented":

* The endpoint must exist.
* It must perform the operation it is designed for.
* It must update/read from storage (in‑memory storage is acceptable for API points).

Examples:

* If you call **POST /rooms** to create a room, that room **must appear** in **GET /rooms**.
* If you start a session, **GET /sessions** must show it.

Functionality must be observable.

---

# 🎨 2. UI Layer – 20% of Total Grade

Your UI must call your API correctly, use authentication, and implement user stories.

The UI grade is divided as follows:

* **5%** → UI Authentication
* **12%** → Functionality via User Stories
* **3%** → UI Polish / Design

---

## **A. Authentication in the UI – 5%**

The UI must:

* Allow the user to log in using Firebase authentication.
* Correctly store and send the JWT token.
* Hide authenticated features until login is complete.

---

## **B. Functionality (User Stories) – 12%**

This is where most of the UI points come from. The UI should:

* Call real API endpoints.
* Display real data from the API (no hardcoding).
* Implement as many user stories as possible.

Examples of user stories:

* “As a user, I can create a room.”
* “As a user, I can join a room.”
* “As a user, I can start a session.”
* "As a user, I can see the list of rooms I created."

Scoring is proportional:

* Implementing all user stories → full points
* Implementing half → 50% of these points

---

## **C. UI Polish / Design Quality – 3%**

Points here are for:

* Clean layout
* Good visual structure
* Pleasant to use
* Clear labels/buttons
* A UI your classmates actually enjoy using

This is small bonus credit, but it rewards care and aesthetics.

---

# 🗄️ 3. Backend Layer – 15% of Total Grade

Your backend must use Firestore and include real persistence.

The backend grade is:

* **5 of the 15%** → Defense in Depth
* **10 of the 15%** → Firestore Implementation

---

## **A. Defense in Depth (Library or Security Layer) – 5 of the 15%**

To earn this:

* Implement a library/helper layer between your API and Firestore.
* Perform validation **again** at the backend layer (not just the API layer).
* Demonstrate any form of additional backend security consideration.

Examples:

* A Firestore access wrapper that ensures user permissions.
* A backend validator that prevents insecure writes.

---

## **B. Firestore Implementation – 10 of the 15%**

Your backend must:

* Use Firestore for real storage.
* Save rooms, sessions, or users according to project expectations.
* Read/write data properly.
* Return Firestore results through your API.

Scoring is proportional to completeness:

* All backend operations implemented → full credit
* Partial implementation → partial credit

---

# ✔️ Final Notes

To receive full credit:

* Your API must function and follow the API spec.
* Your UI must be connected to the API and demonstrate user stories.
* Your backend must use Firestore.
* Security must be taken seriously at every layer.

If you have questions or want clarification, ask early and often!

Good luck — and build something you're proud of!
