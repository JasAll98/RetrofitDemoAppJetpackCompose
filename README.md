<pre>
<h1>1. Implement dependencies  </h1>
   a) Retrofit with OkHttp  
   implementation("com.squareup.retrofit2:retrofit:(insert latest version)") - <a href="https://github.com/square/retrofit">github.com/square/retrofit</a>
   implementation("com.squareup.okhttp3:okhttp:4.12.0")  - <a href="https://square.github.io/okhttp/">square.github.io/okhttp</a>
   <hr>

   b) Kotlin Serialization with Serialization Converter  - <a href="https://kotlinlang.org/docs/serialization.html">kotlinlang.org/docs/serialization.html</a>
   plugins {
      id 'org.jetbrains.kotlin.jvm' version '2.1.0'
      id 'org.jetbrains.kotlin.plugin.serialization' version '2.1.0'
   }    
   implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3" 
   implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0") - <a href="https://github.com/JakeWharton/retrofit2-kotlinx-serialization-converter">kotlinx-serialization-converter</a>
<hr>
   c) Coil for showing images
   implementation("io.coil-kt:coil-compose:2.7.0")  - <a href="https://coil-kt.github.io/coil/compose/">coil-kt.github.io/coil/compose</a>

</pre>
