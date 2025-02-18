import platform.UIKit.UIDevice

class Platform() {
    val name: String =
        UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}