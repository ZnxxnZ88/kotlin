import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("jvm")
    `maven-publish`
}

group = "com.example"
version = "1.0"

repositories {
    mavenLocal()
    mavenCentral()
}

kotlin {
    jvmToolchain(8)
    compilerOptions {
        allWarningsAsErrors.set(true)
        jvmTarget.set(JvmTarget.JVM_1_8)
    }

    target.compilations {
        val main by getting {
            defaultSourceSet.dependencies {
                api(kotlin("gradle-plugin-api"))
                implementation(kotlin("stdlib-jdk8"))
            }
        }

        val test by getting {
            defaultSourceSet.dependencies {
                implementation(kotlin("test-junit"))
            }
        }

        val benchmark by creating {
            associateWith(main)
            defaultSourceSet.dependencies {
                implementation(kotlin("reflect"))
            }
        }
    }
}

val runBenchmark by tasks.registering(JavaExec::class) {
    classpath = kotlin.target.compilations["benchmark"].run { runtimeDependencyFiles + output.allOutputs }
    mainClass.set("com.example.ABenchmarkKt")
}

publishing {
    publications {
        create("default", MavenPublication::class) {
            from(components.getByName("kotlin"))
            artifact(tasks.getByName("kotlinSourcesJar"))
        }
    }
    repositories {
        maven("${buildDir}/repo")
    }
}