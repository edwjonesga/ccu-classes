# 🧠 GET It Done! – Your Procrastinot API Kickoff

Welcome to your first API adventure in Firebase! This week, we’ll be building and testing a real HTTP API using your very own API spec and Firebase Cloud Functions. Let’s take it one step at a time.

---

## 🚀 In-Class Setup

### ✅ Step 1: Launch Your Firebase Emulator

1. Start the Firebase emulator for your project:
   ```
   firebase emulators:start
   ```
   or
   ```
   ./run.sh
   ```
   From inside the running docker container.
3. Open **VS Code** and locate your **Procrastinot API spec** file (JSON).
4. Open your browser and visit:
   ```
   http://localhost:4000
   ```
5. Look for the port where **functions** is running (usually port `5000`).

---

### ✅ Step 2: Update the API Spec Base URL (First Pass)

1. In your API spec JSON, find the `servers` section and update the URL to:
   ```json
   "url": "http://localhost:5000"
   ```
2. Save the file.

---

### ✅ Step 3: Try Out a Request

1. In the preview (e.g. Swagger UI), click **"Try it out"** for any endpoint.
2. Click **"Execute"**.
3. In the terminal running Firebase, you should see a log confirming a request was received.

🎉 If you see that — it worked!

---

### ✅ Step 4: Use the Real Function URL with Project Name

Now let’s use the full emulator function URL so Swagger talks directly to your function.

1. Go to your `functions/index.js` file and **uncomment** the `helloWorld` function:

   ```js
   const { onRequest } = require("firebase-functions/v2/https");
   const logger = require("firebase-functions/logger");

   exports.helloWorld = onRequest((request, response) => {
     logger.info("Hello logs!", { structuredData: true });
     response.send("Hello from Firebase!");
   });
   ```

2. Save the file.
3. Restart the emulator if needed and look for a line like this in the logs:

   ```
   functions[us-central1-helloWorld]: http function initialized (http://127.0.0.1:5001/YOUR_PROJECT_NAME/us-central1/helloWorld).
   ```

4. **Copy that full URL** (including your project name and `/helloWorld`).
5. Replace the `url` in your API spec with this new value:
   ```json
   "url": "http://127.0.0.1:5001/YOUR_PROJECT_NAME/us-central1/helloWorld"
   ```

6. Save your API spec.
7. Go back to the preview and click **"Try it out"** → **"Execute"**.

✅ You should now see your first real Firebase Cloud Function being invoked from your spec!

---

## 🧪 Step-by-Step Function Development

### 🧾 Step 1: Return Real JSON

Update the function to return structured JSON instead of text:

```js
exports.helloWorld = onRequest((request, response) => {
  logger.info("Hello logs!", { structuredData: true });
  response.status(200).json({
    id: "r_123",
    name: "Algebra Hour",
    mode: "pomodoro",
    inviteCode: "AB12CD"
  });
});
```

---

### 🔍 Step 2: Inspect the Request

Log different parts of the incoming request:

```js
exports.helloWorld = onRequest((request, response) => {
  logger.info("Path:", request.path);
  logger.info("Query:", request.query);
  logger.info("Body:", request.body);
  logger.info("Headers:", request.headers);

  response.status(200).send("Check logs for request data!");
});
```

---

### 🛣️ Step 3: Handle Different Paths

Add simple path routing using `request.path`:

```js
exports.helloWorld = onRequest((request, response) => {
  if (request.path === "/rooms") {
    response.status(200).json({
      id: "r_123",
      name: "Algebra Hour",
      mode: "pomodoro",
      inviteCode: "AB12CD"
    });
  } else {
    response.status(404).json({ error: "Unrecognized path." });
  }
});
```

---

### 📦 Step 4: Use Request Body Logic

Parse request body and respond differently:

```js
exports.helloWorld = onRequest((request, response) => {
  const data = request.body;

  if (data.name === "Algebra Hour") {
    response.status(200).json({ message: "Matched Algebra Hour!" });
  } else {
    response.status(200).json({ message: `Room created: ${data.name}` });
  }
});
```

---

## 🏠 Take-Home Assignment

### 📋 Goal

For each path defined in your OpenAPI spec, extend the function logic to:

- Match the path using `request.path`
- Return dummy JSON data **in the exact format** defined in your spec

#### ✅ Example for `/rooms`

If your API spec defines:

```json
{
  "id": "r_123",
  "name": "Algebra Hour",
  "mode": "pomodoro",
  "inviteCode": "AB12CD"
}
```

Then in your function:

```js
if (request.path === "/rooms") {
  response.status(200).json({
    id: "r_123",
    name: "Algebra Hour",
    mode: "pomodoro",
    inviteCode: "AB12CD"
  });
}
```

Repeat for **all endpoints** defined in your spec.

---

## 📦 What to Submit

Turn in:

1. ✅ Your **API Spec** file (`.json`)
2. ✅ Your **index.js** file containing your path-matching function logic

---

👏 That’s it! You’ve wired up Firebase to your OpenAPI contract and learned how to create, route, and simulate a complete backend API.
