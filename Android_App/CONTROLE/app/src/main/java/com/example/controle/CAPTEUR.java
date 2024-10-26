package com.example.controle;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class CAPTEUR extends AppCompatActivity {


    TextView temp,hum,gaz;
    GraphView graph;
    ImageView imageView,imageView5,imageView3;
    FirebaseDatabase database= FirebaseDatabase.getInstance();

    DatabaseReference referenceEntrada1 = database.getReference("SALLLE1").child("MOUVMENT");
    DatabaseReference referenceEntrada2 = database.getReference("SALLLE1").child("lecture");

    DatabaseReference referenceEntrada3 = database.getReference("SALLLE1").child("gaz");
    double m,k;


    private LineGraphSeries<DataPoint> series;
    private LineGraphSeries<DataPoint> series1;
    private int lastX=0;
    private int pointsPlotted = 0 ;
    private int graphIntervalCounter = 0;
    int Te ;
    int aux1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_a_p_t_e_u_r);
        imageView= findViewById(R.id.imageView);
                imageView5= findViewById(R.id.imageView5);
        imageView3= findViewById(R.id.imageView3);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.off));
        imageView5.setImageDrawable(getResources().getDrawable(R.drawable.gazoff));
        temp=findViewById(R.id.temp);
        hum=findViewById(R.id.hum);
        gaz=findViewById(R.id.gaz);
        GraphView graph = (GraphView) findViewById(R.id.graph);
        ImageView myImageView = (ImageView) findViewById(R.id.imageView3);
//        ImageView myImageView = (ImageView) findViewById(R.id.imageView5);

        myImageView.setImageResource(R.drawable.reall);

        series= new LineGraphSeries<DataPoint>();
        series1=new LineGraphSeries<DataPoint>();

        Viewport viewport = graph.getViewport();
        viewport.setScrollable(true);


        viewport.setMinY(0);
        viewport.setMaxY(60);
        //--------- erreur Moving Graph :::::::::
//        series.setDrawBackground(true);
        series.setColor(Color.GREEN);

//-----------Moving Graph :::::
        viewport.setXAxisBoundsManual(true);
        graph.getViewport().setScrollable(true);
//----------------


        graph.addSeries(series);
        graph.addSeries(series1);

        final ValueEventListener valueEventListener = referenceEntrada2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String T= dataSnapshot.child("temp").getValue().toString();
                temp.setText(T);
                String h = dataSnapshot.child("hum").getValue().toString();
                hum.setText(h);
                String t = dataSnapshot.child("time").getValue().toString();
                int aux = (int) Double.parseDouble(t);
                if (aux!=aux1){
                    pointsPlotted++;
                    String t1 = dataSnapshot.child("time").getValue().toString();
                    aux1 = (int) Double.parseDouble(t);
                    series.appendData( new DataPoint(pointsPlotted, Double.parseDouble(T)),true,pointsPlotted);
                    series1.appendData( new DataPoint(pointsPlotted, Double.parseDouble(h)),true,pointsPlotted);}
                viewport.setMaxX(pointsPlotted);
                viewport.setMinX(pointsPlotted - 100);
                //reset chaque 100 point :
                if(pointsPlotted==100){
                    finish();
                    startActivity(getIntent());
                }
                //----------------
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        referenceEntrada1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String T =dataSnapshot.child("value").getValue().toString();
                m = Double.parseDouble(T);
                if(m == 1){
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.on));
                }
                else{
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.off));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        referenceEntrada3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String G= dataSnapshot.child("value").getValue().toString();
                gaz.setText(G);
                String v =dataSnapshot.child("detection").getValue().toString();
                k = Double.parseDouble(v);
                if(k == 1){
                    imageView5.setImageDrawable(getResources().getDrawable(R.drawable.gazon));
                }
                else{
                    imageView5.setImageDrawable(getResources().getDrawable(R.drawable.gazoff));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}