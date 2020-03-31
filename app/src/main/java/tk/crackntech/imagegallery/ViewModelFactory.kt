package tk.crackntech.imagegallery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import tk.crackntech.imagegallery.data.DataRepo
import tk.crackntech.imagegallery.ui.home.HomeViewModel

class ViewModelFactory(val repo: DataRepo):ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(repo) as T
    }

}