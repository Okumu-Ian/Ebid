package adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import comd.example.thearchitect.e_bid.ProductDetails;
import comd.example.thearchitect.e_bid.R;
import models.ProductsModel;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.MyHolder>{

    private List<ProductsModel> productsModelList;
    private Context context;
    private ProductsModel productsModel;
    private Activity activity;

    public ProductsAdapter(List<ProductsModel> productsModelList,Context context,Activity activity)
    {
        this.activity=activity;
        this.productsModelList=productsModelList;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_grid,parent,false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, int position) {
        productsModel = productsModelList.get(position);
        Picasso.get().load(productsModel.getImage_url()).fit().into(holder.product_image);
        holder.overflow_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkMenu(v);
            }
        });
    }



    private void checkMenu(View view)
    {
        PopupMenu popupMenu = new PopupMenu(activity,view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.item_menu,popupMenu.getMenu());
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
               int x = item.getItemId();
               switch (x)
               {
                   case R.id.action_not_interested:
                       Toast.makeText(context, ""+item.getTitle()+" coming soon", Toast.LENGTH_SHORT).show();
                       break;
                   case R.id.action_show_details:
                       activity.startActivity(new Intent(activity, ProductDetails.class));
                       break;
                   default:
                       break;
               }
                return true;
            }
        });
    }


    @Override
    public int getItemCount() {
        return productsModelList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder
    {
        private TextView product_name,product_price,product_timer;
        private ImageView product_image,overflow_menu;

        public MyHolder(View itemView) {
            super(itemView);

            product_name = itemView.findViewById(R.id.txt_product_name);
            product_price = itemView.findViewById(R.id.txt_product_price);

            product_image = itemView.findViewById(R.id.img_items);
            overflow_menu = itemView.findViewById(R.id.img_overflow);

        }
    }

}
