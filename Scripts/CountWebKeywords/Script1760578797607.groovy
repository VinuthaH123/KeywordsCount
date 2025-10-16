import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.nio.file.*

// Replace these with your actual Groovy script file paths
def testFile1 = Paths.get('C:/Users/Vishnu/Katalon Studio/Count Keywords/Scripts/Login/Script1760368386897.groovy')
def testFile2 = Paths.get('C:/Users/Vishnu/Katalon Studio/Count Keywords/Scripts/Signup/Script1760369161699.groovy')

// Function to count WebUI keywords in a script's content
def countWebUIKeywords(String content) {
	def matcher = content =~ /WebUI\.\w+\s*\(/
	def keywordCounts = [:].withDefault{0}
	matcher.each { m ->
		def keyword = m.replaceAll(/\s*\(/, '')
		keywordCounts[keyword]++
	}
	return keywordCounts
}

// Process each file and display the results
[testFile1, testFile2].each { filePath ->
	def content = new String(Files.readAllBytes(filePath))
	def counts = countWebUIKeywords(content)
	println "Keyword counts in ${filePath.fileName}:"
	if (counts.isEmpty()) {
		println "  No WebUI keywords found."
	} else {
		counts.each { k, v -> println "  $k : $v" }
	}
	println ""
}

