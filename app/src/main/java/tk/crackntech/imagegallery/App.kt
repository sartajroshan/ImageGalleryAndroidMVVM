package tk.crackntech.imagegallery

import android.app.Application
import androidx.multidex.MultiDexApplication

class App: MultiDexApplication() {
    val appContainer = AppContainer()
    override fun onCreate() {
        super.onCreate()
    }
}