package com.discoverer.livingroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.auto.value.AutoValue;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Sample class that just shows on the screen the description of a common living room.
 */
public class LivingRoomActivity extends AppCompatActivity {

    private Arguments arguments;

    @BindView(R.id.wall_colors_text_view) TextView wallColorsTextView;
    @BindView(R.id.num_walls_text_view) TextView numWallsTextView;

    // region Activity methods

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_living_room);
        ButterKnife.bind(this);

        arguments = Arguments.createFromIntent(getIntent());

        wallColorsTextView.setText("Room color: " + arguments.roomColor());
        numWallsTextView.setText(String.format("Number of walls: %d", arguments.numOfWalls()));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    // endregion Activity methods


    /**
     * POJO class that just stores the arguments required for starting the LivingRoomAcitivity.
     * It can also start the LivingRoomActivity itself.
     */
    @AutoValue
    public static abstract class Arguments {

        private static final String ROOM_COLOR_TAG = "roomColorTag";
        private static final String NUM_OF_WALLS_TAG = "numOfWallsTag";
        private static final int DEFAULT_NUM_OF_WALLS = 4;

        public abstract String roomColor();
        public abstract int numOfWalls();

        public static Arguments createFromIntent(final Intent intent) {
            return builder()
                    .setRoomColor(intent.getStringExtra(ROOM_COLOR_TAG))
                    .setNumOfWalls(intent.getIntExtra(NUM_OF_WALLS_TAG, DEFAULT_NUM_OF_WALLS))
                    .build();
        }

        public static Builder builder() {
            return new AutoValue_LivingRoomActivity_Arguments.Builder();
        }

        public void startActivity(final Context context) {
            final Intent intent = new Intent(context, LivingRoomActivity.class);
            intent.putExtra(ROOM_COLOR_TAG, roomColor());
            intent.putExtra(NUM_OF_WALLS_TAG, numOfWalls());
            context.startActivity(intent);
        }

        /**
         * Builder class for the LivingRoomActivity.Arguments class.
         */
        @AutoValue.Builder
        public static abstract class Builder {

            public abstract Builder setRoomColor(String value);
            public abstract Builder setNumOfWalls(int value);
            public abstract Arguments build();

        } // Builder class

    } // Arguments class

} // LivingRoomActivity class
