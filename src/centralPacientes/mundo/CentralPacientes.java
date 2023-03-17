/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Departamento de Tecnolog�as de la Informaci�n y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Central de Pacientes.
 * Adaptado de CUPI2 (Uniandes)
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package centralPacientes.mundo;

import java.util.ArrayList;

/**
 * Esta clase representa una central en la que se maneja una lista de pacientes
 */
public class CentralPacientes {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista de pacientes
     */
    private ArrayList<Paciente> pacientes;

    /**
     * Vector de cl�nicas manejadas por la central
     */
    private ArrayList<String> listaClinicas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva central sin pacientes y con una lista predefinida de cl�nicas
     */
    public CentralPacientes() {
        pacientes = new ArrayList<>();

        listaClinicas = new ArrayList<>();
        listaClinicas.add("Cl�nica del Country");
        listaClinicas.add("Cl�nica Palermo");
        listaClinicas.add("Cl�nica Reina Sof�a");
        listaClinicas.add("Cl�nica El Bosque");
        listaClinicas.add("Cl�nica San Ignacio");
        listaClinicas.add("Otra");
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el n�mero de pacientes de la cl�nica
     *
     * @return El n�mero de pacientes de la cl�nica
     */
    public int darNumeroPacientes() {
        return pacientes.size();
    }

    /**
     * Adiciona un paciente al principio de la lista
     *
     * @param pac El paciente a ser agregado al comienzo de la lista. <br>
     *            pac!=null y no existe un paciente con c�digo igual a pac.codigo
     */
    public void agregarPacienteAlComienzo(Paciente pac) {
        if(pac != null)
        {
            boolean existePaciente = ExistePaciente(pac);

            if(!existePaciente){
                pacientes.add(0, pac);
            }
        }
    }

    private boolean ExistePaciente(Paciente pac) {
        boolean existePaciente = false;
        for (int i = 0; i < pacientes.size(); i++) {
            if(pacientes.get(i).darCodigo() == pac.darCodigo()){
                existePaciente = true;
                break;
            }
        }
        return existePaciente;
    }

    /**
     * Adiciona un paciente al final de la lista. Si la lista est� vac�a el paciente queda de primero
     *
     * @param pac El paciente a ser agregado al final la lista. <br>
     *            pac!=null y no existe un paciente con c�digo igual a pac.codigo
     */
    public void agregarPacienteAlFinal(Paciente pac) {
        if(pac != null)
        {
            boolean existePaciente = ExistePaciente(pac);

            if(!existePaciente){
                pacientes.add(pacientes.size(), pac);
            }
        }
    }

    /**
     * Adiciona un paciente a la lista de pacientes antes del paciente con el c�digo especificado. <br>
     */
    public void agregarPacienteAntesDe(int cod, Paciente pac) throws NoExisteException {
        int indice = ObtenerIndicePorCodigo(cod);

        if(indice == -1){
            throw new NoExisteException(cod);
        }

        pacientes.add(indice, pac);
    }

    private int ObtenerIndicePorCodigo(int cod) {
        for (int i = 0; i < pacientes.size(); i++) {
            Paciente pacienteActual = pacientes.get(i);
            if (pacienteActual !=null && pacienteActual.darCodigo() == cod) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Adiciona un paciente a la lista de pacientes despu�s del paciente con el c�digo especificado.
     */
    public void agregarPacienteDespuesDe(int cod, Paciente pac) throws NoExisteException {
        int indice = ObtenerIndicePorCodigo(cod);

        if(indice == -1){
            throw new NoExisteException(cod);
        }

        int nuevoIndice = indice + 1;

        pacientes.add(nuevoIndice, pac);
    }

    /**
     * Busca el paciente con el c�digo dado en la lista de pacientes.
     */
    public Paciente localizar(int codigo) {
        return null;
    }

    /**
     * Elimina el paciente con el c�digo especificado.
     */
    public void eliminarPaciente(int cod) throws NoExisteException {
        int indice = ObtenerIndicePorCodigo(cod);

        if(indice == -1){
            throw new NoExisteException(cod);
        }

        pacientes.remove(indice);
    }

    /**
     * Devuelve una lista con los pacientes de la central
     */
    public ArrayList<Paciente> darPacientes() {
        return pacientes;
    }

    /**
     * Retorna la lista de cl�nicas manejadas por la central
     */
    public ArrayList<String> darListaClinicas() {
        return listaClinicas;
    }

    /**
     * Retorna la longitud de la lista
     */
    private int darLongitud() {
        return pacientes.size();
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * Retorna la cantidad de hombres que hay en la lista
     */
    public int cantHombres() {
        int cantidadHombres = 0;
        for (int i = 0; i < pacientes.size(); i++) {
            if(pacientes.get(i).darSexo() == 1){
                cantidadHombres++;
            }
        }
        return cantidadHombres;
    }

    /**
     * Retorna la cantidad de mujeres que hay en la lista
     */
    public int cantMujeres() {
        int cantidadMujeres = 0;
        for (int i = 0; i < pacientes.size(); i++) {
            if(pacientes.get(i).darSexo() == 2){
                cantidadMujeres++;
            }
        }
        return cantidadMujeres;
    }

    /**
     * De las 6 opciones de cl�nicas que tiene la central
     * �Cu�l es el nombre de la m�s ocupada, la que tiene m�s pacientes?
     *
     * @return nombre de la cl�nica
     */
    public String metodo4() {
        String clinicaMasOcupada = "";
        int mayorNumerodePacientes = 0;
        for (int c = 0; c < listaClinicas.size(); c++) {
            String nombreClinica = listaClinicas.get(c);
            int numeroPacientes = 0;
            
            for (int p = 0; p < pacientes.size(); p++) {
                if(pacientes.get(p).darClinica().equals(nombreClinica)){
                    numeroPacientes++;
                }
            }

            if(numeroPacientes > mayorNumerodePacientes){
                mayorNumerodePacientes = numeroPacientes;
                clinicaMasOcupada = nombreClinica;
            }

        }
        return clinicaMasOcupada;
    }


}
