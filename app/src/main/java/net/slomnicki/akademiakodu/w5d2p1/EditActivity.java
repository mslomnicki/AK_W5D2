package net.slomnicki.akademiakodu.w5d2p1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;

import net.slomnicki.akademiakodu.w5d2p1.data.TodoDatabase;
import net.slomnicki.akademiakodu.w5d2p1.model.TodoItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditActivity extends AppCompatActivity {
    public static final String EXTRA_ID = "id";
    @BindView(R.id.title) EditText mTitle;
    @BindView(R.id.done) CheckBox mDone;
    @BindView(R.id.note) EditText mNote;
    private int mPosition;

    public static void startActivity(Context context, int position) {
        Intent intent = new Intent(context, EditActivity.class);
        intent.putExtra(EXTRA_ID, position);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        ButterKnife.bind(this);
        if (!validateInput()) return;
        TodoItem item = getItem();
        mTitle.setText(item.getTitle());
        mDone.setChecked(item.isDone());
        mNote.setText(item.getNote());
    }

    protected TodoItem getItem() {
        return TodoDatabase.getItem(mPosition);
    }

    protected boolean validateInput() {
        mPosition = getIntent().getIntExtra(EXTRA_ID, -1);
        if (mPosition == -1) {
            finish();
            return false;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.save_item:
                String title = mTitle.getText().toString();
                boolean done = mDone.isChecked();
                String note = mNote.getText().toString();
                TodoItem item = new TodoItem(title, done, note);
                saveItem(item);
                finish();
                break;
            case R.id.delete_item:
                TodoDatabase.removeItem(mPosition);
                finish();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected void saveItem(TodoItem item) {
        TodoDatabase.updateItem(mPosition, item);
    }

}
