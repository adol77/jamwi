package com.vogella.android.recyclerview;

import java.util.ArrayList;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
	private ArrayList<String> values;

	// Provide a reference to the views for each data item
	// Complex data items may need more than one view per item, and
	// you provide access to all the views for a data item in a view holder
	public class ViewHolder extends RecyclerView.ViewHolder {
		// each data item is just a string in this case
		public TextView txtHeader;
		public TextView txtFooter;
		public CustomViewStyles drawCanvas;
		public ImageView iconView;
		public ImageView off30;
		public ImageView off40;

		public View layout;

		public ViewHolder(View v) {
			super(v);
			layout = v;
			txtHeader = (TextView) v.findViewById(R.id.firstLine);
			txtFooter = (TextView) v.findViewById(R.id.secondLine);
			drawCanvas = (CustomViewStyles) v.findViewById(R.id.drawView);

			iconView = (ImageView) v.findViewById(R.id.icon);
			off30 = (ImageView) v.findViewById(R.id.off30);
			off30.setImageResource(R.drawable.off30);
			off40 = (ImageView) v.findViewById(R.id.off40);
			off40.setImageResource(R.drawable.off40);
		}
	}

	public void add(int position, String item) {
		values.add(position, item);
		notifyItemInserted(position);
	}

	public void remove(int position) {
		values.remove(position);
		notifyItemRemoved(position);
	}

	// Provide a suitable constructor (depends on the kind of dataset)
	public MyAdapter(ArrayList<String> myDataset) {
		values = myDataset;
	}

	// Create new views (invoked by the layout manager)
	@Override
	public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
			int viewType) {
		// create a new view
		LayoutInflater inflater = LayoutInflater.from(
				parent.getContext());
		View v = 
				inflater.inflate(R.layout.rowlayout, parent, false);
		// set the view's size, margins, paddings and layout parameters
		ViewHolder vh = new ViewHolder(v);
		return vh;
	}

	// Replace the contents of a view (invoked by the layout manager)
	@Override
	public void onBindViewHolder(ViewHolder holder, final int position) {
		// - get element from your dataset at this position
		// - replace the contents of the view with that element
		final String name = values.get(position);
		holder.txtHeader.setText(name);
		holder.txtHeader.setOnClickListener(new OnClickListener() {
		        @Override
		        public void onClick(View v) {
		        	remove(position);
		        }
		    });
		
		//holder.txtFooter.setText("Footer: " + name);

		float per = 50;
		int visitCount = 30;
		int tableCount = 40;
		if (name.equals("명동메트로")){
			visitCount = 3;
			tableCount = 50;
			holder.iconView.setImageResource(R.drawable.myungdongmetro);
		}
		if (name.equals("무교동")){
			visitCount = 60;
			tableCount = 70;
			holder.iconView.setImageResource(R.drawable.mugyodong);
		}
		if (name.equals("광화문")){
			visitCount = 83;
			tableCount = 70;
			holder.iconView.setImageResource(R.drawable.gwanghwamun);
		}
		if (name.equals("남산단암")){
			visitCount = 28;
			tableCount = 60;
			holder.iconView.setImageResource(R.drawable.namsandanam);
		}
		if (name.equals("을지로입구")){
			visitCount = 12;
			tableCount = 60;
			holder.iconView.setImageResource(R.drawable.uljiroipgu);
		}
		if (name.equals("명동입구")){
			visitCount = 25;
			tableCount = 40;
			holder.iconView.setImageResource(R.drawable.myungdongipgu);
		}
		per = (float)visitCount * 100 / (float)tableCount;
		holder.txtFooter.setText("혼잡도 " + (int)per + "% (방문 " + visitCount + "명 / 좌석 " + tableCount + "개)");

		if (per < 30) holder.off40.setVisibility(View.VISIBLE);
		else if (per < 50) holder.off30.setVisibility(View.VISIBLE);

		holder.drawCanvas.visitCount = visitCount;
		holder.drawCanvas.tableCount = tableCount;


	}


	// Return the size of your dataset (invoked by the layout manager)
	@Override
	public int getItemCount() {
		return values.size();
	}

}