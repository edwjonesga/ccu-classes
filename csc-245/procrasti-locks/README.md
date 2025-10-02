# Procrastinot — ProcrastiLocks: JWT Tokens & CORS Control

In this assignment, we’ll continue building the **Procrastinot API** by adding **JWT authentication** and **CORS support**. This will help you understand how to secure your endpoints and how to make sure your frontend can communicate with your backend.

---

## Part 1 — Update Your OpenAPI Spec

First, we’ll declare that **all endpoints require a JWT bearer token**.

1. Open your `procrastinot.json` file.
2. Under the `components` section, add a `securitySchemes` entry for a JWT bearer token:

```json
"components": {
  "securitySchemes": {
    "bearerAuth": {
      "type": "http",
      "scheme": "bearer",
      "bearerFormat": "JWT"
    }
  }
}
```

3. At the **top level** of your OpenAPI file, add the following to make this required globally:

```json
"security": [
  { "bearerAuth": [] }
]
```

Now every endpoint in your API spec will require a JWT bearer token.

### Testing with Swagger UI

To verify this, open your OpenAPI spec in Swagger UI. Each endpoint should now show a **lock icon**. Click it to enter a bearer token (e.g. `<your_token>` — for now, just enter something recognizable so you can spot it in the logs). Once authorized, try sending requests from Swagger UI to confirm that the token is required and correctly passed to your backend.

---

## Part 2 — Extract the Token in Your Code

Next, we’ll adjust your `index.js` so you can access the token from requests.

Every HTTP request has headers. The **Authorization header** contains the bearer token.

Example of logging headers:

```js
exports.yourFunctionName = functions.https.onRequest // e.g., createRoom, helloWorld, etc.((req, res) => {
  console.log("Headers:", req.headers);
  res.send({ message: "Check your logs for headers" });
});
```

Your job:

* Find the token inside `req.headers`.
* Print **just the token** by creating a helper function called `getToken` that extracts it from `req.headers`.

Example of what you might see in a request header:

```
Authorization: <your_token_entered_in_swagger_ui>
```

---

## Part 3 — Prepare for Firebase Auth

Once you’ve extracted the token, the next step will be validating it using Firebase Auth.

Add the Firebase Admin SDK to your project:

```js
const admin = require("firebase-admin");
admin.initializeApp();
```

Then set up a placeholder function for later:

```js
async function getAuthUser(req) {
  // TODO: find the token in req.headers
  // TODO: use admin.auth().verifyIdToken(token)
}
```

Right now, don’t implement validation. Uncomment this helper and call it at the top of your file, then test it out with the random string you sent as a token in Swagger UI. You should see that authentication fails with the random string. After testing, comment it back out for now.

---

## Part 4 — Add CORS to Your Endpoints

Browsers enforce **CORS (Cross-Origin Resource Sharing)** rules. By default, your API will block requests from your frontend unless you explicitly allow them.

We fix this by adding headers to the **response object**:

```js
response.set("Access-Control-Allow-Origin", "http://localhost:5173");
response.set("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
response.set("Access-Control-Allow-Headers", "Authorization, Content-Type");

if (request.method === "OPTIONS") {
  response.status(204).send("");
  return;
}
```

Try this first with only `http://localhost:5173`. When you test using Swagger UI, you should see a **CORS error** because Swagger runs from a different origin. Then change it to `*` and try again — this time it will work. `*` means accept all origins (which is not secure). After testing, change it back to `http://localhost:5173`.

Explanation:

* **Allow-Origin**: which sites are allowed (start with `http://localhost:5173`).
* **Allow-Methods**: which HTTP methods are permitted.
* **Allow-Headers**: which headers the browser can send (must include `Authorization`).

Your task: Create a helper function called `setCors(response)` that contains this setup.  Then make sure to call `setCors(response)` inside each of your endpoint functions so that CORS headers are applied correctly. Remember that in the future, you may need to support **multiple allowed origins**, not just one.

---

## Deliverables

1. **Updated OpenAPI spec** with bearerAuth required globally.
2. **Modified `index.js`** that finds and prints the token from `req.headers`.
3. **Endpoints updated with CORS headers** so your frontend can connect successfully.

---

## Next Steps

In the next assignment, you will:

* Actually validate tokens with Firebase Auth.
* Enforce permissions (e.g. only room owners can delete their rooms).
