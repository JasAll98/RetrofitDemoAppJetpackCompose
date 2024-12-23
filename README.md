1. Implement dependencies  <br>
   a) Retrofit with OkHttp  <br>
   implementation("com.squareup.retrofit2:retrofit:(insert latest version)") - https://github.com/square/retrofit<br>
   implementation("com.squareup.okhttp3:okhttp:4.12.0")  - https://square.github.io/okhttp/<br>
   <hr>
<br>
   b) Kotlin Serialization with Serialization Converter  - https://kotlinlang.org/docs/serialization.html <br>
   plugins {<br>
    id 'org.jetbrains.kotlin.jvm' version '2.1.0'<br>
    id 'org.jetbrains.kotlin.plugin.serialization' version '2.1.0'<br>
   }    <br>
   implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3" <br>
   implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0") - https://github.com/JakeWharton/retrofit2-kotlinx-serialization-converter<br>
<hr><br>
   c) Coil for showing images<br>
   implementation("io.coil-kt.coil:coil-compose:3.0.4")  - https://coil-kt.github.io/coil/compose/
<br>
