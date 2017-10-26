package com.example.home;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.app;
import com.example.R;
import com.example.base.BaseFragment;
import com.example.card.FragmentCard;
import com.example.contact.ContactNumberFragment;
import com.example.contact.FragmentContactEmail;
import com.example.custom.AddShareDialog;
import com.example.custom.CustomDialogOptions;
import com.example.custom.CustomItemClickListener;
import com.example.preview.PreviewFragment;
import com.example.utils.Constants;

public class FragmentHome extends BaseFragment implements CustomDialogOptions.OnButtonClickListener {

    private AdapterSocialMedia mediaAdapter;
    private final ArrayList<String> arrListEmail;

    public static FragmentHome newInstance() {

        return new FragmentHome();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void initView(View view) {
     
        final RecyclerView rvEmail = view.findViewById(R.id.fragment_home_rvEmail);
        rvEmail.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        adapterEmail = new AdapterEmail(getActivity(), arrListEmail(), new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                arrListEmail().remove(position);
                adapterEmail.notifyDataSetChanged();
                if (getArrListEmail().size() <= 0) {
                    tvHintEmail.setVisibility(View.VISIBLE);
                }
            }
        });
        rvEmail.setAdapter(adapterEmail);

        final LinearLayout llMail = _findViewById(R.id.fragment_home_llMail, view);
        tvHintEmail = _findViewById(R.id.fragment_home_tvEmailHint, view);
    }
}
