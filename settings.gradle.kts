pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "flux-android-experience"

includeBuild("../flux-android-ds")
includeBuild("../flux-android-assets")
includeBuild("../flux-android-foundation")
