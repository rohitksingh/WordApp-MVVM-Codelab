package com.rohitksingh.wordapp.callbacks;

import com.rohitksingh.wordapp.models.Word;

public interface ListItemClickListener {

    public void itemClicked(int position, Word word);
}
