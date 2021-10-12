package com.example.listazakupow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class ZakupyAdapter
        extends RecyclerView.Adapter
        <ZakupyAdapter.ProduktViewHolder> {
    private LayoutInflater inflater;
    private LinkedList<String> listaProduktow ;

    public ZakupyAdapter(Context context,
                         ListaProduktow listaProduktowObiekt) {
        inflater = LayoutInflater.from(context);
        this.listaProduktow =
                listaProduktowObiekt.listaProduktow;
    }

    //create class ProduktViewHelder
    //implements method - wybrane wszystkie
    @NonNull
    @Override
    public ProduktViewHolder onCreateViewHolder
    (@NonNull ViewGroup parent, int viewType) {
        //wywoływana przez RecyclerView
        //w celu utworzenia nowego obiektu
        //przypisuje odpowiedni widok
        //ale nie wypełnia widoku danymi
        View itemView = inflater
                .inflate(R.layout.item_produkt,
                        parent,
                        false);

        return new ProduktViewHolder(itemView,ZakupyAdapter.this);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ProduktViewHolder holder,
            int position) {
        //metoda wywoływana przez
        // RecyclerView w celu wypełnienia danymi widoku
        holder.productTextView
                .setText(listaProduktow
                        .get(position));
    }

    @Override
    public int getItemCount() {
        //zwraca liczbę elementów w całej liście
        return listaProduktow.size();
    }

    public class ProduktViewHolder
            extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        //create constructor mathing super
        //generowanie widoku pojedynczego elementu listy
        private TextView productTextView;
        ZakupyAdapter zakupyAdapter;
        public ProduktViewHolder(@NonNull View itemView,
                                 ZakupyAdapter adapter) {
            super(itemView);
            productTextView = itemView.findViewById(R.id.textView);
            this.zakupyAdapter = adapter;
        }

        @Override
        public void onClick(View view) {
            int indeksListy = getLayoutPosition();
            String produkt = listaProduktow.get(indeksListy);

        }
    }
}
