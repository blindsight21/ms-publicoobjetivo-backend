/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.publicoobjetivo.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.siscap.model.PublicoObjetivo;
import pe.gob.mimp.siscap.repository.publicoobjetivo.PublicoObjRepository;
import pe.gob.mimp.publicoobjetivo.bean.FindByParamBean;
import pe.gob.mimp.publicoobjetivo.bean.PublicoObjetivoBean;
import pe.gob.mimp.publicoobjetivo.converter.PublicoObjetivoCast;
import pe.gob.mimp.publicoobjetivo.util.Util;
import pe.gob.mimp.publicoobjetivo.service.PublicoObjetivoService;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class PublicoObjetivoServiceImpl implements PublicoObjetivoService {

    @Autowired
    private PublicoObjRepository publicoObjetivoRepository;

    @Override
    public void crearPublicoObjetivo(PublicoObjetivoBean publicoObjetivoBean) throws Exception {

        PublicoObjetivo publicoObjetivo = new PublicoObjetivo();
        publicoObjetivo.setTxtPublicoObjetivo(publicoObjetivoBean.getTxtPublicoObjetivo());
        publicoObjetivo.setNidUsuario(publicoObjetivoBean.getNidUsuario());
        publicoObjetivo.setTxtPc(publicoObjetivoBean.getTxtPc());
        publicoObjetivo.setTxtIp(publicoObjetivoBean.getTxtIp());
        publicoObjetivo.setFecEdicion(publicoObjetivoBean.getFecEdicion());
        publicoObjetivo.setFlgActivo(publicoObjetivoBean.getFlgActivo());

        publicoObjetivoRepository.save(publicoObjetivo);

    }

    @Override
    public void editarPublicoObjetivo(PublicoObjetivoBean publicoObjetivoBean) {

        PublicoObjetivo publicoObjetivo = new PublicoObjetivo();

        publicoObjetivo.setNidPublicoObjetivo(publicoObjetivoBean.getNidPublicoObjetivo());
        publicoObjetivo.setTxtPublicoObjetivo(publicoObjetivoBean.getTxtPublicoObjetivo());
        publicoObjetivo.setNidUsuario(publicoObjetivoBean.getNidUsuario());
        publicoObjetivo.setTxtPc(publicoObjetivoBean.getTxtPc());
        publicoObjetivo.setTxtIp(publicoObjetivoBean.getTxtIp());
        publicoObjetivo.setFecEdicion(publicoObjetivoBean.getFecEdicion());
        publicoObjetivo.setFlgActivo(publicoObjetivoBean.getFlgActivo());

        publicoObjetivoRepository.save(publicoObjetivo);

    }

    @Override
    public String obtenerPublicoObjetivoPorId(BigDecimal nidPublicoObjetivo) throws Exception {

        Optional<PublicoObjetivo> publicoObjetivo = publicoObjetivoRepository.findById(nidPublicoObjetivo);

        if (publicoObjetivo.isPresent()) {
            return publicoObjetivo.get().getTxtPublicoObjetivo();
        }

        return "";
    }

    @Override
    public List<PublicoObjetivoBean> loadPublicoObjetivoList(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }

        List<PublicoObjetivo> publicoObjetivoList = publicoObjetivoRepository.findByParams(findByParamBean.getParameters(), findByParamBean.getOrderBy());

        if (!Util.esListaVacia(publicoObjetivoList)) {

            return publicoObjetivoList.stream().map(publicoObjetivo -> {
                PublicoObjetivoBean publicoObjetivoBean = new PublicoObjetivoBean();
                publicoObjetivoBean.setNidPublicoObjetivo(publicoObjetivo.getNidPublicoObjetivo());
                publicoObjetivoBean.setTxtPublicoObjetivo(publicoObjetivo.getTxtPublicoObjetivo());
                publicoObjetivoBean.setNidUsuario(publicoObjetivo.getNidUsuario());
                publicoObjetivoBean.setTxtPc(publicoObjetivo.getTxtPc());
                publicoObjetivoBean.setTxtIp(publicoObjetivo.getTxtIp());
                publicoObjetivoBean.setFecEdicion(publicoObjetivo.getFecEdicion());
                publicoObjetivoBean.setFlgActivo(publicoObjetivo.getFlgActivo());
                return publicoObjetivoBean;
            }).collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public Integer getRecordCount(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }
        Integer count = publicoObjetivoRepository.getRecordCount(findByParamBean.getParameters());
        return count;
    }

    @Override
    public PublicoObjetivoBean find(BigDecimal id) {

        Optional<PublicoObjetivo> publicoObjetivo = publicoObjetivoRepository.findById(id);

        if (!publicoObjetivo.isPresent()) {
            return null;
        }

        return PublicoObjetivoCast.castPublicoObjetivoToPublicoObjetivoBean(publicoObjetivo.get());

    }

}
