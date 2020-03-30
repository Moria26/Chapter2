package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myViewHolder> {

    private int mNumberItems;
    private final ListItemClickListener mOnClickListener;
    private List<Message> allMessage;

    public MyAdapter(int numListItems, List<Message> messages,ListItemClickListener listener) {
        mNumberItems = numListItems;
        mOnClickListener = listener;
        allMessage = messages;  //所有信息
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.im_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ImageView robot_notice;
        private final CircleImageView iv_avatar;
        private final TextView tv_title;
        private final TextView tv_description;
        private final TextView tv_time;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            robot_notice = itemView.findViewById(R.id.robot_notice);
            iv_avatar = itemView.findViewById(R.id.iv_avatar);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_description = itemView.findViewById(R.id.tv_description);
            tv_time = itemView.findViewById(R.id.tv_time);
            itemView.setOnClickListener(this);
        }

        public void bind(int position) {
            Message curMessage = allMessage.get(position);
            tv_time.setText(curMessage.getTime());
            tv_description.setText(curMessage.getDescription());
            tv_title.setText(curMessage.getTitle());

            String iconType = curMessage.getIcon();
            int iconID = 0;
            switch (iconType){
                case "TYPE_ROBOT":
                    iconID = R.drawable.session_robot;
                    break;
                case "TYPE_GAME":
                    iconID = R.drawable.icon_micro_game_comment;
                    break;
                case "TYPE_SYSTEM":
                    iconID = R.drawable.session_system_notice;
                    break;
                case "TYPE_STRANGER":
                    iconID = R.drawable.session_stranger;
                    break;
                case "TYPE_USER":
                    iconID = R.drawable.icon_girl;
                    break;
                default:
                    break;
            }
            iv_avatar.setImageResource(iconID);

            if(curMessage.isOfficial()) //官方图标
                robot_notice.setImageResource(R.drawable.im_icon_notice_official);
        }


        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            if (mOnClickListener != null) {
                mOnClickListener.onListItemClick(clickedPosition);
            }
        }
    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }
}