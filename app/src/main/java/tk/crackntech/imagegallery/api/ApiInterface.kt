package tk.crackntech.imagegallery.api

import io.reactivex.Single
import retrofit2.http.GET
import tk.crackntech.imagegallery.data.model.Images
import tk.crackntech.imagegallery.data.model.Photos

interface ApiInterface {

    @GET("services/rest/?method=flickr.photos.getRecent&per_page=20&page=1&api_key=6f102c62f41998d151e5a1b48713cf13&format=json&nojsoncallback=1&extras=url_s")
    fun getImages(): Single<Images>
}