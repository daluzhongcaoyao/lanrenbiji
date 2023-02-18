package com.lanrenbiji.dict.ui.word;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.lanrenbiji.dict.R;

import java.util.ArrayList;
import java.util.List;

public class WordFragment extends Fragment {
    private RecyclerView recyclerView;
    private WordAdapter adapter;
    private ViewPager2 viewPager2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_word, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
        adapter = new WordAdapter();
        recyclerView.setAdapter(adapter);
//        viewPager2 = view.findViewById(R.id.viewPager2);
        viewPager2.setAdapter(adapter);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        viewPager2.setOffscreenPageLimit(1);
        viewPager2.setPageTransformer(new ViewPager2.PageTransformer() {
            private static final float MIN_SCALE = 0.5f;
            private static final float MIN_ALPHA = 0.5f;
            private static final float MIN_MOVE_DISTANCE = 300f;

            @Override
            public void transformPage(@NonNull View page, float position) {
                float absPosition = Math.abs(position);
                if (absPosition >= 1) {
                    page.setAlpha(MIN_ALPHA);
                    page.setScaleY(MIN_SCALE);
                } else {
                    float scale = Math.max(MIN_SCALE, 1 - absPosition);
                    page.setScaleY(scale);
                    float alpha = Math.max(MIN_ALPHA, 1 - absPosition);
                    page.setAlpha(alpha);
                    if (absPosition >= 0.5) {
                        int direction = position > 0 ? 1 : -1;
                        int nextPosition = viewPager2.getCurrentItem() + direction;
                        if (nextPosition >= 0 && nextPosition < adapter.getItemCount()) {
                            viewPager2.setCurrentItem(nextPosition);
                        }
                    }
                }
            }
        });
        return view;
    }

    private class WordAdapter extends RecyclerView.Adapter<WordViewHolder> {
        private final List<String> words = new ArrayList<>();

        public WordAdapter() {
            for (int i = 0; i < 10; i++) {
                words.add("Word " + (i + 1));
            }
        }

        @NonNull
        @Override
        public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_word, parent, false);
            return new WordViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull WordViewHolder viewHolder, int position) {
            String word = words.get(position);
            viewHolder.textView.setText(word);
        }

        @Override
        public int getItemCount() {
            return words.size();
        }
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }

        public void bind(String string) {
            textView.setText(string);
        }
    }
}
