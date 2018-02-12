package mx.unam.aragon.fes.diplo.gitandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button boton1;
    private TextView textview1;
    private Button boton2;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton1=findViewById(R.id.button);
        textview1=findViewById(R.id.textView);
        boton2=findViewById(R.id.button2);

        boton1.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                textview1.setText("Sieg Heil");
                Toast.makeText(MainActivity.this, "Se cambió el mensaje en el textview",Toast.LENGTH_SHORT).show();
            }


        });

        boton2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                textview1.setText("Diplomado Android");
            }


        });

    }
}
