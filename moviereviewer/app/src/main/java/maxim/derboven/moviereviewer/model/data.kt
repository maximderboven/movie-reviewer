package maxim.derboven.moviereviewer.model

import java.time.LocalDate

fun getMovies(): Array<Movie> {
    return arrayOf(
        Movie(1,false,"Avatar", LocalDate.of(2009,11,18),162,Mediatype.MOVIE,"A paraplegic marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.","avatar"),
        Movie(2,false,"I Am Legend", LocalDate.of(2007,12,14),101,Mediatype.MOVIE,"Years after a plague kills most of humanity and transforms the rest into monsters, the sole survivor in New York City struggles valiantly to find a cure.","legend"),
        Movie(3,false,"300", LocalDate.of(2012,3,9),117,Mediatype.MOVIE,"King Leonidas of Sparta and a force of 300 men fight the Persians at Thermopylae in 480 B.C.","the300"),
        Movie(4,false,"The Avengers", LocalDate.of(2012,3,9),117,Mediatype.MOVIE,"Earth's mightiest heroes must come together and learn to fight as a team if they are to stop the mischievous Loki and his alien army from enslaving humanity.","avengers"),
        Movie(5,false,"The Wolf of Wall Street", LocalDate.of(2012,3,9),117,Mediatype.MOVIE,"Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.","wow"),
        Movie(6,false,"Interstellar", LocalDate.of(2012,3,9),117,Mediatype.MOVIE,"A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.","interstellar"),
        Movie(7,false,"Game of Thrones", LocalDate.of(2012,3,9),117,Mediatype.MOVIE,"While a civil war brews between several noble families in Westeros, the children of the former rulers of the land attempt to rise up to power. Meanwhile a forgotten race, bent on destruction, plans to return after thousands of years in the North.","got"),
        Movie(8,false,"Vikings", LocalDate.of(2012,3,9),117,Mediatype.MOVIE,"The world of the Vikings is brought to life through the journey of Ragnar Lothbrok, the first Viking to emerge from Norse legend and onto the pages of history - a man on the edge of myth.","vikings"),
        Movie(9,false,"Gotham", LocalDate.of(2012,3,9),117,Mediatype.MOVIE,"The story behind Detective James Gordon's rise to prominence in Gotham City in the years before Batman's arrival.","gotham"),
        Movie(10,false,"Power", LocalDate.of(2012,3,9),117,Mediatype.MOVIE,"James \\\"Ghost\\\" St. Patrick, a wealthy New York night club owner who has it all, catering for the city's elite and dreaming big, lives a double life as a drug kingpin.","power"),
        Movie(11,false,"Narcos", LocalDate.of(2012,3,9),117,Mediatype.SERIE,"A chronicled look at the criminal exploits of Colombian drug lord Pablo Escobar.","narcos"),
        Movie(12,false,"Breaking Bad", LocalDate.of(2012,3,9),117,Mediatype.SERIE,"A high school chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and selling methamphetamine in order to secure his family's financial future.","bb"),
        Movie(13,false,"Doctor Strange", LocalDate.of(2012,3,9),117,Mediatype.MOVIE,"After his career is destroyed, a brilliant but arrogant and conceited surgeon gets a new lease on life when a sorcerer takes him under her wing and trains him to defend the world against evil.","doctorstrange"),
        Movie(14,true,"Rogue One: A Star Wars Story", LocalDate.of(2022,12,16),130,Mediatype.SERIE,"The Rebellion makes a risky move to steal the plans to the Death Star, setting up the epic saga to follow.","starwars"),
        Movie(15,true,"Assassin's Creed", LocalDate.of(2022,12,16),130,Mediatype.MOVIE,"When Callum Lynch explores the memories of his ancestor Aguilar and gains the skills of a Master Assassin, he discovers he is a descendant of the secret Assassins society.","assassinscreed"),
        Movie(16,true,"Luke Cage", LocalDate.of(2022,12,16),130,Mediatype.MOVIE,"Given superstrength and durability by a sabotaged experiment, a wrongly accused man escapes prison to become a superhero for hire.","lukecage"),
    );
}