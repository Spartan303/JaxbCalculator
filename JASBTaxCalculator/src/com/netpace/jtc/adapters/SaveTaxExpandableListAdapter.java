package com.netpace.jtc.adapters;

import java.util.List;

import com.netpace.jtc.R;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class SaveTaxExpandableListAdapter extends BaseExpandableListAdapter{

	
	private Context _context;
    private List<String> _listDataHeader;
    private List<String> _listDataContent;
          	
	public SaveTaxExpandableListAdapter(Context _context,
			List<String> _listDataHeader, List<String> _listDataContent) {
		super();
		this._context = _context;
		this._listDataHeader = _listDataHeader;
		this._listDataContent = _listDataContent;
	}

	@Override
	public Object getChild(int arg0, int arg1) {
		return this._listDataContent.get(arg1);
	}

	@Override
	public long getChildId(int arg0, int arg1) {
		return arg1;
	}

	@Override
	public View getChildView(int arg0, int arg1, boolean arg2, View arg3,
			ViewGroup arg4) {
		final String _content = (String) getChild(arg0, arg1);
		if (arg3 == null) {
			LayoutInflater inflater = (LayoutInflater)this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			arg3 = inflater.inflate(R.layout.save_tax_list_item, null);
		}
		
		TextView txtListChild = (TextView) arg3.findViewById(R.id.lblListItem);
        txtListChild.setText(_content);
        
        return arg3;
	}

	@Override
	public int getChildrenCount(int arg0) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Object getGroup(int arg0) {
		return this._listDataHeader.get(arg0);
	}

	@Override
	public int getGroupCount() {
		return this._listDataHeader.size();
	}

	@Override
	public long getGroupId(int arg0) {
		return arg0;
	}

	@Override
	public View getGroupView(int arg0, boolean arg1, View arg2, ViewGroup arg3) {
		String headerTitle = (String) getGroup(arg0);
        if (arg2 == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            arg2 = infalInflater.inflate(R.layout.save_tax_list_group, null);
        }
 
        TextView lblListHeader = (TextView) arg2
                .findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
 
        return arg2;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		return true;
	}

}
