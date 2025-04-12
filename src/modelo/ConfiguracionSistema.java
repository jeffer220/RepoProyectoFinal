/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;



/**
 *
 * @author gp
 */
public class ConfiguracionSistema {
    private String nombreEmpresa;
    private String logoEmpresa;
    private String idiomaPredeterminado;
    private String zonaHoraria;
    private int tiempoVencimientoTickets;
    private String[] nivelesPrioridad;
    

    public ConfiguracionSistema(String nombreEmpresa, String logoEmpresa, String idiomaPredeterminado, String zonaHoraria, int tiempoVencimientoTickets, String[] nivelesPrioridad) {
        this.nombreEmpresa = nombreEmpresa;
        this.logoEmpresa = logoEmpresa;
        this.idiomaPredeterminado = idiomaPredeterminado;
        this.zonaHoraria = zonaHoraria;
        this.tiempoVencimientoTickets = tiempoVencimientoTickets;
        this.nivelesPrioridad = nivelesPrioridad;
    }
    
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getLogoEmpresa() {
        return logoEmpresa;
    }

    public void setLogoEmpresa(String logoEmpresa) {
        this.logoEmpresa = logoEmpresa;
    }

    public String getIdiomaPredeterminado() {
        return idiomaPredeterminado;
    }

    public void setIdiomaPredeterminado(String idiomaPredeterminado) {
        this.idiomaPredeterminado = idiomaPredeterminado;
    }

    public String getZonaHoraria() {
        return zonaHoraria;
    }

    public void setZonaHoraria(String zonaHoraria) {
        this.zonaHoraria = zonaHoraria;
    }

    public int getTiempoVencimientoTickets() {
        return tiempoVencimientoTickets;
    }

    public void setTiempoVencimientoTickets(int tiempoVencimientoTickets) {
        this.tiempoVencimientoTickets = tiempoVencimientoTickets;
    }

    public String[] getNivelesPrioridad() {
        return nivelesPrioridad;
    }

    public void setNivelesPrioridad(String[] nivelesPrioridad) {
        this.nivelesPrioridad = nivelesPrioridad;
    }
    
    
}
