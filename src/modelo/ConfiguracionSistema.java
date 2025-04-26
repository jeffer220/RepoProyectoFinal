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
    private String idiomaPredeterminado;
    private String zonaHoraria;
    private String rutaLogo;
    //private int tiempoVencimientoTickets;
    //private String[] nivelesPrioridad;
    
    public ConfiguracionSistema(){}

    public ConfiguracionSistema(String nombreEmpresa, String idiomaPredeterminado, String rutaLogo) {
        this.nombreEmpresa = nombreEmpresa;
        this.idiomaPredeterminado = idiomaPredeterminado;
        this.rutaLogo = rutaLogo;
        
    }
    
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
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

    public String getRutaLogo() {
        return rutaLogo;
    }

    public void setRutaLogo(String rutaLogo) {
        this.rutaLogo = rutaLogo;
    }
 
    
}
