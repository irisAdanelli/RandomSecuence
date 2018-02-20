package mx.edu.ittepic.randomsecuence;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    float random, avance;
    String bien, bien2, bien3;
    CountDownTimer timer;
    Button botoncito;
    TextView numero,cap,nfinal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botoncito = findViewById(R.id.button);
        numero = findViewById(R.id.textView);


        avance = 0;

        final DecimalFormat df = new DecimalFormat("#.0");
        random = (float) (Math.random() * 3);
        bien = df.format(random);
        numero.setText("" + bien);






        timer = new CountDownTimer(10000, 300) {
            @Override
            public void onTick(long millisUntilFinished) {
                avance = (float) (avance + 0.1);
                bien2 = df.format(avance);
                botoncito.setText("" + bien2);

                if (avance >= 2.9) {
                    avance = (float) 0.0;
                }

            }

            @Override
            public void onFinish() {
                timer.start();

            }
        };
        timer.start();

        cap.setText(""+bien2);

        botoncito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*cap.setText(""+bien2);
                nfinal.setText(""+bien);*/

                if (cap == numero){
                    Toast.makeText(MainActivity.this, "le Atinaste campeon", Toast.LENGTH_LONG).show();
                    timer.cancel();

                }else {
                    Toast.makeText(MainActivity.this, "Malisimo", Toast.LENGTH_LONG).show();

                    final DecimalFormat df = new DecimalFormat("#.0");
                    random = (float) (Math.random() * 3);
                    bien = df.format(random);
                    numero.setText("" + bien);

                }


            }
        });

    }
}
