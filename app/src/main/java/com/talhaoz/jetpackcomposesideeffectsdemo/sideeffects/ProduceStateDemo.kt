package com.talhaoz.jetpackcomposesideeffectsdemo.sideeffects

import android.media.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import com.talhaoz.jetpackcomposesideeffectsdemo.Result

@Composable
fun ProduceStateDemo(
    url: String,
    imageRepository: ImageRepository
): State<Result<Image>> {

    // Creates a State<T> with Result.Loading as initial value
    // If either `url` or `imageRepository` changes, the running producer
    // will cancel and will be re-launched with the new inputs.
    return produceState<Result<Image>>(initialValue = Result.loading(), url, imageRepository) {
        // In a coroutine, can make suspend calls
        val image = imageRepository.load(url)
        // Update State with either an Error or Success result.
        // This will trigger a recomposition where this State is read
        value = if (image == null) {
            Result.failed("Call Failed")
        } else {
            Result.Success(image)
        }
    }
}

class ImageRepository {
    fun load(url: String): Image? {
        return null
    }
}