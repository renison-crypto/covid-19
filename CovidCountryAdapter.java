package com.example.movies40.ui.country;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.movies40.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

public class CovidCountryAdapter extends RecyclerView.Adapter<CovidCountryAdapter.ViewHolder> implements Filterable {

  private   List<CovidCountry> covidCountries;
  private   List<CovidCountry> covidCountriesFull;

    public CovidCountryAdapter(List<CovidCountry> covidCountries, FragmentActivity activity){
        this.covidCountries = covidCountries;
        covidCountriesFull = new ArrayList<>(covidCountries);

    }
    @NonNull
    @Override
    public CovidCountryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_covid_country, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CovidCountryAdapter.ViewHolder holder, int position) {
        CovidCountry covidCountry = covidCountries.get(position);
        holder.tvtotalCases.setText(covidCountry.getmCases());
        holder.tvCountryName.setText(covidCountry.getmCovidCountry());
    }

    @Override
    public int getItemCount() {
        return covidCountries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvtotalCases, tvCountryName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvtotalCases = itemView.findViewById(R.id.tvTotalCases);
            tvCountryName = itemView.findViewById(R.id.tvCountryName);

        }
    }

    @Override
    public Filter getFilter() {
        return covidCountriesFilter;
    }

    private Filter covidCountriesFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<CovidCountry> filteredCovidCountry = new ArrayList<>();
            if(constraint == null || constraint.length() == 0){
                filteredCovidCountry.addAll(covidCountriesFull);
            }
            else{
                String filterPattern = constraint.toString().toLowerCase().trim();

                for(CovidCountry itemCovidCountry:covidCountriesFull){
                    if(itemCovidCountry.getmCovidCountry().toLowerCase().contains(filterPattern)){
                        filteredCovidCountry.add(itemCovidCountry);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredCovidCountry;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            covidCountries.clear();
            covidCountriesFull.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}
