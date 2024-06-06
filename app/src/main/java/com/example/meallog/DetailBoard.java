package com.example.meallog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DetailBoard extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    // RecyclerView와 관련된 멤버 변수
    private RecyclerView recyclerView;
    private PostAdapter adapter;
    private ArrayList<Post> postList;

    public DetailBoard() {
        // Required empty public constructor
    }

    public static DetailBoard newInstance(String param1, String param2) {
        DetailBoard fragment = new DetailBoard();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_board, container, false);



        recyclerView = view.findViewById(R.id.recyclerViewItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        postList = new ArrayList<>();
        postList.add(new Post("게시글 제목 1", "작성자 A"));
        postList.add(new Post("게시글 제목 2", "작성자 B"));
        postList.add(new Post("게시글 제목 4", "작성자 C"));
        postList.add(new Post("게시글 제목 5", "작성자 D"));
        postList.add(new Post("게시글 제목 6", "작성자 E"));
        postList.add(new Post("게시글 제목 7", "작성자 F"));
        postList.add(new Post("게시글 제목 8", "작성자 G"));
        postList.add(new Post("게시글 제목 9", "작성자 H"));


        adapter = new PostAdapter(postList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
