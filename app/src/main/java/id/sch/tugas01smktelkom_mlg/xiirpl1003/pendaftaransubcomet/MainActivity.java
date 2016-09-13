package id.sch.tugas01smktelkom_mlg.xiirpl1003.pendaftaransubcomet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nama, tgl_lahir, bulan_lahir, tahun_lahir, alasan;
    Spinner las;
    RadioGroup SB;
    CheckBox Metic, Bdi, Medsan;
    Button proses, daftar;
    TextView hasil_nama, hasil_kelas, hasil_ttl, hasil_umur, hasil_SB, hasil_sub, hasil_alasan, sukses;
    LinearLayout llHasil;

    private int year;
    private String _sb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nama = (EditText) findViewById(R.id.etNama);
        tgl_lahir = (EditText) findViewById(R.id.etTgl);
        bulan_lahir = (EditText) findViewById(R.id.etBulan);
        tahun_lahir = (EditText) findViewById(R.id.etTahun);
        alasan = (EditText) findViewById(R.id.etAlasan);
        las = (Spinner) findViewById(R.id.spinnerLas);
        SB = (RadioGroup) findViewById(R.id.rgSB);
        Metic = (CheckBox) findViewById(R.id.cbMetic);
        Bdi = (CheckBox) findViewById(R.id.cbBdi);
        Medsan = (CheckBox) findViewById(R.id.cbMedsan);
        proses = (Button) findViewById(R.id.btnProcess);
        daftar = (Button) findViewById(R.id.btnRegister);
        hasil_nama = (TextView) findViewById(R.id.tvHasilNama);
        hasil_kelas = (TextView) findViewById(R.id.tvHasilKelas);
        hasil_ttl = (TextView) findViewById(R.id.tvHasilLahir);
        hasil_umur = (TextView) findViewById(R.id.tvHasilUmur);
        hasil_SB = (TextView) findViewById(R.id.tvHasilSB);
        hasil_sub = (TextView) findViewById(R.id.tvHasilSub);
        hasil_alasan = (TextView) findViewById(R.id.tvHasilAlasan);
        sukses = (TextView) findViewById(R.id.tvSukses);
        llHasil = (LinearLayout) findViewById(R.id.llHasil);

        proses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nama.getText().toString().equals("")
                        || tgl_lahir.getText().toString().equals("")
                        || bulan_lahir.getText().toString().equals("")
                        || tahun_lahir.getText().toString().equals("")
                        || las.getSelectedItem().toString().equals("")
                        || SB.getCheckedRadioButtonId() == -1
                        || alasan.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Isi data dengan lengkap", Toast.LENGTH_SHORT).show();
                } else if (Integer.parseInt(tgl_lahir.getText().toString()) < 1 || Integer.parseInt(tgl_lahir.getText().toString()) > 31) {
                    tgl_lahir.setError("Format tanggal salah");
                } else if (Integer.parseInt(bulan_lahir.getText().toString()) < 1 || Integer.parseInt(bulan_lahir.getText().toString()) > 12) {
                    bulan_lahir.setError("Format bulan salah");
                } else if (!Metic.isChecked()
                        && !Bdi.isChecked()
                        && !Medsan.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Anda belum memilih Sub organisasi", Toast.LENGTH_SHORT).show();
                } else {
                    llHasil.setVisibility(View.VISIBLE);
                    llHasil.setFocusableInTouchMode(true);
                    llHasil.requestFocus();
                    hasil_nama.setText(nama.getText().toString());
                    hasil_kelas.setText(las.getSelectedItem().toString());
                    hasil_ttl.setText(tgl_lahir.getText().toString() + " - " + getMonth(bulan_lahir.getText().toString()) + " - " + tahun_lahir.getText().toString());
                    hasil_umur.setText(getYear(tahun_lahir.getText().toString()));
                    hasil_sub.setText(setTim());
                    hasil_alasan.setText(alasan.getText().toString());
                    hasil_SB.setText(getSB() + " tahu tentang sub COMET sebelumnya");
                }
            }
        });

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                llHasil.setVisibility(View.GONE);
                sukses.setVisibility(View.VISIBLE);
                sukses.setFocusableInTouchMode(true);
                sukses.requestFocus();

            }
        });
    }

    private String getMonth(String bulan) {
        String month = "";
        switch (bulan) {
            case "1":
            case "01":
                month = "Januari";
                break;
            case "2":
            case "02":
                month = "Februari";
                break;
            case "3":
            case "03":
                month = "Maret";
                break;
            case "4":
            case "04":
                month = "April";
                break;
            case "5":
            case "05":
                month = "Mei";
                break;
            case "6":
            case "06":
                month = "Juni";
                break;
            case "7":
            case "07":
                month = "Juli";
                break;
            case "8":
            case "08":
                month = "Agustus";
                break;
            case "9":
            case "09":
                month = "September";
                break;
            case "10":
                month = "Oktober";
                break;
            case "11":
                month = "November";
                break;
            case "12":
                month = "Desember";
                break;
        }
        return month;
    }

    public String getYear(String tahun) {
        year = 2016 - Integer.parseInt(tahun);
        return String.valueOf(year);
    }

    public String getSB() {
        RadioButton rb = (RadioButton) findViewById(SB.getCheckedRadioButtonId());
        _sb = rb.getText().toString();
        return _sb;
    }

    private String setTim() {
        String tim = "";
        if (Metic.isChecked()) {
            tim += "METIC, ";
        }
        if (Bdi.isChecked()) {
            tim += "BDI, ";
        }
        if (Medsan.isChecked()) {
            tim += "MEDSAN.";
        }
        return tim;
    }
}
