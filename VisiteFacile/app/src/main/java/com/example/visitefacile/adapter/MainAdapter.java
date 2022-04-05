package com.example.visitefacile.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.visitefacile.model.MainData;
import com.example.visitefacile.R;
import com.example.visitefacile.Database.RoomDb;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewHolder> {

    private List<MainData> dataList;
    private Activity context;
    private RoomDb database;

    public MainAdapter(List<MainData> dataList, Activity context) {
        this.dataList = dataList;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_main,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
     MainData data = dataList.get(position);
     database = RoomDb.getInstance(context);
     holder.textView.setText(data.getText());
     holder.btEdit.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             MainData d = dataList.get(holder.getAdapterPosition());

             int sID = d.getID();

             String sText = d.getText();

             Dialog dialog = new Dialog(context);

             dialog.setContentView(R.layout.dialog_update);

             int width = WindowManager.LayoutParams.MATCH_PARENT;

             int height = WindowManager.LayoutParams.WRAP_CONTENT;

             dialog.getWindow().setLayout(width,height);

             dialog.show();

             EditText editText = dialog.findViewById(R.id.edit_text);
             Button btUpdate = dialog.findViewById(R.id.bt_update);

             editText.setText(sText);

             btUpdate.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     dialog.dismiss();

                     String uText = editText.getText().toString().trim();

                     database.mainDao().update(sID,uText);

                     dataList.clear();
                     dataList.addAll(database.mainDao().getAll());
                     notifyDataSetChanged();
                 }
             });
         }
     });

     holder.btDelete.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             MainData d = dataList.get(holder.getAdapterPosition());

             database.mainDao().delete(d);

             int position = holder.getAdapterPosition();
             dataList.remove(position);
             notifyItemRemoved(position);
             notifyItemRangeChanged(position, dataList.size());

         }
     });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView btEdit,btDelete;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
            btEdit = itemView.findViewById(R.id.bt_edit);
            btDelete = itemView.findViewById(R.id.bt_delete);

        }
    }
}
