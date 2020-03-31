package tk.crackntech.imagegallery.data

import io.reactivex.Single
import tk.crackntech.imagegallery.api.ApiInterface
import tk.crackntech.imagegallery.data.model.Images
import tk.crackntech.imagegallery.data.model.Photos

class DataRepo(private val apiInterface: ApiInterface) {

    fun getImages():Single<Images>{
        return apiInterface.getImages()
    }
}