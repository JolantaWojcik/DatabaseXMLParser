package com.example.jola.databasexmlparser;

/**
 * Created by Jola on 30/06/2015.
 */
public class Filozof {
    /* <binding name="filozof"><uri>http://dbpedia.org/resource/George_Campbell_(minister)</uri></binding>
      name: <binding name="label"><literal xml:lang="en">George Campbell (minister)</literal></binding>
     deathplace:  <binding name="deathplace"><literal xml:lang="en">Aberdeen</literal></binding>
       <binding name="era"><uri>http://dbpedia.org/resource/Age_of_Enlightenment</uri></binding>
        <binding name="birthDate"><literal datatype="http://www.w3.org/2001/XMLSchema#date">1719-12-25+02:00</literal></binding>*/

    private int id;
    private String name;
    private String deathplace;

    /*public Filozof(String name, String deathplace) {
        this.name = name;
        this.deathplace = deathplace;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeathplace() {
        return deathplace;
    }

    public void setDeathplace(String deathplace) {
        this.deathplace = deathplace;
    }
}
