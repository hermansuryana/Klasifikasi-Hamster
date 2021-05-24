package org.tensorflow.lite.examples.classification;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.app.AlertDialog;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton scan = findViewById(R.id.scan);
        ImageButton about = findViewById(R.id.about);
        ImageButton exit = findViewById(R.id.exit);

        scan.setOnClickListener(view -> {
            Intent iScan = new Intent(MainActivity.this, ClassifierActivity.class);
            startActivity(iScan);
        });
        about.setOnClickListener(view -> {
            Intent iAbout = new Intent(MainActivity.this, About.class);
            startActivity(iAbout);
        });
        exit.setOnClickListener(view -> {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        this);

                // set title dialog
                alertDialogBuilder.setTitle("Keluar dari aplikasi?");

                // set pesan dari dialog
                alertDialogBuilder
                        .setMessage("Klik Ya untuk keluar!")
                        .setIcon(R.drawable.keluar)
                        .setCancelable(false)
                        .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // jika tombol YA diklik , maka akan menutup activity ini
                                MainActivity.this.finish();
                            }
                        })
                        .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // jika tombol TIDAK diklik, akan menutup dialog
                                // dan tidak terjadi apa2
                                dialog.cancel();
                            }
                        });

                // membuat alert dialog dari builder
                AlertDialog alertDialog = alertDialogBuilder.create();
                // menampilkan alert dialog
                alertDialog.show();

        });
    }
}
