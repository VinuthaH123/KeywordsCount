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

// Paths to your two test scripts
def testFile1 = Paths.get('C:/Users/Vishnu/Katalon Studio/Count Keywords/Scripts/Login/Script1760368386897.groovy')
def testFile2 = Paths.get('C:/Users/Vishnu/Katalon Studio/Count Keywords/Scripts/Signup/Script1760369161699.groovy')

def countWebUIKeywords(String content) {
	def matcher = content =~ /WebUI\.\w+\s*\(/
	def keywordCounts = [:].withDefault{0}
	matcher.each { m ->
		def keyword = m.replaceAll(/\s*\(/, '')
		keywordCounts[keyword]++
	}
	return keywordCounts
}

def mergeCounts(map1, map2) {
	def merged = [:].withDefault{0}
	(map1.keySet() + map2.keySet()).each { key ->
		merged[key] = map1.get(key, 0) + map2.get(key, 0)
	}
	return merged
}

// Read content and count keywords in each file
def content1 = new String(Files.readAllBytes(testFile1))
def counts1 = countWebUIKeywords(content1)

def content2 = new String(Files.readAllBytes(testFile2))
def counts2 = countWebUIKeywords(content2)

// Merge counts to get total counts of all keywords
def totalCounts = mergeCounts(counts1, counts2)

// Print total counts
println "Total WebUI keyword counts from both test cases:"
totalCounts.each { k, v -> println "  $k : $v" }

