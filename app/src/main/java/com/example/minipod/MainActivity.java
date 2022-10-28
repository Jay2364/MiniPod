package com.example.minipod;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public GridView gridView;
    ArrayList<String[]> albumName;
    ArrayList<int[]> albumImage;
    ArrayList<int[]> albumSong;

    public String name1[] = {"Blank Space","Delicate","We are never ever Getting Old Together","You Belong with me",
                        "You need to Calm Down","Willow","Wildest Dreams","Love Story","22"};
    public int img1[] = {R.drawable.blank,R.drawable.delicate,R.drawable.never,R.drawable.belong
                        ,R.drawable.calm_down,R.drawable.willow,R.drawable.wildest_dreams,R.drawable.love_story,R.drawable.t_22};
    public int song1[] = {R.raw.blank_space,R.raw.delicate,R.raw.we_are_never_ever_getting_back_together,R.raw.you_belong_with_me,
                            R.raw.you_need_to_calm_down,R.raw.willow,R.raw.love_story,R.raw.wildest_dreams,R.raw.t_22};

    public String name2[] = {"All Too Well","Exile","Champagne Problems","My tears Richochet",
                        "This is me trying","Call it what you want","Ours","Better Man"};
    public int img2[] = {R.drawable.all_too_well,R.drawable.exile,R.drawable.champaign_problems,R.drawable.taylor7,
            R.drawable.taylor2,R.drawable.taylor3,R.drawable.taylor8,R.drawable.taylor6};
    public int song2[] = {R.raw.all_too_well,R.raw.exile,R.raw.champagne,R.raw.richochet,
            R.raw.this_is_me_trying,R.raw.call_it,R.raw.ours,R.raw.better_man};

    public String name3[] = {"Attention","Bad Lair","Closer","Despacito","Girls Like You","Hymm for the Weekend","Night Changes"
            ,"No Lies","Play Date","Rockabye","See You Again","Sunflower","The Nights","Uptown","Waka-Waka","Don't Talk"};
    public int img3[] = {R.drawable.attention,R.drawable.bad_lair,R.drawable.closer,R.drawable.despacito,R.drawable.girls
            ,R.drawable.hymm,R.drawable.night_changes,R.drawable.no_lie,R.drawable.play_date,R.drawable.rockabye
            ,R.drawable.see_you_again,R.drawable.sunflower,R.drawable.the_nights,R.drawable.uptown
            ,R.drawable.waka,R.drawable.dont_talk};
    public int song3[] = {R.raw.attention,R.raw.bad_lair,R.raw.closer,R.raw.despacito,R.raw.girls_like_you
            ,R.raw.hymm_for_the_weekend,R.raw.night_changes,R.raw.no_lie,R.raw.play_date,R.raw.rackabye
            ,R.raw.see_you_again,R.raw.sunflower,R.raw.the_nights,R.raw.uptown_funk,R.raw.waka_waka,R.raw.we_dont_talk_anymore};


    public String name4[] = {"Alone","Arcade","August Dairies","Bella Chao","Cheap thrills","Darum","Faded","Friends","Habibi"
            ,"Halo","High School","Instagram","Into your Arms","Laviating","Let me down Slowly","New rules","Not you Barbie girl"
            ,"On my way","One night in Dubai","Paris","Perfect strangers","Queen of hearts","Run","Safari","Sanctuary","Satan"
            ,"Say my name","Scream my name","se Te Nota","Sorry","Sugar and Brownies","Taki Taki","What makes you Beautiful","Work from Home"
            ,"Your love"};
    public int img4[] = {R.drawable.alone,R.drawable.arcade,R.drawable.august,R.drawable.bella_chao,R.drawable.cheap_thrills
            ,R.drawable.darum,R.drawable.faded,R.drawable.friends,R.drawable.habibi
            ,R.drawable.halo,R.drawable.high_school,R.drawable.instagram,R.drawable.into_your_arms,R.drawable.laviating
            ,R.drawable.let_me_down_slowly,R.drawable.new_rules,R.drawable.not_your_barbie_girl,R.drawable.on_my_way
            ,R.drawable.one_night_in_dubai,R.drawable.paris,R.drawable.perfect_strangers,R.drawable.queen_of_hearts
            ,R.drawable.run,R.drawable.safari,R.drawable.sanctuary,R.drawable.satan,R.drawable.say_my_name
            ,R.drawable.scream_my_name,R.drawable.se_te_nota,R.drawable.sorry,R.drawable.sugar_and_brownies,R.drawable.taki_taki
            ,R.drawable.what_makes_you_beautiful,R.drawable.work_from_home,R.drawable.your_love};
    public int song4[] = {R.raw.alone,R.raw.arcade,R.raw.august_diaries,R.raw.bella_chiao,R.raw.cheap_thrills
            ,R.raw.darum,R.raw.faded,R.raw.friends,R.raw.habibi,R.raw.halo,R.raw.high_school
            ,R.raw.instagram,R.raw.into_your_arms,R.raw.laviating,R.raw.let_me_down_slowly_lofi,R.raw.new_rules,R.raw.not_your_barbie_girl
            ,R.raw.on_my_way,R.raw.one_night_in_dubai,R.raw.paris,R.raw.perfect_strangers,R.raw.queen_of_hearts,R.raw.run
            ,R.raw.safari,R.raw.sanctuary,R.raw.i_dont_believe_in_satan,R.raw.say_my_name,R.raw.scream_my_name,R.raw.se_te_nota
            ,R.raw.sorry,R.raw.sugar_brownies,R.raw.taki_taki,R.raw.what_makes_you_beautiful,R.raw.work_from_home,R.raw.your_love};

    public String name5[] = {"Asvaar","Chaand ne kaho","Garba shuffle","Gori Radha","Halaji tara","Khichdi","Manda lidha Mohi raj"
            ,"Mehendi","Moti verana","Nayan ne bandh rakhina","Pankhire","Radha ne shyam","Radha rani","Teri aankhon mein","Udi Udi Jaay"
            ,"Vagyo re Dhol","Vhalam"};
    public int img5[] = {R.drawable.asvaar,R.drawable.chaand_ne_kaho,R.drawable.garba_shuffle,R.drawable.gori_radha,R.drawable.halaji
            ,R.drawable.khichdi,R.drawable.manda_lidha,R.drawable.mehendi,R.drawable.moti_verana,R.drawable.nayan_ne_bandh
            ,R.drawable.pankhire,R.drawable.radha_ne_shyam,R.drawable.radha_rani,R.drawable.teri_aankhon_mein,R.drawable.udi_udi_jaay
            ,R.drawable.vagyo_re_dhol,R.drawable.vhalam};
    public int song5[] = {R.raw.asvaar,R.raw.chaand_ne_kaho,R.raw.garba_shuffle,R.raw.gori_radha,R.raw.halaji_tara,R.raw.khichdi
            ,R.raw.manda_lidha,R.raw.mehendi,R.raw.moti_verana,R.raw.nayan_ne_bandh,R.raw.pankhire,R.raw.radha_ne_shyam
            ,R.raw.radha_ne_shyam,R.raw.teri_aankhon_mein,R.raw.udi_udi,R.raw.vagyo_re_dhol,R.raw.vhalum};

    public String name6[] = {"Jaane Kaha Mera Jigar Gaya Jii","Pal Pal Dil Ke Pass","Jawan-e-Janeman"};
    public int img6[] = {R.drawable.jane_kaha,R.drawable.pal_pal,R.drawable.jawan_e};
    public int song6[] = {R.raw.jane_kaha,R.raw.pal_pal,R.raw.jawan_e};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Collection of Albums
        gridView = findViewById(R.id.gridView);
        ArrayList<AlbumModel> arrayList = new ArrayList<AlbumModel>();
        arrayList.add(new AlbumModel("Taylor Swift",R.drawable.taylor3));
        arrayList.add(new AlbumModel("Night for One",R.drawable.night1));
        arrayList.add(new AlbumModel("Crossing a Bridge",R.drawable.bridge1));
