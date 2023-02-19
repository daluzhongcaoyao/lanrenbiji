package com.lanrenbiji.dict.word.ui;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 左右滑动recycleView删除当前页
 */
public class WordItemTouchHelper extends ItemTouchHelper.SimpleCallback {
    private WordAdapter mAdapter;
    private RecyclerView mRecyclerView;

    public WordItemTouchHelper(RecyclerView recyclerView, WordAdapter adapter) {
        super(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        mAdapter = adapter;
        mRecyclerView = recyclerView;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                          RecyclerView.ViewHolder target) {
        // do nothing
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        int position = viewHolder.getAbsoluteAdapterPosition();
        mAdapter.removeItem(position);
        mAdapter.notifyItemRemoved(position);

    }

    @Override
    public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
        // set the swipe threshold to 0.5f
        return 0.5f;
    }
}
