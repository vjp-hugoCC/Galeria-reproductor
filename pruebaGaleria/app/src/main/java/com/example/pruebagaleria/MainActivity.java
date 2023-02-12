package com.example.pruebagaleria;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pruebagaleria.adaptadores.ListaCancionesAdapter;
import com.example.pruebagaleria.entidades.Canciones;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListaCancionesAdapter.OnCancionListener {
    private RecyclerView listaCanciones;
    Switch formato;
    private ArrayList<Canciones> listaArrayCanciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //captura elementos
        formato = findViewById(R.id.switch_formato);

        listaCanciones=findViewById(R.id.listaCanciones);
        listaCanciones.setLayoutManager(new LinearLayoutManager(this));
        listaArrayCanciones=new ArrayList<>();
        //cargar todas las canciones al array
        Canciones cancion1=new Canciones(1,"Normal", "feid","https://images.genius.com/3c9af42660323c238624f2a2276937a5.1000x1000x1.png","https://www.youtube.com/watch?v=oD5f55ohsc4","https://cdn.discordapp.com/attachments/316652022021488640/1073369317414023178/Feid_-_Normal_Official_Video.mp3");
        Canciones cancion2=new Canciones(2, "El patio" , "Vizio & Delaossa", "https://images.genius.com/e94ab89ef0a66d4cf357163153181069.1000x1000x1.jpg", "https://www.youtube.com/watch?v=OOec5Ci3LVQ", "https://cdn.discordapp.com/attachments/316652022021488640/1073369869619306527/Pepe___Vizio_Delaossa_-_El_Patio__Video_.mp3");
        Canciones cancion3= new Canciones(3, "XX", "Feid", "https://akamai.sscdn.co/uploadfile/letras/albuns/a/9/8/0/889301589894973.jpg", "https://www.youtube.com/watch?v=Ndd60RpmrZQ", "https://cdn.discordapp.com/attachments/316652022021488640/1073368882313707600/Feid_-_XX_Official_Video.mp3");
        Canciones cancion4= new Canciones(4, "Tubaru", "Nyno Vargas, Moncho Chavea y Banis", "https://www.que.es/wp-content/uploads/2022/02/Nyno-Vargas-Tubaru.png", "https://www.youtube.com/watch?v=Sb1oExXDe0k", "https://cdn.discordapp.com/attachments/316652022021488640/1073369110739685396/Nyno_Vargas_Moncho_Chavea_Banis_-_Tubaru_Videoclip_Oficial_Sb1oExXDe0k.mp3");
        Canciones cancion5= new Canciones(5, "No pensarte", "Myke Towers & Junhn", "https://images.genius.com/b5cfefc46b100aad938e20988bc53200.750x750x1.jpg" , "https://www.youtube.com/watch?v=cd0qvCR6sBE", "https://cdn.discordapp.com/attachments/316652022021488640/1073369298376077444/Myke_Towers__Juhn_-_No_Pensarte_Official_Video_cd0qvCR6sBE.mp3");
        Canciones cancion6= new Canciones(6,"Casualidad", "Mora", "https://www.lahiguera.net/musicalia/artistas/varios/disco/12602/mora_paraiso-portada.jpg", "https://www.youtube.com/watch?v=dUTg8AkAEDE", "https://cdn.discordapp.com/attachments/316652022021488640/1073370472214970368/Mora_-_CASUALIDAD_Visualizer___PARAISO_dUTg8AkAEDE.mp3");
        Canciones cancion7= new Canciones(7,"Mercho", "Lil cake & Migrantes", "https://m.media-amazon.com/images/I/51lgEt3KouL._SX354_SY354_BL0_QL100__UXNaN_FMjpg_QL85_.jpg", "https://www.youtube.com/watch?v=VVWH9jJLGkE", "https://cdn.discordapp.com/attachments/316652022021488640/1073370472680534136/LiL_CaKe_Migrantes_-_MERCHO_Official_Video_VVWH9jJLGkE.mp3");
        listaArrayCanciones.add(cancion1);
        listaArrayCanciones.add(cancion2);
        listaArrayCanciones.add(cancion3);
        listaArrayCanciones.add(cancion4);
        listaArrayCanciones.add(cancion5);
        listaArrayCanciones.add(cancion6);
        listaArrayCanciones.add(cancion7);
        ListaCancionesAdapter adapter=new ListaCancionesAdapter(listaArrayCanciones,this);
        listaCanciones.setAdapter(adapter);
    }

    @Override
    public void onCancionClick(int posicion) {
        if(formato.isChecked()){
            Intent intent=new Intent(this,VideoActivity.class);
            intent.putExtra("cancion",listaArrayCanciones.get(posicion));
            startActivity(intent);
        }else{
            Intent intent=new Intent(this,AudioActivity.class);
            intent.putExtra("cancion",listaArrayCanciones.get(posicion));
            startActivity(intent);
        }
    }
}