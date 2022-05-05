package com.example.sportify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class StudentSign extends AppCompatActivity {
    EditText name, branch, hostel, emailId, password, roll, year;
    Button btnSignUp;
    TextView clickLogin;
    FirebaseAuth mFirebaseAuth;
    FirebaseFirestore dbroot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_sign);
        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.Email);
        password = findViewById(R.id.pass);
        name = findViewById(R.id.Name);
        branch = findViewById(R.id.Branch);
        hostel = findViewById(R.id.Hostel);
        roll = findViewById(R.id.Roll);
        year = findViewById(R.id.Year);
        btnSignUp = findViewById(R.id.button3);

        //clickLogin = findViewById(R.id.Exist);
        dbroot=FirebaseFirestore.getInstance();
        btnSignUp.setOnClickListener(view -> {
            createUser();
            insertdata();
        });
        clickLogin.setOnClickListener(view -> {
            startActivity(new Intent(StudentSign.this, StudentLogin.class));

        });
    }
    private void createUser(){
        String email = emailId.getText().toString();
        String pwd = password.getText().toString();
        if(email.isEmpty()){
            emailId.setError("Please enter email id");
            emailId.requestFocus();
        }
        else if(pwd.isEmpty()){
            password.setError("Please enter your password");
            password.requestFocus();
        }
        else if(email.isEmpty() && pwd.isEmpty()){

            Toast.makeText(StudentSign.this, "Fields Are Empty!",Toast.LENGTH_SHORT).show();
        }
        else if(!(email.isEmpty() && pwd.isEmpty())){
            mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful()){
                        Toast.makeText(StudentSign.this, "Sign Up Unsuccessful", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        startActivity(new Intent(StudentSign.this, StudentHome.class));
                        Toast.makeText(StudentSign.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(StudentSign.this, StudentHome.class));
                    }
                }
            });
        }
        else{
            Toast.makeText(StudentSign.this, "Error Ocurred!", Toast.LENGTH_SHORT).show();
        }

    }
    public  void insertdata(){
        Map<String,String> items=new HashMap<>();
        items.put("name",name.getText().toString().trim());
        items.put("rollno",roll.getText().toString().trim());
        items.put("branch",branch.getText().toString().trim());        items.put("email",emailId.getText().toString().trim());
        items.put("hostel",hostel.getText().toString().trim());
        items.put("password",password.getText().toString().trim());
        items.put("year",year.getText().toString().trim());

        dbroot.collection("students").add(items)
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        name.setText(" ");
                        emailId.setText(" ");
                        password.setText(" ");
                    }
                });
    }
}