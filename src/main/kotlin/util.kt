import java.io.File

fun readInputFile(fileName: String): String {
    return File(ClassLoader.getSystemResource(fileName).file).readText().trim()
}
