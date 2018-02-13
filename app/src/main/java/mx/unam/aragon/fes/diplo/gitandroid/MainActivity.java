package mx.unam.aragon.fes.diplo.gitandroid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private Button boton1;
    private TextView textview1;
    private Button boton2;
    private Button boton3;
    private ImageView imageview1;
    private Bitmap imagenDescargada;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton1=findViewById(R.id.button);
        textview1=findViewById(R.id.textView);
        boton2=findViewById(R.id.button2);
        boton3=findViewById(R.id.button3);
        imageview1=findViewById(R.id.imageView);

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


        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="http://vignette.wikia.nocookie.net/toontown/images/4/42/F785462b-8874-4a2b-bba9-4be6b0cd88e9.jpg/revision/latest?cb=20131125131901";
                try {
                    //hilo
                    new DescargarImagen().execute(new URL(url));
                }catch(Exception e){
                    android.util.Log.e("diplo tag","eeror al descargar la image ");
                }
            }
        });

    }

    class DescargarImagen extends AsyncTask<URL,Integer,Bitmap> {
        @Override
        protected Bitmap doInBackground(URL... params) {
            try {
                Log.i("diplo tag","iNICIANDO DESCRGa");
                imagenDescargada=
                        BitmapFactory.decodeStream(params[0].openConnection().getInputStream());
            }catch (Exception e){
                android.util.Log.e("Internet error",e.toString());
            }
            return imagenDescargada;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values[0]);
            Log.i("diplo tag",""+values[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageview1.setImageBitmap(imagenDescargada);
            super.onPostExecute(bitmap);
        }
    }
}
