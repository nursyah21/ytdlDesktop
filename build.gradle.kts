import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "com.nursyah"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    jvm {
        jvmToolchain(11)
        withJava()
    }
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation("io.ktor:ktor-client-core:2.2.1")
                implementation("io.ktor:ktor-client-cio:2.2.1")
                implementation("com.google.code.gson:gson:2.10.1")
                implementation("com.google.guava:guava:31.1-jre")
                implementation("org.apache.logging.log4j:log4j-api:2.19.0")
                implementation("org.apache.logging.log4j:log4j-core:2.19.0")
                implementation("org.bytedeco:ffmpeg-platform:5.1.2-1.5.8")
            }
        }
        val jvmTest by getting
    }
}

compose.desktop {

    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "ytdlDesktop"
            packageVersion = "1.0.0"
            //WEB_API = ""

            val icon = project.file("./src/jvmMain/resources/images/icon.png")
//            linux{
//                iconFile.set(icon)
//            }
//            windows{
//                iconFile.set(icon)
//            }
        }
    }
}
