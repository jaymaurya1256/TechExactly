# Senior Android Developer Task

This repository contains the solution for the Senior Android Developer position task at Tech Exactly. The task involved implementing an Android application with specific requirements, including UI design, dynamic app list, local search functionality, and a toggle button.

## Task Requirements

1. **Pixel-Perfect UI**:  
   The UI is designed as per the provided specifications. The top avatar and title are static, while the app list is dynamic and scrollable.

2. **ViewPager Implementation**:  
   A `ViewPager` has been implemented to display multiple pages (if required in the design).

3. **Local Search Feature**:  
   A search functionality has been added, where the list of apps filters dynamically as the user types. Only items whose names start with the entered characters are shown.

4. **Toggle Button**:  
   A toggle button has been implemented to enable or disable a feature, with the state properly reflecting as "ON" or "OFF".

## Architecture

- **MVVM (Model-View-ViewModel)**:  
   The project follows the MVVM architecture, where:
   - **Model** represents the data layer (API responses).
   - **ViewModel** holds and manages UI-related data in a lifecycle-conscious way.
   - **View** is the UI that observes the ViewModel.

- **Retrofit**:  
   Retrofit is used to handle network operations, fetching app list data from the provided API endpoint.

- **Kotlin**:  
   The project is developed using Kotlin, which is the preferred language for Android development.

## Libraries Used

- **Retrofit**: For network calls to fetch data from the API.
- **Coil**: For image loading into the ImageViews.
- **Material Components**: For UI components like `SwitchMaterial` and `TextInputLayout`.
- **ViewPager2**: For implementing the view pager functionality.

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/your-repo-name.git
   
2. Open the project in Android Studio.

3. Sync the project with Gradle files.

4. Build and run the app on an emulator or a physical device.

API Endpoint

The app makes a POST request to the following API endpoint to fetch the app list:

POST https://navkiraninfotech.com/g-mee-api/api/v1/apps/list?kid_id=378

Screenshots
UI Preview:

App List:

Conclusion

This project implements the required features with a focus on clean architecture, efficient network calls using Retrofit, and user-friendly UI design. The search and toggle button functionalities are working as expected.

Feel free to contribute or open issues for any enhancements!


Make sure to replace placeholders like `yourusername` and `your-repo-name` with your actual GitHub user
