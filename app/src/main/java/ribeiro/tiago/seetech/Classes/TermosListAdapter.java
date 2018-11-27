package ribeiro.tiago.seetech.Classes;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ribeiro.tiago.seetech.R;

public class TermosListAdapter extends ArrayAdapter<Termos> {

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;
    ArrayList<Termos> termosArrayList;

    private static class ViewHolder{
        TextView nome;
        TextView desc;
        ImageView img;

        public ViewHolder(View view){
            nome =  view.findViewById(R.id.txtNome);
            desc =  view.findViewById(R.id.txtDesc);
            img =  view.findViewById(R.id.imgList);
        }
    }

    public TermosListAdapter(Context context, int resource, ArrayList<Termos> objects) {
        super(context, resource, objects);
        this.termosArrayList = objects;
        mContext = context;
        mResource = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent){
//        View convertView;
        ViewHolder holder;


        convertView = LayoutInflater.from(mContext).inflate(R.layout.custom_list, parent, false);

        holder = new ViewHolder(convertView);
        convertView.setTag(holder);

        final Termos termosData = getItem(position);

        holder.nome.setText(termosData.getNome());
        holder.desc.setText(termosData.getDescricao());
        holder.img.setImageResource(termosData.getImg());

        // Get the Layout Parameters for ListView Current Item View
        ViewGroup.LayoutParams params = convertView.getLayoutParams();

        // Set the height of the Item View

        convertView.setLayoutParams(params);

        return convertView;
    }

    @Override
    public int getCount() { //count the objects
        return termosArrayList.size(); //return the length of the array
    }

    @Override
    public long getItemId(int position) { //returns the item ID of our objects
        return position; //The ID is the position of the item in the array
    }
}
