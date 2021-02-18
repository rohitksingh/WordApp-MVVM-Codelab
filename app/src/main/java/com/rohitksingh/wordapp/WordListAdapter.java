package com.rohitksingh.wordapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder>{

    private static final String TAG = "WordListAdapter";

    private LayoutInflater inflater;
    private List<Word> allWords;

    WordListAdapter(Context context){
        inflater = LayoutInflater.from(context);
    }

    public void setAllWords(List<Word> allWords){
        this.allWords = allWords;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_word_list, parent, false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        holder.bind(allWords.get(position));
    }

    @Override
    public int getItemCount() {
        return (allWords!=null) ? allWords.size() : 0;
    }

    class WordViewHolder extends RecyclerView.ViewHolder{

        private final TextView wordTextView;

        WordViewHolder(@NonNull View itemView) {
            super(itemView);
            wordTextView = itemView.findViewById(R.id.word);
        }

        public void bind(Word word){
            Log.d(TAG, "bind: "+word.getWord() + (wordTextView==null));
            wordTextView.setText(word.getWord());
        }
    }

}
