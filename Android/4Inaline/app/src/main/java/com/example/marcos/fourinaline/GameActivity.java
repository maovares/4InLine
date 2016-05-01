package com.example.marcos.fourinaline;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GameActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    String ip;
    String port = "3000";

    NodeData node = new NodeData();

    String actualColor;
    Boolean autoMove;
    int level;
    TableLayout tableGame;
    ImageView m00,m01,m02,m03,m04,m05,m06,m10,m11,m12,m13,m14,m15,m16,m20,m21,m22,m23,m24,m25,m26,m30,m31,m32,m33,
        m34,m35,m36,m40,m41,m42,m43,m44,m45,m46,m50,m51,m52,m53,m54,m55,m56;

    ArrayList<ImageView> col0 = new ArrayList<>();
    ArrayList<ImageView> col1 = new ArrayList<>();
    ArrayList<ImageView> col2 = new ArrayList<>();
    ArrayList<ImageView> col3 = new ArrayList<>();
    ArrayList<ImageView> col4 = new ArrayList<>();
    ArrayList<ImageView> col5 = new ArrayList<>();
    ArrayList<ImageView> col6 = new ArrayList<>();

    ArrayList<ArrayList<ImageView>> gameMatrix = new ArrayList<>();


    TextView tvName;
    TextView tvEmail;
    ImageView ivProfile;
    SeekBar bar;

    String email;
    String name;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        bundle = getIntent().getExtras();
        name = bundle.getString("name");
        email = bundle.getString("email");
        ip = bundle.getString("ip");
        level = bundle.getInt("level");

        String photo = getIntent().getExtras().getString("photo");

        //Toast.makeText(this, name+ "  "+email, Toast.LENGTH_SHORT).show();

        bar = (SeekBar) findViewById(R.id.seekBar);

        String[] colors = {"red","blue"};
        int idx = new Random().nextInt(colors.length);
        actualColor = (colors[idx]);
        actualColor = changeColor(actualColor);
        autoMove = true;

        tableGame = (TableLayout) findViewById(R.id.tableLayout);

        m00 = (ImageView) findViewById(R.id.m00);
        m10 = (ImageView) findViewById(R.id.m10);
        m20 = (ImageView) findViewById(R.id.m20);
        m30 = (ImageView) findViewById(R.id.m30);
        m40 = (ImageView) findViewById(R.id.m40);
        m50 = (ImageView) findViewById(R.id.m50);

        m01 = (ImageView) findViewById(R.id.m01);
        m11 = (ImageView) findViewById(R.id.m11);
        m21 = (ImageView) findViewById(R.id.m21);
        m31 = (ImageView) findViewById(R.id.m31);
        m41 = (ImageView) findViewById(R.id.m41);
        m51 = (ImageView) findViewById(R.id.m51);

        m02 = (ImageView) findViewById(R.id.m02);
        m12 = (ImageView) findViewById(R.id.m12);
        m22 = (ImageView) findViewById(R.id.m22);
        m32 = (ImageView) findViewById(R.id.m32);
        m42 = (ImageView) findViewById(R.id.m42);
        m52 = (ImageView) findViewById(R.id.m52);

        m03 = (ImageView) findViewById(R.id.m03);
        m13 = (ImageView) findViewById(R.id.m13);
        m23 = (ImageView) findViewById(R.id.m23);
        m33 = (ImageView) findViewById(R.id.m33);
        m43 = (ImageView) findViewById(R.id.m43);
        m53 = (ImageView) findViewById(R.id.m53);

        m04 = (ImageView) findViewById(R.id.m04);
        m14 = (ImageView) findViewById(R.id.m14);
        m24 = (ImageView) findViewById(R.id.m24);
        m34 = (ImageView) findViewById(R.id.m34);
        m44 = (ImageView) findViewById(R.id.m44);
        m54 = (ImageView) findViewById(R.id.m54);

        m05 = (ImageView) findViewById(R.id.m05);
        m15 = (ImageView) findViewById(R.id.m15);
        m25 = (ImageView) findViewById(R.id.m25);
        m35 = (ImageView) findViewById(R.id.m35);
        m45 = (ImageView) findViewById(R.id.m45);
        m55 = (ImageView) findViewById(R.id.m55);

        m06 = (ImageView) findViewById(R.id.m06);
        m16 = (ImageView) findViewById(R.id.m16);
        m26 = (ImageView) findViewById(R.id.m26);
        m36 = (ImageView) findViewById(R.id.m36);
        m46 = (ImageView) findViewById(R.id.m46);
        m56 = (ImageView) findViewById(R.id.m56);

        col0.add(m50);
        col0.add(m40);
        col0.add(m30);
        col0.add(m20);
        col0.add(m10);
        col0.add(m00);

        col1.add(m51);
        col1.add(m41);
        col1.add(m31);
        col1.add(m21);
        col1.add(m11);
        col1.add(m01);

        col2.add(m52);
        col2.add(m42);
        col2.add(m32);
        col2.add(m22);
        col2.add(m12);
        col2.add(m02);

        col3.add(m53);
        col3.add(m43);
        col3.add(m33);
        col3.add(m23);
        col3.add(m13);
        col3.add(m03);

        col4.add(m54);
        col4.add(m44);
        col4.add(m34);
        col4.add(m24);
        col4.add(m14);
        col4.add(m04);

        col5.add(m55);
        col5.add(m45);
        col5.add(m35);
        col5.add(m25);
        col5.add(m15);
        col5.add(m05);

        col6.add(m56);
        col6.add(m46);
        col6.add(m36);
        col6.add(m26);
        col6.add(m16);
        col6.add(m06);

        gameMatrix.add(col0);
        gameMatrix.add(col1);
        gameMatrix.add(col2);
        gameMatrix.add(col3);
        gameMatrix.add(col4);
        gameMatrix.add(col5);
        gameMatrix.add(col6);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerLayout = navigationView.inflateHeaderView(R.layout.nav_header_game);
        tvName = (TextView) headerLayout.findViewById(R.id.tvName);
        tvEmail = (TextView) headerLayout.findViewById(R.id.tvEmail);
        ivProfile = (ImageView) headerLayout.findViewById(R.id.ivProfile);

        tvName.setText(name);
        tvEmail.setText(email);

        /*
        if(getIntent().hasExtra("image")) {
            ImageView previewThumbnail = new ImageView(this);
            Bitmap b = BitmapFactory.decodeByteArray(
                    getIntent().getByteArrayExtra("image"),0,getIntent().getByteArrayExtra("image").length);
            //previewThumbnail.setImageBitmap(b);
            ivProfile.setImageBitmap(b);

        }*/


        try{
            InputStream is = (InputStream) new URL(photo).getContent();
            Drawable d = Drawable.createFromStream(is, "profile_photo");
            ivProfile.setImageDrawable(d);
            /*
            Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(photo).getContent());
            ivProfile.setImageBitmap(bitmap);*/

        }catch (Exception e){
            //Toast.makeText(GameActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        /*
        String[] matrix  = {"120000",
                            "000000",
                            "000000",
                            "000000",
                            "000000",
                            "100000",
                            "000000"};*/
        setMatrix(getGameFromServer(ip,port,"getGameData/"+email,"data"));
        //Toast.makeText(GameActivity.this, getStringFromServer("192.168.1.14","3000","getGameData/"+email,"gameID"), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.menu_newgame_singlemode) {

        } else if (id == R.id.menu_newgame_multiplayer) {

        } else if (id == R.id.menu_stats) {
            Intent intent = new Intent(this,StatsActivity.class);
            startActivity(intent);
        } else if (id == R.id.menu_about) {

        } else if (id == R.id.menu_logout) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void columClick(View view){
        int id = view.getId();

        switch (id){
            case R.id.m00:
            case R.id.m10:
            case R.id.m20:
            case R.id.m30:
            case R.id.m40:
            case R.id.m50:
                clickColum(col0);
                break;

            case R.id.m01:
            case R.id.m11:
            case R.id.m21:
            case R.id.m31:
            case R.id.m41:
            case R.id.m51:
                clickColum(col1);
                break;

            case R.id.m02:
            case R.id.m12:
            case R.id.m22:
            case R.id.m32:
            case R.id.m42:
            case R.id.m52:
                clickColum(col2);
                break;

            case R.id.m03:
            case R.id.m13:
            case R.id.m23:
            case R.id.m33:
            case R.id.m43:
            case R.id.m53:
                clickColum(col3);
                break;

            case R.id.m04:
            case R.id.m14:
            case R.id.m24:
            case R.id.m34:
            case R.id.m44:
            case R.id.m54:
                clickColum(col4);
                break;

            case R.id.m05:
            case R.id.m15:
            case R.id.m25:
            case R.id.m35:
            case R.id.m45:
            case R.id.m55:
                clickColum(col5);
                break;

            case R.id.m06:
            case R.id.m16:
            case R.id.m26:
            case R.id.m36:
            case R.id.m46:
            case R.id.m56:
                clickColum(col6);
                break;

        }
    }


    public void clickColum(ArrayList<ImageView> col){
        for (ImageView iv:col) {
            String backgroundImageName = (String) iv.getTag();
            if(backgroundImageName.equals("empty")){
                iv.setTag("full");
                setImage(actualColor, iv);
                actualColor = changeColor(actualColor);


                JSONArray gameJSONArray = new JSONArray(Arrays.asList(getMatrix()));

                if (autoMove){
                    int pos = getWinnerFromServer(ip, port,"sendGameMatriz/"+gameJSONArray+"/"+level);
                    autoMove = false;
                    if ( pos != -1 ){
                        clickColum(gameMatrix.get(pos));
                    }
                }else {
                    getWinnerFromServer(ip, port,"sendGameMatriz/"+gameJSONArray+"/"+level);
                    autoMove = true;
                }


                //Toast.makeText(GameActivity.this, response, Toast.LENGTH_SHORT).show();
                break;
            }
        }
        //Toast.makeText(GameActivity.this, getMatrix()[0], Toast.LENGTH_SHORT).show();
    }

    public void setImage(String color, ImageView view){
        if(color =="red"){
            view.setImageResource(R.mipmap.ball_red);
            view.setTag("1");
        }else {
            view.setImageResource(R.mipmap.ball_blue);
            view.setTag("2");
        }
    }

    public String changeColor(String color){
        if(color.equals("red")){
            color = "blue";
            bar.setProgress(33);
            //bar.setDrawingCacheBackgroundColor(Color.BLUE);
            bar.setBackgroundColor(Color.BLUE);
        }else {
            color = "red";
            bar.setProgress(66);
            //bar.setDrawingCacheBackgroundColor(Color.BLUE);
            bar.setBackgroundColor(Color.RED);
        }
        return color;
    }

    public void setMatrix(String[] positions){
        for (int i = 0; i<positions.length; i++){
            for (int j = 0; j<positions[i].length(); j++){
                setOnePosition(String.valueOf(positions[i].charAt(j)), gameMatrix.get(i).get(j));
            }
        }
    }


    public String[] getMatrix(){
        ArrayList<String> aux = new ArrayList<>();
        for (int i = 0; i<gameMatrix.size(); i++){
            String row="";
            for (int j = 0; j<gameMatrix.get(i).size(); j++){
                String ivText = String.valueOf(gameMatrix.get(i).get(j).getTag().toString());
                if(ivText.equals("empty")){
                    ivText="0";
                }
                row = row+ ivText;
            }
            aux.add(row);
        }
        String[] temp = new String[aux.size()];
        return aux.toArray(temp);
    }

    public void setOnePosition(String position, ImageView iv){
        if(position.equals("1")){
            setImage("red",iv);
            iv.setTag("1");
        }else if(position.equals("2")){
            setImage("blued",iv);
            iv.setTag("2");
        }
    }

    /*
    public String getStringFromServer(String ip, String port,String url, String attr){
        NodeData node = new NodeData();
        String aux = "";
        try{
            String data = node.getResponse(ip+":"+port+"/"+url);
            JSONObject dataJson = node.toJSON(data);
            aux = dataJson.getString(attr);

        }catch (Exception e){
            Toast.makeText(GameActivity.this, "You're not at home :(\n"+e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return aux;
    }*/

    public String[] getGameFromServer(String ip, String port,String url, String attr){
        String[] newArray={};
        try{
            String data = node.getResponse(ip+":"+port+"/"+url);
            JSONObject dataJson = node.toJSON(data);
            JSONArray a = dataJson.getJSONArray(attr);
            newArray = jsonToStringArray(a);
        }catch (Exception e){
            //Toast.makeText(GameActivity.this, "Error!!\n"+e.getMessage(), Toast.LENGTH_LONG).show();
            Toast.makeText(GameActivity.this, "Network error!\n", Toast.LENGTH_LONG).show();
            disableEnableTableGame(gameMatrix);
        }
        return newArray;
    }

    public int getWinnerFromServer(String ip, String port,String url){
        String response="";
        String winner = "";
        int movement = -1;
        try{
            String data = node.getResponse(ip+":"+port+"/"+url);
            JSONObject dataJson = node.toJSON(data);
            //response = dataJson.getString("data");
            winner = dataJson.getString("winner");

            //Toast.makeText(GameActivity.this, winner + " " + movement, Toast.LENGTH_SHORT).show();
            if (winner.equals("1")){
                Toast.makeText(GameActivity.this, "Red wins", Toast.LENGTH_LONG).show();
                disableEnableTableGame(gameMatrix);
            }else if (winner.equals("2") ){
                Toast.makeText(GameActivity.this, "Blue wins", Toast.LENGTH_LONG).show();
                disableEnableTableGame(gameMatrix);
            }else {
                movement = dataJson.getInt("moveColum");
            }
        }catch (Exception e){
            //Toast.makeText(GameActivity.this, "Error!!\n"+e.getMessage(), Toast.LENGTH_LONG).show();
            Toast.makeText(GameActivity.this, "Network error!\n", Toast.LENGTH_LONG).show();
            disableEnableTableGame(gameMatrix);
        }
        return movement;
    }


    public String[] clearArray(String[] array){
        ArrayList<String> newArray = new ArrayList<>();
        for (String str:array){
            str = str.substring(1, str.length()-1);
            newArray.add(str);
        }
        String[] stockArr = new String[newArray.size()];
        stockArr = newArray.toArray(stockArr);
        return stockArr;
    }

    public static String[] jsonToStringArray(JSONArray jsonArray){
        String[] stringArray = null;
        int length = jsonArray.length();
        try{
            if(jsonArray!=null){
                stringArray = new String[length];
                for(int i=0;i<length;i++){
                    stringArray[i]= jsonArray.getString(i);
                }
            }
        }catch (Exception e){

        }
        return stringArray;
    }

    public void disableEnableTableGame(ArrayList< ArrayList<ImageView>> ivArray){
        for (ArrayList<ImageView> al: ivArray) {
            for (ImageView iv: al) {
                if(iv.isEnabled()){
                    iv.setEnabled(false);
                }else {
                    iv.setEnabled(true);
                }
            }
        }
    }

}
