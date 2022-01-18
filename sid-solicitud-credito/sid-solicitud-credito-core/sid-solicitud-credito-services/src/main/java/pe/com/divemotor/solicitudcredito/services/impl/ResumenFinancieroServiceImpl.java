package pe.com.divemotor.solicitudcredito.services.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.divemotor.generico.dto.BaseResponse;

import pe.com.divemotor.generico.dto.HeaderParams;
import pe.com.divemotor.solicitudcredito.dao.ResumenFinancieroDAO;
import pe.com.divemotor.solicitudcredito.dto.procedure.resumenFinanciero.InsertarResumenFinancieroMaturityProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.resumenFinanciero.InsertarResumenFinancieroProcedure;
import pe.com.divemotor.solicitudcredito.dto.procedure.resumenFinanciero.ListarResumenFinancieroProcedure;
import pe.com.divemotor.solicitudcredito.dto.request.ResumenFinancieroMaturityRequest;
import pe.com.divemotor.solicitudcredito.dto.request.ResumenFinancieroRequest;
import pe.com.divemotor.solicitudcredito.dto.response.ResumenFinancieroListadoResponse;
import pe.com.divemotor.solicitudcredito.services.ResumenFinancieroService;

@Service
@Transactional
public class ResumenFinancieroServiceImpl implements ResumenFinancieroService {

    private ResumenFinancieroDAO resumenFinancieroDAO;
    private Mapper mapper;

    //@Transactional(readOnly = true)
    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setResumenFinancieroDAO(ResumenFinancieroDAO resumenFinancieroDAO) {
        this.resumenFinancieroDAO = resumenFinancieroDAO;
    }
    
    @Transactional(readOnly = true)
    @Override
    public ResumenFinancieroListadoResponse listar(HeaderParams headerParams, String codSoliCred, String codcliente) throws Exception {
		
        ListarResumenFinancieroProcedure parametros = mapper.map(headerParams, ListarResumenFinancieroProcedure.class);
        parametros.setCodSoliCred(codSoliCred);
        parametros.setCodcliente(codcliente);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        this.resumenFinancieroDAO.listar(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            ResumenFinancieroListadoResponse response = new ResumenFinancieroListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            response.setResumenFinancieroMaturity(parametros.getBusquedaMat());
            response.setFecSolicitudUltima(parametros.getFecSolicitudUltima());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }

    }
    
  @Transactional(readOnly = true)
    @Override
    public ResumenFinancieroListadoResponse listarRangos(HeaderParams headerParams, String codSoliCred, String codcliente,String anioSup,String anioInf) throws Exception {
		
        ListarResumenFinancieroProcedure parametros = mapper.map(headerParams, ListarResumenFinancieroProcedure.class);
        parametros.setCodSoliCred(codSoliCred);
        parametros.setCodcliente(codcliente);
        parametros.setAnioSup(anioSup);
        parametros.setAnioInf(anioInf);
        parametros.setCodUsuario(headerParams.getCodUsuario());
        parametros.setIdUsuario(headerParams.getIdUsuario());
        this.resumenFinancieroDAO.listarRangos(parametros);

        Integer statusQuery = parametros.getStatus();
        if (statusQuery.equals(1)) {
            ResumenFinancieroListadoResponse response = new ResumenFinancieroListadoResponse();
            response.setEstadoTrama(String.valueOf(parametros.getStatus()));
            response.setMensaje(parametros.getMensaje());
            response.setListado(parametros.getBusqueda());
            response.setFecSolicitudUltima(parametros.getFecSolicitudUltima());
            return response;
        } else {
            throw new Exception(parametros.getMensaje());

        }

    }    
    
