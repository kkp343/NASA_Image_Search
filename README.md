# Welcome to NASA_Image_Search Library

## Overview of our APP

* This app basically displays the image content including the picture details like Title,Description
  and Date the picture was taken.
* Primary purpose is that All the important Image details were displayed accordingly such that we
  can keep a log of memory with important achievements.

## Libraries used in this APP

* Android Jetpack Libraries : These provide all the necessary components, tools and necessary
  guidance in order to build our app. Basic architecture components include
    * Navigation Component : Used for navigating between different screens.
    * Lifecycle : Used for handling various lifecycle activities of fragments used in the app
    * ViewModel : Used to manage and store the observed live data coming from various forms and
      display them on UI nad helps data survive configuration changes.
    * Paging Library : Used to load large data sets incrementally and cache them to reduce memory
      consumption while reloading. All these features helps us to create most compatible and robust
      apps with highest scalability.
* Retrofit : Best type-safe HTTP client for consuming RESTful API's by transforming API endpoints
  into Kotlin Interfaces that reduces the errors.
* Kotlin Coroutines: Used for maintaining asynchronous code work better that helps to read and
  maintain better.
* Glide : Library used to bind resources from various network, local sources and cache them for
  reuse.
* Dagger/Hilt : Dependency Injection Library used for providing dependencies to classes and helps
  the app manage better that helps in maintainability.
* Junit: Testing library used in writing unit test cases that uses annotations, assertions and test
  runners for better testing possibilities using gradle and maven.
    * OkHttp Library : MockWebServer used to test the given api by creating a fake web server that
      helps in test app's behaviour in different scenarios.

## Overview of APP Architecture

* The architectural pattern used in this app is Model-View-ViewModel (MVVM) pattern.
* The Gallery Fragment and the associated GalleryViewModel class will represent the View layer which
  helps in managing all the UI interactions between screens. It basically abstract view and provides
  it to the model layer.
* The model layer is mostly handled by Repository and DataClasses which helps in managing all the
  data logic of the app. It helps in retrieving necessary data from the api source and helps in
  providing that data to teh ViewModel.
* GalleryViewModel helps in managing all the data coming from Repository and is displayed on
  GalleryFragment. It has objects that contain the images list from the API call and retrieve those
  images through search query and display them in GalleryFragment.
* ImageAdapter helps in binding the views and LoadStateAdapter provides views for different
  loadStates of PagingDataAdapter that help in smooth paging experience while scrolling the
  recyclerView.
* ImageDetailsFragment will have the necessary information fro an image retrieved from
  GalleryFragment. It also uses Glide to load nad bind image data from the network and cache the
  image for future reference.
* MainActivity contains NavHostFragment responsible for navigating different screens using
  navigation component.

## Build/Run the app.

* Download from the project.zip file and extract the workSpace folder
* Open the project in your local device android studio.
* Connect your Android Device or Emulator from Android Studio.
* Build the app by taping on "RUN" button to install the app in your specified emulatorSkin or
  Device.
* Once installed, navigate through the screens for the implementation of the app.


  

      
