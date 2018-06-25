package com.example.bohongtao.sch;
/**
 * Created by bohongtao on 16-5-20.
 */
import android.app.Activity;
import android.app.AlertDialog;
import java.lang.String;
import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompatSideChannelService;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.security.PublicKey;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    TextView pan1_1,pan1_2,pan1_3,pan1_4,
             pan2_1,pan2_2,pan2_3,pan2_4,
             pan3_1,pan3_2,pan3_3,pan3_4,
             pan4_1,pan4_2,pan4_3,pan4_4,
             pan5_1,pan5_2,pan5_3,pan5_4;
    public static final String PREFERENCE_NAME="SavaSetting";
    public  static int MODE = Context.MODE_WORLD_READABLE+Context.MODE_WORLD_WRITEABLE;

    String s = "[{\"jieci\":\"1-1\",\"project\":\"rjxmgl\",\"teacher\":\"sql\",\"place\":\"10#C420\",\"credit\":\"3\"},{\"jieci\":\"1-2\",\"project\":\"byyl\",\"teacher\":\"zlp\",\"place\":\"10#C429\",\"credit\":\"3\"},{\"jieci\":\"1-3\",\"project\":\"rgzn\",\"teacher\":\"cj\",\"place\":\"10#C429\",\"credit\":\"3\"},{\"jieci\":\"1-4\",\"project\":null,\"teacher\":null,\"place\":null,\"credit\":null},{\"jieci\":\"2-1\",\"project\":\"mxdx\",\"teacher\":\"zhw\",\"place\":\"10#C420\",\"credit\":\"3\"},{\"jieci\":\"2-2\",\"project\":\"android\",\"teacher\":\"wyt\",\"place\":\"10#C428\",\"credit\":\"3\"},{\"jieci\":\"2-3\",\"project\":\"rjcs\",\"teacher\":\"st\",\"place\":\"11#C207\",\"credit\":\"3\"},{\"jieci\":\"2-4\",\"project\":null,\"teacher\":null,\"place\":null,\"credit\":null},{\"jieci\":\"3-1\",\"project\":\"websj\",\"teacher\":\"lhy\",\"place\":\"A307\",\"credit\":\"2\"},{\"jieci\":\"3-2\",\"project\":\"byyl\",\"teacher\":\"zlp\",\"place\":\"11#207\",\"credit\":\"3\"},{\"jieci\":\"3-3\",\"project\":\"rjxmgl\",\"teacher\":\"sql\",\"place\":\"10#C421\",\"credit\":\"3\"},{\"jieci\":\"3-4\",\"project\":null,\"teacher\":null,\"place\":null,\"credit\":null},{\"jieci\":\"4-1\",\"project\":null,\"teacher\":null,\"place\":null,\"credit\":null},{\"jieci\":\"4-2\",\"project\":\"android\",\"teacher\":\"wyt\",\"place\":\"10#C421\",\"credit\":\"3\"},{\"jieci\":\"4-3\",\"project\":null,\"teacher\":null,\"place\":null,\"credit\":null},{\"jieci\":\"4-4\",\"project\":null,\"teacher\":null,\"place\":null,\"credit\":null},{\"jieci\":\"5-1\",\"project\":\"websj\",\"teacher\":\"lhy\",\"place\":\"A307\",\"credit\":\"2\"},{\"jieci\":\"5-2\",\"project\":\"rgzn\",\"teacher\":\"cj\",\"place\":\"10#C424\",\"credit\":\"3\"},{\"jieci\":\"5-3\",\"project\":null,\"teacher\":null,\"place\":null,\"credit\":null},{\"jieci\":\"5-4\",\"project\":null,\"teacher\":null,\"place\":null,\"credit\":null}]";







    String []pro = new String[20];
    String []tea = new String[20];
    String []pla = new String[20];
    String []cre= new String[20];

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取控件//
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        pan1_1 = (TextView) findViewById(R.id.pan1_1);
        pan1_2 = (TextView) findViewById(R.id.pan1_2);
        pan1_3 = (TextView) findViewById(R.id.pan1_3);
        pan1_4 = (TextView) findViewById(R.id.pan1_4);

        pan2_1 = (TextView) findViewById(R.id.pan2_1);
        pan2_2 = (TextView) findViewById(R.id.pan2_2);
        pan2_3 = (TextView) findViewById(R.id.pan2_3);
        pan2_4 = (TextView) findViewById(R.id.pan2_4);

        pan3_1 = (TextView) findViewById(R.id.pan3_1);
        pan3_2 = (TextView) findViewById(R.id.pan3_2);
        pan3_3 = (TextView) findViewById(R.id.pan3_3);
        pan3_4 = (TextView) findViewById(R.id.pan3_4);

        pan4_1 = (TextView) findViewById(R.id.pan4_1);
        pan4_2 = (TextView) findViewById(R.id.pan4_2);
        pan4_3 = (TextView) findViewById(R.id.pan4_3);
        pan4_4 = (TextView) findViewById(R.id.pan4_4);

        pan5_1 = (TextView) findViewById(R.id.pan5_1);
        pan5_2 = (TextView) findViewById(R.id.pan5_2);
        pan5_3 = (TextView) findViewById(R.id.pan5_3);
        pan5_4 = (TextView) findViewById(R.id.pan5_4);


        pan1_1.setBackgroundColor(Color.parseColor("#912CEE"));
        pan1_2.setBackgroundColor(Color.parseColor("#B0E2FF"));
        pan1_3.setBackgroundColor(Color.parseColor("#7FFF00"));
        pan1_4.setBackgroundColor(Color.parseColor("#A52A2A"));

        pan2_1.setBackgroundColor(Color.parseColor("#00F5FF"));
        pan2_2.setBackgroundColor(Color.parseColor("#DB7093"));
        pan2_3.setBackgroundColor(Color.parseColor("#CAE1FF"));
        pan2_4.setBackgroundColor(Color.parseColor("#B3EE3A"));

        pan3_1.setBackgroundColor(Color.parseColor("#7FFF00"));
        pan3_2.setBackgroundColor(Color.parseColor("#436EEE"));
        pan3_3.setBackgroundColor(Color.parseColor("#778899"));
        pan3_4.setBackgroundColor(Color.parseColor("#98FB98"));

        pan4_1.setBackgroundColor(Color.parseColor("#FF6A6A"));
        pan4_2.setBackgroundColor(Color.parseColor("#EEE685"));
        pan4_3.setBackgroundColor(Color.parseColor("#EE1289"));
        pan4_4.setBackgroundColor(Color.parseColor("#CDCD00"));

        pan5_1.setBackgroundColor(Color.parseColor("#98FB98"));
        pan5_2.setBackgroundColor(Color.parseColor("#00F5FF"));
        pan5_3.setBackgroundColor(Color.parseColor("#E8E8E8"));
        pan5_4.setBackgroundColor(Color.parseColor("#EE3B3B"));

        if((pan1_1.getText()).equals(" "))  {  pan1_1.setBackgroundColor(Color.parseColor("#FFFFFF")); }
        if((pan1_2.getText()).equals(" "))  {  pan1_2.setBackgroundColor(Color.parseColor("#FFFFFF")); }
        if((pan1_3.getText()).equals(" "))  {  pan1_3.setBackgroundColor(Color.parseColor("#FFFFFF")); }
        if((pan1_4.getText()).equals(" "))  {  pan1_4.setBackgroundColor(Color.parseColor("#FFFFFF")); }
        if((pan2_1.getText()).equals(" "))  {  pan2_1.setBackgroundColor(Color.parseColor("#FFFFFF")); }
        if((pan2_2.getText()).equals(" "))  {  pan2_2.setBackgroundColor(Color.parseColor("#FFFFFF")); }
        if((pan2_3.getText()).equals(" "))  {  pan2_3.setBackgroundColor(Color.parseColor("#FFFFFF")); }
        if((pan2_4.getText()).equals(" "))  {  pan2_4.setBackgroundColor(Color.parseColor("#FFFFFF")); }
        if((pan3_1.getText()).equals(" "))  {  pan3_1.setBackgroundColor(Color.parseColor("#FFFFFF")); }
        if((pan3_2.getText()).equals(" "))  {  pan3_2.setBackgroundColor(Color.parseColor("#FFFFFF")); }
        if((pan3_3.getText()).equals(" "))  {  pan3_3.setBackgroundColor(Color.parseColor("#FFFFFF")); }
        if((pan3_4.getText()).equals(" "))  {  pan3_4.setBackgroundColor(Color.parseColor("#FFFFFF")); }
        if((pan4_1.getText()).equals(" "))  {  pan4_1.setBackgroundColor(Color.parseColor("#FFFFFF")); }
        if((pan4_2.getText()).equals(" "))  {  pan4_2.setBackgroundColor(Color.parseColor("#FFFFFF")); }
        if((pan4_3.getText()).equals(" "))  {  pan4_3.setBackgroundColor(Color.parseColor("#FFFFFF")); }
        if((pan4_4.getText()).equals(" "))  {  pan4_4.setBackgroundColor(Color.parseColor("#FFFFFF")); }
        if((pan5_1.getText()).equals(" "))  {  pan5_1.setBackgroundColor(Color.parseColor("#FFFFFF")); }
        if((pan5_2.getText()).equals(" "))  {  pan5_2.setBackgroundColor(Color.parseColor("#FFFFFF")); }
        if((pan5_3.getText()).equals(" "))  {  pan5_3.setBackgroundColor(Color.parseColor("#FFFFFF")); }
        if((pan5_4.getText()).equals(" "))  {  pan5_4.setBackgroundColor(Color.parseColor("#FFFFFF")); }

        OnClick m = new OnClick();
        OnLongClick n = new OnLongClick();
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        pan1_1.setOnClickListener(m);
        pan1_2.setOnClickListener(m);
        pan1_3.setOnClickListener(m);
        pan1_4.setOnClickListener(m);
        pan2_1.setOnClickListener(m);
        pan2_2.setOnClickListener(m);
        pan2_3.setOnClickListener(m);
        pan2_4.setOnClickListener(m);
        pan3_1.setOnClickListener(m);
        pan3_2.setOnClickListener(m);
        pan3_3.setOnClickListener(m);
        pan3_4.setOnClickListener(m);
        pan4_1.setOnClickListener(m);
        pan4_2.setOnClickListener(m);
        pan4_3.setOnClickListener(m);
        pan4_4.setOnClickListener(m);
        pan5_1.setOnClickListener(m);
        pan5_2.setOnClickListener(m);
        pan5_3.setOnClickListener(m);
        pan5_4.setOnClickListener(m);


        pan1_1.setOnLongClickListener(n);
        pan1_2.setOnLongClickListener(n);
        pan1_3.setOnLongClickListener(n);
        pan1_4.setOnLongClickListener(n);
        pan2_1.setOnLongClickListener(n);
        pan2_2.setOnLongClickListener(n);
        pan2_3.setOnLongClickListener(n);
        pan2_4.setOnLongClickListener(n);
        pan3_1.setOnLongClickListener(n);
        pan3_2.setOnLongClickListener(n);
        pan3_3.setOnLongClickListener(n);
        pan3_4.setOnLongClickListener(n);
        pan4_1.setOnLongClickListener(n);
        pan4_2.setOnLongClickListener(n);
        pan4_3.setOnLongClickListener(n);
        pan4_4.setOnLongClickListener(n);
        pan5_1.setOnLongClickListener(n);
        pan5_2.setOnLongClickListener(n);
        pan5_3.setOnLongClickListener(n);
        pan5_4.setOnLongClickListener(n);



        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
    private void load(){
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME,MODE);
        String name1_1 = sharedPreferences.getString("project",pro[0]);
        pan1_1.setText(name1_1);
    }
    private void sava(){
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME,MODE);
        SharedPreferences.Editor ed = sharedPreferences.edit();
        ed.putString("project",pan1_1.getText().toString());
        ed.commit();
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
            //导入课表//
        if (id == R.id.nav_camera) {
//            Toast.makeText(MainActivity.this,
//                    "fdsdsagafdsgag",
//                    Toast.LENGTH_SHORT).show();

            try {
                JSONArray array = new JSONArray(s);

                for(int i = 0; i < array.length(); ++i){
                    JSONObject obj = array.getJSONObject(i);
                    //String jieCi = obj.getString("jieci");
                    String project = obj.getString("project");
                    String teacher = obj.getString("teacher");

                    String place = obj.getString("place");

                   String credit = obj.getString("credit");
                    pro[i]=project;                                    //解析json后把各个属性放在数组中
                    tea[i]=teacher;
                    pla[i]=place;
                    cre[i]=credit;

                    pan1_1.setBackgroundColor(Color.parseColor("#912CEE"));
                    pan1_2.setBackgroundColor(Color.parseColor("#B0E2FF"));
                    pan1_3.setBackgroundColor(Color.parseColor("#7FFF00"));
                    pan1_4.setBackgroundColor(Color.parseColor("#A52A2A"));

                    pan2_1.setBackgroundColor(Color.parseColor("#00F5FF"));
                    pan2_2.setBackgroundColor(Color.parseColor("#DB7093"));
                    pan2_3.setBackgroundColor(Color.parseColor("#CAE1FF"));
                    pan2_4.setBackgroundColor(Color.parseColor("#B3EE3A"));

                    pan3_1.setBackgroundColor(Color.parseColor("#7FFF00"));
                    pan3_2.setBackgroundColor(Color.parseColor("#436EEE"));
                    pan3_3.setBackgroundColor(Color.parseColor("#778899"));
                    pan3_4.setBackgroundColor(Color.parseColor("#98FB98"));

                    pan4_1.setBackgroundColor(Color.parseColor("#FF6A6A"));
                    pan4_2.setBackgroundColor(Color.parseColor("#EEE685"));
                    pan4_3.setBackgroundColor(Color.parseColor("#EE1289"));
                    pan4_4.setBackgroundColor(Color.parseColor("#CDCD00"));

                    pan5_1.setBackgroundColor(Color.parseColor("#98FB98"));
                    pan5_2.setBackgroundColor(Color.parseColor("#00F5FF"));
                    pan5_3.setBackgroundColor(Color.parseColor("#E8E8E8"));
                    pan5_4.setBackgroundColor(Color.parseColor("#EE3B3B"));

                    switch (project){
                        case "rjxmgl":
                            project = "软件项目管理";
                            break;
                        case  "byyl":
                            project = "编译原理";
                            break;
                        case "rgzn":
                            project ="人工智能";
                            break;
                        case "mxdx":
                            project ="面向对象的分析与设计";
                            break;
                        case "android":
                            project = "移动应用开发";
                            break;
                        case "rjcs":
                            project = "软件测试";
                            break;
                        case "websj":
                            project = "web上机";
                            break;
                            default:
                                break;
                    }
                    //这个地方要判断课程是不是null，如果是，就不赋值
                    //但是我不能理解为什么null要加  ""
                    //2016.6.3 22:36
                  switch (i){
                      case 0:
                      {
                          if(project.equals("null"))
                          {

                          }
                          else
                            pan1_1.setText(project);
                          break;
                      }
                      case 1:
                      {
                          if(project.equals("null"))
                          {

                          }
                          else
                          pan1_2.setText(project);
                          break;
                      }

                      case 2:
                      {
                          if(project.equals("null"))
                          {

                          }
                          else
                          pan1_3.setText(project);
                          break;
                      }

                      case 3:
                      {
                          if(project.equals("null"))
                          {

                          }
                          else
                             pan1_4.setText(project);
                          break;
                      }

                      case 4:
                      {
                          if(project.equals("null"))
                          {

                          }
                          else
                          pan2_1.setText(project);
                          break;
                      }

                      case 5:
                      {
                          if(project.equals("null"))
                          {

                          }
                          else
                          pan2_2.setText(project);
                          break;
                      }

                      case 6:
                      {
                          if(project.equals("null"))
                          {

                          }
                          else
                          pan2_3.setText(project);
                          break;
                      }

                      case 7:
                      {
                          if(project.equals("null"))
                          {

                          }
                          else
                          pan2_4.setText(project);
                          break;
                      }

                      case 8:
                      {
                          if(project.equals("null"))
                          {

                          }
                          else
                          pan3_1.setText(project);
                          break;
                      }

                      case 9:
                      {
                          if(project.equals("null"))
                          {

                          }
                          else
                          pan3_2.setText(project);
                          break;
                      }

                      case 10:
                      {
                          if(project.equals("null"))
                          {

                          }
                          else
                          pan3_3.setText(project);
                          break;
                      }

                      case 11:
                      {
                          if(project.equals("null"))
                          {

                          }
                          else
                          pan3_4.setText(project);
                          break;
                      }

                      case 12:
                      {
                          if(project.equals("null"))
                          {

                          }
                          else
                          pan4_1.setText(project);
                          break;
                      }

                      case 13:
                      {
                          if(project.equals("null"))
                          {

                          }
                          else
                          pan4_2.setText(project);
                          break;
                      }

                      case 14:
                      {
                          if(project.equals("null"))
                          {

                          }
                          else
                          pan4_3.setText(project);
                          break;
                      }

                      case 15:
                      {
                          if(project.equals("null"))
                          {

                          }
                          else
                          pan4_4.setText(project);
                          break;
                      }

                      case 16:
                      {
                          if(project.equals("null"))
                          {

                          }
                          else
                          pan5_1.setText(project);
                          break;
                      }

                      case 17:
                      {
                          if(project.equals("null"))
                          {

                          }
                          else
                          pan5_2.setText(project);
                          break;
                      }

                      case 18:
                      {
                          if(project.equals("null"))
                          {

                          }
                          else
                          pan5_3.setText(project);
                          break;
                      }

                      case 19:
                      {
                          if(project.equals("null"))
                          {

                          }
                          else
                          pan5_4.setText(project);
                          break;
                      }


                  }
                }




                if((pan1_1.getText()).equals(" "))  {  pan1_1.setBackgroundColor(Color.parseColor("#FFFFFF")); }
                if((pan1_2.getText()).equals(" "))  {  pan1_2.setBackgroundColor(Color.parseColor("#FFFFFF")); }
                if((pan1_3.getText()).equals(" "))  {  pan1_3.setBackgroundColor(Color.parseColor("#FFFFFF")); }
                if((pan1_4.getText()).equals(" "))  {  pan1_4.setBackgroundColor(Color.parseColor("#FFFFFF")); }
                if((pan2_1.getText()).equals(" "))  {  pan2_1.setBackgroundColor(Color.parseColor("#FFFFFF")); }
                if((pan2_2.getText()).equals(" "))  {  pan2_2.setBackgroundColor(Color.parseColor("#FFFFFF")); }
                if((pan2_3.getText()).equals(" "))  {  pan2_3.setBackgroundColor(Color.parseColor("#FFFFFF")); }
                if((pan2_4.getText()).equals(" "))  {  pan2_4.setBackgroundColor(Color.parseColor("#FFFFFF")); }
                if((pan3_1.getText()).equals(" "))  {  pan3_1.setBackgroundColor(Color.parseColor("#FFFFFF")); }
                if((pan3_2.getText()).equals(" "))  {  pan3_2.setBackgroundColor(Color.parseColor("#FFFFFF")); }
                if((pan3_3.getText()).equals(" "))  {  pan3_3.setBackgroundColor(Color.parseColor("#FFFFFF")); }
                if((pan3_4.getText()).equals(" "))  {  pan3_4.setBackgroundColor(Color.parseColor("#FFFFFF")); }
                if((pan4_1.getText()).equals(" "))  {  pan4_1.setBackgroundColor(Color.parseColor("#FFFFFF")); }
                if((pan4_2.getText()).equals(" "))  {  pan4_2.setBackgroundColor(Color.parseColor("#FFFFFF")); }
                if((pan4_3.getText()).equals(" "))  {  pan4_3.setBackgroundColor(Color.parseColor("#FFFFFF")); }
                if((pan4_4.getText()).equals(" "))  {  pan4_4.setBackgroundColor(Color.parseColor("#FFFFFF")); }
                if((pan5_1.getText()).equals(" "))  {  pan5_1.setBackgroundColor(Color.parseColor("#FFFFFF")); }
                if((pan5_2.getText()).equals(" "))  {  pan5_2.setBackgroundColor(Color.parseColor("#FFFFFF")); }
                if((pan5_3.getText()).equals(" "))  {  pan5_3.setBackgroundColor(Color.parseColor("#FFFFFF")); }
                if((pan5_4.getText()).equals(" "))  {  pan5_4.setBackgroundColor(Color.parseColor("#FFFFFF")); }







            } catch (JSONException e) {
                e.printStackTrace();

            }

        } else if (id == R.id.nav_slideshow) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, funActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_manage) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,lightActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_share) {
//            Intent intent = new Intent();
//            intent.setClass(MainActivity.this,ShareActivity.class);
//            startActivity(intent);

            //这个分享是调用系统自带的分享功能，代码来自百度，不是我写的//
            Intent intent = new Intent(Intent.ACTION_SEND);

            intent.setType("text/plain");

            intent.putExtra(Intent.EXTRA_SUBJECT, "分享");

            intent.putExtra(Intent.EXTRA_TEXT, "我在使用课程格子，一起使用吧！！");

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            startActivity(Intent.createChooser(intent, getTitle()));

        } else if (id == R.id.nav_send) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, aboutActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onStart() {
        super.onStart();
        load();



        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.bohongtao.sch/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();
        sava();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.bohongtao.sch/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    //监听类//
    public class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            switch (v.getId()) {
                case R.id.pan1_1:
                    if((pan1_1.getText()).equals(" ")){

                        Toast toast = Toast.makeText(MainActivity.this,"这个点不上课，戳你妹",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else
                        showdialog(tea[0],pla[0],cre[0]);
                    break;
//                    Toast toast = Toast.makeText(MainActivity.this,"上课教室",Toast.LENGTH_LONG);
//                    toast.show();
                case R.id.pan1_2:
                    if((pan1_2.getText()).equals(" ")){
                        Toast toast = Toast.makeText(MainActivity.this,"这个点不上课，戳你妹",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else
                        showdialog(tea[1],pla[1],cre[1]);
                    break;
                case R.id.pan1_3:
                    if((pan1_3.getText()).equals(" ")){
                        Toast toast = Toast.makeText(MainActivity.this,"这个点不上课，戳你妹",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else
                        showdialog(tea[2],pla[2],cre[2]);
                    break;
                case R.id.pan1_4:
                    if((pan1_4.getText()).equals(" ")){
                            Toast toast = Toast.makeText(MainActivity.this,"这个点不上课，戳你妹",Toast.LENGTH_SHORT);
                            toast.show();
                            break;
                        }
                        else{
                        showdialog(tea[3],pla[3],cre[3]);
                        break;
                            }
                case R.id.pan2_1:
                    if((pan2_1.getText()).equals(" ")){
                        Toast toast = Toast.makeText(MainActivity.this,"这个点不上课，戳你妹",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else
                    {
                        showdialog(tea[4],pla[4],cre[4]);

                    }
                    break;
                case R.id.pan2_2:
                    if((pan2_2.getText()).equals(" ")){
                        Toast toast = Toast.makeText(MainActivity.this,"这个点不上课，戳你妹",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else
                    {showdialog(tea[5],pla[5],cre[5]);

                    }
                    break;
                case R.id.pan2_3:
                    if((pan2_3.getText()).equals(" ")){
                        Toast toast = Toast.makeText(MainActivity.this,"这个点不上课，戳你妹",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else
                    {
                        showdialog(tea[6],pla[6],cre[6]);

                    }
                    break;
                case R.id.pan2_4:
                    if((pan2_4.getText()).equals(" ")){
                        Toast toast = Toast.makeText(MainActivity.this,"这个点不上课，戳你妹",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else
                    {
                        showdialog(tea[7],pla[7],cre[7]);
                    }
                    break;
                case R.id.pan3_1:
                    if((pan3_1.getText()).equals(" ")){
                        Toast toast = Toast.makeText(MainActivity.this,"这个点不上课，戳你妹",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else
                    {
                        showdialog(tea[8],pla[8],cre[8]);
                    }
                    break;
                case R.id.pan3_2:
                    if((pan3_2.getText()).equals(" ")){
                        Toast toast = Toast.makeText(MainActivity.this,"这个点不上课，戳你妹",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else
                    {
                        showdialog(tea[9],pla[9],cre[9]);

                    }
                    break;
                case R.id.pan3_3:
                    if((pan1_1.getText()).equals(" ")){
                        Toast toast = Toast.makeText(MainActivity.this,"这个点不上课，戳你妹",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else
                    {
                        showdialog(tea[10],pla[10],cre[10]);

                    }
                    break;
                case R.id.pan3_4:
                    if((pan3_4.getText()).equals(" ")){
                        Toast toast = Toast.makeText(MainActivity.this,"这个点不上课，戳你妹",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else
                    {
                        showdialog(tea[11],pla[11],cre[11]);

                    }
                    break;
                case R.id.pan4_1:
                    if((pan4_1.getText()).equals(" ")){
                        Toast toast = Toast.makeText(MainActivity.this,"这个点不上课，戳你妹",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else
                    {
                        showdialog(tea[12],pla[12],cre[12]);
                    }
                    break;
                case R.id.pan4_2:
                    if((pan4_2.getText()).equals(" ")){
                        Toast toast = Toast.makeText(MainActivity.this,"这个点不上课，戳你妹",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else
                    {
                        showdialog(tea[13],pla[13],cre[13]);

                    }
                    break;
                case R.id.pan4_3:
                    if((pan4_3.getText()).equals(" ")){
                        Toast toast = Toast.makeText(MainActivity.this,"这个点不上课，戳你妹",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else
                    {
                        showdialog(tea[14],pla[14],cre[14]);

                    }
                    break;
                case R.id.pan4_4:
                    if((pan4_4.getText()).equals(" ")){
                        Toast toast = Toast.makeText(MainActivity.this,"这个点不上课，戳你妹",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else
                    {
                        showdialog(tea[15],pla[15],cre[15]);

                    }
                    break;
                case R.id.pan5_1:
                    if((pan5_1.getText()).equals(" ")){
                        Toast toast = Toast.makeText(MainActivity.this,"这个点不上课，戳你妹",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else
                    {
                        showdialog(tea[16],pla[16],cre[16]);
                    }
                    break;
                case R.id.pan5_2:
                    if((pan5_2.getText()).equals(" ")){
                        Toast toast = Toast.makeText(MainActivity.this,"这个点不上课，戳你妹",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else
                    {
                        showdialog(tea[17],pla[17],cre[17]);

                    }
                    break;
                case R.id.pan5_3:
                    if((pan5_3.getText()).equals(" ")){
                        Toast toast = Toast.makeText(MainActivity.this,"这个点不上课，戳你妹",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else
                    {
                        showdialog(tea[18],pla[18],cre[18]);

                    }
                    break;
                case R.id.pan5_4:
                    if((pan5_4.getText()).equals(" ")){
                        Toast toast = Toast.makeText(MainActivity.this,"这个点不上课，戳你妹",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else
                    {
                        showdialog(tea[19],pla[19],cre[19]);

                    }
                    break;

                default:
                    break;
            }
        }

    }

    public class OnLongClick implements View.OnLongClickListener{
        @Override
        public boolean onLongClick(View view) {
            switch (view.getId()){
                case R.id.pan1_1:
//                    Toast toast = Toast.makeText(MainActivity.this,"编辑功能正在开发中！",Toast.LENGTH_SHORT);
//                    toast.show();
                    LayoutInflater inflater = getLayoutInflater();
                     final View layout = inflater.inflate(R.layout.dialog,
                      (ViewGroup) findViewById(R.id.dialog));
                     new AlertDialog.Builder(MainActivity.this).setTitle("更新课程").setView(layout)
                     .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialogInterface, int i) {

                             EditText edt1 = (EditText) layout.findViewById(R.id.teacher);
                             EditText edt2= (EditText) layout.findViewById(R.id.place);
                             EditText edt3 = (EditText) layout.findViewById(R.id.credit);
                             EditText edt4 = (EditText) layout.findViewById(R.id.project);
//                             Toast toast = Toast.makeText(MainActivity.this, edt.getText().toString(),Toast.LENGTH_SHORT);
//                                toast.show();

                             pan1_1.setText(edt4.getText());
                             pro[0] = edt4.getText().toString();
                             tea[0] = edt1.getText().toString();
                             pla[0] = edt2.getText().toString();
                             cre[0] = edt3.getText().toString();
                         }
                     })
                      .setNegativeButton("取消", null).show();

            }
            return false;
        }
    }


    //dialog对话框提示上课信息//
    private void showdialog(String teacher,String space,String value) {
        switch (teacher){
            case "sql":
                teacher = "师庆玲";
                break;
            case "zlp":
                teacher = "郑丽萍";
                break;
            case "cj":
                teacher = "陈晶";
                break;
            case "wyt":
                teacher = "王玉亭";
                break;
            case "st":
                teacher = "孙涛";
                break;
            case "zhw":
                teacher = "张怀伟";
                break;
            case "lhy":
                teacher = "凌海云";
                break;
            default:
                teacher = "小黑";
                break;
        }



        AlertDialog.Builder mbuild = new AlertDialog.Builder(this);
        mbuild.setTitle("上课信息");
        mbuild.setMessage("老师："+teacher+"\n地点："+space+"\n学分："+value);
        mbuild.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        mbuild.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        mbuild.create().show();

    }

}
