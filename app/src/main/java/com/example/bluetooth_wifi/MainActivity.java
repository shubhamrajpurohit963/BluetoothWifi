package com.example.bluetooth_wifi;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup wifiradioGroup;
    RadioGroup bluetoothradioGroup;
    WifiManager wifi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifiradioGroup = findViewById(R.id.wifi_radiogroup);
        bluetoothradioGroup = findViewById(R.id.bluetooth_radiogroup);
        wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
    }

    public void onWifiRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.wifi_enable:
                if (checked) {
                    wifi.setWifiEnabled(true);
                    Toast.makeText(this, "Wifi Enabled", Toast.LENGTH_LONG).show();
                }
                    break;
            case R.id.wifi_disable:
            {
                wifi.setWifiEnabled(false);
                Toast.makeText(this,"Wifi Disabled",Toast.LENGTH_LONG).show();
            }
                break;
        }
    }

    public void onBluetoothRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();


        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.bluetooth_enable:
                if (checked) {
                        Intent intentBtEnabled = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                        int REQUEST_ENABLE_BT = 1;
                        startActivityForResult(intentBtEnabled, REQUEST_ENABLE_BT);
                        Toast.makeText(this, "Bluetooth Enabled", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bluetooth_disable:
                if (checked) {
                        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
                        adapter.disable();
                        Toast.makeText(this, "Bluetooth Disabled", Toast.LENGTH_LONG).show();

                }
                break;
        }
    }
}