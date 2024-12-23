1. Implement dependencies
   a) Retrofit with OkHttp
   implementation("com.squareup.retrofit2:retrofit:(insert latest version)") - https://github.com/square/retrofit
   implementation("com.squareup.okhttp3:okhttp:4.12.0")  - https://square.github.io/okhttp/

   b) Kotlin Serialization with Serialization Converter  - https://kotlinlang.org/docs/serialization.html
   plugins {
    id 'org.jetbrains.kotlin.jvm' version '2.1.0'
    id 'org.jetbrains.kotlin.plugin.serialization' version '2.1.0'
   }    
   implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3" 
   implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0") - https://github.com/JakeWharton/retrofit2-kotlinx-serialization-converter

   c) Coil for showing images
   implementation("io.coil-kt.coil:coil-compose:3.0.4")  - https://coil-kt.github.io/coil/compose/
