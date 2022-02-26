package maxim.derboven.moviereviewer.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import maxim.derboven.moviereviewer.R
import maxim.derboven.moviereviewer.adapters.ItemAdapter
import maxim.derboven.moviereviewer.model.getMovies


class ItemsActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        recyclerView  = findViewById(R.id.rv_items)
        var adapter = ItemAdapter(this, getMovies())
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : ItemAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@ItemsActivity, MainActivity::class.java)
                intent.putExtra("positie", position)
                startActivity(intent)
            }
        })

        recyclerView.setHasFixedSize(true)
    }
}