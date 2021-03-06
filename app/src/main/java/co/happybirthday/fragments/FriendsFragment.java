package co.happybirthday.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import co.happybirthday.Birthday;
import co.happybirthday.BirthdayDetails;
import co.happybirthday.Common;
import co.happybirthday.R;

import co.happybirthday.BirthdayRepo;


public class FriendsFragment extends Fragment implements OnItemClickListener {
    ListView listViewAll;
    MyBaseAdapter birthDayAdapter;
    ArrayList<Birthday> birthdayList;
    public FriendsFragment() {
        // Required empty public constructor
        Log.e("FriendsFragment"," =>");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.e("FriendsFragment", " onCreate=>");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       //Log.e("FriendsFragment", " onCreateView=>");
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_all,
                container, false);
        Common.loadAd(view);
        BirthdayRepo birthdayRepo = new BirthdayRepo(getActivity());

        birthdayList= new ArrayList<Birthday>();
        birthdayList= birthdayRepo.getCategoryBirthDay(Birthday.friends);
        listViewAll=(ListView) view.findViewById(R.id.listViewAll);
        birthDayAdapter= new MyBaseAdapter(getActivity(), birthdayList);
        listViewAll.setAdapter(birthDayAdapter);
        listViewAll.setOnItemClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }
    public void onItemClick(AdapterView<?> arg0, View view, int arg2, long arg3) {
        int birthday_id = birthdayList.get(arg2).birthday_ID;
        Intent iDetails= new Intent(getActivity(), BirthdayDetails.class);
        iDetails.putExtra(Birthday.KEY_ID,birthday_id);
        startActivity(iDetails);
    }
    protected void showToast(String product) {
        Toast.makeText(getActivity(), product, Toast.LENGTH_SHORT).show();
        // TODO Auto-generated method stub

    }
    }

