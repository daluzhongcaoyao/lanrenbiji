package com.lanrenbiji.dict.dict;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.lanrenbiji.dict.R;
import com.lanrenbiji.dict.databinding.FragmentNotificationsBinding;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebViewFragment extends Fragment {

    private WebViewModel webViewModel;
    private FragmentNotificationsBinding binding;

    @BindView(R.id.webView)
    WebView webView;

    private final String url;

    public  WebViewFragment(){
        this.url = "https://lanrenbiji.cn";
    }

    public WebViewFragment(String url){
        this.url=url;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        webViewModel =
                new ViewModelProvider(this).get(WebViewModel.class);
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ButterKnife.bind(this, root);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

