package net.slomnicki.akademiakodu.w5d2p1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.slomnicki.akademiakodu.w5d2p1.model.TodoItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TodoItemAdapter extends RecyclerView.Adapter<TodoItemAdapter.TodoItemViewHolder> {
    private List<TodoItem> mItems;
    private OnTodoItemClick mClickListener;

    public void setClickListener(OnTodoItemClick clickListener) {
        this.mClickListener = clickListener;
    }

    public TodoItemAdapter(List<TodoItem> items) {
        this.mItems = items;
    }

    @Override
    public TodoItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_todo, parent, false);
        return new TodoItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TodoItemViewHolder holder, int position) {
        TodoItem item = mItems.get(position);
        holder.mElement = item;
        holder.mPosition = position;
        holder.mTitle.setText(item.getTitle());
        holder.mDone.setText(item.isDone() ? "Zakończone" : "Do zrobienia");
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class TodoItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.title) TextView mTitle;
        @BindView(R.id.done) TextView mDone;
        private TodoItem mElement;
        private int mPosition;

        public TodoItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mClickListener.onClick(mPosition, mElement);
        }
    }

    public interface OnTodoItemClick {
        void onClick(int position, TodoItem element);
    }
}
