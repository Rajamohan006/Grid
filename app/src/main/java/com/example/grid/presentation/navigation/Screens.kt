package com.example.grid.presentation.navigation

sealed class Screens(val route: String) {
    object SplashScreen: Screens("splash_screen")
    object WelcomeScreen: Screens("welcome_screen")
    object SignInScreen: Screens("login_screen")
    object SignUpScreen: Screens("signup_screen")
    object OTPScreen: Screens("otp_screen")
    object PersonalDetailsScreen: Screens("personal_details_screen")
    object HomeScreen: Screens("home_screen")
    object FilterScreen: Screens("filterScreen")
    object ApplyScreen: Screens("apply_screen")
    object CompanyDetailsScreen: Screens("company_details_screen")

    object ReachScreen: Screens("reach_screen")

    object WallScreen: Screens("wall_screen")
    object AboutScreen: Screens("about_screen")
    object CertificationScreen: Screens("certification_screen")
    object ContactScreen: Screens("contact_screen")
    object CoverLetterScreen: Screens("cover_letter_screen")
    object EducationScreen: Screens("education_screen")
    object LanguageScreen: Screens("language_screen")
    object PersonalInfoScreen: Screens("personal_info_screen")
    object SkillsScreen: Screens("skills_screen")
    object SocialProfileScreen: Screens("social_profile_screen")


    object NotificationScreen: Screens("notification_screen")

    object ProfileScreen: Screens("profile_screen")
    object SettingsScreen: Screens("setting_screen")
}