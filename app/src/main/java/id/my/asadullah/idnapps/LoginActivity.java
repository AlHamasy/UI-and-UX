package id.my.asadullah.idnapps;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Todo deklarasi
        Button submit = findViewById(R.id.button);
        final EditText editText = findViewById(R.id.editText);
        final Preference preference = new Preference(LoginActivity.this);

        //Todo aksi button
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Todo get ke string
                String nama = editText.getText().toString();

                //Todo mengecek apabila kosong
                if (TextUtils.isEmpty(nama)){
                    //Toast.makeText(LoginActivity.this, "Harap isi", Toast.LENGTH_SHORT).show();
                    editText.setError("Harap isi");
                }
                else {
                    preference.setNama(nama);
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }
            }
        });
    }

    //Todo membuat class preference
    public static class Preference{
        String KEY_NAME = "NAMA";
        String PREF_NAME = "SIMPAN";
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editor;
        // todo membuat construktor
        public Preference (Context context){
            sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        }
        // todo method get nama
        public String getNama(){
            return  sharedPreferences.getString(KEY_NAME, null);
        }
        // todo method set nama
        public  void setNama(String nama){
            editor = sharedPreferences.edit();
            editor.putString(KEY_NAME, nama).apply();
        }
        public void logout(){
            editor = sharedPreferences.edit();
            editor.clear().commit();
        }
    }
}

