package maxim.derboven.moviereviewer.adapters
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import maxim.derboven.moviereviewer.R
//import maxim.derboven.moviereviewer.fragments.ReviewsFragment
//import maxim.derboven.moviereviewer.model.Review
//
//class ReviewsAdapter(private val context: ReviewsFragment) :
//    RecyclerView.Adapter<ReviewsAdapter.MovieReviewViewHolder>() {
//    private var dataset: MutableList<Review> = mutableListOf()
//
//    class MovieReviewViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
//        val txtAuthor: TextView = view.findViewById(R.id.txtAuthor)
//        val txtComment: TextView = view.findViewById(R.id.txtComment)
//        val txtRating: TextView = view.findViewById(R.id.txtRating)
//        val txtCreatedAt: TextView = view.findViewById(R.id.txtCreatedAt)
//    }
//
//    interface onItemClickListener {
//        fun onItemClick(position: Int)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieReviewViewHolder {
//        val adapterLayout = LayoutInflater.from(parent.context)
//            .inflate(R.layout.poster_item, parent, false)
//
//        return MovieReviewViewHolder(adapterLayout)
//    }
//
//    override fun onBindViewHolder(holder: MovieReviewViewHolder, position: Int) {
//        val review = dataset[position]
//        if (review.published) {
//            holder.txtAuthor.text = dataset[position].author
//            holder.txtComment.text = dataset[position].comment
//            holder.txtCreatedAt.text = dataset[position].createdAt.toString()
//            holder.txtRating.text = dataset[position].rating.toString() + "/5";
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return dataset.size
//    }
//
//    fun setData(data: List<Review>) {
//        dataset.clear()
//        dataset.addAll(data)
//        notifyDataSetChanged()
//        apply { }
//    }
//
//
//}