//        arrayList.add(new AlbumModel("Bed of Roses",R.drawable.calm_down));
        arrayList.add(new AlbumModel("Crazy",R.drawable.crazy2));
        arrayList.add(new AlbumModel("Gujarati",R.drawable.garba1));
        arrayList.add(new AlbumModel("Old",R.drawable.old));
//        arrayList.add(new AlbumModel("A Rare Heartbeat",R.drawable.calm_down));

        AlbumModelAdapter albumModelAdapter = new AlbumModelAdapter(this,arrayList);
        gridView.setAdapter(albumModelAdapter);


        albumName = new ArrayList<>();
        albumImage = new ArrayList<>();
        albumSong = new ArrayList<>();
        albumName.add(name1);
        albumName.add(name2);
        albumName.add(name3);
        albumName.add(name4);
        albumName.add(name5);
        albumName.add(name6);

        albumImage.add(img1);
        albumImage.add(img2);
        albumImage.add(img3);
        albumImage.add(img4);
        albumImage.add(img5);
        albumImage.add(img6);

        albumSong.add(song1);
        albumSong.add(song2);
        albumSong.add(song3);
        albumSong.add(song4);
        albumSong.add(song5);
        albumSong.add(song6);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,FirstAlbum.class);

                intent.putExtra("strings",albumName.get(i));
                intent.putExtra("images",albumImage.get(i));
                // Give arraylist of songs
                intent.putExtra("songs",albumSong.get(i));

                startActivity(intent);
            }
        });

    }
}