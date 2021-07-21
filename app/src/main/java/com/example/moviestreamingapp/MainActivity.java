package com.example.moviestreamingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import com.example.moviestreamingapp.adapter.BannerMoviesPagerAdapter;
import com.example.moviestreamingapp.adapter.MainRecyclerAdapter;
import com.example.moviestreamingapp.models.AllCategory;
import com.example.moviestreamingapp.models.BannerMovies;
import com.example.moviestreamingapp.models.CategoryItem;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    BannerMoviesPagerAdapter bannerMoviesPagerAdapter;
    TabLayout indicatorTab,categoryTab;
    ViewPager bannerMovieViewPager;

    List<BannerMovies> homeBannerList;
    List<BannerMovies> showBannerList;
    List<BannerMovies> moviesBannerList;
    List<BannerMovies> kidsBannerList;

    MainRecyclerAdapter mainRecyclerAdapter;
    RecyclerView mainRecycle;
    List<AllCategory> allCategoryList;

    AppBarLayout appBarLayout;
    NestedScrollView nestedScrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        indicatorTab = findViewById(R.id.tab_indicator);
        categoryTab = findViewById(R.id.categoryTab);
        mainRecycle = findViewById(R.id.recyclerView);

        nestedScrollView = findViewById(R.id.nested_scroll);
        appBarLayout  = findViewById(R.id.appbar);

        homeBannerList = new ArrayList<>();
        homeBannerList.add(new BannerMovies(1,"Aksiyon","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/48f82216cce56ed6dd38359e66770d250661ff29a68961f8235bd9290f3c5e82._UR1920,1080_RI_SX356_FMwebp_.jpg" ,"https://www.youtube.com/watch?v=El-3UfKqSTc&ab_channel=Mehmet%C3%96zer"));
        homeBannerList.add(new BannerMovies(2,"Mission: Impossible - Fallout","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/bee521d5e5c8aacf78c15b3359aef058b9103f1e81744fc0d6ab51158d0d107a._UR1920,1080_RI_SX356_FMwebp_.jpg","https://www.youtube.com/watch?v=El-3UfKqSTc&ab_channel=Mehmet%C3%96zer"));
        homeBannerList.add(new BannerMovies(3,"Logan (2017)","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/ff3baae249aceb99fde444582ca003dfd4c6d5fadccc68ee4f51b457013d3f25._UR1920,1080_RI_SX356_FMwebp_.jpg","https://www.youtube.com/watch?v=El-3UfKqSTc&ab_channel=Mehmet%C3%96zer"));
        homeBannerList.add(new BannerMovies(4,"Inglourious Basterds (Soysuzlar Çetesi, 2009)","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/50a30be22954e2c661d9cb9a995e9786b55df5f270ebe73da50545523cef0108._UR1920,1080_RI_SX356_FMwebp_.jpg","https://www.youtube.com/watch?v=El-3UfKqSTc&ab_channel=Mehmet%C3%96zer"));
        homeBannerList.add(new BannerMovies(5,"Baby Driver (2017)","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/e9ea704b7bf4aa40e95d133eb9db210cdbbf63a8e8b4b51478c486524a456c08._UR1920,1080_RI_SX356_FMwebp_.jpg","https://www.youtube.com/watch?v=El-3UfKqSTc&ab_channel=Mehmet%C3%96zer"));

        showBannerList = new ArrayList<>();
        showBannerList.add(new BannerMovies(1,"Aksiyon","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/48f82216cce56ed6dd38359e66770d250661ff29a68961f8235bd9290f3c5e82._UR1920,1080_RI_SX356_FMwebp_.jpg" ,"https://www.youtube.com/watch?v=El-3UfKqSTc&ab_channel=Mehmet%C3%96zer"));
        showBannerList.add(new BannerMovies(2,"Mission: Impossible - Fallout","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/bee521d5e5c8aacf78c15b3359aef058b9103f1e81744fc0d6ab51158d0d107a._UR1920,1080_RI_SX356_FMwebp_.jpg","https://www.youtube.com/watch?v=El-3UfKqSTc&ab_channel=Mehmet%C3%96zer"));
        showBannerList.add(new BannerMovies(3,"Logan (2017)","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/ff3baae249aceb99fde444582ca003dfd4c6d5fadccc68ee4f51b457013d3f25._UR1920,1080_RI_SX356_FMwebp_.jpg","https://www.youtube.com/watch?v=El-3UfKqSTc&ab_channel=Mehmet%C3%96zer"));
        showBannerList.add(new BannerMovies(4,"Inglourious Basterds (Soysuzlar Çetesi, 2009)","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/50a30be22954e2c661d9cb9a995e9786b55df5f270ebe73da50545523cef0108._UR1920,1080_RI_SX356_FMwebp_.jpg","https://www.youtube.com/watch?v=El-3UfKqSTc&ab_channel=Mehmet%C3%96zer"));
        showBannerList.add(new BannerMovies(5,"Baby Driver (2017)","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/e9ea704b7bf4aa40e95d133eb9db210cdbbf63a8e8b4b51478c486524a456c08._UR1920,1080_RI_SX356_FMwebp_.jpg","https://www.youtube.com/watch?v=El-3UfKqSTc&ab_channel=Mehmet%C3%96zer"));

        moviesBannerList = new ArrayList<>();
        moviesBannerList.add(new BannerMovies(1,"Aksiyon","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/d9f062d3a8344a890dc491b50a55e74cf02cfdc7cc09d874e76498ec92ac49b2._UR1920,1080_RI_SX356_FMwebp_.jpg" ,"https://www.youtube.com/watch?v=El-3UfKqSTc&ab_channel=Mehmet%C3%96zer"));
        moviesBannerList.add(new BannerMovies(2,"Family Man","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/f447f7b124e6c785d64c0772f46841159b8f58ab9fdf3a6489bd7fbdf2c37a51._UR1920,1080_RI_SX356_FMwebp_.jpg","https://www.youtube.com/watch?v=El-3UfKqSTc&ab_channel=Mehmet%C3%96zer"));
        moviesBannerList.add(new BannerMovies(3,"Bosch","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/848076090b3278e3229d652949d0d5b018d74927a1d487f09d38b50ea5618cf1._UR1920,1080_RI_SX356_FMwebp_.jpg","https://www.youtube.com/watch?v=El-3UfKqSTc&ab_channel=Mehmet%C3%96zer"));

        kidsBannerList = new ArrayList<>();
        kidsBannerList.add(new BannerMovies(1,"Aksiyon","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/a3c9a288e58ef94c928d8742effeaa4051ef6f77b81e0b1ef51af1cb52a8c9bd._UR1920,1080_RI_SX356_FMwebp_.jpg" ,"https://www.youtube.com/watch?v=El-3UfKqSTc&ab_channel=Mehmet%C3%96zer"));
        kidsBannerList.add(new BannerMovies(2,"Mission: Impossible - Fallout","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/0d17927e39390396db441f76f925594782c835f9b1281372a6c773bec69c7d29._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        kidsBannerList.add(new BannerMovies(3,"Logan (2017)","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/c9c2033bdb5fcb8699e44b55671feab160e809eeda74a3e71d93bb3e57e35228._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        kidsBannerList.add(new BannerMovies(4,"Inglourious Basterds (Soysuzlar Çetesi, 2009)","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/1c7e4f4334e630a80fc85aee7b7e3dd72bcc8ab877fd5d803377c2e4a2d1e906._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        kidsBannerList.add(new BannerMovies(5,"Baby Driver (2017)","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/f2b682fc754b218a04b75c2f600fc11bc4eafced2582e748968eac57a6cb717d._UR1920,1080_RI_SX356_FMwebp_.jpg",""));


        categoryTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){

                    case 0:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(homeBannerList);

                        return;
                    case 1:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(showBannerList);

                        return;
                    case 2:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(moviesBannerList);


                        return;
                    case 3:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(kidsBannerList);
                        return;
                    default:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(homeBannerList);

                     }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        List<CategoryItem> homeCatListItem1 = new ArrayList<>();
        homeCatListItem1.add(new CategoryItem(1,"The Office","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/c1f99e589f703b936ca9d13650765ec29941cf49cefd5dcbbf17b1b878636833._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        homeCatListItem1.add(new CategoryItem(2,"Fear The Walking Dead","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/2b69847ba61920b5867b9a9691059fc89dc3c89a9dc62e3bd4384350acbdc9c3._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        homeCatListItem1.add(new CategoryItem(3,"Kung Fu Panda","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/a3c9a288e58ef94c928d8742effeaa4051ef6f77b81e0b1ef51af1cb52a8c9bd._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        homeCatListItem1.add(new CategoryItem(4,"GSI:","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/18b7465fcf6427d29daca8175e469afbe27ba7ac9121f688864d23feda0fb604._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        homeCatListItem1.add(new CategoryItem(5,"SOLOS","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/bee521d5e5c8aacf78c15b3359aef058b9103f1e81744fc0d6ab51158d0d107a._UR1920,1080_RI_SX356_FMwebp_.jpg",""));

        List<CategoryItem> homeCatListItem2 = new ArrayList<>();
        homeCatListItem2.add(new CategoryItem(1,"BONES","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/71f3ec98d6cb5cfcbafc67effdd0be5b9291450f929acf2016329bd88d264dc0._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        homeCatListItem2.add(new CategoryItem(2,"This is us","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/f41c6e3e13a2da27a12769d806866d1b0f192cee66be4cdb3aa6763f24ec3b5b._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        homeCatListItem2.add(new CategoryItem(3,"Hanna","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/a76b251ae95819f2716dfce7fc15168a9435f7af49d336f363eb54ffb7253bd2._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        homeCatListItem2.add(new CategoryItem(4,"Heroes","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/d970afe412627b86db8784c8f75793b88e048b6fb8785cff83a121479e68fd58._UR1920,1080_RI_SX356_FMwebp_.jpg",""));

        List<CategoryItem> homeCatListItem3 = new ArrayList<>();
        homeCatListItem3.add(new CategoryItem(1,"The man in the high castle","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/0feaaa399d820f524fe92d11639c04f682e2a4c1ac91509dabe91f134022bba9._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        homeCatListItem3.add(new CategoryItem(2,"The Purge","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/571c61f4cd781f602b1cec95794121b5b3aff51a2975d1aa01fed32aedbd55f7._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        homeCatListItem3.add(new CategoryItem(3,"Mr. Robot","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/84b24359960c53fc83af12127ea67e202489750fc7d0ec3fe7306ef612b2972f._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        homeCatListItem3.add(new CategoryItem(4,"Panic","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/eb741f855c5f2e56764fb840cf56f4d41c522a77a0e1dcfa912528103e90847d._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        homeCatListItem3.add(new CategoryItem(5,"Hunters","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/bf1417ad8a63fda2e912b7dc7a1f7dec604307eb65e075d7d7fbbe4cfb609921._UR1920,1080_RI_SX356_FMwebp_.jpg",""));

        List<CategoryItem> homeCatListItem4 = new ArrayList<>();
        homeCatListItem4.add(new CategoryItem(1,"Aksiyon","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/a3c9a288e58ef94c928d8742effeaa4051ef6f77b81e0b1ef51af1cb52a8c9bd._UR1920,1080_RI_SX356_FMwebp_.jpg" ,""));
        homeCatListItem4.add(new CategoryItem(2,"Mission: Impossible - Fallout","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/0d17927e39390396db441f76f925594782c835f9b1281372a6c773bec69c7d29._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        homeCatListItem4.add(new CategoryItem(3,"Logan (2017)","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/c9c2033bdb5fcb8699e44b55671feab160e809eeda74a3e71d93bb3e57e35228._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        homeCatListItem4.add(new CategoryItem(4,"Inglourious Basterds (Soysuzlar Çetesi, 2009)","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/1c7e4f4334e630a80fc85aee7b7e3dd72bcc8ab877fd5d803377c2e4a2d1e906._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        homeCatListItem4.add(new CategoryItem(5,"Baby Driver (2017)","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/f2b682fc754b218a04b75c2f600fc11bc4eafced2582e748968eac57a6cb717d._UR1920,1080_RI_SX356_FMwebp_.jpg",""));



        allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory(1,"Alt yazılı TV içerikleri",homeCatListItem1));
        allCategoryList.add(new AllCategory(2,"En İyi TV İçerikleri",homeCatListItem2));
        allCategoryList.add(new AllCategory(3,"Gerilim TV İçerikleri",homeCatListItem3));
        allCategoryList.add(new AllCategory(3,"Çocuk ve Aile Filmleri",homeCatListItem4));

        setMainRecycle(allCategoryList);
    }

    public void setBannerMoviesPagerAdapter(List<BannerMovies> bannerMoviesList) {

        bannerMovieViewPager = findViewById(R.id.banner_view);
        bannerMoviesPagerAdapter = new BannerMoviesPagerAdapter(this,bannerMoviesList);
        bannerMovieViewPager.setAdapter(bannerMoviesPagerAdapter);
        indicatorTab.setupWithViewPager(bannerMovieViewPager);

        Timer sliderTimer = new Timer();
        sliderTimer.scheduleAtFixedRate(new AutoSlider(),4000,6000);
        indicatorTab.setupWithViewPager(bannerMovieViewPager,true);

    }

    class AutoSlider extends TimerTask {


        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(bannerMovieViewPager.getCurrentItem()<homeBannerList.size()-1){

                        bannerMovieViewPager.setCurrentItem(bannerMovieViewPager.getCurrentItem()+1);

                    }
                    else {
                        bannerMovieViewPager.setCurrentItem(0);
                    }
                }

            });
        }
    }
    public  void setMainRecycle(List<AllCategory> allCategoryList){

        mainRecycle = findViewById(R.id.recyclerView);

//        mainRecyclerAdapter = new MainRecyclerAdapter(this,allCategoryList);
//        mainRecycle.setAdapter(mainRecyclerAdapter);
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        mainRecycle.setLayoutManager(layoutManager);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        mainRecycle.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new MainRecyclerAdapter(this,allCategoryList);
        mainRecycle.setAdapter(mainRecyclerAdapter);
    }

    private void setScrollDefaultState(){

        nestedScrollView.fullScroll(View.FOCUS_UP);
        nestedScrollView.scrollTo(0,0);
        appBarLayout.setExpanded(true);

    }

}
