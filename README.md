<h1 align="center">Ktx</h1></br>

<p align="center">
A KTX is ~~Korea Train eXpress~~ simply support ktx for android component

</p>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
</p>

### Dependency Gradle 
Add below codes to your **root** `build.gradle` file (not your module build.gradle file).
```gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```

```gradle
dependencies {
  implementation 'com.github.kennethss:ktx:1.0.1'
}
```


## Usage
### Example Context 

```kotlin
context.toast("Some Message")

```

### Example LifeCycleOwner

```kotlin
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observe(viewModel.livedata) { value ->
          // Something
        }
    }
}

class MainFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe(viewModel.livedata) { value ->
          // Something
        }
    }
}
```
