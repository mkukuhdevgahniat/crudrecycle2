package com.example.crudrecycle2

import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationItemView

class MainActivity : AppCompatActivity() {

    private  lateinit var inputNIS : EditText
    private  lateinit var inputNama : EditText
    private  lateinit var jkLakiLaki : RadioButton
    private  lateinit var jkPerempuan : RadioButton
    private  lateinit var btnTambah : Button
    private  lateinit var recycleView : RecyclerView
    private  lateinit var recycleAdapter : RecyclerView.Adapter<*>
    private  lateinit var viewManager : RecyclerView.LayoutManager



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputNIS = findViewById(R.id.txtinputNIS)
        inputNama = findViewById(R.id.txtinputNAMA)
        jkLakiLaki = findViewById(R.id.radiobuttonLakiLaki)
        jkPerempuan = findViewById(R.id.radiobuttonPerempuan)
        btnTambah = findViewById(R.id.btnTambah)
        recycleView = findViewById(R.id.listdata)

        //membuat variabel kosong tipe Array Mutablelist untuk simpan data ARRAY
        //data array disimpan di data class Siswadata
        val data = mutableListOf<SiswaData>()
        viewManager = LinearLayoutManager(this)
        recycleAdapter = SiswaAdapter(data)
        recycleView.adapter = recycleAdapter
        recycleView.layoutManager = viewManager

        //setOnClickListener untuk tombol tambah data
        btnTambah.setOnClickListener{
            val nis = inputNIS.text.toString()
            val nama = inputNama.text.toString()
            var jenisKelamin = ""
            if(jkLakiLaki.isChecked){
                jenisKelamin = "Laki-Laki"
            }else if (jkPerempuan.isChecked){
                jenisKelamin = "Perempuan"
            }else{
                jenisKelamin = "Harus Pilih satu"
            }
            val siswaData = SiswaData(nis,nama,jenisKelamin)
            data.add(siswaData)
            recycleAdapter.notifyDataSetChanged()
            inputNIS.setText("")
            inputNama.setText("")
            val rGroup = findViewById<RadioGroup>(R.id.radioGroup)
            rGroup.clearCheck()
        }
    }
}