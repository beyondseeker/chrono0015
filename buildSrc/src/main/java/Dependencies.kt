//// TODO: マルチモジュールの時にやりたいなというネタのメモ
//import org.gradle.api.artifacts.ProjectDependency
//import org.gradle.api.artifacts.dsl.DependencyHandler

/**
 * 複数個所で利用されるバージョン情報
 */
private object Versions {
    const val kotlin = "1.3.72"
}

/**
 * DependencyHandler.add(CLASSPATH_CONFIGURATION, dependencyNotation) の dependencyNotation として
 * 扱われる文字列です。
 *
 * 変数の命名手順：
 *   - <groupId>:<artifactId>:<version> のうち、:<version> を削除する。
 *   - colon を 2連続の underscore に変換し、それ以外の編巣名に利用不可能な文字を underscore に変換する。
 *
 * 利用例：
 *   classpath(Classpaths.com_android_tools_build__gradle)
 */
object Classpaths {
    const val com_android_tools_build__gradle = "com.android.tools.build:gradle:4.0.1"
    const val org_jetbrains_kotlin__kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

/**
 * PluginDependenciesSpecScope.id(id) の id として扱われる文字列です。
 *
 * 変数の命名手順：
 *   - colon を 2連続の underscore に変換し、それ以外の変数名に利用不可能な文字を underscore に変換する。
 *
 * 利用例：
 *   id(Plugins.com_android_application)
 */
object Plugins {
    const val com_android_application = "com.android.application"
    const val kotlin_android_extensions = "kotlin-android-extensions"
    const val org_jetbrains_kotlin_android = "org.jetbrains.kotlin.android"
}

/**
 * dependencyNotation として扱われる文字列です。
 *
 * 変数の命名手順：
 *   - <groupId>:<artifactId>:<version> のうち、:<version> を削除する。
 *   - colon を 2連続の underscore に変換し、それ以外の変数名に利用不可能な文字を underscore に変換する。
 *
 * 利用例：
 *   coreLibraryDesugaring(Deps.com_android_tools__desugar_jdk_libs)
 *   implementation(Deps.androidx_appcompat__appcompat)
 *   testImplementation(Deps.junit__junit)
 *   androidTestImplementation(Deps.androidx_test_espresso__espresso_core)
 */
object Deps {
    const val androidx_appcompat__appcompat = "androidx.appcompat:appcompat:1.1.0"
    const val androidx_constraintlayout__constraintlayout = "androidx.constraintlayout:constraintlayout:1.1.3"
    const val androidx_test_espresso__espresso_core = "androidx.test.espresso:espresso-core:3.2.0"
    const val androidx_test_ext__junit = "androidx.test.ext:junit:1.1.1"
    const val com_android_tools__desugar_jdk_libs = "com.android.tools:desugar_jdk_libs:1.0.10"
    const val junit__junit = "junit:junit:4.12"
    const val org_jetbrains_kotlin__kotlin_stdlib_jdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
}

//// TODO: マルチモジュールの時にやりたいなというネタのメモ
///**
// * DependencyHandler.project(path: String, configuration: String?) で path のみ指定し configuration を
// * 指定しない場合の dependencyNotation として扱われる [ProjectDependency] です。
// *
// * 変数の命名手順：
// *   - project(":aaa:bbb") のような形式をベースとする。
// *   - 先頭を大文字にする。(Pが大文字になる)
// *   - colon を 2連続の underscore に変換する。
// *   - 括弧とダブルクウォーテーションを削除する。
// *   - 変数名に利用不可能な文字を underscore に変換する。
// *
// * 利用例：
// *   implementation(Project__kotlin)
// */
//val DependencyHandler.Project__kotlin: ProjectDependency
//    get() = project(":kotlin")