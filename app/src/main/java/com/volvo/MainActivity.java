package com.volvo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.meituan.android.walle.ChannelInfo;
import com.meituan.android.walle.WalleChannelReader;

public class MainActivity extends AppCompatActivity {

  private TextView tvChannel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    tvChannel = findViewById(R.id.tv_channel);
    String channel = WalleChannelReader.getChannel(this.getApplicationContext());
    tvChannel.setText(channel);

  }

  private void readChannel() {
    final long startTime = System.currentTimeMillis();
    final ChannelInfo channelInfo = WalleChannelReader.getChannelInfo(this.getApplicationContext());
    if (channelInfo != null) {
      tvChannel.setText(channelInfo.getChannel() + "\n" + channelInfo.getExtraInfo());
    }
    Toast.makeText(this, "ChannelReader takes " + (System.currentTimeMillis() - startTime) + " milliseconds", Toast.LENGTH_SHORT).show();
  }
}
