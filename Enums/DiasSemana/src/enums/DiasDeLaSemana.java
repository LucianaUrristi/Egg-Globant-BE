public enum DiasDeLaSemana {
    LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO;

    public boolean esDiaLaboral(){
        if (this == SABADO || this == DOMINGO){
            return false;
        }else{
            return true;
        }
    }
}
