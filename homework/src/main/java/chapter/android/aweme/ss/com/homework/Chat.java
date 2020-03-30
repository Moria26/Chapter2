package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Chat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);
        TextView tv_num = findViewById(R.id.tv_content_info);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Bundle result = extras.getBundle("result");
            if (result != null) {
                int num = result.getInt("index");
                tv_num.setText(Integer.toString(num));
            }
        }
    }
}