/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package turnos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author lleon
 */
public class Cliente {
    //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Cliente Attributes
  private String nombre;
  private String apellido;
  private int edad;

  //Cliente Associations
  private List<Turnos> turnos;

  //------------------------
  // CONSTRUCTOR
  //------------------------
  void Mostrar(){
      System.out.println("Su nombre es: "+nombre);
      System.out.println("Su apellido es: "+apellido);
      System.out.println("Su edad es: "+edad);
  }
  
  public Cliente(String aNombre, String aApellido, int aEdad)
  {
    nombre = aNombre;
    apellido = aApellido;
    edad = aEdad;
    turnos = new ArrayList<Turnos>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNombre(String aNombre)
  {
    boolean wasSet = false;
    nombre = aNombre;
    wasSet = true;
    return wasSet;
  }

  public boolean setApellido(String aApellido)
  {
    boolean wasSet = false;
    apellido = aApellido;
    wasSet = true;
    return wasSet;
  }

  public boolean setEdad(int aEdad)
  {
    boolean wasSet = false;
    edad = aEdad;
    wasSet = true;
    return wasSet;
  }

  public String getNombre()
  {
    return nombre;
  }

  public String getApellido()
  {
    return apellido;
  }

  public int getEdad()
  {
    return edad;
  }
  /* Code from template association_GetMany */
  public Turnos getTurno(int index)
  {
    Turnos aTurno = turnos.get(index);
    return aTurno;
  }

  public List<Turnos> getTurnos()
  {
    List<Turnos> newTurnos = Collections.unmodifiableList(turnos);
    return newTurnos;
  }

  public int numberOfTurnos()
  {
    int number = turnos.size();
    return number;
  }

  public boolean hasTurnos()
  {
    boolean has = turnos.size() > 0;
    return has;
  }

  public int indexOfTurno(Turnos aTurno)
  {
    int index = turnos.indexOf(aTurno);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTurnos()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Turnos addTurno(String aEmpleado, String aTematica)
  {
    return new Turnos(aEmpleado, aTematica, this);
  }

  public boolean addTurno(Turnos aTurno)
  {
    boolean wasAdded = false;
    if (turnos.contains(aTurno)) { return false; }
    Cliente existingCliente = aTurno.getCliente();
    boolean isNewCliente = existingCliente != null && !this.equals(existingCliente);
    if (isNewCliente)
    {
      aTurno.setCliente(this);
    }
    else
    {
      turnos.add(aTurno);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTurno(Turnos aTurno)
  {
    boolean wasRemoved = false;
    //Unable to remove aTurno, as it must always have a cliente
    if (!this.equals(aTurno.getCliente()))
    {
      turnos.remove(aTurno);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTurnoAt(Turnos aTurno, int index)
  {  
    boolean wasAdded = false;
    if(addTurno(aTurno))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTurnos()) { index = numberOfTurnos() - 1; }
      turnos.remove(aTurno);
      turnos.add(index, aTurno);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTurnoAt(Turnos aTurno, int index)
  {
    boolean wasAdded = false;
    if(turnos.contains(aTurno))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTurnos()) { index = numberOfTurnos() - 1; }
      turnos.remove(aTurno);
      turnos.add(index, aTurno);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTurnoAt(aTurno, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=turnos.size(); i > 0; i--)
    {
      Turnos aTurno = turnos.get(i - 1);
      aTurno.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "nombre" + ":" + getNombre()+ "," +
            "apellido" + ":" + getApellido()+ "," +
            "edad" + ":" + getEdad()+ "]";
  }
}
