package maxim.derboven.moviereviewer.model

import java.time.LocalDate

fun getMovies(): Array<Movie> {
    return arrayOf(
        Movie(1,false,"Avatar", LocalDate.of(2009,11,18),162,Mediatype.MOVIE,"A paraplegic marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.","avatar"),
        Movie(2,false,"I Am Legend", LocalDate.of(2007,12,14),101,Mediatype.MOVIE,"Years after a plague kills most of humanity and transforms the rest into monsters, the sole survivor in New York City struggles valiantly to find a cure.","legend"),
        Movie(3,false,"300", LocalDate.of(2012,3,9),117,Mediatype.MOVIE,"King Leonidas of Sparta and a force of 300 men fight the Persians at Thermopylae in 480 B.C.","the300"),
        Movie(14,true,"Rogue One: A Star Wars Story", LocalDate.of(2022,12,16),130,Mediatype.SERIE,"The Rebellion makes a risky move to steal the plans to the Death Star, setting up the epic saga to follow.","starwars"),
    );
}