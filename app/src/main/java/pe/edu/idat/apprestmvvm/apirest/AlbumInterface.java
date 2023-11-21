package pe.edu.idat.apprestmvvm.apirest;

import java.util.List;

import pe.edu.idat.apprestmvvm.model.Album;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AlbumInterface {
    @GET("albums")
    public Call<List<Album>> getAlbums();

}
