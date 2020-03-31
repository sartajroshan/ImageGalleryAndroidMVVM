package tk.crackntech.imagegallery.ui.home

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import tk.crackntech.imagegallery.data.DataRepo
import tk.crackntech.imagegallery.data.model.Photo

class HomeViewModel(private val repo:DataRepo) : ViewModel() {


    private val _loading = MutableLiveData<Boolean>(true)
    val loading: LiveData<Boolean> = _loading
    private val _photos = MutableLiveData<List<Photo>>()
    val photos:LiveData<List<Photo>> = _photos



    @SuppressLint("CheckResult")
    fun getData()
    {
        _loading.value = true
        repo.getImages().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _loading.value = false
                _photos.value = it.photos.photo
            },{
                _loading.value = false
            })
    }
}