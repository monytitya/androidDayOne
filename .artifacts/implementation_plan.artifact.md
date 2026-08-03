# Implement Fragment Navigation and Result Passing

The user wants to implement `FragmentA` with navigation to `FragmentB` and receive results back using the `FragmentResultAPI`. Several components are missing or incorrectly configured:
1. `viewBinding` is not enabled in `build.gradle.kts`.
2. `fragment-ktx` dependency is missing.
3. `FragmentB` and its layout are missing.
4. `activity_main.xml` lacks a fragment container.
5. `FragmentA.kt` has syntax errors in `setFragmentResultListener`.

## Proposed Changes

### [Component: Build Configuration]
#### [MODIFY] [build.gradle.kts](file:///C:/Android2026/ANDROIDS26/AndroidsOneDay/app/build.gradle.kts)
- Enable `viewBinding` in `buildFeatures`.
- Add `androidx.fragment:fragment-ktx` dependency.

### [Component: Layouts]
#### [MODIFY] [activity_main.xml](file:///C:/Android2026/ANDROIDS26/AndroidsOneDay/app/src/main/res/layout/activity_main.xml)
- Add a `FragmentContainerView` with ID `fragment_container`.

#### [NEW] [fragment_a.xml](file:///C:/Android2026/ANDROIDS26/AndroidsOneDay/app/src/main/res/layout/fragment_a.xml)
- Define `tvResult` and `btnNavigate`.

#### [NEW] [fragment_b.xml](file:///C:/Android2026/ANDROIDS26/AndroidsOneDay/app/src/main/res/layout/fragment_b.xml)
- Define a button to send data back to `FragmentA`.

#### [DELETE] [fragement.xml](file:///C:/Android2026/ANDROIDS26/AndroidsOneDay/app/src/main/res/layout/fragement.xml)
- Remove typo file.

### [Component: Fragments]
#### [MODIFY] [FragmentA.kt](file:///C:/Android2026/ANDROIDS26/AndroidsOneDay/app/src/main/java/com/example/androidsoneday/FragmentA.kt)
- Fix `setFragmentResultListener` lambda arguments.
- Add missing imports.

#### [NEW] [FragmentB.kt](file:///C:/Android2026/ANDROIDS26/AndroidsOneDay/app/src/main/java/com/example/androidsoneday/FragmentB.kt)
- Implement `FragmentB` which sends a result back when a button is clicked.

## Verification Plan

### Automated Tests
- Run `gradlew assembleDebug` to ensure all binding classes are generated and code compiles.

### Manual Verification
- Deploy the app.
- Verify navigation from A to B.
- Verify data passing from B to A via Fragment Result API.
