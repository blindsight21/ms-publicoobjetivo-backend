/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.publicoobjetivo.service;

import java.math.BigDecimal;
import java.util.List;
import pe.gob.mimp.publicoobjetivo.bean.FindByParamBean;
import pe.gob.mimp.publicoobjetivo.bean.PublicoObjetivoBean;

/**
 *
 * @author Omar
 */
public interface PublicoObjetivoService {

    void crearPublicoObjetivo(PublicoObjetivoBean publicoObjetivoBean) throws Exception;

    void editarPublicoObjetivo(PublicoObjetivoBean publicoObjetivoBean) throws Exception;

//    void anularPublicoObjetivo(PublicoObjetivoBean publicoObjetivoBean) throws Exception;
    String obtenerPublicoObjetivoPorId(BigDecimal nidPublicoObjetivo) throws Exception;

    List<PublicoObjetivoBean> loadPublicoObjetivoList(FindByParamBean findByParamBean) throws Exception;

    Integer getRecordCount(FindByParamBean findByParamBean) throws Exception;

    PublicoObjetivoBean find(BigDecimal id);

}
