package com.rohitksingh.wordapp.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.rohitksingh.wordapp.R;
import com.rohitksingh.wordapp.callbacks.ListItemClickListener;
import com.rohitksingh.wordapp.models.Word;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder>{

    private static final String TAG = "WordListAdapter";

    private LayoutInflater inflater;
    private List<Word> allWords;
    private ListItemClickListener itemClickListener;

    public WordListAdapter(Context context){
        inflater = LayoutInflater.from(context);
        itemClickListener = (ListItemClickListener)context;
    }


    /***********************************************************************************************
     *                              Adapter methods
     **********************************************************************************************/
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
    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private final TextView wordTextView;
        private Button deleteButton;
        private Button editButton;

        WordViewHolder(@NonNull View itemView) {
            super(itemView);
            wordTextView = itemView.findViewById(R.id.word);
            deleteButton = itemView.findViewById(R.id.delete);
            editButton = itemView.findViewById(R.id.edit);
            deleteButton.setOnClickListener(this);
            editButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            int index = getAdapterPosition();
            Word word = allWords.get(index);

            switch (view.getId()){

                case R.id.delete:
                    itemClickListener.deleteItem(index, word);
                    break;

                case R.id.edit:
                    itemClickListener.editItem(index, word);
                    break;

                default:
                    break;
            }

        }

        public void bind(Word word){
            wordTextView.setText(word.getWord());
        }

    }

}
