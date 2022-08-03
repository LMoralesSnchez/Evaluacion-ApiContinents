package facci.pm.evaluacionapicontinents.Adapter;

import java.util.List;

import facci.pm.evaluacionapicontinents.Constants.ContinentsApi;
import facci.pm.evaluacionapicontinents.Models.Continent;
import facci.pm.evaluacionapicontinents.Service.ContinentsService;
import retrofit2.Call;

public class ContinentsAdapter extends BaseAdapter implements ContinentsService {
    private ContinentsService continentsService;

    public ContinentsAdapter() {
        super(ContinentsApi.BASE_GHIBLI_URL);
        continentsService  = createService(ContinentsService.class);
    }
    @Override
    public Call<List<Continent>> getContinents() {
        return continentsService.getContinents();
    }
}
