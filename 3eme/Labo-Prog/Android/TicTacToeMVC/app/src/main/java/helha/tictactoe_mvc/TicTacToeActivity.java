package helha.tictactoe_mvc;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Observable;
import java.util.Observer;

import helha.tictactoe_mvc.model.Game;
import helha.tictactoe_mvc.model.Player;

public class TicTacToeActivity extends AppCompatActivity implements Observer{

    private static String TAG = TicTacToeActivity.class.getName();

    private Game model;

    private ViewGroup buttonGrid;
    private View winnerPlayerViewGroup;
    private TextView winnerPlayerLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_tic_tac_toe);

        //Lien entre la vue et le controleur
        winnerPlayerLabel = (TextView) findViewById(R.id.winnerPlayerLabel);
        winnerPlayerViewGroup = findViewById(R.id.winnerPlayerViewGroup);
        buttonGrid = (ViewGroup) findViewById(R.id.buttonGrid);

        //Lien entre le controleur et le modele
        model = new Game();
        model.addObserver(this);
    }

    public void onCellClicked(View v) {
        Log.d(TAG, "onCellClicked");
        //Le controleur recoit la vue en parametre
        Button button = (Button) v;
        String tag = button.getTag().toString();
        int row = Integer.valueOf(tag.substring(0, 1));
        int col = Integer.valueOf(tag.substring(1, 2));
        Log.d(TAG, "Click Row: [" + row + "," + col + "]");
        model.mark(row, col);
    }

    public void resetButtonClicked(View v) {
        Log.d(TAG, "resetButtonClicked");
        model.reset();
    }

    @Override
    public void update(Observable observable, Object o) {
        Log.d(TAG, "update");
        updateCells();
        updateWinner();
    }

    private void updateWinner() {
        Player winner = model.getWinner();
        if (model.getWinner() != null) {
            winnerPlayerLabel.setText(winner.toString());
            winnerPlayerViewGroup.setVisibility(View.VISIBLE);
        }else{
            winnerPlayerViewGroup.setVisibility(View.GONE);
            winnerPlayerLabel.setText("");
        }
    }

    private void updateCells() {
        int size = model.getSize();
        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                int index = j + i*size;
                String value = model.getCellValue(i,j) != null ? model.getCellValue(i,j).toString() : null;
                ((Button) buttonGrid.getChildAt(index)).setText(value);
            }
        }
    }
}
