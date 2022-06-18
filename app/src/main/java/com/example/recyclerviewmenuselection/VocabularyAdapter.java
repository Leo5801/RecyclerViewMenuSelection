package com.example.recyclerviewmenuselection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VocabularyAdapter extends RecyclerView.Adapter<VocabularyAdapter.VocablaryViewHolder> {

    Context context;
    ArrayList<Vocabulary> vocabularyArrayList;
    ArrayList<Vocabulary> cleararrayList=new ArrayList<>();
    MainActivity mainActivity;
    int a=0;
    public VocabularyAdapter(Context context, ArrayList<Vocabulary> vocabularyArrayList) {
        this.context = context;
        this.vocabularyArrayList = vocabularyArrayList;
        mainActivity= (MainActivity) context;
    }

    @NonNull
    @Override
    public VocablaryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.vocabulary_layout,parent,false);
        return new VocablaryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VocablaryViewHolder holder, int position) {

        if (vocabularyArrayList.get(position).isSelected()){
            //holder.checkBox.setChecked(false);
            holder.checkBox.setVisibility(View.VISIBLE);
        } else {
            //holder.checkBox.setChecked(true);
            holder.checkBox.setVisibility(View.GONE);
        }

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.checkBox.isChecked()){
                    a++;
                    cleararrayList.add(vocabularyArrayList.get(position));
                    mainActivity.textView.setText(a +" Selected");
                    if (a>0){
                        mainActivity.imageView.setVisibility(View.VISIBLE);
                    }
                } else {
                    a--;
                    cleararrayList.remove(vocabularyArrayList.get(position));
                    mainActivity.textView.setText(a +" Selected");
                    if (a==0){
                        mainActivity.textView.setText("Vocubulary");
                        mainActivity.imageView.setVisibility(View.INVISIBLE);

                        for (int i = 0; i < vocabularyArrayList.size(); i++) {
                            vocabularyArrayList.get(i).setSelected(false);
                            notifyDataSetChanged();
                        }
                    }
                }

            }
        });

        mainActivity.imageView.setOnClickListener(view -> {
            vocabularyArrayList.removeAll(cleararrayList);
            mainActivity.textView.setText("Vocubulary");
            mainActivity.imageView.setVisibility(View.INVISIBLE);
            cleararrayList.clear();
            a=0;

            for (int i = 0; i < vocabularyArrayList.size(); i++) {
                vocabularyArrayList.get(i).setSelected(false);
                notifyDataSetChanged();
            }
            notifyDataSetChanged();
        });

        holder.textView.setText(vocabularyArrayList.get(position).getEng()+" - "+vocabularyArrayList.get(position).getUzb());

        holder.relativeLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                for (int i = 0; i < vocabularyArrayList.size(); i++) {
                    vocabularyArrayList.get(i).setSelected(true);
                    notifyDataSetChanged();
                }
                mainActivity.textView.setText(0 +" Selected");
//                vocabularyArrayList.get(position).setSelected(!vocabularyArrayList.get(position).isSelected());
//                if (vocabularyArrayList.get(position).isSelected()){
//                    holder.checkBox.setVisibility(View.VISIBLE);
//                }

                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return vocabularyArrayList.size();
    }

    class VocablaryViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        CheckBox checkBox;
        RelativeLayout relativeLayout;
        public VocablaryViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textview1);
            checkBox=itemView.findViewById(R.id.checkbox1);
            relativeLayout=itemView.findViewById(R.id.relativlay1);
        }
    }
}
