package id.sch.tugas01smktelkom_mlg.xiirpl1003.pendaftaransubcomet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

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
    }
}
