package com.rlti.autoescola.agenda.domain;

public enum HorarioAula {
    H8(8), H9(9), H10(10), H11(11), H12(12), H13(13), H14(14), H15(15), H16(16), H17(17), H18(18);

    private final int hora;

    HorarioAula(int hora) {
        this.hora = hora;
    }
    public int getHora(){
        return hora;
    }
}
