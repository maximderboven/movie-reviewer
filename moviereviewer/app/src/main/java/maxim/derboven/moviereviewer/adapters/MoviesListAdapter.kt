package maxim.derboven.moviereviewer.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import maxim.derboven.moviereviewer.R
import maxim.derboven.moviereviewer.fragments.MoviesListFragment
import maxim.derboven.moviereviewer.model.Movie
import maxim.derboven.moviereviewer.model.getMovies
import kotlin.Array
import kotlin.Int


class MoviesListAdapter(
    private val context: MoviesListFragment,
    private val dataset: Array<Movie>,

    ) : RecyclerView.Adapter<MoviesListAdapter.ItemViewHolder>() {
    private lateinit var clickListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener) {
        clickListener = listener;
    }
    // inner viewholder class
    class ItemViewHolder(private val view: View, listener: onItemClickListener) : RecyclerView.ViewHolder(view) {
        val txtItem_title: TextView = view.findViewById(R.id.txtItem_title)
        val txtItem_runtime: TextView = view.findViewById(R.id.txtItem_runtime)
        val txtItem_releasedate: TextView = view.findViewById(R.id.txtItem_releasedate)
        val imgItem_poster: ImageView = view.findViewById(R.id.imgItem_poster)

        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition);
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_movie, parent, false)
        return ItemViewHolder(adapterLayout,clickListener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.txtItem_releasedate.text = dataset[position].released.toString();
        holder.txtItem_runtime.text = dataset[position].runtime.toString() + " min.";
        holder.txtItem_title.text = dataset[position].title;
        holder.imgItem_poster.setImageResource(context.getResources().getIdentifier("@drawable/"+ getMovies()[position].poster, null, context.activity?.packageName))
    }

    override fun getItemCount() = dataset.size

}