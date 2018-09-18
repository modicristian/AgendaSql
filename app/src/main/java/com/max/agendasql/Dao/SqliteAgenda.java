package com.max.agendasql.Dao;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.inputmethodservice.Keyboard;

import com.max.agendasql.Models.Agenda;

import java.util.ArrayList;

public class SqliteAgenda extends SQLiteOpenHelper{
    private static final String DBNAME="dbAgenda";
    private static final Integer DBVERSION=2;
    private Context context;
    private SQLiteDatabase conexion;

    public SqliteAgenda(Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String query="CREATE TABLE `AgendaTabla` ( `Id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,`Nombre` TEXT NOT NULL, `Apellido` TEXT NOT NULL, `Telefono` INTEGER NOT NULL,`Dni` INTEGER NOT NULL UNIQUE,`Email` TEXT NOT NULL,`Calle` TEXT NOT NULL, `Altura` INTEGER NOT NULL,`PisoDto` INTEGER NOT NULL )";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    String query="CREATE TABLE `AgendaTabla` ( `Id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,`Nombre` TEXT NOT NULL, `Apellido` TEXT NOT NULL, `Telefono` INTEGER NOT NULL,`Dni` INTEGER NOT NULL UNIQUE,`Email` TEXT NOT NULL,`Calle` TEXT NOT NULL, `Altura` INTEGER NOT NULL,`PisoDto` INTEGER NOT NULL )";
        db.execSQL(query);
    }
    private void Conectar(){
        conexion=getWritableDatabase();
    }
    private void Desconectar(){
        conexion.close();
    }

    public void GuardarAgendaSql(Agenda agenda){
        this.Conectar();
        String query="";
        query="insert into AgendaTabla (Nombre,Apellido,Telefono,Dni,Email,Calle,Altura,PisoDto) values('" +agenda.getNombre()+"','"+agenda.getApellido()+"','"+agenda.getTelefono()+"',"+agenda.getDni()+",'"+agenda.getEmail()+"','"+agenda.getCalle()+"',"+agenda.getAltura()+",'"+agenda.getPisoDto()+ "')";
        conexion.execSQL(query);
        this.Desconectar();
    }
    public void BorrarAgendaSql(Agenda agenda){
        this.Conectar();
        String query="";
        query="delete from AgendaTabla where Id =" + agenda.getId().toString();
        conexion.execSQL(query);
        this.Desconectar();
    }
    public Agenda getAgendaPorID(Integer id){
        this.Conectar();
        Agenda miAgenda = null;
        String query="";
        query="Select * from AgendaTabla where Id =" + id.toString();
        Cursor cursor=conexion.rawQuery(query, null);
        while (cursor.moveToNext()){
            miAgenda = new Agenda(cursor.getInt(cursor.getColumnIndex("Id")),cursor.getString(cursor.getColumnIndex("Nombre")),cursor.getString(cursor.getColumnIndex("Apellido")),cursor.getInt(cursor.getColumnIndex("Telefono")),cursor.getInt(cursor.getColumnIndex("Dni")),cursor.getString(cursor.getColumnIndex("Email")),cursor.getString(cursor.getColumnIndex("Calle")),cursor.getInt(cursor.getColumnIndex("Altura")),cursor.getInt(cursor.getColumnIndex("PisoDto")));
        }
        this.Desconectar();
    return miAgenda;
    }
    public void actualizar(Agenda agenda){
       this.Conectar();

        ContentValues row = new ContentValues();

        row.put("Nombre", agenda.getNombre());
        row.put("Apellido", agenda.getApellido());
        row.put("Telefono", agenda.getTelefono().toString());
        row.put("Dni", agenda.getDni().toString());
        row.put("Email", agenda.getEmail());
        row.put("Calle", agenda.getCalle());
        row.put("Altura", agenda.getAltura().toString());
        row.put("PisoDto", agenda.getPisoDto().toString());
        conexion.update("AgendaTabla", row,"Id = " + agenda.getId(), null);

        this.Desconectar();
    }

    public ArrayList<Agenda> getAgenda(){
      ArrayList<Agenda> agendaArrayList = new ArrayList<>();
      this.Conectar();
      String query="";
      query="Select Nombre, Apellido, Telefono, Dni, Email, Calle, Altura, PisoDto, Id from AgendaTabla";
      Cursor cursor= conexion.rawQuery(query, null);
      while (cursor.moveToNext()){
          Agenda miAgenda = new Agenda(cursor.getInt(cursor.getColumnIndex("Id")),cursor.getString(cursor.getColumnIndex("Nombre")),cursor.getString(cursor.getColumnIndex("Apellido")),cursor.getInt(cursor.getColumnIndex("Telefono")),cursor.getInt(cursor.getColumnIndex("Dni")),cursor.getString(cursor.getColumnIndex("Email")),cursor.getString(cursor.getColumnIndex("Calle")),cursor.getInt(cursor.getColumnIndex("Altura")),cursor.getInt(cursor.getColumnIndex("PisoDto")));
          agendaArrayList.add(miAgenda);
      }
      this.Desconectar();
      return agendaArrayList;
    }

    public ArrayList<Agenda> getAgendaPorNombre(){
        ArrayList<Agenda> agendaArrayList = new ArrayList<>();
        this.Conectar();
        String query="";
        query="Select Nombre, Apellido, Telefono, Dni, Email, Calle, Altura, PisoDto, Id from AgendaTabla order by NOMBRE";
        Cursor cursor= conexion.rawQuery(query, null);
        while (cursor.moveToNext()){
            Agenda miAgenda = new Agenda(cursor.getInt(cursor.getColumnIndex("Id")),cursor.getString(cursor.getColumnIndex("Nombre")),cursor.getString(cursor.getColumnIndex("Apellido")),cursor.getInt(cursor.getColumnIndex("Telefono")),cursor.getInt(cursor.getColumnIndex("Dni")),cursor.getString(cursor.getColumnIndex("Email")),cursor.getString(cursor.getColumnIndex("Calle")),cursor.getInt(cursor.getColumnIndex("Altura")),cursor.getInt(cursor.getColumnIndex("PisoDto")));
            agendaArrayList.add(miAgenda);
        }
        this.Desconectar();
        return agendaArrayList;
    }

    public ArrayList<Agenda> getAgendaPorDNI(){
        ArrayList<Agenda> agendaArrayList = new ArrayList<>();
        this.Conectar();
        String query="";
        query="Select Nombre, Apellido, Telefono, Dni, Email, Calle, Altura, PisoDto, Id from AgendaTabla order by Dni";
        Cursor cursor= conexion.rawQuery(query, null);
        while (cursor.moveToNext()){
            Agenda miAgenda = new Agenda(cursor.getInt(cursor.getColumnIndex("Id")),cursor.getString(cursor.getColumnIndex("Nombre")),cursor.getString(cursor.getColumnIndex("Apellido")),cursor.getInt(cursor.getColumnIndex("Telefono")),cursor.getInt(cursor.getColumnIndex("Dni")),cursor.getString(cursor.getColumnIndex("Email")),cursor.getString(cursor.getColumnIndex("Calle")),cursor.getInt(cursor.getColumnIndex("Altura")),cursor.getInt(cursor.getColumnIndex("PisoDto")));
            agendaArrayList.add(miAgenda);
        }
        this.Desconectar();
        return agendaArrayList;
    }

}
