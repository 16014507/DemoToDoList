package sg.edu.rp.c346.id16014507.demotodolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<ToDoItem> toDoList;

    public CustomAdapter(Context context, int resource, ArrayList<ToDoItem> object) {
        super(context, resource, object);

        parent_context = context;
        layout_id = resource;
        toDoList = object;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvToDo = rowView.findViewById(R.id.textViewToDo);
        TextView tvDate = rowView.findViewById(R.id.textViewDate);

        ToDoItem toDo = toDoList.get(position);

        tvToDo.setText(toDo.getTitle());
        tvDate.setText(toDo.toString());

        return rowView;
    }
}
