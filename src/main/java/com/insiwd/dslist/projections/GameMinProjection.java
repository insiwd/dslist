package com.insiwd.dslist.projections;

public interface GameMinProjection {

    // vamos colocar métodos get para cada dado que a consulta retorna
    Long getId();
    String getTitle();
    Integer getYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();
}
