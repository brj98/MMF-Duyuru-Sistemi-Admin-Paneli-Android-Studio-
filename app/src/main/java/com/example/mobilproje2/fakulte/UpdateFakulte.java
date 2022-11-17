package com.example.mobilproje2.fakulte;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.mobilproje2.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateFakulte extends AppCompatActivity {

    FloatingActionButton fab;
    private RecyclerView BMuh,BiMuh,CeMuh,EEMuh,GBMuh,GMuh,IMuh,MakMuh;
    private LinearLayout BMuhNoData,BiMuhNoData,CeMuhNoData,EEMuhNoData,GBMuhNoData,GMuhNoData,IMuhNoData,MakMuhNoData;
    private List<TeacherData> list,list2,list3,list4;
    private TeacherAdapter adapter;

    private DatabaseReference reference,dbRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_fakulte);

        BMuh = findViewById(R.id.BMuh);
        BiMuh = findViewById(R.id.BiMuh);
        CeMuh = findViewById(R.id.CeMuh);
        EEMuh = findViewById(R.id.EEMuh);
        GBMuh = findViewById(R.id.GBMuh);
        GMuh = findViewById(R.id.GMuh);
        IMuh = findViewById(R.id.IMuh);
        MakMuh = findViewById(R.id.MakMuh);

        BMuhNoData = findViewById(R.id.BMuhNoData);
        BiMuhNoData = findViewById(R.id.BiMuhNoData);
        CeMuhNoData = findViewById(R.id.CeMuhNoData);
        EEMuhNoData = findViewById(R.id.EEMuhNoData);
        GBMuhNoData = findViewById(R.id.GBMuhNoData);
        GMuhNoData = findViewById(R.id.GMuhNoData);
        IMuhNoData = findViewById(R.id.IMuhNoData);
        MakMuhNoData = findViewById(R.id.MakMuhNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        BilgisayarMuh();
        BiyomedikalMuh();
        CevreMuh();
        EEMuh();

        GenetikMuh();
        GidaMuh();
        InsaatMuh();
        MakineMuh();


        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpdateFakulte.this,AddTeacher.class));
            }
        });
    }

    private void BilgisayarMuh() {
        dbRef = reference.child("BİLGİSAYAR MÜHENDİSLİĞİ");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                if (!snapshot.exists()){
                    BMuhNoData.setVisibility(View.VISIBLE);
                    BMuh.setVisibility(View.GONE);
                }else{
                    BMuhNoData.setVisibility(View.GONE);
                   BMuh.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list.add(data);
                    }
                    BMuh.setHasFixedSize(true);
                    BMuh.setLayoutManager(new LinearLayoutManager(UpdateFakulte.this));
                    adapter = new TeacherAdapter(list,UpdateFakulte.this,"BİLGİSAYAR MÜHENDİSLİĞİ");
                    BMuh.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFakulte.this,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void BiyomedikalMuh() {
        dbRef = reference.child("BİYOMEDİKAL MÜHENDİSLİĞİ");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2 = new ArrayList<>();
                if (!snapshot.exists()){
                   BiMuhNoData.setVisibility(View.VISIBLE);
                    BiMuh.setVisibility(View.GONE);
                }else{
                    BiMuhNoData.setVisibility(View.GONE);
                    BiMuh.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    BiMuh.setHasFixedSize(true);
                    BiMuh.setLayoutManager(new LinearLayoutManager(UpdateFakulte.this));
                    adapter = new TeacherAdapter(list2,UpdateFakulte.this,"BİYOMEDİKAL MÜHENDİSLİĞİ");
                    BiMuh.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFakulte.this,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void CevreMuh() {
        dbRef = reference.child("ÇEVRE MÜHENDİSLİĞİ");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3 = new ArrayList<>();
                if (!snapshot.exists()){
                   CeMuhNoData.setVisibility(View.VISIBLE);
                    CeMuh.setVisibility(View.GONE);
                }else{
                    CeMuhNoData.setVisibility(View.GONE);
                    CeMuh.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    CeMuh.setHasFixedSize(true);
                    CeMuh.setLayoutManager(new LinearLayoutManager(UpdateFakulte.this));
                    adapter = new TeacherAdapter(list3,UpdateFakulte.this,"ÇEVRE MÜHENDİSLİĞİ");
                    CeMuh.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFakulte.this,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void EEMuh() {
        dbRef = reference.child("ELEKTRİK-ELEKTRONİK MÜHENDİSLİĞİ");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4 = new ArrayList<>();
                if (!snapshot.exists()){
                   EEMuhNoData.setVisibility(View.VISIBLE);
                    EEMuh.setVisibility(View.GONE);
                }else{
                    EEMuhNoData.setVisibility(View.GONE);
                    EEMuh.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    EEMuh.setHasFixedSize(true);
                   EEMuh.setLayoutManager(new LinearLayoutManager(UpdateFakulte.this));
                    adapter = new TeacherAdapter(list4,UpdateFakulte.this,"ELEKTRİK-ELEKTRONİK MÜHENDİSLİĞİ");
                    EEMuh.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFakulte.this,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void GenetikMuh() {
        dbRef = reference.child("GENETİK VE BİYOMÜHENDİSLİK");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4 = new ArrayList<>();
                if (!snapshot.exists()){
                    GBMuhNoData.setVisibility(View.VISIBLE);
                     GBMuh.setVisibility(View.GONE);
                }else{
                    GBMuhNoData.setVisibility(View.GONE);
                     GBMuh.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                     GBMuh.setHasFixedSize(true);
                     GBMuh.setLayoutManager(new LinearLayoutManager(UpdateFakulte.this));
                    adapter = new TeacherAdapter(list4,UpdateFakulte.this,"GENETİK VE BİYOMÜHENDİSLİK");
                     GBMuh.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFakulte.this,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void GidaMuh() {
        dbRef = reference.child("GIDA MÜHENDİSLİĞİ");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4 = new ArrayList<>();
                if (!snapshot.exists()){
                   GMuhNoData.setVisibility(View.VISIBLE);
                    GMuh.setVisibility(View.GONE);
                }else{
                    GMuhNoData.setVisibility(View.GONE);
                    GMuh.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                   GMuh.setHasFixedSize(true);
                   GMuh.setLayoutManager(new LinearLayoutManager(UpdateFakulte.this));
                    adapter = new TeacherAdapter(list4,UpdateFakulte.this,"GIDA MÜHENDİSLİĞİ");
                    GMuh.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFakulte.this,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void InsaatMuh() {
        dbRef = reference.child("İNŞAAT MÜHENDİSLİĞİ");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4 = new ArrayList<>();
                if (!snapshot.exists()){
                    IMuhNoData.setVisibility(View.VISIBLE);
                    IMuh.setVisibility(View.GONE);
                }else{
                    IMuhNoData.setVisibility(View.GONE);
                    IMuh.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                     IMuh.setHasFixedSize(true);
                     IMuh.setLayoutManager(new LinearLayoutManager(UpdateFakulte.this));
                    adapter = new TeacherAdapter(list4,UpdateFakulte.this,"İNŞAAT MÜHENDİSLİĞİ");
                     IMuh.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFakulte.this,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void MakineMuh() {
        dbRef = reference.child("MAKİNE MÜHENDİSLİĞİ");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4 = new ArrayList<>();
                if (!snapshot.exists()){
                    MakMuhNoData.setVisibility(View.VISIBLE);
                    MakMuh.setVisibility(View.GONE);
                }else{
                    MakMuhNoData.setVisibility(View.GONE);
                    MakMuh.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                   MakMuh.setHasFixedSize(true);
                   MakMuh.setLayoutManager(new LinearLayoutManager(UpdateFakulte.this));
                    adapter = new TeacherAdapter(list4,UpdateFakulte.this,"MAKİNE MÜHENDİSLİĞİ");
                    MakMuh.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFakulte.this,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}