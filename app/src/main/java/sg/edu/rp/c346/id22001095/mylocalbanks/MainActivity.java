package sg.edu.rp.c346.id22001095.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    String bankSelected="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);



        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        } else {
            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_main2, menu);

        if(v == tvDBS){
            bankSelected = "dbs";
        }
        else if (v == tvOCBC) {
            bankSelected = "ocbc";
        }
        else if (v == tvUOB){
            bankSelected = "uob";
        }
    }

    boolean isFavourite = false;

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (bankSelected.equalsIgnoreCase("dbs")) {

            if (item.getItemId() == R.id.WebsiteSelection) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);



                return true;
            } else if (item.getItemId() == R.id.DialSelection) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + "18001111111"));
                startActivity(intent);


                return true;
            }

            else if (item.getItemId() == R.id.AddToFav){

                if (isFavourite == true) {
                    tvDBS.setTextColor(Color.BLACK);
                    isFavourite = false;
                } else {
                    tvDBS.setTextColor(Color.RED);
                    isFavourite = true;
                }



            return true;
        }

        } else if(bankSelected.equalsIgnoreCase("ocbc")){
            if (item.getItemId() == R.id.WebsiteSelection) {
                //code for action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);


                return true;
            } else if (item.getItemId() == R.id.DialSelection) {
                //code for action
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + "18003633333"));
                startActivity(intent);


                return true;  //menu item successfully handled
            }
            else if (item.getItemId() == R.id.AddToFav){
                //code for action

                if (isFavourite == true) {
                    tvOCBC.setTextColor(Color.BLACK);
                    isFavourite = false;
                } else {
                    tvOCBC.setTextColor(Color.RED);
                    isFavourite = true;
                }



                return true;
            }


        }

        else if(bankSelected.equalsIgnoreCase("uob")){
            if (item.getItemId() == R.id.WebsiteSelection) {
                //code for action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);


                return true;
            } else if (item.getItemId() == R.id.DialSelection) {
                //code for action
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + "18002222121"));
                startActivity(intent);


                return true;  //menu item successfully handled
            }
            else if (item.getItemId() == R.id.AddToFav){
                //code for action

                if (isFavourite == true) {
                    tvUOB.setTextColor(Color.BLACK);
                    isFavourite = false;
                } else {
                    tvUOB.setTextColor(Color.RED);
                    isFavourite = true;
                }



                return true;
            }


        }

            return super.onContextItemSelected(item);
        }




}