    @Override
    public BaseResponse insertar(HeaderParams headerParams, ResumenFinancieroRequest request) throws Exception {
        InsertarResumenFinancieroProcedure procedureParams = new InsertarResumenFinancieroProcedure();
        if(request.getValegypvtastota()!=null && !request.getValegypvtastota().trim().equals(""))procedureParams.setValegypvtastota(Double.parseDouble(request.getValegypvtastota()));
        if(request.getValegypcostvtasserv()!=null && !request.getValegypcostvtasserv().trim().equals(""))procedureParams.setValegypcostvtasserv(Double.parseDouble(request.getValegypcostvtasserv()));
        if(request.getValegyputilbrut()!=null && !request.getValegyputilbrut().trim().equals(""))procedureParams.setValegyputilbrut(Double.parseDouble(request.getValegyputilbrut()));
        if(request.getValegypgastvtas()!=null && !request.getValegypgastvtas().trim().equals(""))procedureParams.setValegypgastvtas(Double.parseDouble(request.getValegypgastvtas()));
        if(request.getValegypgastadmi()!=null && !request.getValegypgastadmi().trim().equals(""))procedureParams.setValegypgastadmi(Double.parseDouble(request.getValegypgastadmi()));
        if(request.getValegypotroingrgast()!=null && !request.getValegypotroingrgast().trim().equals(""))procedureParams.setValegypotroingrgast(Double.parseDouble(request.getValegypotroingrgast()));
        if(request.getValegyputiloper()!=null && !request.getValegyputiloper().trim().equals(""))procedureParams.setValegyputiloper(Double.parseDouble(request.getValegyputiloper()));
        if(request.getValegypgastfina()!=null && !request.getValegypgastfina().trim().equals(""))procedureParams.setValegypgastfina(Double.parseDouble(request.getValegypgastfina()));
        if(request.getValegypingrfina()!=null && !request.getValegypingrfina().trim().equals(""))procedureParams.setValegypingrfina(Double.parseDouble(request.getValegypingrfina()));
        if(request.getValegyppartrela()!=null && !request.getValegyppartrela().trim().equals(""))procedureParams.setValegyppartrela(Double.parseDouble(request.getValegyppartrela()));
        if(request.getValegyputilordi()!=null && !request.getValegyputilordi().trim().equals(""))procedureParams.setValegyputilordi(Double.parseDouble(request.getValegyputilordi()));
        if(request.getValegypingrextrccja()!=null && !request.getValegypingrextrccja().trim().equals(""))procedureParams.setValegypingrextrccja(Double.parseDouble(request.getValegypingrextrccja()));
        if(request.getValegypegreextrccaja()!=null && !request.getValegypegreextrccaja().trim().equals(""))procedureParams.setValegypegreextrccaja(Double.parseDouble(request.getValegypegreextrccaja()));
        if(request.getValegypingrextrscja()!=null && !request.getValegypingrextrscja().trim().equals(""))procedureParams.setValegypingrextrscja(Double.parseDouble(request.getValegypingrextrscja()));
        if(request.getValegypegreextrscja()!=null && !request.getValegypegreextrscja().trim().equals(""))procedureParams.setValegypegreextrscja(Double.parseDouble(request.getValegypegreextrscja()));
        if(request.getValegypotroingr()!=null && !request.getValegypotroingr().trim().equals(""))procedureParams.setValegypotroingr(Double.parseDouble(request.getValegypotroingr()));
        if(request.getValegypotroegre()!=null && !request.getValegypotroegre().trim().equals(""))procedureParams.setValegypotroegre(Double.parseDouble(request.getValegypotroegre()));
        if(request.getValegyputilanteimp()!=null && !request.getValegyputilanteimp().trim().equals(""))procedureParams.setValegyputilanteimp(Double.parseDouble(request.getValegyputilanteimp()));
        if(request.getValegypimppart()!=null && !request.getValegypimppart().trim().equals(""))procedureParams.setValegypimppart(Double.parseDouble(request.getValegypimppart()));
        if(request.getValegyputilperdneta()!=null && !request.getValegyputilperdneta().trim().equals(""))procedureParams.setValegyputilperdneta(Double.parseDouble(request.getValegyputilperdneta()));
        if(request.getValraticapitrab()!=null && !request.getValraticapitrab().trim().equals(""))procedureParams.setValraticapitrab(Double.parseDouble(request.getValraticapitrab()));
        if(request.getValratidiasexist()!=null && !request.getValratidiasexist().trim().equals(""))procedureParams.setValratidiasexist(Double.parseDouble(request.getValratidiasexist()));
        if(request.getValraticobrclie()!=null && !request.getValraticobrclie().trim().equals(""))procedureParams.setValraticobrclie(Double.parseDouble(request.getValraticobrclie()));
        if(request.getValratipagoprov()!=null && !request.getValratipagoprov().trim().equals(""))procedureParams.setValratipagoprov(Double.parseDouble(request.getValratipagoprov()));
        if(request.getValraticicloper()!=null && !request.getValraticicloper().trim().equals(""))procedureParams.setValraticicloper(Double.parseDouble(request.getValraticicloper()));
        if(request.getValratipasitotapatr()!=null && !request.getValratipasitotapatr().trim().equals(""))procedureParams.setValratipasitotapatr(Double.parseDouble(request.getValratipasitotapatr()));
        if(request.getValratideudfinabrut()!=null && !request.getValratideudfinabrut().trim().equals(""))procedureParams.setValratideudfinabrut(Double.parseDouble(request.getValratideudfinabrut()));
        if(request.getValratideudfinaestr()!=null && !request.getValratideudfinaestr().trim().equals(""))procedureParams.setValratideudfinaestr(Double.parseDouble(request.getValratideudfinaestr()));
        if(request.getValratiporcvarvtas()!=null && !request.getValratiporcvarvtas().trim().equals(""))procedureParams.setValratiporcvarvtas(Double.parseDouble(request.getValratiporcvarvtas()));
        if(request.getValratiebitdaanual()!=null && !request.getValratiebitdaanual().trim().equals(""))procedureParams.setValratiebitdaanual(Double.parseDouble(request.getValratiebitdaanual()));
        if(request.getValratiporcebitdavtas()!=null && !request.getValratiporcebitdavtas().trim().equals(""))procedureParams.setValratiporcebitdavtas(Double.parseDouble(request.getValratiporcebitdavtas()));
        if(request.getValratiporcroe()!=null && !request.getValratiporcroe().trim().equals(""))procedureParams.setValratiporcroe(Double.parseDouble(request.getValratiporcroe()));
        if(request.getValratiporcroa()!=null && !request.getValratiporcroa().trim().equals(""))procedureParams.setValratiporcroa(Double.parseDouble(request.getValratiporcroa()));
        if(request.getValraticashflow()!=null && !request.getValraticashflow().trim().equals(""))procedureParams.setValraticashflow(Double.parseDouble(request.getValraticashflow()));
        if(request.getValratiporccashflowvtas()!=null && !request.getValratiporccashflowvtas().trim().equals(""))procedureParams.setValratiporccashflowvtas(Double.parseDouble(request.getValratiporccashflowvtas()));
        if(request.getValratideudfinabrutanos()!=null && !request.getValratideudfinabrutanos().trim().equals(""))procedureParams.setValratideudfinabrutanos(Double.parseDouble(request.getValratideudfinabrutanos()));
        if(request.getValratideudfinaestranos()!=null && !request.getValratideudfinaestranos().trim().equals(""))procedureParams.setValratideudfinaestranos(Double.parseDouble(request.getValratideudfinaestranos()));
        if(request.getValratideudfinaebitda()!=null && !request.getValratideudfinaebitda().trim().equals(""))procedureParams.setValratideudfinaebitda(Double.parseDouble(request.getValratideudfinaebitda()));
        if(request.getValratiebitda()!=null && !request.getValratiebitda().trim().equals(""))procedureParams.setValratiebitda(Double.parseDouble(request.getValratiebitda()));
        if(request.getValratidepramorejer()!=null && !request.getValratidepramorejer().trim().equals(""))procedureParams.setValratidepramorejer(Double.parseDouble(request.getValratidepramorejer()));
        if(request.getValratidivi()!=null && !request.getValratidivi().trim().equals(""))procedureParams.setValratidivi(Double.parseDouble(request.getValratidivi()));
        if(request.getValratinromese()!=null && !request.getValratinromese().trim().equals(""))procedureParams.setValratinromese(Double.parseDouble(request.getValratinromese()));
        if(request.getValbgaccajabcos()!=null && !request.getValbgaccajabcos().trim().equals(""))procedureParams.setValbgaccajabcos(Double.parseDouble(request.getValbgaccajabcos()));
        if(request.getValbgacvalonego()!=null && !request.getValbgacvalonego().trim().equals(""))procedureParams.setValbgacvalonego(Double.parseDouble(request.getValbgacvalonego()));
        if(request.getValbgacclie()!=null && !request.getValbgacclie().trim().equals(""))procedureParams.setValbgacclie(Double.parseDouble(request.getValbgacclie()));
        if(request.getValbgacprovcobrdud()!=null && !request.getValbgacprovcobrdud().trim().equals(""))procedureParams.setValbgacprovcobrdud(Double.parseDouble(request.getValbgacprovcobrdud()));
        if(request.getValbgaccxcsrel()!=null && !request.getValbgaccxcsrel().trim().equals(""))procedureParams.setValbgaccxcsrel(Double.parseDouble(request.getValbgaccxcsrel()));
        if(request.getValbgaccxcdive()!=null && !request.getValbgaccxcdive().trim().equals(""))procedureParams.setValbgaccxcdive(Double.parseDouble(request.getValbgaccxcdive()));
        if(request.getValbgacexist()!=null && !request.getValbgacexist().trim().equals(""))procedureParams.setValbgacexist(Double.parseDouble(request.getValbgacexist()));
        if(request.getValbgacgastpagaanti()!=null && !request.getValbgacgastpagaanti().trim().equals(""))procedureParams.setValbgacgastpagaanti(Double.parseDouble(request.getValbgacgastpagaanti()));
        if(request.getValbgac()!=null && !request.getValbgac().trim().equals(""))procedureParams.setValbgac(Double.parseDouble(request.getValbgac()));
        if(request.getValbgancinverela()!=null && !request.getValbgancinverela().trim().equals(""))procedureParams.setValbgancinverela(Double.parseDouble(request.getValbgancinverela()));
        if(request.getValbgancotrainve()!=null && !request.getValbgancotrainve().trim().equals(""))procedureParams.setValbgancotrainve(Double.parseDouble(request.getValbgancotrainve()));
        if(request.getValbganccxcsrel()!=null && !request.getValbganccxcsrel().trim().equals(""))procedureParams.setValbganccxcsrel(Double.parseDouble(request.getValbganccxcsrel()));
        if(request.getValbgancinmuneto()!=null && !request.getValbgancinmuneto().trim().equals(""))procedureParams.setValbgancinmuneto(Double.parseDouble(request.getValbgancinmuneto()));
        if(request.getValbgancterr()!=null && !request.getValbgancterr().trim().equals(""))procedureParams.setValbgancterr(Double.parseDouble(request.getValbgancterr()));
        if(request.getValbgancedif()!=null && !request.getValbgancedif().trim().equals(""))procedureParams.setValbgancedif(Double.parseDouble(request.getValbgancedif()));
        if(request.getValbgancmaqu()!=null && !request.getValbgancmaqu().trim().equals(""))procedureParams.setValbgancmaqu(Double.parseDouble(request.getValbgancmaqu()));
        if(request.getValbgancmueb()!=null && !request.getValbgancmueb().trim().equals(""))procedureParams.setValbgancmueb(Double.parseDouble(request.getValbgancmueb()));
        if(request.getValbgancunidtrans()!=null && !request.getValbgancunidtrans().trim().equals(""))procedureParams.setValbgancunidtrans(Double.parseDouble(request.getValbgancunidtrans()));
        if(request.getValbgancequidive()!=null && !request.getValbgancequidive().trim().equals(""))procedureParams.setValbgancequidive(Double.parseDouble(request.getValbgancequidive()));
        if(request.getValbgancdepracum()!=null && !request.getValbgancdepracum().trim().equals(""))procedureParams.setValbgancdepracum(Double.parseDouble(request.getValbgancdepracum()));
        if(request.getValbganctrab()!=null && !request.getValbganctrab().trim().equals(""))procedureParams.setValbganctrab(Double.parseDouble(request.getValbganctrab()));
        if(request.getValbgancotroacti()!=null && !request.getValbgancotroacti().trim().equals(""))procedureParams.setValbgancotroacti(Double.parseDouble(request.getValbgancotroacti()));
        if(request.getValbgancintan()!=null && !request.getValbgancintan().trim().equals(""))procedureParams.setValbgancintan(Double.parseDouble(request.getValbgancintan()));
        if(request.getValbgancotroanc()!=null && !request.getValbgancotroanc().trim().equals(""))procedureParams.setValbgancotroanc(Double.parseDouble(request.getValbgancotroanc()));
        if(request.getValbganc()!=null && !request.getValbganc().trim().equals(""))procedureParams.setValbganc(Double.parseDouble(request.getValbganc()));
        if(request.getValbgtotaacti()!=null && !request.getValbgtotaacti().trim().equals(""))procedureParams.setValbgtotaacti(Double.parseDouble(request.getValbgtotaacti()));
        if(request.getValbgpcbancdeudfinacp()!=null && !request.getValbgpcbancdeudfinacp().trim().equals(""))procedureParams.setValbgpcbancdeudfinacp(Double.parseDouble(request.getValbgpcbancdeudfinacp()));
        if(request.getValbgpcotradeudfinacp()!=null && !request.getValbgpcotradeudfinacp().trim().equals(""))procedureParams.setValbgpcotradeudfinacp(Double.parseDouble(request.getValbgpcotradeudfinacp()));
        if(request.getValbgpcdeudlp()!=null && !request.getValbgpcdeudlp().trim().equals(""))procedureParams.setValbgpcdeudlp(Double.parseDouble(request.getValbgpcdeudlp()));
        if(request.getValbgpctribpaga()!=null && !request.getValbgpctribpaga().trim().equals(""))procedureParams.setValbgpctribpaga(Double.parseDouble(request.getValbgpctribpaga()));
        if(request.getValbgpcremupaga()!=null && !request.getValbgpcremupaga().trim().equals(""))procedureParams.setValbgpcremupaga(Double.parseDouble(request.getValbgpcremupaga()));
        if(request.getValbgpcprov()!=null && !request.getValbgpcprov().trim().equals(""))procedureParams.setValbgpcprov(Double.parseDouble(request.getValbgpcprov()));
        if(request.getValbgpccxpsrel()!=null && !request.getValbgpccxpsrel().trim().equals(""))procedureParams.setValbgpccxpsrel(Double.parseDouble(request.getValbgpccxpsrel()));
        if(request.getValbgpccxpdive()!=null && !request.getValbgpccxpdive().trim().equals(""))procedureParams.setValbgpccxpdive(Double.parseDouble(request.getValbgpccxpdive()));
        if(request.getValbgpc()!=null && !request.getValbgpc().trim().equals(""))procedureParams.setValbgpc(Double.parseDouble(request.getValbgpc()));
        if(request.getValbgpncbcosdeudfinalp()!=null && !request.getValbgpncbcosdeudfinalp().trim().equals(""))procedureParams.setValbgpncbcosdeudfinalp(Double.parseDouble(request.getValbgpncbcosdeudfinalp()));
        if(request.getValbgpncotradeudfinalp()!=null && !request.getValbgpncotradeudfinalp().trim().equals(""))procedureParams.setValbgpncotradeudfinalp(Double.parseDouble(request.getValbgpncotradeudfinalp()));
        if(request.getValbgpnccxpsrel()!=null && !request.getValbgpnccxpsrel().trim().equals(""))procedureParams.setValbgpnccxpsrel(Double.parseDouble(request.getValbgpnccxpsrel()));
        if(request.getValbgpncotropnc()!=null && !request.getValbgpncotropnc().trim().equals(""))procedureParams.setValbgpncotropnc(Double.parseDouble(request.getValbgpncotropnc()));
        if(request.getValbgpncganadife()!=null && !request.getValbgpncganadife().trim().equals(""))procedureParams.setValbgpncganadife(Double.parseDouble(request.getValbgpncganadife()));
        if(request.getValbgpnc()!=null && !request.getValbgpnc().trim().equals(""))procedureParams.setValbgpnc(Double.parseDouble(request.getValbgpnc()));
        if(request.getValbgtotapasi()!=null && !request.getValbgtotapasi().trim().equals(""))procedureParams.setValbgtotapasi(Double.parseDouble(request.getValbgtotapasi()));
        if(request.getValbgpatcapi()!=null && !request.getValbgpatcapi().trim().equals(""))procedureParams.setValbgpatcapi(Double.parseDouble(request.getValbgpatcapi()));
        if(request.getValbgpatcapadic()!=null && !request.getValbgpatcapadic().trim().equals(""))procedureParams.setValbgpatcapadic(Double.parseDouble(request.getValbgpatcapadic()));
        if(request.getValbgpatexcereva()!=null && !request.getValbgpatexcereva().trim().equals(""))procedureParams.setValbgpatexcereva(Double.parseDouble(request.getValbgpatexcereva()));
        if(request.getValbgpatrese()!=null && !request.getValbgpatrese().trim().equals(""))procedureParams.setValbgpatrese(Double.parseDouble(request.getValbgpatrese()));
        if(request.getValbgpatresuacum()!=null && !request.getValbgpatresuacum().trim().equals(""))procedureParams.setValbgpatresuacum(Double.parseDouble(request.getValbgpatresuacum()));
        if(request.getValbgpatresuejer()!=null && !request.getValbgpatresuejer().trim().equals(""))procedureParams.setValbgpatresuejer(Double.parseDouble(request.getValbgpatresuejer()));
        if(request.getValbgpatotro()!=null && !request.getValbgpatotro().trim().equals(""))procedureParams.setValbgpatotro(Double.parseDouble(request.getValbgpatotro()));
        if(request.getValbgpat()!=null && !request.getValbgpat().trim().equals(""))procedureParams.setValbgpat(Double.parseDouble(request.getValbgpat()));
        if(request.getValtotapasipatr()!=null && !request.getValtotapasipatr().trim().equals(""))procedureParams.setValtotapasipatr(Double.parseDouble(request.getValtotapasipatr()));
        if(request.getValcdreactipasipatr()!=null && !request.getValcdreactipasipatr().trim().equals(""))procedureParams.setValcdreactipasipatr(Double.parseDouble(request.getValcdreactipasipatr()));
        if(request.getValegypvarvtastota()!=null && !request.getValegypvarvtastota().trim().equals(""))procedureParams.setValegypvarvtastota(Double.parseDouble(request.getValegypvarvtastota()));
        if(request.getValegypvarcostvtasserv()!=null && !request.getValegypvarcostvtasserv().trim().equals(""))procedureParams.setValegypvarcostvtasserv(Double.parseDouble(request.getValegypvarcostvtasserv()));
        if(request.getValegypvarutilbrut()!=null && !request.getValegypvarutilbrut().trim().equals(""))procedureParams.setValegypvarutilbrut(Double.parseDouble(request.getValegypvarutilbrut()));
        if(request.getValegypvargastvtas()!=null && !request.getValegypvargastvtas().trim().equals(""))procedureParams.setValegypvargastvtas(Double.parseDouble(request.getValegypvargastvtas()));
        if(request.getValegypvargastadmi()!=null && !request.getValegypvargastadmi().trim().equals(""))procedureParams.setValegypvargastadmi(Double.parseDouble(request.getValegypvargastadmi()));
        if(request.getValegypvarotroingrgast()!=null && !request.getValegypvarotroingrgast().trim().equals(""))procedureParams.setValegypvarotroingrgast(Double.parseDouble(request.getValegypvarotroingrgast()));
        if(request.getValegypvarutiloper()!=null && !request.getValegypvarutiloper().trim().equals(""))procedureParams.setValegypvarutiloper(Double.parseDouble(request.getValegypvarutiloper()));
        if(request.getValegypvargastfina()!=null && !request.getValegypvargastfina().trim().equals(""))procedureParams.setValegypvargastfina(Double.parseDouble(request.getValegypvargastfina()));
        if(request.getValegypvaringrfina()!=null && !request.getValegypvaringrfina().trim().equals(""))procedureParams.setValegypvaringrfina(Double.parseDouble(request.getValegypvaringrfina()));
        if(request.getValegypvarpartrela()!=null && !request.getValegypvarpartrela().trim().equals(""))procedureParams.setValegypvarpartrela(Double.parseDouble(request.getValegypvarpartrela()));
        if(request.getValegypvarutilordi()!=null && !request.getValegypvarutilordi().trim().equals(""))procedureParams.setValegypvarutilordi(Double.parseDouble(request.getValegypvarutilordi()));
        if(request.getValegypvaringrextrccja()!=null && !request.getValegypvaringrextrccja().trim().equals(""))procedureParams.setValegypvaringrextrccja(Double.parseDouble(request.getValegypvaringrextrccja()));
        if(request.getValegypvaregreextrccaja()!=null && !request.getValegypvaregreextrccaja().trim().equals(""))procedureParams.setValegypvaregreextrccaja(Double.parseDouble(request.getValegypvaregreextrccaja()));
        if(request.getValegypvaringrextrscja()!=null && !request.getValegypvaringrextrscja().trim().equals(""))procedureParams.setValegypvaringrextrscja(Double.parseDouble(request.getValegypvaringrextrscja()));
        if(request.getValegypvaregreextrscja()!=null && !request.getValegypvaregreextrscja().trim().equals(""))procedureParams.setValegypvaregreextrscja(Double.parseDouble(request.getValegypvaregreextrscja()));
        if(request.getValegypvarotroingr()!=null && !request.getValegypvarotroingr().trim().equals(""))procedureParams.setValegypvarotroingr(Double.parseDouble(request.getValegypvarotroingr()));
        if(request.getValegypvarotroegre()!=null && !request.getValegypvarotroegre().trim().equals(""))procedureParams.setValegypvarotroegre(Double.parseDouble(request.getValegypvarotroegre()));
        if(request.getValegypvarutilanteimp()!=null && !request.getValegypvarutilanteimp().trim().equals(""))procedureParams.setValegypvarutilanteimp(Double.parseDouble(request.getValegypvarutilanteimp()));
        if(request.getValegypvarimppart()!=null && !request.getValegypvarimppart().trim().equals(""))procedureParams.setValegypvarimppart(Double.parseDouble(request.getValegypvarimppart()));
        if(request.getValegypvarutilperdneta()!=null && !request.getValegypvarutilperdneta().trim().equals(""))procedureParams.setValegypvarutilperdneta(Double.parseDouble(request.getValegypvarutilperdneta()));
        if(request.getValrativardepramorejer()!=null && !request.getValrativardepramorejer().trim().equals(""))procedureParams.setValrativardepramorejer(Double.parseDouble(request.getValrativardepramorejer()));
        if(request.getValrativardivi()!=null && !request.getValrativardivi().trim().equals(""))procedureParams.setValrativardivi(Double.parseDouble(request.getValrativardivi()));
        if(request.getValbgvaraccajabcos()!=null && !request.getValbgvaraccajabcos().trim().equals(""))procedureParams.setValbgvaraccajabcos(Double.parseDouble(request.getValbgvaraccajabcos()));
        if(request.getValbgvaracvalonego()!=null && !request.getValbgvaracvalonego().trim().equals(""))procedureParams.setValbgvaracvalonego(Double.parseDouble(request.getValbgvaracvalonego()));
        if(request.getValbgvaracclie()!=null && !request.getValbgvaracclie().trim().equals(""))procedureParams.setValbgvaracclie(Double.parseDouble(request.getValbgvaracclie()));
        if(request.getValbgvaracprovcobrdud()!=null && !request.getValbgvaracprovcobrdud().trim().equals(""))procedureParams.setValbgvaracprovcobrdud(Double.parseDouble(request.getValbgvaracprovcobrdud()));
        if(request.getValbgvaraccxcsrel()!=null && !request.getValbgvaraccxcsrel().trim().equals(""))procedureParams.setValbgvaraccxcsrel(Double.parseDouble(request.getValbgvaraccxcsrel()));
        if(request.getValbgvaraccxcdive()!=null && !request.getValbgvaraccxcdive().trim().equals(""))procedureParams.setValbgvaraccxcdive(Double.parseDouble(request.getValbgvaraccxcdive()));
        if(request.getValbgvaracexist()!=null && !request.getValbgvaracexist().trim().equals(""))procedureParams.setValbgvaracexist(Double.parseDouble(request.getValbgvaracexist()));
        if(request.getValbgvaracgastpagaanti()!=null && !request.getValbgvaracgastpagaanti().trim().equals(""))procedureParams.setValbgvaracgastpagaanti(Double.parseDouble(request.getValbgvaracgastpagaanti()));
        if(request.getValbgvarac()!=null && !request.getValbgvarac().trim().equals(""))procedureParams.setValbgvarac(Double.parseDouble(request.getValbgvarac()));
        if(request.getValbgvarancinverela()!=null && !request.getValbgvarancinverela().trim().equals(""))procedureParams.setValbgvarancinverela(Double.parseDouble(request.getValbgvarancinverela()));
        if(request.getValbgvarancotrainve()!=null && !request.getValbgvarancotrainve().trim().equals(""))procedureParams.setValbgvarancotrainve(Double.parseDouble(request.getValbgvarancotrainve()));
        if(request.getValbgvaranccxcsrel()!=null && !request.getValbgvaranccxcsrel().trim().equals(""))procedureParams.setValbgvaranccxcsrel(Double.parseDouble(request.getValbgvaranccxcsrel()));
        if(request.getValbgvarancinmuneto()!=null && !request.getValbgvarancinmuneto().trim().equals(""))procedureParams.setValbgvarancinmuneto(Double.parseDouble(request.getValbgvarancinmuneto()));
        if(request.getValbgvarancterr()!=null && !request.getValbgvarancterr().trim().equals(""))procedureParams.setValbgvarancterr(Double.parseDouble(request.getValbgvarancterr()));
        if(request.getValbgvarancedif()!=null && !request.getValbgvarancedif().trim().equals(""))procedureParams.setValbgvarancedif(Double.parseDouble(request.getValbgvarancedif()));
        if(request.getValbgvarancmaqu()!=null && !request.getValbgvarancmaqu().trim().equals(""))procedureParams.setValbgvarancmaqu(Double.parseDouble(request.getValbgvarancmaqu()));
        if(request.getValbgvarancmueb()!=null && !request.getValbgvarancmueb().trim().equals(""))procedureParams.setValbgvarancmueb(Double.parseDouble(request.getValbgvarancmueb()));
        if(request.getValbgvarancunidtrans()!=null && !request.getValbgvarancunidtrans().trim().equals(""))procedureParams.setValbgvarancunidtrans(Double.parseDouble(request.getValbgvarancunidtrans()));
        if(request.getValbgvarancequidive()!=null && !request.getValbgvarancequidive().trim().equals(""))procedureParams.setValbgvarancequidive(Double.parseDouble(request.getValbgvarancequidive()));
        if(request.getValbgvarancdepracum()!=null && !request.getValbgvarancdepracum().trim().equals(""))procedureParams.setValbgvarancdepracum(Double.parseDouble(request.getValbgvarancdepracum()));
        if(request.getValbgvaranctrab()!=null && !request.getValbgvaranctrab().trim().equals(""))procedureParams.setValbgvaranctrab(Double.parseDouble(request.getValbgvaranctrab()));
        if(request.getValbgvarancotroacti()!=null && !request.getValbgvarancotroacti().trim().equals(""))procedureParams.setValbgvarancotroacti(Double.parseDouble(request.getValbgvarancotroacti()));
        if(request.getValbgvarancintan()!=null && !request.getValbgvarancintan().trim().equals(""))procedureParams.setValbgvarancintan(Double.parseDouble(request.getValbgvarancintan()));
        if(request.getValbgvarancotroanc()!=null && !request.getValbgvarancotroanc().trim().equals(""))procedureParams.setValbgvarancotroanc(Double.parseDouble(request.getValbgvarancotroanc()));
        if(request.getValbgvaranc()!=null && !request.getValbgvaranc().trim().equals(""))procedureParams.setValbgvaranc(Double.parseDouble(request.getValbgvaranc()));
        if(request.getValbgvartotaacti()!=null && !request.getValbgvartotaacti().trim().equals(""))procedureParams.setValbgvartotaacti(Double.parseDouble(request.getValbgvartotaacti()));
        if(request.getValbgvarpcbancdfinacp()!=null && !request.getValbgvarpcbancdfinacp().trim().equals(""))procedureParams.setValbgvarpcbancdfinacp(Double.parseDouble(request.getValbgvarpcbancdfinacp()));
        if(request.getValbgvarpcotradfinacp()!=null && !request.getValbgvarpcotradfinacp().trim().equals(""))procedureParams.setValbgvarpcotradfinacp(Double.parseDouble(request.getValbgvarpcotradfinacp()));
        if(request.getValbgvarpcdeudlp()!=null && !request.getValbgvarpcdeudlp().trim().equals(""))procedureParams.setValbgvarpcdeudlp(Double.parseDouble(request.getValbgvarpcdeudlp()));
        if(request.getValbgvarpctribpaga()!=null && !request.getValbgvarpctribpaga().trim().equals(""))procedureParams.setValbgvarpctribpaga(Double.parseDouble(request.getValbgvarpctribpaga()));
        if(request.getValbgvarpcremupaga()!=null && !request.getValbgvarpcremupaga().trim().equals(""))procedureParams.setValbgvarpcremupaga(Double.parseDouble(request.getValbgvarpcremupaga()));
        if(request.getValbgvarpcprov()!=null && !request.getValbgvarpcprov().trim().equals(""))procedureParams.setValbgvarpcprov(Double.parseDouble(request.getValbgvarpcprov()));
        if(request.getValbgvarpccxpsrel()!=null && !request.getValbgvarpccxpsrel().trim().equals(""))procedureParams.setValbgvarpccxpsrel(Double.parseDouble(request.getValbgvarpccxpsrel()));
        if(request.getValbgvarpccxpdive()!=null && !request.getValbgvarpccxpdive().trim().equals(""))procedureParams.setValbgvarpccxpdive(Double.parseDouble(request.getValbgvarpccxpdive()));
        if(request.getValbgvarpc()!=null && !request.getValbgvarpc().trim().equals(""))procedureParams.setValbgvarpc(Double.parseDouble(request.getValbgvarpc()));
        if(request.getValbgvarpncbcosdfinalp()!=null && !request.getValbgvarpncbcosdfinalp().trim().equals(""))procedureParams.setValbgvarpncbcosdfinalp(Double.parseDouble(request.getValbgvarpncbcosdfinalp()));
        if(request.getValbgvarpncotradfinalp()!=null && !request.getValbgvarpncotradfinalp().trim().equals(""))procedureParams.setValbgvarpncotradfinalp(Double.parseDouble(request.getValbgvarpncotradfinalp()));
        if(request.getValbgvarpnccxpsrel()!=null && !request.getValbgvarpnccxpsrel().trim().equals(""))procedureParams.setValbgvarpnccxpsrel(Double.parseDouble(request.getValbgvarpnccxpsrel()));
        if(request.getValbgvarpncotropnc()!=null && !request.getValbgvarpncotropnc().trim().equals(""))procedureParams.setValbgvarpncotropnc(Double.parseDouble(request.getValbgvarpncotropnc()));
        if(request.getValbgvarpncganadife()!=null && !request.getValbgvarpncganadife().trim().equals(""))procedureParams.setValbgvarpncganadife(Double.parseDouble(request.getValbgvarpncganadife()));
        if(request.getValbgvarpnc()!=null && !request.getValbgvarpnc().trim().equals(""))procedureParams.setValbgvarpnc(Double.parseDouble(request.getValbgvarpnc()));
        if(request.getValbgvartotapasi()!=null && !request.getValbgvartotapasi().trim().equals(""))procedureParams.setValbgvartotapasi(Double.parseDouble(request.getValbgvartotapasi()));
        if(request.getValbgvarpatcapi()!=null && !request.getValbgvarpatcapi().trim().equals(""))procedureParams.setValbgvarpatcapi(Double.parseDouble(request.getValbgvarpatcapi()));
        if(request.getValbgvarpatcapadic()!=null && !request.getValbgvarpatcapadic().trim().equals(""))procedureParams.setValbgvarpatcapadic(Double.parseDouble(request.getValbgvarpatcapadic()));
        if(request.getValbgvarpatexcereva()!=null && !request.getValbgvarpatexcereva().trim().equals(""))procedureParams.setValbgvarpatexcereva(Double.parseDouble(request.getValbgvarpatexcereva()));
        if(request.getValbgvarpatrese()!=null && !request.getValbgvarpatrese().trim().equals(""))procedureParams.setValbgvarpatrese(Double.parseDouble(request.getValbgvarpatrese()));
        if(request.getValbgvarpatresuacum()!=null && !request.getValbgvarpatresuacum().trim().equals(""))procedureParams.setValbgvarpatresuacum(Double.parseDouble(request.getValbgvarpatresuacum()));
        if(request.getValbgvarpatresuejer()!=null && !request.getValbgvarpatresuejer().trim().equals(""))procedureParams.setValbgvarpatresuejer(Double.parseDouble(request.getValbgvarpatresuejer()));
        if(request.getValbgvarpatotro()!=null && !request.getValbgvarpatotro().trim().equals(""))procedureParams.setValbgvarpatotro(Double.parseDouble(request.getValbgvarpatotro()));
        if(request.getValbgvarpat()!=null && !request.getValbgvarpat().trim().equals(""))procedureParams.setValbgvarpat(Double.parseDouble(request.getValbgvarpat()));
        if(request.getValvartotapasipatr()!=null && !request.getValvartotapasipatr().trim().equals(""))procedureParams.setValvartotapasipatr(Double.parseDouble(request.getValvartotapasipatr()));

        if(request.getCodSoliCred()!=null)procedureParams.setCodSoliCred(request.getCodSoliCred());
        if(request.getCodcliente()!=null)procedureParams.setCodcliente(request.getCodcliente());
        if(request.getValanoeeff()!=null)procedureParams.setValanoeeff(request.getValanoeeff());
        if(request.getIndice()!=null)procedureParams.setIndice(request.getIndice());
        if(request.getCodmoneeeff()!=null)procedureParams.setCodmoneeeff(request.getCodmoneeeff());
        
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);
        resumenFinancieroDAO.insertar(procedureParams);

