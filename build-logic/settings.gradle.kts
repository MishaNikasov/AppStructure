pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
    }

    dependencyResolutionManagement {
        versionCatalogs {
            create("libs") {
                from(files("../gradle/libs.versions.toml"))
            }
        }
    }
}

rootProject.name = "build-logic"
include(":convention")
