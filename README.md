# This Repository involves full basics and advance Knoledge for Kotlin App Development with XML
# Layouts
# XML
# Activities
# Fragments
# BottomNavigation
# SibebarNavigationDrawer
# DataBinding
for data binding you only have to go to build.gradle module level file and add -----> buildFeatures {dataBinding = true}
# ViewModel
        // ViewModel
        1. Go to plugins and add id 'kotlin-kapt'
        val lifecycle_version = "2.6.1"
        ViewModel
        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
# LiveData
        // LiveData
        implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
        Annotation processor
        kapt("androidx.lifecycle:lifecycle-compiler:$lifecycle_version")
# ROOM Database
        // To use Room Database
         val room_version = "2.5.2"

        implementation("androidx.room:room-runtime:$room_version")
        annotationProcessor("androidx.room:room-compiler:$room_version")
  
        To use Kotlin annotation processing tool (kapt)
        kapt("androidx.room:room-compiler:$room_version")
      
        optional - Kotlin Extensions and Coroutines support for Room
        implementation("androidx.room:room-ktx:$room_version")
# MVVM 
# Architecture Components
# Api 
# Retrofit
        // Retrofit
        implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
        implementation 'com.squareup.retrofit2:retrofit:2.9.0'
        
# Dependency Injection DI using Dagger-Hilt
        // Dagger-Hilt
        First, add the hilt-android-gradle-plugin plugin to your project's root build.gradle file:
        
        plugins {
              id("com.google.dagger.hilt.android") version "2.44" apply false
        }
        
        Then, apply the Gradle plugin and add these dependencies in your app/build.gradle file:
        plugins {
            kotlin("kapt")
            id("com.google.dagger.hilt.android")
        }

      dependencies {
          implementation("com.google.dagger:hilt-android:2.44")
          kapt("com.google.dagger:hilt-android-compiler:2.44")
      }

      Allow references to generated code
      kapt {
        correctErrorTypes = true
      }

      android {
      compileOptions {
          sourceCompatibility = JavaVersion.VERSION_1_8
          targetCompatibility = JavaVersion.VERSION_1_8
         }
     }
    
# lifecycle components 
# SQL
# phpMyAdmin
# Xampp localhost
# Firebase
# Firestore + Storage + Authentication
        // Following includes all Dependencies for Firebase
        
        Firebase Authentication
        dependencies {
         Import the BoM for the Firebase platform
         implementation(platform("com.google.firebase:firebase-bom:32.1.1"))

         Add the dependency for the Firebase Authentication library
         When using the BoM, you don't specify versions in Firebase library dependencies
         implementation("com.google.firebase:firebase-auth-ktx")
        }

        Realtime Database
        dependencies {
         Import the BoM for the Firebase platform
         implementation(platform("com.google.firebase:firebase-bom:32.1.1"))

         Add the dependency for the Realtime Database library
         When using the BoM, you don't specify versions in Firebase library dependencies
         implementation("com.google.firebase:firebase-database-ktx")
        }

        Firestore Database
        dependencies {
         Import the BoM for the Firebase platform
         implementation(platform("com.google.firebase:firebase-bom:32.1.1"))

         Declare the dependency for the Cloud Firestore library
         When using the BoM, you don't specify versions in Firebase library dependencies
         implementation("com.google.firebase:firebase-firestore-ktx")
        }

        Storage
        dependencies {
         Import the BoM for the Firebase platform
         implementation(platform("com.google.firebase:firebase-bom:32.1.1"))

         Add the dependency for the Cloud Storage library
         When using the BoM, you don't specify versions in Firebase library dependencies
         implementation("com.google.firebase:firebase-storage-ktx")
        }

        
# In future I will add JetPack Compose 
# copyright @fatiq


