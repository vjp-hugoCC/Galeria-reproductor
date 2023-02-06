package com.example.reproductor_musica.ui.main;

import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.reproductor_musica.R;
import com.example.reproductor_musica.databinding.FragmentMainBinding;
import com.example.reproductor_musica.databinding.FragmentVideoBinding;

/**
 * A placeholder fragment containing a simple view.
 */
public class VideoFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private ViewGroup layout;
    private ScrollView scrollView;

    private PageViewModel pageViewModel;
    private FragmentVideoBinding binding;

    public static VideoFragment newInstance() {
        VideoFragment fragment = new VideoFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = FragmentVideoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        layout = (ViewGroup) root.findViewById(R.id.content);
        scrollView = (ScrollView) root.findViewById(R.id.scrollView);
        cargarCanciones(root,inflater);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private void cargarCanciones(View root,LayoutInflater inflater) {
        int id = R.layout.prueba;


        RelativeLayout relativeLayout = (RelativeLayout) inflater.inflate(id, null, false);

        TextView textView = (TextView) relativeLayout.findViewById(R.id.textViewCancion);
        textView.setText("Normal");
        TextView textView2 = (TextView) relativeLayout.findViewById(R.id.textViewAutores);
        textView2.setText("Feid");

        //layout params
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        params.topMargin = 15;
        relativeLayout.setPadding(5, 3, 5, 3);
        relativeLayout.setLayoutParams(params);
        ///////
        layout.addView(relativeLayout);

        //scroll to last element
        //http://stackoverflow.com/questions/6438061/can-i-scroll-a-scrollview-programmatically-in-android
        scrollView.post(new Runnable() {
            public void run() {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
        ///////
    }
}