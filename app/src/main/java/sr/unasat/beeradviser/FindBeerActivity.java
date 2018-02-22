package sr.unasat.beeradviser;

/*
Head First Android Development 2nd Edition

Chapter 2 (Building Interactive Apps)

The Beer Adviser

Here's how the app is structured:
1. The Layout "activity_find_beer.xml" specifies what the app will look like.
It includes three GUI components:
- A drop-down list of values called a spinner,
which allows the user to choose which type of beer they want.
- A button what when pressed will return a selection of beer types.
- A text field that displays the type of beer.
2. The file "strings.xml" includes any string resources needed by the layout.
For exemple, the label of the button specified in the layout.
3. The activity "FindBeerActivity.java" specifies how the app should interact with the user.
It takes the type of beer the user chooses,
and uses this to display a list of beers the user might be interested in.
It achieves this with the help of a custom Java class.
4. The custom Java class "BeerExpert.java" contains the application logic for the app.
It includes a method that takes a type of beer as a parameter,
and returns a list of beers of this type.
The activity calls the method, passes it to the type of beer, and uses the response.
*/

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindBeerActivity extends AppCompatActivity {
    /* Instance of BeerExpert as a private variable */
    private BeerExpert expert = new BeerExpert();

    /* onCreate() is called when the activity is created */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }

    /* onClickFindBeer() is called when the button gets clicked */
    public void onClickFindBeer(View view) {
        // Get a reference to the Spinner
        Spinner color = (Spinner) findViewById(R.id.color);
        // Get the selected item in the Spinner
        String beerType = String.valueOf(color.getSelectedItem());
                                // getSelectedItem() is method of class Spinner
                                // String.valueOf() converts object to String

        // Get a reference to the TextView
        TextView brands = (TextView) findViewById(R.id.brands);
        /*Replaced: // Display the selected item
        brands.setText(beerType);*/
        // Get recommendations from the BeerExpert class
        List<String> brandsList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brand : brandsList) {
            brandsFormatted.append(brand).append('\n');
        }
        // Display the beers
        brands.setText(brandsFormatted);
    }

}