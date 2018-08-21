package com.blogbasbas.usingalert;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_nama_form_alert)
    TextView tvNamaFormAlert;
    @BindView(R.id.tv_umur_form_alert)
    TextView tvUmurFormAlert;
    @BindView(R.id.btn_alert)
    Button btnAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_alert)
    public void onViewClicked() {
        showAlert();
    }

    private void showAlert() {
        LayoutInflater factory = LayoutInflater.from(this);
        final View dialogView = factory.inflate(R.layout.alert_dialog, null);
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setView(dialogView);
        dialog.setTitle("Inut nama");
        dialog.setMessage("input . . . ");
        final EditText nama = (EditText) dialogView.findViewById(R.id.edt_name_alert);
        final EditText umur = (EditText) dialogView.findViewById(R.id.edt_umur_alert);
        Button btnSave = (Button) dialogView.findViewById(R.id.btn_save_name);
        dialog.setCancelable(false);
        final AlertDialog show = dialog.show();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String getNama = nama.getText().toString();
                final String getUmur = umur.getText().toString();
                if (getNama.isEmpty()) {
                    nama.setError("Data tidak bisa kosong");
                } else if (getUmur.isEmpty()) {
                    umur.setError("data tidak bisa kosong");
                } else {

                    tvNamaFormAlert.setText("hasil :" + getNama);
                    tvUmurFormAlert.setText("hasil " + getUmur);
                    Log.e("tag", "hasil : " + getNama);
                    Toast.makeText(MainActivity.this, "test", Toast.LENGTH_SHORT).show();

                    show.dismiss();
                }

            }
        });


    }

}
