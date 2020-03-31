package tk.crackntech.imagegallery.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_home.view.*
import tk.crackntech.imagegallery.App
import tk.crackntech.imagegallery.R
import tk.crackntech.imagegallery.ViewModelFactory
import tk.crackntech.imagegallery.adapter.ImageAdapter
import tk.crackntech.imagegallery.data.model.Photo
import tk.crackntech.imagegallery.ui.FullImageFragment

class HomeFragment : Fragment(),ImageAdapter.ClickListener {

    private lateinit var homeViewModel: HomeViewModel
    override fun onResume() {
        super.onResume()
        homeViewModel.getData()
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val appContainer = (activity?.application as App).appContainer
        homeViewModel = ViewModelProvider(this,ViewModelFactory(appContainer.repo)).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        root.recview.layoutManager = GridLayoutManager(this.context,2)
        root.recview.setHasFixedSize(true)
        var adapter = ImageAdapter(this)
        root.recview.adapter = adapter

        homeViewModel.photos.observe(viewLifecycleOwner, Observer {
             adapter.update(it)
        })

        homeViewModel.loading.observe(viewLifecycleOwner, Observer {
            if (it)
                root.loading.visibility = View.VISIBLE
            else
                root.loading.visibility = View.GONE
        })

        return root
    }

    override fun onClick(photo: Photo) {
        val b =Bundle()
        b.putString("url",photo.url_s)
        findNavController().navigate(R.id.fullImageFragment,b)
    }


}
