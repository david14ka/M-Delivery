package com.maishapay.delivery.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.maishapay.delivery.R;
import com.maishapay.delivery.ui.main.SectionsPagerAdapter;
import com.synnapps.carouselview.CarouselView;

public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        HomeCarouselView carouselView = new HomeCarouselView(getContext());
        carouselView.show(new int[]{R.drawable.home001, R.drawable.home002, R.drawable.home003}, (CarouselView) root.findViewById(R.id.carouselView));

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getContext(), getChildFragmentManager());

        ViewPager viewPager = root.findViewById(R.id.view_pager);

        viewPager.setAdapter(sectionsPagerAdapter) ;

        return root;

    }

}