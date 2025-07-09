plugins {
    alias(libs.plugins.appstructure.android.application)
    alias(libs.plugins.appstructure.android.application.compose)
    alias(libs.plugins.appstructure.hilt)
}

android {
    namespace = "com.nikasov.appstructure"
    defaultConfig {
        applicationId = "com.nikasov.appstructure"
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(project(":feature:hub"))

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.navigation.compose)

    ksp(libs.hilt.compiler)
    kspTest(libs.hilt.compiler)
}