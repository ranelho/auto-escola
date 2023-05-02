package com.rlti.autoescola.agenda.domain;

public enum HorarioAula {
    H8(8, "8h"),
    H9(9, "9h"),
    H10(10, "10h"),
    H11(11, "11h"),
    H12(12, "12h"),
    H13(13, "13h"),
    H14(14, "14h"),
    H15(15, "15h"),
    H16(16, "16h"),
    H17(17, "17h"),
    H18(18, "18h");

    private final int hora;
    private final String descricao;

    HorarioAula(int hora, String descricao) {
        this.hora = hora;
        this.descricao = descricao;
    }

    public int getHora() {
        return hora;
    }

    public String getDescricao() {
        return descricao;
    }
}
