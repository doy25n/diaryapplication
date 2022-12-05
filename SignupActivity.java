package com.cookandroid.project10_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class SignupActivity extends AppCompatActivity {
    private EditText et_id, et_pass;
    private Button btn_register;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        //아이디 값 찾아주기
        et_id=findViewById(R.id.sample_EditText);
        et_pass=findViewById(R.id.et_pw);

        btn_register=findViewById(R.id.button2);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //editText에 입력되어있는 값을 get(가져온다)해온다
                String userID=et_id.getText().toString();
                final String userPass=et_pass.getText().toString();
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
                Response.Listener<String> responseListener=new Response.Listener<String>() {//volley
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jasonObject=new JSONObject(response);//Register2 php에 response
                            boolean success=jasonObject.getBoolean("success");//Register2 php에 sucess
                            if (success) {//회원등록 성공한 경우
                                    Toast.makeText(getApplicationContext(), "회원 등록 성공", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                                    startActivity(intent);
                            }

                            else{//회원등록 실패한 경우
                                Toast.makeText(getApplicationContext(),"회원 등록 실패",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                //서버로 volley를 이용해서 요청을 함
                RegisterRequest registerRequest=new RegisterRequest(userID, userPass,responseListener);
                RequestQueue queue= Volley.newRequestQueue(SignupActivity.this);
                queue.add(registerRequest);
            }
        });
    }

}
