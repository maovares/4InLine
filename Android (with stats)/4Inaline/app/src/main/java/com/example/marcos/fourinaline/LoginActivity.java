package com.example.marcos.fourinaline;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;

public class LoginActivity extends AppCompatActivity  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener{

    private Button btSignIn;
    private SignInButton googleBtn;
    private GoogleApiClient mGoogleApiClient;
    private EditText etIP;
    private EditText etLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btSignIn = (Button) findViewById(R.id.email_sign_in_button);
        googleBtn = (SignInButton) findViewById(R.id.googlebtn);
        etIP = (EditText) findViewById(R.id.etIP);
        etLv = (EditText) findViewById(R.id.etLevel);


        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */,
                        this /* OnConnectionFailedListener */)
                .addApi(Plus.API)
                .addScope(Plus.SCOPE_PLUS_LOGIN)
                .build();


        setFuntions();

    }

    public void setFuntions(){
        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    mGoogleApiClient.connect();
                    if (Plus.PeopleApi.getCurrentPerson(mGoogleApiClient) != null) {
                        Person currentPerson = Plus.PeopleApi.getCurrentPerson(mGoogleApiClient);
                        String personName = currentPerson.getDisplayName();
                        Person.Image personPhoto = currentPerson.getImage();
                        //String personGooglePlusProfile = currentPerson.getUrl();
                        String email = Plus.AccountApi.getAccountName(mGoogleApiClient);
                        String ip = etIP.getText().toString();
                        int level = Integer.parseInt(etLv.getText().toString());

                        Bundle bundle = new Bundle();
                        bundle.putString("name",personName);
                        bundle.putString("email",email);
                        bundle.putString("ip",ip);
                        bundle.putInt("level",level);
                        //bundle.putString("photo",personPhoto.getUrl());

                        Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                        intent.putExtras(bundle);
                        intent.putExtra("photo",personPhoto.getUrl());
                        startActivity(intent);
                        finish();
                    }
                }catch (Exception e){
                    Toast.makeText(LoginActivity.this, "Connection not available", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    @Override
    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }


    @Override
    public void onConnected(Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        if(connectionResult.hasResolution()){
            try{
                connectionResult.startResolutionForResult(this, connectionResult.getErrorCode());
            }catch (IntentSender.SendIntentException e){
                mGoogleApiClient.connect();
            }
        }
    }
}
