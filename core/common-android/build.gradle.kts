plugins {
    alias(libs.plugins.appstructure.android.library)
    alias(libs.plugins.appstructure.hilt)
}

dependencies {
    api(projects.core.common)

    implementation(libs.timber)
}