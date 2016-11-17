public class DisplayHoraYFecha
{
    private DisplayDosDigitos dia;

    private DisplayDosDigitos mes;

    private DisplayDosDigitos anno;
    
    private NumberDisplay hora;
    
    private NumberDisplay minuto;
    
    private boolean mostrarFecha;
    
    private boolean mostrarHora;

    public DisplayHoraYFecha(boolean mostrarLaFecha, boolean mostrarLaHora)
   {
    dia = new DisplayDosDigitos(31);
    mes = new DisplayDosDigitos(13);
    anno = new DisplayDosDigitos(100);
    hora = new NumberDisplay(24);
    minuto = new NumberDisplay(60);
    mostrarFecha = mostrarLaFecha;
    mostrarHora = mostrarLaHora;
   }
   public void avanzarMomento()
   {
        minuto.increment();
        if(minuto.getValue() == 0) {
            hora.increment();
            if(hora.getValue() == 0 && minuto.getValue() == 0) {
                dia.incrementaValor();
                if(dia.getValor() == 1) {
                    mes.incrementaValor();
                    if(mes.getValor() == 1) {
                        anno.incrementaValor();
                    }
                }
            }
        }
   }
   public void setMomento(int nuevoDia, int nuevoMes, int nuevoAnno, int nuevaHora, int nuevoMinuto)
    {
        if(nuevaHora >= 0 && nuevaHora < 24 && nuevoMinuto >=0 && nuevoMinuto <60 && nuevoDia >=1 && nuevoDia <31 && nuevoMes >=1 && nuevoMes <13 && nuevoAnno >=1 && nuevoAnno <100) {
           hora.setValue(nuevaHora);
           minuto.setValue(nuevoMinuto);
           dia.setValor(nuevoDia);
           mes.setValor(nuevoMes);
           anno.setValor(nuevoAnno);
        }
    }
   public String getMomento()
    {
        String mostrarCadena = "";
        if(mostrarHora == true && mostrarFecha == true) {
            mostrarCadena = hora.getDisplayValue() + ":" + minuto.getDisplayValue() + " " + dia.getValorDelDisplay() + "/" + mes.getValorDelDisplay() + "/" + anno.getValorDelDisplay();
        }
        if(mostrarHora == true && mostrarFecha == false) {
            mostrarCadena = hora.getDisplayValue() + ":" + minuto.getDisplayValue();
        }
        if(mostrarHora == false && mostrarFecha == true) {
            mostrarCadena = dia.getValorDelDisplay() + "/" + mes.getValorDelDisplay() + "/" + anno.getValorDelDisplay();
        }
        if(mostrarHora == false && mostrarFecha == false) {
            mostrarCadena = "";
        }
        return mostrarCadena;
    }
}