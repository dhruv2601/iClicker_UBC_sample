package iclicker.resess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import mehdi.sakout.fancybuttons.FancyButton;

//  COURSES LIST ACTIVITY

public class Act2 extends AppCompatActivity {

    private FancyButton btnSubjOne;
    private FancyButton btnSubjTwo;
    private FancyButton btnSubjThree;
    private FancyButton btnSubjFour;

    private StringRequest stringRequest;
    private String urlUpdateClass = "http://localhost:8000/authenticate.php/";;                 // append url later
    private String urlGetQuestion = "http://localhost:8000/authenticate.php/";                  // append url later

    private String courseList[] = new String[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);

        btnSubjOne = findViewById(R.id.btn_subj_one);
        btnSubjTwo = findViewById(R.id.btn_subj_two);
        btnSubjThree = findViewById(R.id.btn_subj_three);
        btnSubjFour = findViewById(R.id.btn_subj_four);

        courseList = Act1.courseList;

        urlUpdateClass = urlUpdateClass; //+" something";
        stringRequest = new StringRequest(Request.Method.GET, urlUpdateClass,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Act2.this, "Act2 updated", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Act2.this, "Error "+error.getMessage().toString()+" in Act2 update", Toast.LENGTH_SHORT).show();
                    }
                });


        btnSubjOne.setText(courseList[0]);
        btnSubjTwo.setText(courseList[1]);
        btnSubjThree.setText(courseList[2]);
        btnSubjFour.setText(courseList[3]);

        btnSubjOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSubjTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSubjThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSubjFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}