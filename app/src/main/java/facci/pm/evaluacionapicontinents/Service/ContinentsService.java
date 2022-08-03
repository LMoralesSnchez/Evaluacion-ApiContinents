package facci.pm.evaluacionapicontinents.Service;

import java.util.List;

import facci.pm.evaluacionapicontinents.Constants.ContinentsApi;
import facci.pm.evaluacionapicontinents.Models.Continent;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ContinentsService {
    @GET(ContinentsApi.CONTINENTS_ENDPOINT)
    Call<List<Continent>> getContinents();
}
