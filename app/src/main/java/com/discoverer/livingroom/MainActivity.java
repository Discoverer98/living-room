package com.discoverer.livingroom;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Sample class that allows the user to enter the characteristics of his living room.
 * It's used to show how an "Arguments" class can be used to pass the parameters for
 * starting another activity.
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.room_color_edittext) EditText roomColorEdittext;
    @BindView(R.id.number_walls_edittext) EditText numWallsEdittext;

    // region Activity methods

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    // endregion Activity methods

    @OnClick(R.id.enter_living_room_button)
    public void enterLivingRoom(final View view) {
        final LivingRoomActivity.Arguments arguments = LivingRoomActivity.Arguments.builder()
                .setRoomColor(roomColorEdittext.getText().toString())
                .setNumOfWalls(Integer.parseInt(numWallsEdittext.getText().toString()))
                .build();
        arguments.startActivity(this);
    }

} // MainActivity class
