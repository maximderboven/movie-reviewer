package maxim.derboven.moviereviewer.adapters

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import maxim.derboven.moviereviewer.R
import maxim.derboven.moviereviewer.fragments.MoviesListFragment
import maxim.derboven.moviereviewer.model.Movie
import maxim.derboven.moviereviewer.model.getMovies
import java.io.IOException
import java.io.InputStream
import java.net.MalformedURLException
import java.net.URL


class MoviesListAdapter(private val context: MoviesListFragment) :
    RecyclerView.Adapter<MoviesListAdapter.ItemViewHolder>() {

    private lateinit var clickListener: onItemClickListener
    private var dataset: MutableList<Movie> = mutableListOf()

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        clickListener = listener;
    }

    // inner viewholder class
    class ItemViewHolder(private val view: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(view) {
        val txtItem_title: TextView = view.findViewById(R.id.txtItem_title)
        val txtItem_runtime: TextView = view.findViewById(R.id.txtItem_runtime)
        val txtItem_releasedate: TextView = view.findViewById(R.id.txtItem_releasedate)
        val imgItem_poster: ImageView = view.findViewById(R.id.imgItem_poster)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition);
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_movie, parent, false)
        return ItemViewHolder(adapterLayout, clickListener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.txtItem_releasedate.text = dataset[position].released.toString();
        holder.txtItem_runtime.text = dataset[position].runtime.toString() + " min.";
        holder.txtItem_title.text = dataset[position].title;

        Glide.with(holder.imgItem_poster).load(dataset[position].poster).apply(RequestOptions().placeholder(R.drawable.placeholder)).into(holder.imgItem_poster)
    }

    override fun getItemCount() = dataset.size

    fun setData(data: List<Movie>) {
        dataset.clear()
        dataset.addAll(data)
        notifyDataSetChanged()
        apply { }
    }

}