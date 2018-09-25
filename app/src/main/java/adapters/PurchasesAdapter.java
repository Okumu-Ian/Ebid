package adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import comd.example.thearchitect.e_bid.R;
import models.PurchasesModel;

public class PurchasesAdapter extends RecyclerView.Adapter<PurchasesAdapter.PurchasesHolder> {

    public class PurchasesHolder extends RecyclerView.ViewHolder
    {
        private ImageView purchases_imageView;
        private TextView purchases_name,purchases_date,purchases_price,purchases_seller;

        public PurchasesHolder(View itemView) {
            super(itemView);

            purchases_imageView = itemView.findViewById(R.id.img_purchases);
            purchases_name = itemView.findViewById(R.id.txt_purchase_name);
            purchases_date = itemView.findViewById(R.id.txt_purchase_date);
            purchases_price = itemView.findViewById(R.id.txt_purchase_price);
            purchases_seller = itemView.findViewById(R.id.txt_purchase_seller);
        }
    }

    private Context context;
    private PurchasesModel model;
    private List<PurchasesModel> modelList;
    private Activity activity;

    public PurchasesAdapter(List<PurchasesModel> modelList,Context context)
    {
        this.modelList=modelList;
        this.context = context;
    }

    @Override
    public PurchasesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_purchases,parent,false);
        PurchasesHolder holder = new PurchasesHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(PurchasesHolder holder, int position) {

        model = modelList.get(position);
        holder.purchases_name.setText(model.getProduct_names());
        Picasso.get().load(model.getImage_url()).fit().into(holder.purchases_imageView);
        holder.purchases_seller.setText(model.getProduct_seller());
        holder.purchases_price.setText(model.getPrice_bought());
        holder.purchases_date.setText(model.getDate_bought());

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}
