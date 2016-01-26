
/*
 * Paquete fecha que vamos a utilizar para crear una clase fecha y verificar  
 * que las fechas introducidas esten correctas y realizar diferentes operaciones 
 * con las fechas
 */
package fecha;

/**
 * Clase fecha
 * @author Admin
 */
public class Fecha 
{//INICIO CLASE FECHA
        
    private int dia;
    private int mes;
    private int anno;
    static private int [] diasMes={31,28,31,30,31,30,31,31,30,31,30,31};

    public Fecha() {
    }

    
    /**
     * @return the dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @return the anno
     */
    public int getAnno() {
        return anno;
    }
   
    /**
     * @param anno the anno to set
     */
    public void setAnno(int anno) {
        this.anno = anno;
    }
    
    public int bisiesto()
    {
        int dias=28;
        if((anno%4==0 && anno%100!=0)|| (anno%400==0))
        {
            dias=29;
        }
        return dias;
    }
    
    public int bisiesto(int a)
    {
        int dias=28;
        if((a%4==0 && a%100!=0)|| (a%400==0))
        {
            dias=29;
        }
        return dias;
    }
    
    /**
     * metodo que comprueba que la fecha que se ha introducido es la correcta
     * @param d
     * @param m
     * @param a
     * @return 
     */
    public boolean comprobarFecha(int d, int m, int a)
    {//inicio comprobarFecha
        boolean resultado=true;
        if (a<0)
            resultado=false;
        else 
        {
            if (m<1 || m>12)
                resultado=false;
            else
            {
                diasMes[1]=bisiesto(a);
                if(d<1 || d>diasMes[m-1])
                    resultado=false;
            }
        }
        
        return resultado;
    }//fin comprobarFecha
    
    /**
     * metodo que calcula los dias que han pasado del año hasta la fecha que 
     * introducimos
     * @return los dias del año que han pasado hasta la fecha
     */
    public int diaspasanAno()
    {//metodo diaspasanAno
        int diasHastaFecha=0;//vble para acumular los dias que han pasado
        int mes;//vble para ir recorriendo los meses
        diasMes[1]=bisiesto(anno);//compruebo si el año es bisiesto 
        for (mes=1;mes<this.mes;mes++)//bucle que recorre el vector diasMes
        {//inicio for
            //acumulo los dias del mes hasta que llege al introducido
            diasHastaFecha=diasHastaFecha+diasMes[mes-1];
        }//fin for
        diasHastaFecha=diasHastaFecha+dia;//acumulo los dias del mes no completo
        return diasHastaFecha;
    }//fin metodo diaspasanAnno   
    
    /**
     * 
     * 
     * @return 
     */
    public int diasQuedanAno()
    {
        int diasDesdeFecha=0;
        int mes;
        diasMes[1]=bisiesto(anno);
        diasDesdeFecha=diasMes[this.mes-1]-dia;
        for (mes=this.mes+1;mes<=12;mes++)
        {
            diasDesdeFecha=diasDesdeFecha+diasMes[mes-1];
        }
        return diasDesdeFecha;   
    }
    
    /**
     * metodo de maria Jesus
     * @return 
     */
    public int calcularNumeroOrden()
    {
        int orden=0;
        diasMes[1]=bisiesto();
        for (int m=0; m<mes-1;m++)
        {
            orden=orden+diasMes[m];
        }
        orden=orden+dia;
        return orden;
    }
    public int compararFechas(Fecha fecha) {
        int resultado = 0;
        if (anno < fecha.anno) {
            resultado = 1;
        } else {
            if (this.anno > fecha.anno) {
                resultado = 2;
            } else {
                if (this.mes < fecha.mes) {
                    resultado = 1;
                } else {
                    if (mes > fecha.mes) {
                        resultado = 2;
                    } else {
                        if (dia < fecha.dia) {
                            resultado = 1;
                        } else {
                            if (dia > fecha.dia) {
                                resultado = 2;
                            } else {
                                resultado = 0;
                            }
                        }
                    }
                }
            }
        }
        return resultado;
    }
    
    public int calcularDistancia(Fecha fecha2) {
        int m;
        int dias = 0;
         int anocopy=anno+1;
         int valor=0;
        if (anno == fecha2.getAnno())
        {
            dias = fecha2.getDia() - dia;
        
            if (mes == fecha2.getMes()) 
            {
            dias = diasMes[mes - 1] - dia;
            m = mes;
            
            while (m < (fecha2.getMes() - 1)) {
                dias += diasMes[m];
                m++;
            }
            }
        }
        else {

            dias = this.diasQuedanAno();
            dias += fecha2.diaspasanAno();

            while (anocopy < fecha2.getAnno()) {
                
                valor = bisiesto(anocopy);
                switch (valor) {
                    case 28:
                        dias += 365;
                        break;
                    default:
                        dias += 366;
                        break;
                }
                anocopy++;
            }
        }
    
    return dias ;
}
    public void metodo(){
        System.out.print("Rama primera");
    }
    

}//fin clase FECHA

