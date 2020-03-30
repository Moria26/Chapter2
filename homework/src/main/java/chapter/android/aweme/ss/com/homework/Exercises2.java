package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise2);
        TextView tv_num = (TextView) findViewById(R.id.tv_center); 
        View root_view = findViewById(R.id.root_view); 

        int sumOfView = getAllChildViewCount((ViewGroup) root_view);
        tv_num.setText(Integer.toString(sumOfView)); 
    }


    public int getAllChildViewCount(View root) {
        if (root == null) return 0;

        int viewCount = 0;
        if (root instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) root).getChildCount(); i++) {
                View view = ((ViewGroup) root).getChildAt(i);
                if (view instanceof ViewGroup) {
                    viewCount += getAllChildViewCount(view);
                } else {
                    viewCount++;
                }
            }
        }
        return viewCount;
    }
}
