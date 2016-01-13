
package fecha;

/**
 *
 * @author Hassan Er.
 */
public class Fecha {
    /**
     * Dia del mes
     */
    private int dia; // dia del mes
    private int mes; // mes
    private int anno; // año
/**
 * Constructos que recibe los datos DD/MM/AA
 * @param dia El dia 
 * @param mes El mes
 * @param anno El año
 */
    public Fecha(int dia, int mes, int anno) {
        
        this.dia = dia;
        this.mes = mes;
        this.anno = anno;
    }
    public Fecha(){
    
    }
////////   GETEER AND SETTER  ////
    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }
    
    
    public int bisiesto(){
        int dias=28;
         if ((anno %4==0 && anno % 100!=0) || anno %400==0)
             dias=29;
         return dias;
    }
    /// Fin de getter and setter ///
    /**ç
     * 
     * @param a El año 
     * @return Devuelve los dias que tiene Febrero
     */
     public int bisiesto(int a){
         int dias=28;
         if ((anno %4==0 && anno % 100!=0) || anno %400==0)
             dias=29;
         return dias;
     }
     /**
      * 
      * @param d día 
      * @param m Mes
      * @param a Año
      * @return devuelve 
      */
     public boolean comprobarFecha(int d, int m, int a){
         boolean resultado=true;
         int [] diasMes={31,28,31,30,31,30,31,30,31,30,31,30,31};
         if (a <0)
         {
             resultado= false;
         }
         else 
         {
             if (m >1 || m <diasMes[m-1])
             {
                 resultado=false;
             }
             else{
                 diasMes[1]=bisiesto(a);
                 if (d<1 || d > diasMes[m-1] ){
                 resultado=false;
             }
             }
         }
         return resultado;
     }
             
      public int  calcularNumeroOrden(){
          int orden=0;
          int [] diasMes={31,28,31,30,31,30,31,30,31,30,31,30,31};
          diasMes[1]=bisiesto();
          for (int m=0; m< mes-1;m++)
              orden=orden+diasMes[m];
          orden=orden+dia;
          return orden;
      }     
// welcome
}
