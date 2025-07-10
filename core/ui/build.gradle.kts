plugins {
    alias(libs.plugins.appstructure.android.library)
    alias(libs.plugins.appstructure.android.library.compose)
}

android {
    namespace = "com.nikasov.ui"
}

dependencies {
    implementation(projects.core.design)
}