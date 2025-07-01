/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labintec.dev.demo.dto;

import labintec.dev.demo.entity.Tramite;

/**
 *
 * @author Micaela
 */
public class TramiteMapper {
    
    // Convierte un objeto Tramite (entidad) a un TramiteDTO (objeto de transferencia de datos)
    public static TramiteDTO toDTO(Tramite tramite) {
        if (tramite == null)
            return null;
        TramiteDTO dto = new TramiteDTO();
        dto.setId(tramite.getId());
        dto.setTipo(tramite.getTipo());
        dto.setEstado(tramite.getEstado());
        dto.setDescripcion(tramite.getDescripcion());
        return dto;
    }
    
    // Convierte un TramiteDTO a una entidad Tramite
    public static Tramite toTramite(TramiteDTO tramitedto) {
        if (tramitedto == null)
            return null;
        Tramite tramite = new Tramite();
        tramite.setId(tramitedto.getId());
        tramite.setTipo(tramitedto.getTipo());
        tramite.setEstado(tramitedto.getEstado());
        tramite.setDescripcion(tramitedto.getDescripcion());
        return tramite;
    }
    
    // También convierte un DTO en una entidad Tramite (igual que toTramite)
    // Puede existir para compatibilidad o para diferenciar entre contexto de uso (semántica)
    public static Tramite toEntity(TramiteDTO tramitedto){
        Tramite entity = new Tramite();
        entity.setId(tramitedto.getId());
        entity.setTipo(tramitedto.getTipo());
        entity.setEstado(tramitedto.getEstado());
        entity.setDescripcion(tramitedto.getDescripcion());
        return entity;
    }
}
