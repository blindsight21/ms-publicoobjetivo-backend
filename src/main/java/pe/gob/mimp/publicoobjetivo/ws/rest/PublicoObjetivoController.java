/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.publicoobjetivo.ws.rest;

import java.math.BigDecimal;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.mimp.publicoobjetivo.bean.FindByParamBean;

import pe.gob.mimp.publicoobjetivo.bean.ResponseData;
import pe.gob.mimp.publicoobjetivo.bean.PublicoObjetivoBean;
import pe.gob.mimp.publicoobjetivo.service.PublicoObjetivoService;

/**
 *
 * @author BlindSight
 */
@RestController
@RequestMapping(value = "/")
public class PublicoObjetivoController {

    @Autowired
    private PublicoObjetivoService publicoObjetivoService;

    @PostMapping(value = "/crearPublicoObjetivo", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> crearPublicoObjetivo(@RequestBody PublicoObjetivoBean publicoObjetivoBean) throws Exception {

        publicoObjetivoService.crearPublicoObjetivo(publicoObjetivoBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.CREATED.value());
        response.setMsg(HttpStatus.CREATED.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/editarPublicoObjetivo", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> editarPublicoObjetivo(@RequestBody PublicoObjetivoBean publicoObjetivoBean) throws Exception {

        publicoObjetivoService.editarPublicoObjetivo(publicoObjetivoBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/obtenerPublicoObjetivoPorId/{nidPublicoObjetivo}")
    public ResponseEntity<ResponseData<?>> obtenerPublicoObjetivoPorId(@PathVariable("nidPublicoObjetivo") BigDecimal nidPublicoObjetivo) throws Exception {

        String txtPublicoObjetivo = publicoObjetivoService.obtenerPublicoObjetivoPorId(nidPublicoObjetivo);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(txtPublicoObjetivo);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/loadPublicoObjetivoList", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> loadPublicoObjetivoList(@RequestBody FindByParamBean findByParamBean) throws Exception {

        List<PublicoObjetivoBean> publicoObjetivoList = publicoObjetivoService.loadPublicoObjetivoList(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(publicoObjetivoList);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/getRecordCount", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> getRecordCount(@RequestBody FindByParamBean findByParamBean) throws Exception {

        Integer count = publicoObjetivoService.getRecordCount(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(count);

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<ResponseData<?>> find(@PathVariable("id") BigDecimal id) throws Exception {

        PublicoObjetivoBean publicoObjetivoBean = publicoObjetivoService.find(id);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(publicoObjetivoBean);

        return ResponseEntity.ok(response);

    }

}
