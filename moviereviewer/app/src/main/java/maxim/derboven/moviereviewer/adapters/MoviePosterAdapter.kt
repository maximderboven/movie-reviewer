package maxim.derboven.moviereviewer.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import maxim.derboven.moviereviewer.R
import maxim.derboven.moviereviewer.fragments.PostersFragment
import maxim.derboven.moviereviewer.model.Movie

class MoviePosterAdapter (private val context: PostersFragment, private val dataset: Array<Movie>) : RecyclerView.Adapter<MoviePosterAdapter.MoviePosterViewHolder> (){

    class MoviePosterViewHolder (private val view: View) : RecyclerView.ViewHolder (view) {
        val imgItem_poster: ImageView = view.findViewById (R.id.poster_item_image)
        val imgItem_stamp: ImageView = view.findViewById(R.id.poster_item_stamp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviePosterViewHolder {
        val adapterLayout = LayoutInflater.from (parent.context)
            .inflate(R.layout.poster_item, parent, false)

        return MoviePosterViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: MoviePosterViewHolder, position: Int) {
        val movie = dataset[position]
        holder.imgItem_poster.setImageResource(context.getResources().getIdentifier("@drawable/"+ dataset[position].poster, null, context.activity?.packageName))
        if (movie.comingSoon)
            holder.imgItem_stamp.setImageResource(R.drawable.comingsoon)
        else
            holder.imgItem_stamp.setImageDrawable(null)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}