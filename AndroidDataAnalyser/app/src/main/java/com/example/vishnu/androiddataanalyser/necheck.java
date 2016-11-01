package com.example.vishnu.androiddataanalyser;

import android.net.TrafficStats;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class necheck extends AppCompatActivity {

    final double[] RXOld = new double[1];
    NetConnection nc;
    TextView textView2,textView3;
    TelephonyManager tel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        nc = new NetConnection(this);

            super.onCreate(savedInstanceState);
            //nc = new NetConnection(this);
            //if (nc.isConnected()) {
        setContentView(R.layout.netcheck);
            tel=(TelephonyManager)getSystemService(TELEPHONY_SERVICE);
            textView2=(TextView)findViewById(R.id.textView2);
            textView3=(TextView)findViewById(R.id.textView3);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {


                @Override
                public void run() {


                    ////////////////////////Code to be executed every second////////////////////////////////////////


                    double overallTraffic = TrafficStats.getMobileRxBytes();
                    int kbs;
                    double currentDataRate = overallTraffic - RXOld[0];
                    kbs = (int) currentDataRate / 1024;
                    TextView view1;
                    view1 = (TextView) findViewById(R.id.view1);
                    assert view1 != null;
                    view1.setText("Current Data Rate per second= " + kbs + "kbps");
                    RXOld[0] = overallTraffic;
                    handler.postDelayed(this, 1000);
                }
            }, 1000);
            textView2.setText("operator code:"+ tel.getNetworkOperator() +"\n subscriber Id:"+ tel.getSubscriberId() +"\nOperator name:"+ tel.getNetworkOperatorName() +"\nNetwork type:"+tel.getNetworkType()+"\nCounry ISO:"+ tel.getNetworkCountryIso());
            if(tel.getNetworkOperatorName().equalsIgnoreCase("vodafone in"))
            {
            textView3.setText("call charges:2p/sec"+"   "+"\ndata charges:10p/kb");
            }
            else if(tel.getNetworkOperatorName().equalsIgnoreCase("idea"))
            {
                textView3.setText("call charges:3p/sec"+"   "+"\ndata charges:5p/kb");

            }
            else if(tel.getNetworkOperatorName().equalsIgnoreCase("airtel"))
            {
                textView3.setText("call charges:2p/sec"+"   "+"\ndata charges:2p/kb");

            }
            else if(tel.getNetworkOperatorName().equalsIgnoreCase("reliance"))
            {
                textView3.setText("call charges:1p/sec"+"   "+"\ndata charges:1p/kb");

            }
            else if(tel.getNetworkOperatorName().equalsIgnoreCase("cellone"))
            {
                textView3.setText("call charges:2p/sec"+"   "+"\ndata charges:1p/kb");

            }
            else if(tel.getNetworkOperatorName().equalsIgnoreCase("uninor"))
            {
                textView3.setText("call charges:1p/sec"+"   "+"\ndata charges:5p/kb");

            }
            else if(tel.getNetworkOperatorName().equalsIgnoreCase("aircel"))
            {
                textView3.setText("call charges:3p/sec"+"   "+"\ndata charges:3p/kb");

            }
            else if(tel.getNetworkOperatorName().equalsIgnoreCase("tata docomo"))
            {
                textView3.setText("call charges:1p/sec"+"   "+"\ndata charges:10p/kb");

            }
        else {
                textView3.setText("WORKING FOR YOUR SIM ");
            }


        //Toast.makeText(this, "CONNECTION ESTABLISHED", Toast.LENGTH_LONG).show();
        }
        @Override
    protected void onPause() {
        super.onPause();

    }

    }







