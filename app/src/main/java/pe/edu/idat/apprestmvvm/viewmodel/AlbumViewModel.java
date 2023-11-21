package pe.edu.idat.apprestmvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import pe.edu.idat.apprestmvvm.apirest.AlbumClient;
import pe.edu.idat.apprestmvvm.model.Album;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumViewModel extends AndroidViewModel
{
    public MutableLiveData<List<Album>> listMutableLiveData
            = new MutableLiveData<>();

    public AlbumViewModel(@NonNull Application application) {
        super(application);
    }

    public void getAlbum(){
        AlbumClient.getInstance().getAlbums().enqueue(
                new Callback<List<Album>>() {
                    @Override
                    public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                        listMutableLiveData.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Album>> call, Throwable t) {
                        t.printStackTrace();
                    }
                }
        );
    }
}
