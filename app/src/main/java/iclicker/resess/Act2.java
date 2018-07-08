package iclicker.resess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import mehdi.sakout.fancybuttons.FancyButton;

//  COURSES LIST ACTIVITY

public class Act2 extends AppCompatActivity {

    private FancyButton btnSubjOne;
    private FancyButton btnSubjTwo;
    private FancyButton btnSubjThree;
    private FancyButton btnSubjFour;

    private StringRequest stringRequest;
    private StringRequest stringRequest1;
    private StringRequest stringRequest2;
    private StringRequest stringRequest3;
    private StringRequest stringRequest4;

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
        Volley.newRequestQueue(this).add(stringRequest);


        btnSubjOne.setText(courseList[0]);
        btnSubjTwo.setText(courseList[1]);
        btnSubjThree.setText(courseList[2]);
        btnSubjFour.setText(courseList[3]);

        btnSubjOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                urlGetQuestion = urlGetQuestion+"";     // append name of the subject
                stringRequest1 = new StringRequest(Request.Method.GET,urlGetQuestion ,
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
                Volley.newRequestQueue(Act2.this).add(stringRequest1);

            }
        });

        btnSubjTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                urlGetQuestion = urlGetQuestion+"";     // append name of the subject

                stringRequest2 = new StringRequest(Request.Method.GET,urlGetQuestion ,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // response should contain the next question and answer for next activity
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(Act2.this, "Error "+error.getMessage().toString()+" in fetching question ACT2", Toast.LENGTH_SHORT).show();
                            }
                        });
                Volley.newRequestQueue(Act2.this).add(stringRequest2);

            }
        });

        btnSubjThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                urlGetQuestion = urlGetQuestion+"";     // append name of the subject

                stringRequest3 = new StringRequest(Request.Method.GET, urlGetQuestion,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // response should contain the next question and answer for next activity
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(Act2.this, "Error "+error.getMessage().toString()+" in Act2 update", Toast.LENGTH_SHORT).show();
                            }
                        });
                Volley.newRequestQueue(Act2.this).add(stringRequest3);

            }
        });

        btnSubjFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                urlGetQuestion = urlGetQuestion+"";     // append name of the subject

                stringRequest4 = new StringRequest(Request.Method.GET,urlGetQuestion ,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // response should contain the next question and answer for next activity
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(Act2.this, "Error "+error.getMessage().toString()+" in Act2 update", Toast.LENGTH_SHORT).show();
                            }
                        });
                Volley.newRequestQueue(Act2.this).add(stringRequest4);

            }
        });
    }
}