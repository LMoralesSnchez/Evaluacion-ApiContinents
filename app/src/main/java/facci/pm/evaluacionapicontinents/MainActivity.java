package facci.pm.evaluacionapicontinents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import facci.pm.evaluacionapicontinents.Adapter.ContinentsAdapter;
import facci.pm.evaluacionapicontinents.Models.Continent;
import facci.pm.evaluacionapicontinents.Service.ContinentsService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static TextView mJsonTextViewContinents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mJsonTextViewContinents = findViewById(R.id.jsonTextContinents);

        MostrarContinents();
    }

    private void MostrarContinents() {
        ContinentsAdapter continentsAdapter = new ContinentsAdapter();
        Call<List<Continent>> call = continentsAdapter.getContinents();
        call.enqueue(new Callback<List<Continent>>() {
            @Override
            public void onResponse(Call<List<Continent>> call, Response<List<Continent>> response) {
                List<Continent> datos = response.body();

                for (Continent post : datos){
                    String content = "";

                    content +="ID: "+ post.getId() + "\n";
                    content +="NAME: "+ post.getName() + "\n";
                    mJsonTextViewContinents.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Continent>> call, Throwable t) {
                Log.e("test", "no se pudo traer los datos");

            }
        });

    }
}