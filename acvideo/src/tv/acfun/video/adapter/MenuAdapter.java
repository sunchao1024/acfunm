/*
 * Copyright (C) 2013 YROM.NET
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tv.acfun.video.adapter;

import java.util.List;

import tv.acfun.video.HomeActivity;
import tv.ac.fun.R;
import tv.acfun.video.entity.Category;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * @author Yrom
 *
 */
public class MenuAdapter extends BaseArrayAdapter<Category> {
    
    public MenuAdapter(Context context, List<Category> categories) {
        super(context, categories);
    }
    /**
     * @return cat's id
     */
    @Override
    public long getItemId(int position) {
        return getItem(position).id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        
        int type = getItemViewType(position);
        ViewHolder holder = null;
        if(type == 1){
            convertView = mInflater.inflate(R.layout.item_header, parent,false);
            holder = new ViewHolder();
            holder.text = (TextView) convertView.findViewById(android.R.id.text1);
        }else if(convertView == null){
            convertView = mInflater.inflate(R.layout.item_menus, parent,false);
            holder = new ViewHolder();
            holder.text = (TextView) convertView;
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        
        Category o = getItem(position);
        
        holder.text.setText(o.toString());
        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }
    @Override
    public int getItemViewType(int position) {
        if(position == HomeActivity.sTitles.length -1){
            return 1;
        }
        return 0;
    }
    
    static class ViewHolder{
        TextView text;
    }
}
