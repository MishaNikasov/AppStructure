plugins {
    alias(libs.plugins.appstructure.android.library)
    alias(libs.plugins.appstructure.android.library.compose)
    alias(libs.plugins.appstructure.hilt)
}

android {
    namespace = "com.nikasov.appstructure.common_android"
}

dependencies {
    api(projects.core.common)

    implementation(libs.timber)
}