package pe.edu.idat.apprestmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import java.util.List;

import pe.edu.idat.apprestmvvm.R;
import pe.edu.idat.apprestmvvm.databinding.ActivityMainBinding;
import pe.edu.idat.apprestmvvm.model.Album;
import pe.edu.idat.apprestmvvm.view.adapter.AlbumAdapter;
import pe.edu.idat.apprestmvvm.viewmodel.AlbumViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AlbumViewModel albumViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        albumViewModel = new ViewModelProvider(this)
                .get(AlbumViewModel.class);
        albumViewModel.getAlbum();
        AlbumAdapter adapter = new AlbumAdapter();
        binding.rvalbum.setLayoutManager(
                new LinearLayoutManager(this)
        );
        binding.rvalbum.setAdapter(adapter);

        albumViewModel.listMutableLiveData.observe(this,
                new Observer<List<Album>>() {
                    @Override
                    public void onChanged(List<Album> albums) {
                        adapter.setAlbumList(albums);
                    }
                });
    }
}