buildscript {
    repositories {
        mavenLocal() // for of-commons SNAPSHOT release
        maven { url = uri("https://beyondseeker.github.io/of-commons/mvn-repo") } // for of-commons
        google()
        jcenter()
    }
    dependencies {
        classpath("com.objectfanatics:gradle-plugin-dynamicmodulesplugin:0.0.2-SNAPSHOT")
    }
}

rootProject.name = "chrono0015"
apply(mapOf("plugin" to "com.objectfanatics.gradle.plugin.dynamicmodulesplugin"))