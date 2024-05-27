package com.example.meallog;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FloatingActionButton fabAddPost;
    private PostAdapter postAdapter;
    private List<Post> posts;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerViewItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        posts = generateDummyPosts(); // 가상 데이터 생성
        postAdapter = new PostAdapter(posts);
        recyclerView.setAdapter(postAdapter);

        // Initialize FloatingActionButton
        fabAddPost = findViewById(R.id.fabAddPost);
        fabAddPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "새 게시물 추가", Toast.LENGTH_SHORT).show();
                // 여기서 새 게시물 추가 로직을 구현할 수 있습니다.
            }
        });
    }

    // Dummy data generator
    private List<Post> generateDummyPosts() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("제목 1", "작성자 A"));
        posts.add(new Post("제목 2", "작성자 B"));
        // 추가 데이터 생성
        return posts;
    }

    // Simple Post class
    class Post {
        private String title;
        private String author;

        public Post(String title, String author) {
            this.title = title;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }
    }
}
