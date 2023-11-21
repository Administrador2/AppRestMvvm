package pe.edu.idat.apprestmvvm.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pe.edu.idat.apprestmvvm.databinding.ItemAlbumBinding;
import pe.edu.idat.apprestmvvm.model.Album;

public class AlbumAdapter
        extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {
    private List<Album> albumList = new ArrayList<>();
    @NonNull
    @Override
    public AlbumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup
                                                                  parent,
                                                      int viewType) {
        return new ViewHolder(
                ItemAlbumBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent, false
                )
        );
    }
    @Override
    public void onBindViewHolder(@NonNull AlbumAdapter.ViewHolder holder, int position) {
        final Album album = albumList.get(position);
        holder.binding.tvid.setText(album.getId().toString());
        holder.binding.tvtitle.setText(album.getTitle());
    }
    @Override
    public int getItemCount() {
        return albumList.size();
    }
    public void setAlbumList(List<Album> list){
        albumList.addAll(list);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemAlbumBinding binding;
        public ViewHolder(@NonNull ItemAlbumBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
