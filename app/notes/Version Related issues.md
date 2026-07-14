Good question — this is a skill worth building since it'll save you hours down the line. Here's the actual method, not just guesswork:

## 1. Check the library's release notes for "Requires Kotlin X.Y+"

Almost every `kotlinx-*` library (serialization, coroutines, datetime) lists compatibility in its GitHub releases page. For kotlinx.serialization specifically:This confirms the pattern exactly. Here's your repeatable method:

## 1. Check the library's own release notes for the Kotlin version it was built with

The kotlinx.serialization GitHub releases page states this directly for every version — e.g. version 1.7.1 explicitly notes "Kotlin 2.0.0 is used by default." That's exactly the number you match against your `libs.versions.toml` Kotlin version.

**Where to look:** `https://github.com/Kotlin/kotlinx.serialization/releases` — scroll to your library version, read the top line.

## 2. General rule of thumb — match by release date, not by "latest"

Never grab the newest library version just because it's the newest. Instead:
- Find your `kotlin = "X.Y.Z"` in `libs.versions.toml`
- Go to mvnrepository.com or the library's GitHub releases and find the library version that was released **around the same time** as your Kotlin version
- Older Kotlin version → pick an older-but-not-ancient library version, not the bleeding edge

## 3. Let the compiler tell you when it breaks

If you pick wrong, Kotlin's compiler plugin is actually designed to catch this — mismatches show up as sync errors like the one you just saw ("unsupported binary format," "expected 2.1.0"). That error message itself tells you the expected version — that's your answer, use it directly.

## 4. Quick sanity check via Gradle itself (optional, more advanced)

You can run this in the terminal from your project root to see every resolved dependency version, including any silent bumps:

```
./gradlew :app:dependencies --configuration debugRuntimeClasspath
```

Search the output for `kotlin-stdlib` — if it shows a version higher than what's in your `libs.versions.toml`, some other library pulled it up, exactly like what happened here.

## The takeaway pattern

> New Kotlin version → check what library versions were tested against it → pick libraries released around the same window → if unsure, check the library's own changelog for "Requires/Compatible with Kotlin X.Y"

You now have the actual diagnostic reflex for this — next time you add *any* `kotlinx-*` dependency (coroutines, datetime, etc.), do the same check before syncing instead of after.