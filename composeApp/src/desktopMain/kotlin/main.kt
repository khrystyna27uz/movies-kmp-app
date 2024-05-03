import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.khrystynasika.movievision.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Movie Vision",
    ) {
        App()
    }
}