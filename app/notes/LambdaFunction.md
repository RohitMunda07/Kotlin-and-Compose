This is probably **the most important Kotlin concept** you'll learn for Jetpack Compose.

The `{ }` braces in Kotlin have **different meanings depending on where they're used**. That's why they can be confusing at first.

Let's focus on the Compose context.

---

# 1. `{}` creates a lambda (anonymous function)

For example:

```kotlin
val greet = {
    println("Hello")
}
```

Here,

```kotlin
{
    println("Hello")
}
```

is a **function without a name**.

You can execute it by writing:

```kotlin
greet()
```

---

## Compare with a normal function

Normal function:

```kotlin
fun greet() {
    println("Hello")
}
```

Lambda:

```kotlin
val greet = {
    println("Hello")
}
```

Both do the same thing.

---

# 2. Why Compose uses `{}` everywhere

Take a `Button`:

```kotlin
Button(
    onClick = {
        println("Clicked")
    }
) {
    Text("Click Me")
}
```

There are **two** sets of braces.

---

## First braces

```kotlin
onClick = {
    println("Clicked")
}
```

This is a lambda.

It means:

> "When the button is clicked, execute this code."

---

## Second braces

```kotlin
{
    Text("Click Me")
}
```

This is also a lambda.

It means:

> "This is the content that goes inside the Button."

The `Button` composable expects another composable function to draw its content.

---

# 3. Why your code had an error

You wrote:

```kotlin
onClick = { increment }
```

Let's see what that actually means.

It creates a lambda:

```kotlin
{
    increment
}
```

Inside that lambda, you're only **referencing** the function.

You're not calling it.

---

Imagine:

```kotlin
fun hello() {
    println("Hello")
}
```

Now compare:

### Wrong

```kotlin
{
    hello
}
```

Nothing happens.

You just point at the function.

---

### Correct

```kotlin
{
    hello()
}
```

Now the function executes.

---

# 4. Why `onClick = increment` works

Remember:

```kotlin
increment: () -> Unit
```

means:

> "increment is already a function."

So instead of saying:

```kotlin
onClick = {
    increment()
}
```

you can simply hand the function over:

```kotlin
onClick = increment
```

Android will call it when the button is clicked.

---

# 5. Another use of `{}`

You already saw this:

```kotlin
remember {
    mutableStateOf(0)
}
```

Why braces?

Because `remember()` expects a function.

You're saying:

> "Execute this block only the first time."

That block is:

```kotlin
{
    mutableStateOf(0)
}
```

---

# 6. Another example

```kotlin
listOf(1,2,3).forEach {
    println(it)
}
```

The braces are a lambda.

Equivalent to:

```kotlin
listOf(1,2,3).forEach({ number ->
    println(number)
})
```

The shorter version uses the implicit `it` parameter.

---

# 7. Real-life analogy

Imagine a TV remote.

You don't press the button immediately.

Instead, you tell the TV:

> "When this button is pressed, do this."

That's exactly what a lambda is.

```kotlin
Button(
    onClick = {
        println("Clicked")
    }
)
```

You're not printing `"Clicked"` right now.

You're giving the button instructions for what to do later.

---

# Summary

| Syntax | Meaning                               |
| ------ | ------------------------------------- |
| `{}`   | Creates a lambda (anonymous function) |
| `()`   | Calls a function                      |
| `fun`  | Declares a named function             |

---

# Compare these carefully

### Normal function

```kotlin
fun greet() {
    println("Hello")
}
```

Call it:

```kotlin
greet()
```

---

### Lambda

```kotlin
val greet = {
    println("Hello")
}
```

Call it:

```kotlin
greet()
```

---

### Compose

```kotlin
Button(
    onClick = greet
)
```

The button stores the function and calls it later when clicked.

---

## A simple mental model

Whenever you see `{ ... }` in Compose, ask yourself:

> **"Am I giving Compose some code to execute later?"**

In most cases, the answer is **yes**.

* `onClick = { ... }` → Run this when clicked.
* `label = { Text(...) }` → Draw this label when needed.
* `remember { ... }` → Run this block once to initialize state.
* `Column { ... }` → These composables are the content of the `Column`.

This way of passing behavior and UI as lambdas is one of the core ideas behind Jetpack Compose.
