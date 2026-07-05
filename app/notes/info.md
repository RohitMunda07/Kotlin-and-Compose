Excellent question. This is exactly the kind of question that helps you really understand Compose instead of just copying code.

The answer is:

> **`onValueChange` is a callback that runs whenever the user changes the text inside the `TextField`.**

It **does not automatically update your variable**. **You** decide what to do with the new value.

---

## Let's understand with your code

```kotlin
var name by remember {
    mutableStateOf("")
}

TextField(
    value = name,
    onValueChange = {
        name = it
    }
)
```

There are two important properties here:

### 1. `value`

```kotlin
value = name
```

This tells the `TextField`:

> "Display whatever is stored in `name`."

Initially:

```text
name = ""
```

So the `TextField` is empty.

---

### 2. `onValueChange`

Suppose the user types:

```text
R
```

Compose calls:

```kotlin
onValueChange("R")
```

If the user types:

```text
Ro
```

Compose calls:

```kotlin
onValueChange("Ro")
```

If the user types:

```text
Rohit
```

Compose calls:

```kotlin
onValueChange("Rohit")
```

Notice something?

`onValueChange` **receives** the new text.

It doesn't store it anywhere.

---

## What happens next?

This line is your responsibility:

```kotlin
name = it
```

You're saying:

> "Take the new text the user typed and store it in `name`."

Now:

```text
name = "Rohit"
```

Because `name` is a `mutableStateOf`, Compose notices it changed and redraws the `TextField`.

---

## What if you don't update `name`?

Example:

```kotlin
TextField(
    value = name,
    onValueChange = {
        println(it)
    }
)
```

You type:

```text
Hello
```

Console prints:

```text
Hello
```

But the `TextField` stays empty.

Why?

Because:

```text
value = name
```

and `name` never changed.

---

## Think of it like a conversation

```
User
   │
   │ types "Rohit"
   ▼
TextField
   │
   │ calls
   ▼
onValueChange("Rohit")
   │
   │
   ▼
Your Code
   │
   │ name = "Rohit"
   ▼
mutableStateOf
   │
   ▼
Compose
   │
   ▼
UI updates
```

---

## React comparison

This is almost identical to React.

React:

```jsx
const [name, setName] = useState("");

<input
    value={name}
    onChange={(e) => setName(e.target.value)}
/>
```

Compose:

```kotlin
var name by remember {
    mutableStateOf("")
}

TextField(
    value = name,
    onValueChange = {
        name = it
    }
)
```

Mapping:

| React          | Jetpack Compose |
| -------------- | --------------- |
| `value={name}` | `value = name`  |
| `onChange`     | `onValueChange` |
| `setName()`    | `name = it`     |

---

## A very important concept

A `TextField` is called a **controlled component**.

That means:

* `value` controls what is displayed.
* `onValueChange` tells you what the user wants the new value to be.
* **You** decide whether to accept that change.

For example, you can limit the input to 10 characters:

```kotlin
TextField(
    value = name,
    onValueChange = { newValue ->
        if (newValue.length <= 10) {
            name = newValue
        }
    }
)
```

Here:

* User types the 11th character.
* `onValueChange` is still called.
* But you **don't update `name`**.
* So the `TextField` stays at 10 characters.

This is why `onValueChange` is so powerful: it gives you complete control over what the `TextField` should display.
