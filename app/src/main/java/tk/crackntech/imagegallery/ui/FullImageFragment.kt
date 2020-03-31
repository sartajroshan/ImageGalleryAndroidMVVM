package tk.crackntech.imagegallery.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.NavArgs
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_full_image.view.*
import tk.crackntech.imagegallery.R


/**
 * A simple [Fragment] subclass.
 */
class FullImageFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val v = inflater.inflate(R.layout.fragment_full_image, container, false)
        Glide.with(context!!)
            .load(arguments?.getString("url"))
            .placeholder(R.drawable.placeholder)
            .into(v.fullimg)
        return v
    }

}
