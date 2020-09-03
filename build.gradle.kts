// TODO: Gradle Version Plugin の設定を外部に出すか、外部に出せないことの証明のどちらかをやりたい：ここから
import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

plugins {
    id("com.github.ben-manes.versions") version "0.29.0"
}
// TODO: Gradle Version Plugin の設定を外部に出すか、外部に出せないことの証明のどちらかをやりたい：ここまで

buildscript {
    repositories {
        mavenLocal() // for of-commons SNAPSHOT release
        maven { url = uri("https://beyondseeker.github.io/of-commons/mvn-repo") } // for of-commons
        google()
        jcenter()
    }
    dependencies {
        classpath(Classpaths.com_android_tools_build__gradle)
        classpath(Classpaths.org_jetbrains_kotlin__kotlin_gradle_plugin)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

task("clean", Delete::class) {
    delete = setOf(rootProject.buildDir)
}

fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}

// TODO: Gradle Version Plugin の設定を外部に出すか、外部に出せないことの証明のどちらかをやりたい：ここから
// configure Component Selection Rules.
// @See https://docs.gradle.org/current/userguide/dynamic_versions.html#sec:component_selection_rules
tasks.named("dependencyUpdates", DependencyUpdatesTask::class.java).configure {
    rejectVersionIf {
        isNonStable(candidate.version) && !isNonStable(currentVersion)
    }
}
// TODO: Gradle Version Plugin の設定を外部に出すか、外部に出せないことの証明のどちらかをやりたい：ここまで