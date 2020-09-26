package jp.kaleidot725.movie

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.ImageLoader
import coil.fetch.VideoFrameFileFetcher
import coil.fetch.VideoFrameUriFetcher
import coil.load
import coil.request.videoFrameMicros
import coil.request.videoFrameMillis
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val imageLoader = ImageLoader.Builder(applicationContext)
                .componentRegistry {
                    add(VideoFrameFileFetcher(applicationContext))
                    add(VideoFrameUriFetcher(applicationContext))
                }
                .build()

        val url = Uri.parse("android.resource://" + packageName + "/" + R.raw.movie)
        image_view.load(url, imageLoader) { videoFrameMillis(1000) }
    }
}