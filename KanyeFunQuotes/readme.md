# Kanye Quotes Android Application

This Android application fetches and displays inspirational (and sometimes quirky) quotes from Kanye West using the public "[https://api.kanye.rest](https://api.kanye.rest)" API. The application is built using Jetpack Compose and follows the Material You design guidelines for a modern and adaptive user interface.

## Features

* **Displays a random Kanye West quote** fetched from the API upon opening the app.
* **Refresh Button:** Tap the refresh button (floating action button with a refresh icon) to load a new quote.
* **Material You Themed:** The application dynamically adapts its color scheme based on the user's device theme and wallpaper, providing a personalized experience.
* **Bordered Quote Display:** The displayed quote is enclosed in a light border, with the border color matching the refresh button's color scheme for visual consistency.
* **Image at the Top:** An image is displayed at the top of the quote screen, adding a visual element to the application.

## Technologies Used

* **Jetpack Compose:** A modern declarative UI toolkit for building native Android UIs.
* **Kotlin:** The primary programming language for Android development.
* **Retrofit:** A type-safe HTTP client for Android and Java, used for making network requests to the Kanye REST API.
* **Gson:** A Java library used by Retrofit to automatically serialize/deserialize Java objects to/from JSON.
* **ViewModel:** An Android Architecture Component used to manage UI-related data in a lifecycle-conscious way.
* **Coroutines:** Kotlin's concurrency framework for managing asynchronous tasks, such as network requests.
* **Material Design 3 (Material You):** The latest iteration of Google's design system, implemented through Jetpack Compose Material 3.

## Setup and Installation

1.  **Clone the repository** (if you have the project in a Git repository).
2.  **Open the project in Android Studio.**
3.  **Ensure you have an active internet connection** to fetch quotes from the API.
4.  **Build and run the application** on an Android emulator or a physical Android device.

## Application Structure

The main components of the application are:

* **`MainActivity.kt`:** The main entry point of the application, responsible for setting up the Compose UI.
* **`QuoteScreen.kt`:** A Composable function that defines the main screen of the application, displaying the quote, image, and refresh button. It interacts with the `MainViewModel`.
* **`MainViewModel.kt`:** A ViewModel class that fetches quotes from the API and manages the UI state (loading, quote data, error).
* **`ApiService.kt`:** Defines the Retrofit interface for interacting with the Kanye REST API.
* **`QuoteResponse.kt`:** (Based on the likely structure of the API response) A data class representing the JSON response from the API, containing the quote.
* **`ui.theme` package:** Contains the Material You theme configuration for the application.
* **`res/drawable`:** Contains the image used at the top of the quote screen (you'll need to add your own image file here).
* **`res/mipmap`:** Contains the application icon files.

## Adding Your Own Image

To add your own image at the top of the quote screen:

1.  Place your image file (e.g., `my_kanye_image.png`) in the `app/res/drawable` directory.
2.  In `QuoteScreen.kt`, update the `Image` composable to reference your image file:

    ```kotlin
    Image(
        painter = painterResource(id = R.drawable.my_kanye_image),
        contentDescription = "Kanye West",
        // ... other modifiers
    )
    ```

## Application Icon

The application icon is configured through the "Image Asset" tool in Android Studio. To update or change the application icon:

1.  In the "Project" window, right-click on the `res` folder.
2.  Select **New > Image Asset**.
3.  Choose **Launcher Icons (Adaptive and Legacy)** as the Icon Type.
4.  Configure the **Foreground Layer** (your icon image) and **Background Layer** (color or image).
5.  Adjust any options as needed and click **Next** and **Finish**.

## Future Enhancements

* Displaying a history of previously fetched quotes.
* Allowing users to share quotes to other applications.
* Adding more styling options or animations.
* Error handling for network issues.

## License

[Your License Information Here (e.g., MIT License)]
