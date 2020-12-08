package com.example.dialer_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   // Button btnOne,btnTwo,btnThree,btnFour,btnFive,btnSix,btnSeven,btnEight,btnNine,btnStar,btnZero,btnHash;
   // Button btnDelete,btnDial;
   // EditText input;
    EditText input;
    TextView infotext;
   // String fav[];
    //String num[];

    //int i= 0;

    final static int PERMISSION_TO_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.EditNumb);
        infotext = (TextView) findViewById(R.id.infotext);
      /*  btnOne= findViewById(R.id.button1);
        btnTwo=findViewById(R.id.button2);
        btnThree=findViewById(R.id.button3);
        btnFour=findViewById(R.id.button4);
        btnFive=findViewById(R.id.button5);
        btnSix=findViewById(R.id.button6);
        btnSeven=findViewById(R.id.button7);
        btnEight=findViewById(R.id.button8);
        btnNine=findViewById(R.id.button9);
        btnStar=findViewById(R.id.buttonStar);
        btnZero=findViewById(R.id.button0 );
        btnHash=findViewById(R.id.buttonHash);


        btnDelete=findViewById(R.id.buttonDelete);
        btnDial=findViewById(R.id.buttonDial);

        input=findViewById(R.id.EditNumb);*/

    /*    R.id.button0.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                onSpeedDial("0");
                return true;
            }
        });


    }
    public void onSpeedDial(String numb){
        String phone = input.getText().toString();
        fav[i] = phone;
        num[i] = numb;
        i++;
        new SpeedDial();

    }
    public class SpeedDial {
        EditText tecla, ph_num;
        Button cancel, save;



        protected void onCreate(Bundle savedInstanceState) {
            setContentView(R.layout.speed_dial);

            tecla = (EditText) findViewById(R.id.txtNum);
            ph_num =(EditText) findViewById(R.id.txtFav);

            for(int j = 0; j< fav.length;j++){
                ph_num.setText(fav[j]);
                tecla.setText(num[j]);
            }
        }


    }*/

    }
    public void buttonClickEvent(View v){
        String phone_num = input.getText().toString();

        try {
            switch (v.getId()){
                case R.id.button0:
                    phone_num += "0";
                    infotext.setText("");
                    input.setText((phone_num));
                    break;
                case R.id.button1:
                    phone_num += "1";
                    infotext.setText("");
                    input.setText((phone_num));
                    break;
                case R.id.button2:
                    phone_num += "2";
                    infotext.setText("");
                    input.setText((phone_num));
                    break;
                case R.id.button3:
                    phone_num += "3";
                    infotext.setText("");
                    input.setText((phone_num));
                    break;
                case R.id.button4:
                    phone_num += "4";
                    infotext.setText("");
                    input.setText((phone_num));
                    break;
                case R.id.button5:
                    phone_num += "5";
                    infotext.setText("");
                    input.setText((phone_num));
                    break;
                case R.id.button6:
                    phone_num += "6";
                    infotext.setText("");
                    input.setText((phone_num));
                    break;
                case R.id.button7:
                    phone_num += "7";
                    infotext.setText("");
                    input.setText((phone_num));
                    break;
                case R.id.button8:
                    phone_num += "8";
                    infotext.setText("");
                    input.setText((phone_num));
                    break;
                case R.id.button9:
                    phone_num += "9";
                    infotext.setText("");
                    input.setText((phone_num));
                    break;
                case R.id.buttonHash:
                    phone_num += "#";
                    infotext.setText("");
                    input.setText((phone_num));
                    break;
                case R.id.buttonStar:
                    phone_num += "*";
                    infotext.setText("");
                    input.setText((phone_num));
                    break;
                case R.id.buttonDelete:
                    infotext.setText("");
                    if(phone_num != null && phone_num.length()>0){
                        phone_num = phone_num.substring(0,phone_num.length()-1);
                    }
                    input.setText(phone_num);
                    break;
                case R.id.buttonClear:
                    infotext.setText("");
                    input.setText("");
                    break;
               // case R.id.buttonFav:
                //    new SpeedDial();
                 //   break;
                case R.id.buttonDial:
                    if(phone_num.trim().equals("")){
                        infotext.setText("Please enter a phone number!");
                    }else{
                        Boolean isHash= false;
                        if(phone_num.subSequence(phone_num.length()-1, phone_num.length()).equals("#")){
                            phone_num =  phone_num.substring(0,phone_num.length()-1);
                            String callinfo = "tel:" + phone_num + Uri.encode("#");
                            Intent callIntent = new Intent(Intent.ACTION_CALL);
                            callIntent.setData(Uri.parse(callinfo));
                            if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                                ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                                        Manifest.permission.CALL_PHONE},PERMISSION_TO_CALL);
                            }else{
                                if(callIntent.resolveActivity(getPackageManager())!=null){
                                    startActivity(callIntent);
                                }
                            }
                        }else{
                            String callinfo = "tel:" + phone_num;
                            Intent callIntent = new Intent(Intent.ACTION_CALL);

                            callIntent.setData(Uri.parse(callinfo));
                            if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                                ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                                        Manifest.permission.CALL_PHONE},PERMISSION_TO_CALL);
                            }else{
                                if(callIntent.resolveActivity(getPackageManager())!=null){
                                    startActivity(callIntent);
                                }
                            }
                        }
                    }
                    break;
            }
        }catch (Exception ex){
            infotext.setText("Nao deu");
        }

    }

/*


    public void one(View v){
        onButtonClick(btnOne,input,"1");
    }
    public void two(View v){
        onButtonClick(btnTwo,input,"2");
    }
    public void three(View v){
        onButtonClick(btnThree,input,"3");
    }
    public void four(View v){
        onButtonClick(btnFour,input,"4");
    }
    public void five(View v){
        onButtonClick(btnFive,input,"5");
    }
    public void six(View v){
        onButtonClick(btnSix,input,"6");
    }
    public void seven(View v){
        onButtonClick(btnSeven,input,"7");
    }
    public void eight(View v){
        onButtonClick(btnEight,input,"8");
    }
    public void nine(View v){
        onButtonClick(btnNine,input,"9");
    }
    public void star(View v){
        onButtonClick(btnStar,input,"*");
    }
    public void zero(View v){
        onButtonClick(btnZero,input,"0");
    }
    public void hash(View v){
        onButtonClick(btnHash,input,"#");
    }
    public void onDial(View v){
        input.setText("");
    }
    public void onDelete(View v){
        if(input.getText().length()<=3){
            Toast.makeText(this,"Please Enter a Valid Number",Toast.LENGTH_SHORT).show();
        }else{
            Intent intent= new Intent(Intent.ACTION_CALL);

            String hash=input.getText().toString();
            if(hash.contains("#")){
                hash.replace("#","%23");
            }
            intent.setData(Uri.parse("tel:"+hash));
            startActivity(intent);
        }
    }
    public void onButtonClick(Button button, EditText inputNmb,String nmb){
        String cache = input.getText().toString();
        inputNmb.setText(cache+nmb);
    }*/
}