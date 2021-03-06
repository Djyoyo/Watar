package com.watar.soft.watar.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.watar.soft.watar.Adapter.DownlodeViewAdapter;
import com.watar.soft.watar.Adapter.FavoritesViewAdapter;
import com.watar.soft.watar.Adapter.PlaylistViewAdapter;
import com.watar.soft.watar.R;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class MyLibraryFragment extends Fragment {


    RecyclerView recyclerView,recyclerview2,recyclerview3;
    ArrayList<String> Number;
    RecyclerView.LayoutManager RecyclerViewLayoutManager,RecyclerViewLayoutManager2,RecyclerViewLayoutManager3;
    LinearLayoutManager HorizontalLayout,HorizontalLayout2,HorizontalLayout3 ;
    View ChildView ,ChildView2,ChildView3;
    int RecyclerViewItemPosition,RecyclerViewItemPosition2 ,RecyclerViewItemPosition3;
    FavoritesViewAdapter RecyclerViewHorizontalAdapter;
    DownlodeViewAdapter RecyclerViewHorizontalAdapter2;
    PlaylistViewAdapter RecyclerViewHorizontalAdapter3;
    private Context context;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static MyLibraryFragment newInstance(int index) {
        MyLibraryFragment f = new MyLibraryFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);
        return f;
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_library, container, false);
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getContext());
        String lang = settings.getString("LANG", "");
        if( lang.equals("ar"))
        {
            view.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        }
        else
        {
            view.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        }this.context = getActivity();

        ButterKnife.bind((Object) this, view);
        click(view);

       /* initRecyclerView();
       initRecyclerView2();
       initRecyclerView3();*/
//        initRecyclerView4();
        return view;
    }




    public void click(View v) {
        recyclerView = v.findViewById(R.id.recyclerview1);
        recyclerview2 = v.findViewById(R.id.recyclerview2);
        recyclerview3 = v.findViewById(R.id.recyclerview3);
//        recyclerview4 = v.findViewById(R.id.recyclerview4);

    }


    public void initRecyclerView() {
        RecyclerViewLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(RecyclerViewLayoutManager);
        // Adding items to RecyclerView.
        AddItemsToRecyclerViewArrayList();
        RecyclerViewHorizontalAdapter = new FavoritesViewAdapter(Number);
        HorizontalLayout = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(HorizontalLayout);
        recyclerView.setAdapter(RecyclerViewHorizontalAdapter);
        // Adding on item click listener to RecyclerView.
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
                @Override public boolean onSingleTapUp(MotionEvent motionEvent) {

                    return true;
                }
            });
            @Override
            public boolean onInterceptTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {
                ChildView = Recyclerview.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                if(ChildView != null && gestureDetector.onTouchEvent(motionEvent)) {
                    //Getting clicked value.
                    RecyclerViewItemPosition = Recyclerview.getChildAdapterPosition(ChildView);
                    // Showing clicked item value on screen using toast message.
                    Toast.makeText(getContext(), Number.get(RecyclerViewItemPosition), Toast.LENGTH_LONG).show();
//                    Fragment fragment2= new WaterFragment();
//                    Fragment fragment= new WaterclickFragment();
//                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                    transaction.replace(R.id.mainfragments, fragment); // fragment container id in first parameter is the  container(Main layout id) of Activity
//                    transaction.addToBackStack(null);  // this will manage backstack
//                    transaction.remove(fragment2);
//                    transaction.commit();
                    // manager.popBackStack();

                }
                return false;
            }
            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
            }
            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }
        });
    }

    public void initRecyclerView2() {
        RecyclerViewLayoutManager2 = new LinearLayoutManager(getContext());
        recyclerview2.setLayoutManager(RecyclerViewLayoutManager2);
        // Adding items to RecyclerView.
        AddItemsToRecyclerViewArrayList();
        RecyclerViewHorizontalAdapter2 = new DownlodeViewAdapter(Number);
        HorizontalLayout2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerview2.setLayoutManager(HorizontalLayout2);
        recyclerview2.setAdapter(RecyclerViewHorizontalAdapter2);
        // Adding on item click listener to RecyclerView.
        recyclerview2.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
                @Override public boolean onSingleTapUp(MotionEvent motionEvent) {

                    return true;
                }
            });
            @Override
            public boolean onInterceptTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {
                ChildView2 = Recyclerview.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                if(ChildView2 != null && gestureDetector.onTouchEvent(motionEvent)) {
                    //Getting clicked value.
                    RecyclerViewItemPosition2 = Recyclerview.getChildAdapterPosition(ChildView2);
                    // Showing clicked item value on screen using toast message.
                    Toast.makeText(getContext(), Number.get(RecyclerViewItemPosition2), Toast.LENGTH_LONG).show();
                }
                return false;
            }
            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
            }
            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }
        });
    }


    public void initRecyclerView3() {
        RecyclerViewLayoutManager3 = new LinearLayoutManager(getContext());
        recyclerview3.setLayoutManager(RecyclerViewLayoutManager3);
        // Adding items to RecyclerView.
        AddItemsToRecyclerViewArrayList();
        RecyclerViewHorizontalAdapter3 = new PlaylistViewAdapter(Number);
        HorizontalLayout3 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerview3.setLayoutManager(HorizontalLayout3);
        recyclerview3.setAdapter(RecyclerViewHorizontalAdapter3);
        // Adding on item click listener to RecyclerView.
        recyclerview3.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            GestureDetector gestureDetectors = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
                @Override public boolean onSingleTapUp(MotionEvent motionEvent) {

                    return true;
                }
            });
            @Override
            public boolean onInterceptTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {
                ChildView3 = Recyclerview.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                if(ChildView3 != null && gestureDetectors.onTouchEvent(motionEvent)) {
                    //Getting clicked value.
                    RecyclerViewItemPosition3 = Recyclerview.getChildAdapterPosition(ChildView3);
                    // Showing clicked item value on screen using toast message.
                    Toast.makeText(getContext(), Number.get(RecyclerViewItemPosition3), Toast.LENGTH_LONG).show();
                }
                return false;
            }
            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
            }
            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }
        });

    }














    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void onDetach() {
        super.onDetach();
    }


    public void AddItemsToRecyclerViewArrayList(){

        Number = new ArrayList<>();
        Number.add("Song name... ");
        Number.add("Song name...");
        Number.add("Song name...");
        Number.add("Song name...");
        Number.add("FIVE");
        Number.add("SIX");
        Number.add("SEVEN");
        Number.add("EIGHT");
        Number.add("NINE");
        Number.add("TEN");

    }


}
