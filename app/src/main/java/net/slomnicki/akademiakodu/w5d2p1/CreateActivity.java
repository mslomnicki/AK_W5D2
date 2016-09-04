package net.slomnicki.akademiakodu.w5d2p1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import net.slomnicki.akademiakodu.w5d2p1.data.TodoDatabase;
import net.slomnicki.akademiakodu.w5d2p1.model.TodoItem;

public class CreateActivity extends EditActivity {

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, CreateActivity.class));
    }

    @Override
    protected TodoItem getItem() {
        return new TodoItem();
    }

    @Override
    protected boolean validateInput() {
        return true;
    }

    @Override
    protected void saveItem(TodoItem item) {
        TodoDatabase.add(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean b = super.onCreateOptionsMenu(menu);
        menu.removeItem(R.id.delete_item);
        return b;
    }
}
