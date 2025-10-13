import java.nio.file.*

// Paths to your two specific test scripts
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

// Read and count keywords in first test script
def content1 = new String(Files.readAllBytes(testFile1))
def counts1 = countWebUIKeywords(content1)

// Read and count keywords in second test script
def content2 = new String(Files.readAllBytes(testFile2))
def counts2 = countWebUIKeywords(content2)

// Print results
println "Keyword counts in Login"
counts1.each { k, v -> println "  $k : $v" }
println ""

println "Keyword counts in Signup"
counts2.each { k, v -> println "  $k : $v" }
println ""
