package tk.crackntech.imagegallery

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import tk.crackntech.imagegallery.api.ApiInterface
import tk.crackntech.imagegallery.data.DataRepo
import tk.crackntech.imagegallery.ui.home.HomeViewModel

class AppContainer {




    private val retrofit = getRetofit()
     val repo = DataRepo(retrofit)


   private fun getRetofit():ApiInterface{
       val builder = OkHttpClient().newBuilder()
       val interceptor = HttpLoggingInterceptor()
       interceptor.level = HttpLoggingInterceptor.Level.BODY
       builder.addInterceptor(interceptor)
       val client = builder.build()

      return Retrofit.Builder()
           .baseUrl("https://api.flickr.com/")
          .client(client)
           .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
           .addConverterFactory(GsonConverterFactory.create())
           .build().create(ApiInterface::class.java)
   }
}