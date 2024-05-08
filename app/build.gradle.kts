plugins {
    id ("com.android.application")
    id ("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id ("org.jetbrains.kotlin.android")


}

android {
    namespace = "com.example.appyoutube"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.appyoutube"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    dataBinding{
        enable = true
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //sdp
    implementation("com.intuit.sdp:sdp-android:1.0.6")
    //DungLVHilt android
    implementation ("com.google.dagger:hilt-android:2.43.2")
    kapt ("com.google.dagger:hilt-android-compiler:2.43.2")
    annotationProcessor ("com.google.dagger:hilt-android-compiler:2.43.2")

    //timber
    implementation( "com.jakewharton.timber:timber:5.0.1")
//    add nav
    implementation ("androidx.navigation:navigation-fragment-ktx:$2.4.0")
    implementation ("androidx.navigation:navigation-ui-ktx:$2.4.0")
    //RoomDataBase
//    def room_version = "2.5.0"
//    //noinspection GradleDependency
//    implementation "androidx.room:room-ktx:$room_version"
//    kapt "androidx.room:room-compiler:$room_version"
    //lottie
    implementation("com.airbnb.android:lottie:6.1.0")
    //circleimageview
    implementation("de.hdodenhof:circleimageview:3.1.0")
//glide
    implementation ("com.github.bumptech.glide:glide:4.13.0")

}