        Integer statusQuery = procedureParams.getStatus();
        if (statusQuery.equals(1)) {
            BaseResponse response = new BaseResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());

        }

    }
    
@Override
    public BaseResponse insertarMaturity(HeaderParams headerParams, ResumenFinancieroMaturityRequest request) throws Exception {
        InsertarResumenFinancieroMaturityProcedure procedureParams = new InsertarResumenFinancieroMaturityProcedure();
        if(request.getValmatuamordeudactu()!=null && !request.getValmatuamordeudactu().trim().equals(""))procedureParams.setValmatuamordeudactu(Double.parseDouble(request.getValmatuamordeudactu()));
        if(request.getValmatuamordeudnuev()!=null && !request.getValmatuamordeudnuev().trim().equals(""))procedureParams.setValmatuamordeudnuev(Double.parseDouble(request.getValmatuamordeudnuev()));
        if(request.getValmatucashflowproy()!=null && !request.getValmatucashflowproy().trim().equals(""))procedureParams.setValmatucashflowproy(Double.parseDouble(request.getValmatucashflowproy()));
        if(request.getValmatuebitdaproy()!=null && !request.getValmatuebitdaproy().trim().equals(""))procedureParams.setValmatuebitdaproy(Double.parseDouble(request.getValmatuebitdaproy()));
        if(request.getValmatufactcashfsdeu()!=null && !request.getValmatufactcashfsdeu().trim().equals(""))procedureParams.setValmatufactcashfsdeu(Double.parseDouble(request.getValmatufactcashfsdeu()));
        if(request.getValmatufactebitdasdeu()!=null && !request.getValmatufactebitdasdeu().trim().equals(""))procedureParams.setValmatufactcashfsdeu(Double.parseDouble(request.getValmatufactebitdasdeu()));
        if(request.getValmatugastfinadeudactu()!=null && !request.getValmatugastfinadeudactu().trim().equals(""))procedureParams.setValmatugastfinadeudactu(Double.parseDouble(request.getValmatugastfinadeudactu()));
        if(request.getValmatugastfinadeudnuev()!=null && !request.getValmatugastfinadeudnuev().trim().equals(""))procedureParams.setValmatugastfinadeudnuev(Double.parseDouble(request.getValmatugastfinadeudnuev()));
        if(request.getValmatuservdeud()!=null && !request.getValmatuservdeud().trim().equals(""))procedureParams.setValmatuservdeud(Double.parseDouble(request.getValmatuservdeud()));
       
        if(request.getCodSoliCred()!=null)procedureParams.setCodSoliCred(request.getCodSoliCred());
        if(request.getCodcliente()!=null)procedureParams.setCodcliente(request.getCodcliente());
        if(request.getValMatuAnoProy()!=null)procedureParams.setValMatuAnoProy(request.getValMatuAnoProy());
        if(request.getIndice()!=null)procedureParams.setIndice(request.getIndice());
        if(request.getCodmoneeeff()!=null)procedureParams.setCodmoneeeff(request.getCodmoneeeff());
        
        mapper.map(headerParams, procedureParams);
        mapper.map(request, procedureParams);
        resumenFinancieroDAO.insertarMaturity(procedureParams);

        Integer statusQuery = procedureParams.getStatus();
        if (statusQuery.equals(1)) {
            BaseResponse response = new BaseResponse();
            response.setEstadoTrama(String.valueOf(procedureParams.getStatus()));
            response.setMensaje(procedureParams.getMensaje());
            return response;
        } else {
            throw new Exception(procedureParams.getMensaje());

        }

    }    
}
