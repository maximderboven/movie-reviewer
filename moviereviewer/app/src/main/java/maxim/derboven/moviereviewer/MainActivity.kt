package maxim.derboven.moviereviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import maxim.derboven.moviereviewer.model.getMovies

class MainActivity : AppCompatActivity() {

    //knoppen

    var counter = 0;
    lateinit var btnNext: Button;
    lateinit var btnPrevious: Button;

    //textvelden
    lateinit var txtTitle: TextView;
    lateinit var txtReleasedate: TextView;
    lateinit var txtRuntime: TextView;
    lateinit var txtPlot: TextView;

    //images
    lateinit var imgComingsoon: ImageView;
    lateinit var imgPoster: ImageView;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnNext = findViewById(R.id.btnNext);
        btnPrevious = findViewById(R.id.btnPrevious);
        txtTitle = findViewById(R.id.txtTitle);
        txtReleasedate = findViewById(R.id.txtReleasedate);
        txtRuntime = findViewById(R.id.txtRuntime);
        txtPlot = findViewById(R.id.txtPlot);
        imgComingsoon = findViewById(R.id.imgComingsoon);
        imgPoster = findViewById(R.id.imgPoster);

        btnNext.setOnClickListener{next()};
        btnPrevious.setOnClickListener{previous()};
        fillInfo(counter);
    }

    private fun previous() {
        fillInfo(--counter);
        btnPrevious.isEnabled = counter != 0
        btnNext.isEnabled = true;
    }

    private fun next() {
        fillInfo(++counter);
        btnNext.isEnabled = counter != getMovies().size-1
        btnPrevious.isEnabled = true;
    }

    private fun fillInfo(id:Int) {
        txtPlot.text = getMovies()[id].plot;
        txtReleasedate.text = getMovies()[id].released.toString();
        txtRuntime.text = getMovies()[id].runtime.toString() + "min.";
        txtTitle.text = getMovies()[id].title;

        imgPoster.setImageResource(getResources().getIdentifier("@drawable/"+getMovies()[id].poster, null, getPackageName()))
        if (getMovies()[id].comingSoon) {
            imgComingsoon.setImageResource(R.drawable.comingsoon)
        } else {imgComingsoon.setImageDrawable(null)}
    }

}