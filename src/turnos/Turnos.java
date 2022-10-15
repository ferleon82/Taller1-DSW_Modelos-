/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package turnos;

/**
 *
 * @author lleon
 */
public class Turnos {
    //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Turnos Attributes
  private String empleado;
  private String tematica;

  //Turnos Associations
  private Cliente cliente;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Turnos(String aEmpleado, String aTematica, Cliente aCliente)
  {
    empleado = aEmpleado;
    tematica = aTematica;
    boolean didAddCliente = setCliente(aCliente);
    if (!didAddCliente)
    {
      throw new RuntimeException("Unable to create turno due to cliente. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setEmpleado(String aEmpleado)
  {
    boolean wasSet = false;
    empleado = aEmpleado;
    wasSet = true;
    return wasSet;
  }

  public boolean setTematica(String aTematica)
  {
    boolean wasSet = false;
    tematica = aTematica;
    wasSet = true;
    return wasSet;
  }

  public String getEmpleado()
  {
    return empleado;
  }

  public String getTematica()
  {
    return tematica;
  }
  /* Code from template association_GetOne */
  public Cliente getCliente()
  {
    return cliente;
  }
  /* Code from template association_SetOneToMany */
  public boolean setCliente(Cliente aCliente)
  {
    boolean wasSet = false;
    if (aCliente == null)
    {
      return wasSet;
    }

    Cliente existingCliente = cliente;
    cliente = aCliente;
    if (existingCliente != null && !existingCliente.equals(aCliente))
    {
      existingCliente.removeTurno(this);
    }
    cliente.addTurno(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Cliente placeholderCliente = cliente;
    this.cliente = null;
    if(placeholderCliente != null)
    {
      placeholderCliente.removeTurno(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "empleado" + ":" + getEmpleado()+ "," +
            "tematica" + ":" + getTematica()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "cliente = "+(getCliente()!=null?Integer.toHexString(System.identityHashCode(getCliente())):"null");
  }
}
