# Restructure Project and Implement Material UI Showcase

The goal is to align the project structure with the provided diagram and implement a Material UI showcase following modern Material Design 3 principles.

## User Review Required

> [!IMPORTANT]
> The requested structure separates "Components" (Activity, Service, etc.) and "Material UI" (Button, TextField, etc.). I will create packages for these categories and move existing code accordingly.
> I will also upgrade the project to use **Material 3 (XML)** to ensure the UI components follow the latest standards.

## Proposed Changes

### [Component: Build Configuration]
#### [MODIFY] [build.gradle.kts](file:///C:/Android2026/ANDROIDS26/AndroidsOneDay/app/build.gradle.kts)
- Add `com.google.android.material:material:1.12.0` dependency for XML Material components.

### [Component: Package Reorganization]
Move files and create new packages to match the diagram:
- `com.example.androidsoneday.components.activity`: `MainActivity`
- `com.example.androidsoneday.components.service`: `ExampleService` [NEW]
- `com.example.androidsoneday.components.receiver`: `ExampleReceiver` [NEW]
- `com.example.androidsoneday.components.provider`: `ExampleProvider` [NEW]
- `com.example.androidsoneday.materialui`: Showcase fragments for:
    - `ButtonFragment`, `TextFieldFragment`, `CardFragment`, `ToolbarFragment`, `FabFragment`, `BottomNavFragment`, `SnackbarFragment`, `DialogFragment`.

### [Component: Theming]
#### [MODIFY] [themes.xml](file:///C:/Android2026/ANDROIDS26/AndroidsOneDay/app/src/main/res/values/themes.xml)
- Update parent to `Theme.Material3.DayNight.NoActionBar`.

### [Component: UI Implementation]
I will create a main `MaterialShowcaseFragment` that acts as a hub for all the Material UI components mentioned in the diagram.

#### [NEW] [FragmentShowcase.kt](file:///C:/Android2026/ANDROIDS26/AndroidsOneDay/app/src/main/java/com/example/androidsoneday/materialui/FragmentShowcase.kt)
- A fragment demonstrating:
    - **Button**: Standard, Outlined, and Text buttons.
    - **TextField**: Filled and Outlined text fields with validation.
    - **Card**: Elevated and Outlined Material Cards.
    - **FAB**: Floating Action Button interaction.
    - **Snackbar**: Showing a message with an action.
    - **Dialog**: Material 3 Alert Dialog.
- **Bottom Navigation**: Implemented in `MainActivity` to switch between "Components" and "Material UI" views.

## Verification Plan

### Automated Tests
- Run `gradlew assembleDebug` to verify compilation.

### Manual Verification
- Deploy to a device/emulator.
- Navigate through the "Material UI" section to verify each component renders correctly with Material 3 styling.
- Verify that the new package structure is correctly reflected in the IDE.
