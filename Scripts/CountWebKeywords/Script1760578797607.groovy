import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Define expected URLs for login and signup
String expectedLoginUrl = "https://example.com/login"
String expectedSignupUrl = "https://example.com/signup"

// Navigate to Login page
WebUI.navigateToUrl(expectedLoginUrl)
String actualLoginUrl = WebUI.getUrl()

// Verify login URL
if (WebUI.verifyMatch(actualLoginUrl, expectedLoginUrl, false, FailureHandling.CONTINUE_ON_FAILURE)) {
    println "Login URL verification PASSED"
} else {
    println "Login URL verification FAILED"
}

// Navigate to Signup page
WebUI.navigateToUrl(expectedSignupUrl)
String actualSignupUrl = WebUI.getUrl()

// Verify signup URL
if (WebUI.verifyMatch(actualSignupUrl, expectedSignupUrl, false, FailureHandling.CONTINUE_ON_FAILURE)) {
    println "Signup URL verification PASSED"
} else {
    println "Signup URL verification FAILED"
}
