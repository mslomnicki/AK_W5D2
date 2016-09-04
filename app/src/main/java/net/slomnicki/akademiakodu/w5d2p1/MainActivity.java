package net.slomnicki.akademiakodu.w5d2p1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import net.slomnicki.akademiakodu.w5d2p1.data.TodoDatabase;
import net.slomnicki.akademiakodu.w5d2p1.model.TodoItem;

public class MainActivity extends AppCompatActivity implements TodoItemAdapter.OnTodoItemClick {
    private RecyclerView mList;
    private TodoItemAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Lista zadań");
        mList = (RecyclerView) findViewById(R.id.list);
        // Stage 1 - ustawienie layoutu - LinearLayoutManager(V/H)/GridLayoutManager
        mList.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new TodoItemAdapter(TodoDatabase.getItems());
        mAdapter.setClickListener(this);
        mList.setAdapter(mAdapter);
    }

    @Override
    public void onClick(int position, TodoItem element) {
        EditActivity.startActivity(this, position);
    }

    @Override
    protected void onResume() {
        mAdapter.notifyDataSetChanged();
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add_item)
            CreateActivity.startActivity(this);
        return super.onOptionsItemSelected(item);
    }
}
