package iclicker.resess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Text;

import mehdi.sakout.fancybuttons.FancyButton;

//  Survey Activity

public class Act3 extends AppCompatActivity {

    private TextView txt_ans_one;
    private TextView txt_ans_two;
    private TextView txt_ans_three;
    private TextView txt_question;
    private FancyButton btnSubmitSurvey;
    String question = "";
    String answer[] = new String[4];
    private StringRequest stringRequest;
    private String urlGetNextQ = "http://localhost:8000/authenticate.php/";     // append it later

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act3);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        question = b.getString("question");
        answer = b.getStringArray("answer");

        txt_ans_one = findViewById(R.id.txt_ans_one);
        txt_ans_two = findViewById(R.id.txt_ans_two);
        txt_ans_three = findViewById(R.id.txt_ans_three);
        txt_question = findViewById(R.id.txt_question);
        btnSubmitSurvey = findViewById(R.id.btn_submit_survey);

        updateTxtElements(question, answer[0], answer[1], answer[2]);

        btnSubmitSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringRequest = new StringRequest(Request.Method.GET, urlGetNextQ,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                // get the q and ans and call updateTxtElements
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(Act3.this, "Error "+error.getMessage().toString()+" in Act2 update", Toast.LENGTH_SHORT).show();
                            }
                        });

                Volley.newRequestQueue(Act3.this).add(stringRequest);

            }
        });
    }

    public void updateTxtElements(String q, String a1, String a2, String a3)
    {
        txt_question.setText(q);
        txt_ans_two.setText(a1);
        txt_ans_two.setText(a2);
        txt_ans_three.setText(a3);
    }
}
