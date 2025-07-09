plugins {
    alias(libs.plugins.appstructure.android.feature)
}

android {
    namespace = "com.nikasov.appstructure.hub"
}

dependencies {
    implementation(project(":feature:home"))
}