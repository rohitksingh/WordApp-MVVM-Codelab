package com.rohitksingh.wordapp.views.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rohitksingh.wordapp.R;
import com.rohitksingh.wordapp.callbacks.ListItemClickListener;
import com.rohitksingh.wordapp.databinding.ItemWordListBinding;
import com.rohitksingh.wordapp.models.Word;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder>{

    private static final String TAG = "WordListAdapter";

    private List<Word> allWords;
    private ListItemClickListener itemClickListener;

    public WordListAdapter(Context context){
        itemClickListener = (ListItemClickListener)context;
    }


    /***********************************************************************************************
     *                              Adapter methods
     **********************************************************************************************/
    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemWordListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_word_list, parent, false);

        return new WordViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        holder.bind(allWords.get(position), position, itemClickListener);
    }

    @Override
    public int getItemCount() {
        return allWords!=null ? allWords.size() : 0;
    }

    /***********************************************************************************************
     *                              Public helper methods
     **********************************************************************************************/
    public void setAllWords(List<Word> allWords){
        this.allWords = allWords;
        notifyDataSetChanged();
    }


    /***********************************************************************************************
     *                              Viewholder class
     **********************************************************************************************/
    class WordViewHolder extends RecyclerView.ViewHolder {

        ItemWordListBinding binding;

        WordViewHolder(@NonNull ItemWordListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Word word, int position,  ListItemClickListener itemClickListener){

            binding.setWord(word);
            binding.setPosition(position);
            binding.setItemClickListener(itemClickListener);
            Log.d(TAG, "bind: "+word.toString());

        }

    }

}
