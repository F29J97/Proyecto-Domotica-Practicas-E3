package com.francisco.controlhome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;

import tech.gusavila92.websocketclient.WebSocketClient;

public class MainActivity extends AppCompatActivity {
    String luz= "";
    String bomba="";
    Boolean interrupted= false;
    String parametro = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(b1.getText().equals("Luz Patio")){
                    b1.setText("Apagar luz");
                    parametro= "e";
                }else {
                    b1.setText("Luz Patio");
                    parametro= "a";
                }
                EjecutarSocket socket = new EjecutarSocket();
                socket.execute();

            }
        });

        Button b2 = (Button) findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(b2.getText().equals("Llenar Tinaco")){
                    b2.setText("Apagar Bomba");
                    parametro= "b";
                }else {
                    b2.setText("Llenar Tinaco");
                    parametro= "t";
                }
                EjecutarSocket socket = new EjecutarSocket();
                socket.execute();


            }
        });
        Button b3 = (Button) findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(b3.getText().equals("Ventilador")){
                    b3.setText("Apagar Ventilador");
                    parametro= "v";
                }else {
                    b3.setText("Ventilador");
                    parametro= "c";
                }
                EjecutarSocket socket = new EjecutarSocket();
                socket.execute();


            }
        });
        Button b4 = (Button) findViewById(R.id.b4);
        b4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(b4.getText().equals("Secadora")){
                    b4.setText("Secadora OFF");
                    parametro= "s";
                }else {
                    b4.setText("Secadora");
                    parametro= "d";
                }
                EjecutarSocket socket = new EjecutarSocket();
                socket.execute();


            }
        });

        Switch sw1 = (Switch) findViewById(R.id.sw1);
        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    parametro= "o";
                }
                else{
                    parametro="f";
                }
                EjecutarSocket socket = new EjecutarSocket();
                socket.execute();

            }
        });
        Button b5 = (Button) findViewById(R.id.b5);
        b5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(b5.getText().equals("Luz Sala")){
                    b5.setText("Apagar Luz Sala");
                    parametro= "u";
                }else {
                    b5.setText("Luz Sala");
                    parametro= "g";
                }
                EjecutarSocket socket = new EjecutarSocket();
                socket.execute();


            }
        });
        Button b6 = (Button) findViewById(R.id.b6);
        b6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(b6.getText().equals("Luz Habitacion 1")){
                    b6.setText("Apagar Luz H1");
                    parametro= "h";
                }else {
                    b6.setText("Luz Habitacion 1");
                    parametro= "i";
                }
                EjecutarSocket socket = new EjecutarSocket();
                socket.execute();


            }
        });
        Button b7 = (Button) findViewById(R.id.b7);
        b7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(b7.getText().equals("Luz Habitacion 2")){
                    b7.setText("Apagar Luz H2");
                    parametro= "j";
                }else {
                    b7.setText("Luz Habitacion 2");
                    parametro= "k";
                }
                EjecutarSocket socket = new EjecutarSocket();
                socket.execute();


            }
        });
        Button b8 = (Button) findViewById(R.id.b8);
        b8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(b8.getText().equals("Luz Cocina")){
                    b8.setText("Apagar Luz Cocina");
                    parametro= "l";
                }else {
                    b8.setText("Luz Cocina");
                    parametro= "m";
                }
                EjecutarSocket socket = new EjecutarSocket();
                socket.execute();


            }
        });
        Button b9 = (Button) findViewById(R.id.b9);
        b9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(b9.getText().equals("Luz Baño")){
                    b9.setText("Apagar Luz Baño");
                    parametro= "n";
                }else {
                    b9.setText("Luz Baño");
                    parametro= "p";
                }
                EjecutarSocket socket = new EjecutarSocket();
                socket.execute();


            }
        });

    }

        class EjecutarSocket extends AsyncTask<Void, Void, Void>{
            Socket soc;
            PrintWriter pw;
            BufferedReader br;
            @Override
            protected Void doInBackground(Void... params) {
                String ip = "192.168.0.14";
                int puerto = 5000;
                Log.e("Info Socket", "socket " + ip+ "" + puerto);

                try{
                   soc= new Socket(ip,puerto);
                    /*br =  new BufferedReader(
                            new InputStreamReader(soc.getInputStream()));*/
                    pw = new PrintWriter(
                            new OutputStreamWriter(soc.getOutputStream()), true);

                    pw.write(parametro);

                    /*Toast.makeText(getApplicationContext(),
                            "Recibido de socket: " + br.readLine(), Toast.LENGTH_LONG).show();*/
                    pw.flush();
                    pw.close();
                    soc.close();
                }
                catch (Exception e){
                    Log.d("Exception", "Error: " + e.toString());
                    Toast.makeText(getApplicationContext(),
                            "Error: " + e.toString(), Toast.LENGTH_LONG).show();

                }
                return null;
            }
        }

        }
