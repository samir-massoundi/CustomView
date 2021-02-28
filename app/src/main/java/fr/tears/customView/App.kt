package fr.tears.customView

import android.app.Application
import androidx.core.content.res.ResourcesCompat
import androidx.core.content.res.ResourcesCompat.*

class App: Application()
{
    companion object {
        lateinit var instance: App
        val sColors : List<Int> by lazy {
            listOf(
                getColor(instance.resources, R.color.red,null),
                getColor(instance.resources, R.color.blue,null),
                getColor(instance.resources, R.color.green,null)
            )
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}