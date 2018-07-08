package iclicker.resess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import mehdi.sakout.fancybuttons.FancyButton;

//  LOGIN ACTIVITY

public class Act1 extends AppCompatActivity {

    private FancyButton btnLogin;
    private EditText txtName;
    private EditText txtPwd;
    private String name="";
    private String pwd="";
    private String url = "http://localhost:8000/authenticate.php/";     //append appropriately later
    private StringRequest stringRequest;
    private String courseList[] = new String[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act1);

        btnLogin = findViewById(R.id.btn_submit_login);
        txtName = findViewById(R.id.txt_login_name);
        txtPwd = findViewById(R.id.txt_login_pwd);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pwd = txtName.getText().toString();
                name = txtPwd.getText().toString();

                if(pwd.isEmpty()||name.isEmpty())
                {
                    Toast.makeText(Act1.this, "Please fill the credentials", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    url = url+"sid="+name+"&passwd="+pwd;
                    stringRequest = new StringRequest(Request.Method.GET, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    if(response.equals(null))
                                    {
                                        Toast.makeText(Act1.this, "Server is facing some error!", Toast.LENGTH_SHORT).show();
                                    }
                                    else
                                    {
                                        // Handle the JSON response here -
                                        // get secret key,
                                        // 200 for valid,
                                        // and the course list in courseList[]


                                        if(!courseList[0].isEmpty())
                                        {
                                            //pass intent
                                            Intent i = new Intent(Act1.class, Act2.java);
                                            startActivity(i);
                                        }
                                    }
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // handle the error response here
                        }
                    });
                }

            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }
}
