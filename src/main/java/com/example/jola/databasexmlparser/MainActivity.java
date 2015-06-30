package com.example.jola.databasexmlparser;

import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;


public class MainActivity extends Activity {

    EditText query;
    TextView results;
    DBHandler dbHandler;
    Filozof philosoph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        XmlResourceParser parser = getResources().getXml(R.xml.philosophers);
        query = (EditText) findViewById(R.id.query);
        results = (TextView) findViewById(R.id.results);
        dbHandler = new DBHandler(this, null, null,1);
        philosoph = new Filozof();
        printDatabase();

        try {
            while (parser.next() != XmlPullParser.END_TAG) {
                if (parser.getEventType() != XmlPullParser.START_TAG) {
                    continue;
                }
                String name = parser.getName();
                if (name.equals("result")) {
                    String filozof = null, deathplace = null;
                    String d = null, f = null;
                    while (parser.next() != XmlPullParser.END_TAG) {
                        if (parser.getEventType() != XmlPullParser.START_TAG) {
                            continue;
                        }
                        name = parser.getName();
                        if (name.equals("label")) {
                            filozof = readText(parser);
                           // f = filozof.toString();
                        } else if (name.equals("deathplace")) {
                            deathplace = readText(parser);
                          //  d = deathplace.toString();
                        }
                    }
                    philosoph.setName(filozof);
                    philosoph.setDeathplace(deathplace);
                    //dbHandler.addFilozof();
                }
            }
        } catch (XmlPullParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  finally {
            if (dbHandler != null) {
                dbHandler.close();
            }
        }
    }

    private String readText(XmlPullParser parser) throws IOException,
            XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;

    }

    public void submitQuery(View view){
        //printDatabase();
        results.setText(filozof);
    }

    public void printDatabase() {
        String dbString = dbHandler.databaseToString();
        results.setText(dbString);
    }


}
