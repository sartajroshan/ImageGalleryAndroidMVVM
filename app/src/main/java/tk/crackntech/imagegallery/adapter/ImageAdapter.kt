package tk.crackntech.imagegallery.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.item_image.view.*
import tk.crackntech.imagegallery.R
import tk.crackntech.imagegallery.data.model.Photo

class ImageAdapter(val listener:ClickListener):RecyclerView.Adapter<ImageAdapter.holder>() {
    private var items:List<Photo> = ArrayList<Photo>()

    interface ClickListener{
        fun onClick(photo: Photo)
    }

    class holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.holder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_image,parent,false)

        return holder(v)
    }

    override fun getItemCount()=items.size

    override fun onBindViewHolder(holder: ImageAdapter.holder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(items.get(position).url_s)
            .placeholder(R.drawable.placeholder)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(holder.binding.image)
        holder.itemView.txt.text = items.get(position).title
        holder.itemView.setOnClickListener {
            listener.onClick(items.get(position))
        }

    }

    fun update(data:List<Photo>)
    {
        this.items = data
        notifyDataSetChanged()
    }
}