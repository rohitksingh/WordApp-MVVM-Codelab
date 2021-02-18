package com.rohitksingh.wordapp.callbacks;

import com.rohitksingh.wordapp.models.Word;

public interface ListItemClickListener {

    void deleteItem(int position, Word word);

    void editItem(int position, Word word);
}
