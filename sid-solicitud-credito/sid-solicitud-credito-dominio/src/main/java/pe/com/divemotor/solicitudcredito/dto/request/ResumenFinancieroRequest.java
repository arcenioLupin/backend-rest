package pe.com.divemotor.solicitudcredito.dto.request;

import java.util.List;
import pe.com.divemotor.generico.dto.BaseRequest;

public class ResumenFinancieroRequest extends BaseRequest {
    private String codSoliCred;
    private String codcliente;
    private Integer valanoeeff;
    private Integer indice;
    private String codmoneeeff;
    private String valegypvtastota;
    private String valegypcostvtasserv;
    private String valegyputilbrut;
    private String valegypgastvtas;
    private String valegypgastadmi;
    private String valegypotroingrgast;
    private String valegyputiloper;
    private String valegypgastfina;
    private String valegypingrfina;
    private String valegyppartrela;
    private String valegyputilordi;
    private String valegypingrextrccja;
    private String valegypegreextrccaja;
    private String valegypingrextrscja;
    private String valegypegreextrscja;
    private String valegypotroingr;
    private String valegypotroegre;
    private String valegyputilanteimp;
    private String valegypimppart;
    private String valegyputilperdneta;
    private String valraticapitrab;
    private String valratidiasexist;
    private String valraticobrclie;
    private String valratipagoprov;
    private String valraticicloper;
    private String valratipasitotapatr;
    private String valratideudfinabrut;
    private String valratideudfinaestr;
    private String valratiporcvarvtas;
    private String valratiebitdaanual;
    private String valratiporcebitdavtas;
    private String valratiporcroe;
    private String valratiporcroa;
    private String valraticashflow;
    private String valratiporccashflowvtas;
    private String valratideudfinabrutanos;
    private String valratideudfinaestranos;
    private String valratideudfinaebitda;
    private String valratiebitda;
    private String valratidepramorejer;
    private String valratidivi;
    private String valratinromese;
    private String valbgaccajabcos;
    private String valbgacvalonego;
    private String valbgacclie;
    private String valbgacprovcobrdud;
    private String valbgaccxcsrel;
    private String valbgaccxcdive;
    private String valbgacexist;
    private String valbgacgastpagaanti;
    private String valbgac;
    private String valbgancinverela;
    private String valbgancotrainve;
    private String valbganccxcsrel;
    private String valbgancinmuneto;
    private String valbgancterr;
    private String valbgancedif;
    private String valbgancmaqu;
    private String valbgancmueb;
    private String valbgancunidtrans;
    private String valbgancequidive;
    private String valbgancdepracum;
    private String valbganctrab;
    private String valbgancotroacti;
    private String valbgancintan;
    private String valbgancotroanc;
    private String valbganc;
    private String valbgtotaacti;
    private String valbgpcbancdeudfinacp;//valbgpcbancdfinacp;//
    private String valbgpcotradeudfinacp;
    private String valbgpcdeudlp;
    private String valbgpctribpaga;
    private String valbgpcremupaga;
    private String valbgpcprov;
    private String valbgpccxpsrel;
    private String valbgpccxpdive;
    private String valbgpc;
    private String valbgpncbcosdeudfinalp;
    private String valbgpncotradeudfinalp;
    private String valbgpnccxpsrel;
    private String valbgpncotropnc;
    private String valbgpncganadife;
    private String valbgpnc;
    private String valbgtotapasi;
    private String valbgpatcapi;
    private String valbgpatcapadic;
    private String valbgpatexcereva;
    private String valbgpatrese;
    private String valbgpatresuacum;
    private String valbgpatresuejer;
    private String valbgpatotro;
    private String valbgpat;
    private String valtotapasipatr;
    private String valcdreactipasipatr;
    private String valegypvarvtastota;
    private String valegypvarcostvtasserv;
    private String valegypvarutilbrut;
    private String valegypvargastvtas;
    private String valegypvargastadmi;
    private String valegypvarotroingrgast;
    private String valegypvarutiloper;
    private String valegypvargastfina;
    private String valegypvaringrfina;
    private String valegypvarpartrela;
    private String valegypvarutilordi;
    private String valegypvaringrextrccja;
    private String valegypvaregreextrccaja;
    private String valegypvaringrextrscja;
    private String valegypvaregreextrscja;
    private String valegypvarotroingr;
    private String valegypvarotroegre;
    private String valegypvarutilanteimp;
    private String valegypvarimppart;
    private String valegypvarutilperdneta;
    private String valrativardepramorejer;
    private String valrativardivi;
    private String valbgvaraccajabcos;
    private String valbgvaracvalonego;
    private String valbgvaracclie;
    private String valbgvaracprovcobrdud;
    private String valbgvaraccxcsrel;
    private String valbgvaraccxcdive;
    private String valbgvaracexist;
    private String valbgvaracgastpagaanti;
    private String valbgvarac;
    private String valbgvarancinverela;
    private String valbgvarancotrainve;
    private String valbgvaranccxcsrel;
    private String valbgvarancinmuneto;
    private String valbgvarancterr;
    private String valbgvarancedif;
    private String valbgvarancmaqu;
    private String valbgvarancmueb;
    private String valbgvarancunidtrans;
    private String valbgvarancequidive;
    private String valbgvarancdepracum;
    private String valbgvaranctrab;
    private String valbgvarancotroacti;
    private String valbgvarancintan;
    private String valbgvarancotroanc;
    private String valbgvaranc;
    private String valbgvartotaacti;
    private String valbgvarpcbancdfinacp;
    private String valbgvarpcotradfinacp;
    private String valbgvarpcdeudlp;
    private String valbgvarpctribpaga;
    private String valbgvarpcremupaga;
    private String valbgvarpcprov;
    private String valbgvarpccxpsrel;
    private String valbgvarpccxpdive;
    private String valbgvarpc;
    private String valbgvarpncbcosdfinalp;
    private String valbgvarpncotradfinalp;
    private String valbgvarpnccxpsrel;
    private String valbgvarpncotropnc;
    private String valbgvarpncganadife;
    private String valbgvarpnc;
    private String valbgvartotapasi;
    private String valbgvarpatcapi;
    private String valbgvarpatcapadic;
    private String valbgvarpatexcereva;
    private String valbgvarpatrese;
    private String valbgvarpatresuacum;
    private String valbgvarpatresuejer;
    private String valbgvarpatotro;
    private String valbgvarpat;
    private String valvartotapasipatr;
    //extras
    private String valghistebitdaanual;
    private String valghistcashflowanual;

    public String getCodSoliCred() {
        return codSoliCred;
    }

    public void setCodSoliCred(String codSoliCred) {
        this.codSoliCred = codSoliCred;
    }

    public String getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(String codcliente) {
        this.codcliente = codcliente;
    }

    public Integer getValanoeeff() {
        return valanoeeff;
    }

    public void setValanoeeff(Integer valanoeeff) {
        this.valanoeeff = valanoeeff;
    }

    public Integer getIndice() {
        return indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }

    public String getCodmoneeeff() {
        return codmoneeeff;
    }

    public void setCodmoneeeff(String codmoneeeff) {
        this.codmoneeeff = codmoneeeff;
    }

    public String getValegypvtastota() {
        return valegypvtastota;
    }

    public void setValegypvtastota(String valegypvtastota) {
        this.valegypvtastota = valegypvtastota;
    }

    public String getValegypcostvtasserv() {
        return valegypcostvtasserv;
    }

    public void setValegypcostvtasserv(String valegypcostvtasserv) {
        this.valegypcostvtasserv = valegypcostvtasserv;
    }

    public String getValegyputilbrut() {
        return valegyputilbrut;
    }

    public void setValegyputilbrut(String valegyputilbrut) {
        this.valegyputilbrut = valegyputilbrut;
    }

    public String getValegypgastvtas() {
        return valegypgastvtas;
    }

    public void setValegypgastvtas(String valegypgastvtas) {
        this.valegypgastvtas = valegypgastvtas;
    }

    public String getValegypgastadmi() {
        return valegypgastadmi;
    }

    public void setValegypgastadmi(String valegypgastadmi) {
        this.valegypgastadmi = valegypgastadmi;
    }

    public String getValegypotroingrgast() {
        return valegypotroingrgast;
    }

    public void setValegypotroingrgast(String valegypotroingrgast) {
        this.valegypotroingrgast = valegypotroingrgast;
    }

    public String getValegyputiloper() {
        return valegyputiloper;
    }

    public void setValegyputiloper(String valegyputiloper) {
        this.valegyputiloper = valegyputiloper;
    }

    public String getValegypgastfina() {
        return valegypgastfina;
    }

    public void setValegypgastfina(String valegypgastfina) {
        this.valegypgastfina = valegypgastfina;
    }

    public String getValegypingrfina() {
        return valegypingrfina;
    }

    public void setValegypingrfina(String valegypingrfina) {
        this.valegypingrfina = valegypingrfina;
    }

    public String getValegyppartrela() {
        return valegyppartrela;
    }

    public void setValegyppartrela(String valegyppartrela) {
        this.valegyppartrela = valegyppartrela;
    }

    public String getValegyputilordi() {
        return valegyputilordi;
    }

    public void setValegyputilordi(String valegyputilordi) {
        this.valegyputilordi = valegyputilordi;
    }

    public String getValegypingrextrccja() {
        return valegypingrextrccja;
    }

    public void setValegypingrextrccja(String valegypingrextrccja) {
        this.valegypingrextrccja = valegypingrextrccja;
    }

    public String getValegypegreextrccaja() {
        return valegypegreextrccaja;
    }

    public void setValegypegreextrccaja(String valegypegreextrccaja) {
        this.valegypegreextrccaja = valegypegreextrccaja;
    }

    public String getValegypingrextrscja() {
        return valegypingrextrscja;
    }

    public void setValegypingrextrscja(String valegypingrextrscja) {
        this.valegypingrextrscja = valegypingrextrscja;
    }

    public String getValegypegreextrscja() {
        return valegypegreextrscja;
    }

    public void setValegypegreextrscja(String valegypegreextrscja) {
        this.valegypegreextrscja = valegypegreextrscja;
    }

    public String getValegypotroingr() {
        return valegypotroingr;
    }

    public void setValegypotroingr(String valegypotroingr) {
        this.valegypotroingr = valegypotroingr;
    }

    public String getValegypotroegre() {
        return valegypotroegre;
    }

    public void setValegypotroegre(String valegypotroegre) {
        this.valegypotroegre = valegypotroegre;
    }

    public String getValegyputilanteimp() {
        return valegyputilanteimp;
    }

    public void setValegyputilanteimp(String valegyputilanteimp) {
        this.valegyputilanteimp = valegyputilanteimp;
    }

    public String getValegypimppart() {
        return valegypimppart;
    }

    public void setValegypimppart(String valegypimppart) {
        this.valegypimppart = valegypimppart;
    }

    public String getValegyputilperdneta() {
        return valegyputilperdneta;
    }

    public void setValegyputilperdneta(String valegyputilperdneta) {
        this.valegyputilperdneta = valegyputilperdneta;
    }

    public String getValraticapitrab() {
        return valraticapitrab;
    }

    public void setValraticapitrab(String valraticapitrab) {
        this.valraticapitrab = valraticapitrab;
    }

    public String getValratidiasexist() {
        return valratidiasexist;
    }

    public void setValratidiasexist(String valratidiasexist) {
        this.valratidiasexist = valratidiasexist;
    }

    public String getValraticobrclie() {
        return valraticobrclie;
    }

    public void setValraticobrclie(String valraticobrclie) {
        this.valraticobrclie = valraticobrclie;
    }

    public String getValratipagoprov() {
        return valratipagoprov;
    }

    public void setValratipagoprov(String valratipagoprov) {
        this.valratipagoprov = valratipagoprov;
    }

    public String getValraticicloper() {
        return valraticicloper;
    }

    public void setValraticicloper(String valraticicloper) {
        this.valraticicloper = valraticicloper;
    }

    public String getValratipasitotapatr() {
        return valratipasitotapatr;
    }

    public void setValratipasitotapatr(String valratipasitotapatr) {
        this.valratipasitotapatr = valratipasitotapatr;
    }

    public String getValratideudfinabrut() {
        return valratideudfinabrut;
    }

    public void setValratideudfinabrut(String valratideudfinabrut) {
        this.valratideudfinabrut = valratideudfinabrut;
    }

    public String getValratideudfinaestr() {
        return valratideudfinaestr;
    }

    public void setValratideudfinaestr(String valratideudfinaestr) {
        this.valratideudfinaestr = valratideudfinaestr;
    }

    public String getValratiporcvarvtas() {
        return valratiporcvarvtas;
    }

    public void setValratiporcvarvtas(String valratiporcvarvtas) {
        this.valratiporcvarvtas = valratiporcvarvtas;
    }

    public String getValratiebitdaanual() {
        return valratiebitdaanual;
    }

    public void setValratiebitdaanual(String valratiebitdaanual) {
        this.valratiebitdaanual = valratiebitdaanual;
    }

    public String getValratiporcebitdavtas() {
        return valratiporcebitdavtas;
    }

    public void setValratiporcebitdavtas(String valratiporcebitdavtas) {
        this.valratiporcebitdavtas = valratiporcebitdavtas;
    }

    public String getValratiporcroe() {
        return valratiporcroe;
    }

    public void setValratiporcroe(String valratiporcroe) {
        this.valratiporcroe = valratiporcroe;
    }

    public String getValratiporcroa() {
        return valratiporcroa;
    }

    public void setValratiporcroa(String valratiporcroa) {
        this.valratiporcroa = valratiporcroa;
    }

    public String getValraticashflow() {
        return valraticashflow;
    }

    public void setValraticashflow(String valraticashflow) {
        this.valraticashflow = valraticashflow;
    }

    public String getValratiporccashflowvtas() {
        return valratiporccashflowvtas;
    }

    public void setValratiporccashflowvtas(String valratiporccashflowvtas) {
        this.valratiporccashflowvtas = valratiporccashflowvtas;
    }

    public String getValratideudfinabrutanos() {
        return valratideudfinabrutanos;
    }

    public void setValratideudfinabrutanos(String valratideudfinabrutanos) {
        this.valratideudfinabrutanos = valratideudfinabrutanos;
    }

    public String getValratideudfinaestranos() {
        return valratideudfinaestranos;
    }

    public void setValratideudfinaestranos(String valratideudfinaestranos) {
        this.valratideudfinaestranos = valratideudfinaestranos;
    }

    public String getValratideudfinaebitda() {
        return valratideudfinaebitda;
    }

    public void setValratideudfinaebitda(String valratideudfinaebitda) {
        this.valratideudfinaebitda = valratideudfinaebitda;
    }

    public String getValratiebitda() {
        return valratiebitda;
    }

    public void setValratiebitda(String valratiebitda) {
        this.valratiebitda = valratiebitda;
    }

    public String getValratidepramorejer() {
        return valratidepramorejer;
    }

    public void setValratidepramorejer(String valratidepramorejer) {
        this.valratidepramorejer = valratidepramorejer;
    }

    public String getValratidivi() {
        return valratidivi;
    }

    public void setValratidivi(String valratidivi) {
        this.valratidivi = valratidivi;
    }

    public String getValratinromese() {
        return valratinromese;
    }

    public void setValratinromese(String valratinromese) {
        this.valratinromese = valratinromese;
    }

    public String getValbgaccajabcos() {
        return valbgaccajabcos;
    }

    public void setValbgaccajabcos(String valbgaccajabcos) {
        this.valbgaccajabcos = valbgaccajabcos;
    }

    public String getValbgacvalonego() {
        return valbgacvalonego;
    }

    public void setValbgacvalonego(String valbgacvalonego) {
        this.valbgacvalonego = valbgacvalonego;
    }

    public String getValbgacclie() {
        return valbgacclie;
    }

    public void setValbgacclie(String valbgacclie) {
        this.valbgacclie = valbgacclie;
    }

    public String getValbgacprovcobrdud() {
        return valbgacprovcobrdud;
    }

    public void setValbgacprovcobrdud(String valbgacprovcobrdud) {
        this.valbgacprovcobrdud = valbgacprovcobrdud;
    }

    public String getValbgaccxcsrel() {
        return valbgaccxcsrel;
    }

    public void setValbgaccxcsrel(String valbgaccxcsrel) {
        this.valbgaccxcsrel = valbgaccxcsrel;
    }

    public String getValbgaccxcdive() {
        return valbgaccxcdive;
    }

    public void setValbgaccxcdive(String valbgaccxcdive) {
        this.valbgaccxcdive = valbgaccxcdive;
    }

    public String getValbgacexist() {
        return valbgacexist;
    }

    public void setValbgacexist(String valbgacexist) {
        this.valbgacexist = valbgacexist;
    }

    public String getValbgacgastpagaanti() {
        return valbgacgastpagaanti;
    }

    public void setValbgacgastpagaanti(String valbgacgastpagaanti) {
        this.valbgacgastpagaanti = valbgacgastpagaanti;
    }

    public String getValbgac() {
        return valbgac;
    }

    public void setValbgac(String valbgac) {
        this.valbgac = valbgac;
    }

    public String getValbgancinverela() {
        return valbgancinverela;
    }

    public void setValbgancinverela(String valbgancinverela) {
        this.valbgancinverela = valbgancinverela;
    }

    public String getValbgancotrainve() {
        return valbgancotrainve;
    }

    public void setValbgancotrainve(String valbgancotrainve) {
        this.valbgancotrainve = valbgancotrainve;
    }

    public String getValbganccxcsrel() {
        return valbganccxcsrel;
    }

    public void setValbganccxcsrel(String valbganccxcsrel) {
        this.valbganccxcsrel = valbganccxcsrel;
    }

    public String getValbgancinmuneto() {
        return valbgancinmuneto;
    }

    public void setValbgancinmuneto(String valbgancinmuneto) {
        this.valbgancinmuneto = valbgancinmuneto;
    }

    public String getValbgancterr() {
        return valbgancterr;
    }

    public void setValbgancterr(String valbgancterr) {
        this.valbgancterr = valbgancterr;
    }

    public String getValbgancedif() {
        return valbgancedif;
    }

    public void setValbgancedif(String valbgancedif) {
        this.valbgancedif = valbgancedif;
    }

    public String getValbgancmaqu() {
        return valbgancmaqu;
    }

    public void setValbgancmaqu(String valbgancmaqu) {
        this.valbgancmaqu = valbgancmaqu;
    }

    public String getValbgancmueb() {
        return valbgancmueb;
    }

    public void setValbgancmueb(String valbgancmueb) {
        this.valbgancmueb = valbgancmueb;
    }

    public String getValbgancunidtrans() {
        return valbgancunidtrans;
    }

    public void setValbgancunidtrans(String valbgancunidtrans) {
        this.valbgancunidtrans = valbgancunidtrans;
    }

    public String getValbgancequidive() {
        return valbgancequidive;
    }

    public void setValbgancequidive(String valbgancequidive) {
        this.valbgancequidive = valbgancequidive;
    }

    public String getValbgancdepracum() {
        return valbgancdepracum;
    }

    public void setValbgancdepracum(String valbgancdepracum) {
        this.valbgancdepracum = valbgancdepracum;
    }

    public String getValbganctrab() {
        return valbganctrab;
    }

    public void setValbganctrab(String valbganctrab) {
        this.valbganctrab = valbganctrab;
    }

    public String getValbgancotroacti() {
        return valbgancotroacti;
    }

    public void setValbgancotroacti(String valbgancotroacti) {
        this.valbgancotroacti = valbgancotroacti;
    }

    public String getValbgancintan() {
        return valbgancintan;
    }

    public void setValbgancintan(String valbgancintan) {
        this.valbgancintan = valbgancintan;
    }

    public String getValbgancotroanc() {
        return valbgancotroanc;
    }

    public void setValbgancotroanc(String valbgancotroanc) {
        this.valbgancotroanc = valbgancotroanc;
    }

    public String getValbganc() {
        return valbganc;
    }

    public void setValbganc(String valbganc) {
        this.valbganc = valbganc;
    }

    public String getValbgtotaacti() {
        return valbgtotaacti;
    }

    public void setValbgtotaacti(String valbgtotaacti) {
        this.valbgtotaacti = valbgtotaacti;
    }

    public String getValbgpcbancdeudfinacp() {
        return valbgpcbancdeudfinacp;
    }

    public void setValbgpcbancdeudfinacp(String valbgpcbancdeudfinacp) {
        this.valbgpcbancdeudfinacp = valbgpcbancdeudfinacp;
    }

    public String getValbgpcotradeudfinacp() {
        return valbgpcotradeudfinacp;
    }

    public void setValbgpcotradeudfinacp(String valbgpcotradeudfinacp) {
        this.valbgpcotradeudfinacp = valbgpcotradeudfinacp;
    }

    public String getValbgpcdeudlp() {
        return valbgpcdeudlp;
    }

    public void setValbgpcdeudlp(String valbgpcdeudlp) {
        this.valbgpcdeudlp = valbgpcdeudlp;
    }

    public String getValbgpctribpaga() {
        return valbgpctribpaga;
    }

    public void setValbgpctribpaga(String valbgpctribpaga) {
        this.valbgpctribpaga = valbgpctribpaga;
    }

    public String getValbgpcremupaga() {
        return valbgpcremupaga;
    }

    public void setValbgpcremupaga(String valbgpcremupaga) {
        this.valbgpcremupaga = valbgpcremupaga;
    }

    public String getValbgpcprov() {
        return valbgpcprov;
    }

    public void setValbgpcprov(String valbgpcprov) {
        this.valbgpcprov = valbgpcprov;
    }

    public String getValbgpccxpsrel() {
        return valbgpccxpsrel;
    }

    public void setValbgpccxpsrel(String valbgpccxpsrel) {
        this.valbgpccxpsrel = valbgpccxpsrel;
    }

    public String getValbgpccxpdive() {
        return valbgpccxpdive;
    }

    public void setValbgpccxpdive(String valbgpccxpdive) {
        this.valbgpccxpdive = valbgpccxpdive;
    }

    public String getValbgpc() {
        return valbgpc;
    }

    public void setValbgpc(String valbgpc) {
        this.valbgpc = valbgpc;
    }

    public String getValbgpncbcosdeudfinalp() {
        return valbgpncbcosdeudfinalp;
    }

    public void setValbgpncbcosdeudfinalp(String valbgpncbcosdeudfinalp) {
        this.valbgpncbcosdeudfinalp = valbgpncbcosdeudfinalp;
    }

    public String getValbgpncotradeudfinalp() {
        return valbgpncotradeudfinalp;
    }

    public void setValbgpncotradeudfinalp(String valbgpncotradeudfinalp) {
        this.valbgpncotradeudfinalp = valbgpncotradeudfinalp;
    }

    public String getValbgpnccxpsrel() {
        return valbgpnccxpsrel;
    }

    public void setValbgpnccxpsrel(String valbgpnccxpsrel) {
        this.valbgpnccxpsrel = valbgpnccxpsrel;
    }

    public String getValbgpncotropnc() {
        return valbgpncotropnc;
    }

    public void setValbgpncotropnc(String valbgpncotropnc) {
        this.valbgpncotropnc = valbgpncotropnc;
    }

    public String getValbgpncganadife() {
        return valbgpncganadife;
    }

    public void setValbgpncganadife(String valbgpncganadife) {
        this.valbgpncganadife = valbgpncganadife;
    }

    public String getValbgpnc() {
        return valbgpnc;
    }

    public void setValbgpnc(String valbgpnc) {
        this.valbgpnc = valbgpnc;
    }

    public String getValbgtotapasi() {
        return valbgtotapasi;
    }

    public void setValbgtotapasi(String valbgtotapasi) {
        this.valbgtotapasi = valbgtotapasi;
    }

    public String getValbgpatcapi() {
        return valbgpatcapi;
    }

    public void setValbgpatcapi(String valbgpatcapi) {
        this.valbgpatcapi = valbgpatcapi;
    }

    public String getValbgpatcapadic() {
        return valbgpatcapadic;
    }

    public void setValbgpatcapadic(String valbgpatcapadic) {
        this.valbgpatcapadic = valbgpatcapadic;
    }

    public String getValbgpatexcereva() {
        return valbgpatexcereva;
    }

    public void setValbgpatexcereva(String valbgpatexcereva) {
        this.valbgpatexcereva = valbgpatexcereva;
    }

    public String getValbgpatrese() {
        return valbgpatrese;
    }

    public void setValbgpatrese(String valbgpatrese) {
        this.valbgpatrese = valbgpatrese;
    }

    public String getValbgpatresuacum() {
        return valbgpatresuacum;
    }

    public void setValbgpatresuacum(String valbgpatresuacum) {
        this.valbgpatresuacum = valbgpatresuacum;
    }

    public String getValbgpatresuejer() {
        return valbgpatresuejer;
    }

    public void setValbgpatresuejer(String valbgpatresuejer) {
        this.valbgpatresuejer = valbgpatresuejer;
    }

    public String getValbgpatotro() {
        return valbgpatotro;
    }

    public void setValbgpatotro(String valbgpatotro) {
        this.valbgpatotro = valbgpatotro;
    }

    public String getValbgpat() {
        return valbgpat;
    }

    public void setValbgpat(String valbgpat) {
        this.valbgpat = valbgpat;
    }

    public String getValtotapasipatr() {
        return valtotapasipatr;
    }

    public void setValtotapasipatr(String valtotapasipatr) {
        this.valtotapasipatr = valtotapasipatr;
    }

    public String getValcdreactipasipatr() {
        return valcdreactipasipatr;
    }

    public void setValcdreactipasipatr(String valcdreactipasipatr) {
        this.valcdreactipasipatr = valcdreactipasipatr;
    }

    public String getValegypvarvtastota() {
        return valegypvarvtastota;
    }

    public void setValegypvarvtastota(String valegypvarvtastota) {
        this.valegypvarvtastota = valegypvarvtastota;
    }

    public String getValegypvarcostvtasserv() {
        return valegypvarcostvtasserv;
    }

    public void setValegypvarcostvtasserv(String valegypvarcostvtasserv) {
        this.valegypvarcostvtasserv = valegypvarcostvtasserv;
    }

    public String getValegypvarutilbrut() {
        return valegypvarutilbrut;
    }

    public void setValegypvarutilbrut(String valegypvarutilbrut) {
        this.valegypvarutilbrut = valegypvarutilbrut;
    }

    public String getValegypvargastvtas() {
        return valegypvargastvtas;
    }

    public void setValegypvargastvtas(String valegypvargastvtas) {
        this.valegypvargastvtas = valegypvargastvtas;
    }

    public String getValegypvargastadmi() {
        return valegypvargastadmi;
    }

    public void setValegypvargastadmi(String valegypvargastadmi) {
        this.valegypvargastadmi = valegypvargastadmi;
    }

    public String getValegypvarotroingrgast() {
        return valegypvarotroingrgast;
    }

    public void setValegypvarotroingrgast(String valegypvarotroingrgast) {
        this.valegypvarotroingrgast = valegypvarotroingrgast;
    }

    public String getValegypvarutiloper() {
        return valegypvarutiloper;
    }

    public void setValegypvarutiloper(String valegypvarutiloper) {
        this.valegypvarutiloper = valegypvarutiloper;
    }

    public String getValegypvargastfina() {
        return valegypvargastfina;
    }

    public void setValegypvargastfina(String valegypvargastfina) {
        this.valegypvargastfina = valegypvargastfina;
    }

    public String getValegypvaringrfina() {
        return valegypvaringrfina;
    }

    public void setValegypvaringrfina(String valegypvaringrfina) {
        this.valegypvaringrfina = valegypvaringrfina;
    }

    public String getValegypvarpartrela() {
        return valegypvarpartrela;
    }

    public void setValegypvarpartrela(String valegypvarpartrela) {
        this.valegypvarpartrela = valegypvarpartrela;
    }

    public String getValegypvarutilordi() {
        return valegypvarutilordi;
    }

    public void setValegypvarutilordi(String valegypvarutilordi) {
        this.valegypvarutilordi = valegypvarutilordi;
    }

    public String getValegypvaringrextrccja() {
        return valegypvaringrextrccja;
    }

    public void setValegypvaringrextrccja(String valegypvaringrextrccja) {
        this.valegypvaringrextrccja = valegypvaringrextrccja;
    }

    public String getValegypvaregreextrccaja() {
        return valegypvaregreextrccaja;
    }

    public void setValegypvaregreextrccaja(String valegypvaregreextrccaja) {
        this.valegypvaregreextrccaja = valegypvaregreextrccaja;
    }

    public String getValegypvaringrextrscja() {
        return valegypvaringrextrscja;
    }

    public void setValegypvaringrextrscja(String valegypvaringrextrscja) {
        this.valegypvaringrextrscja = valegypvaringrextrscja;
    }

    public String getValegypvaregreextrscja() {
        return valegypvaregreextrscja;
    }

    public void setValegypvaregreextrscja(String valegypvaregreextrscja) {
        this.valegypvaregreextrscja = valegypvaregreextrscja;
    }

    public String getValegypvarotroingr() {
        return valegypvarotroingr;
    }

    public void setValegypvarotroingr(String valegypvarotroingr) {
        this.valegypvarotroingr = valegypvarotroingr;
    }

    public String getValegypvarotroegre() {
        return valegypvarotroegre;
    }

    public void setValegypvarotroegre(String valegypvarotroegre) {
        this.valegypvarotroegre = valegypvarotroegre;
    }

    public String getValegypvarutilanteimp() {
        return valegypvarutilanteimp;
    }

    public void setValegypvarutilanteimp(String valegypvarutilanteimp) {
        this.valegypvarutilanteimp = valegypvarutilanteimp;
    }

    public String getValegypvarimppart() {
        return valegypvarimppart;
    }

    public void setValegypvarimppart(String valegypvarimppart) {
        this.valegypvarimppart = valegypvarimppart;
    }

    public String getValegypvarutilperdneta() {
        return valegypvarutilperdneta;
    }

    public void setValegypvarutilperdneta(String valegypvarutilperdneta) {
        this.valegypvarutilperdneta = valegypvarutilperdneta;
    }

    public String getValrativardepramorejer() {
        return valrativardepramorejer;
    }

    public void setValrativardepramorejer(String valrativardepramorejer) {
        this.valrativardepramorejer = valrativardepramorejer;
    }

    public String getValrativardivi() {
        return valrativardivi;
    }

    public void setValrativardivi(String valrativardivi) {
        this.valrativardivi = valrativardivi;
    }

    public String getValbgvaraccajabcos() {
        return valbgvaraccajabcos;
    }

    public void setValbgvaraccajabcos(String valbgvaraccajabcos) {
        this.valbgvaraccajabcos = valbgvaraccajabcos;
    }

    public String getValbgvaracvalonego() {
        return valbgvaracvalonego;
    }

    public void setValbgvaracvalonego(String valbgvaracvalonego) {
        this.valbgvaracvalonego = valbgvaracvalonego;
    }

    public String getValbgvaracclie() {
        return valbgvaracclie;
    }

    public void setValbgvaracclie(String valbgvaracclie) {
        this.valbgvaracclie = valbgvaracclie;
    }

    public String getValbgvaracprovcobrdud() {
        return valbgvaracprovcobrdud;
    }

    public void setValbgvaracprovcobrdud(String valbgvaracprovcobrdud) {
        this.valbgvaracprovcobrdud = valbgvaracprovcobrdud;
    }

    public String getValbgvaraccxcsrel() {
        return valbgvaraccxcsrel;
    }

    public void setValbgvaraccxcsrel(String valbgvaraccxcsrel) {
        this.valbgvaraccxcsrel = valbgvaraccxcsrel;
    }

    public String getValbgvaraccxcdive() {
        return valbgvaraccxcdive;
    }

    public void setValbgvaraccxcdive(String valbgvaraccxcdive) {
        this.valbgvaraccxcdive = valbgvaraccxcdive;
    }

    public String getValbgvaracexist() {
        return valbgvaracexist;
    }

    public void setValbgvaracexist(String valbgvaracexist) {
        this.valbgvaracexist = valbgvaracexist;
    }

    public String getValbgvaracgastpagaanti() {
        return valbgvaracgastpagaanti;
    }

    public void setValbgvaracgastpagaanti(String valbgvaracgastpagaanti) {
        this.valbgvaracgastpagaanti = valbgvaracgastpagaanti;
    }

    public String getValbgvarac() {
        return valbgvarac;
    }

    public void setValbgvarac(String valbgvarac) {
        this.valbgvarac = valbgvarac;
    }

    public String getValbgvarancinverela() {
        return valbgvarancinverela;
    }

    public void setValbgvarancinverela(String valbgvarancinverela) {
        this.valbgvarancinverela = valbgvarancinverela;
    }

    public String getValbgvarancotrainve() {
        return valbgvarancotrainve;
    }

    public void setValbgvarancotrainve(String valbgvarancotrainve) {
        this.valbgvarancotrainve = valbgvarancotrainve;
    }

    public String getValbgvaranccxcsrel() {
        return valbgvaranccxcsrel;
    }

    public void setValbgvaranccxcsrel(String valbgvaranccxcsrel) {
        this.valbgvaranccxcsrel = valbgvaranccxcsrel;
    }

    public String getValbgvarancinmuneto() {
        return valbgvarancinmuneto;
    }

    public void setValbgvarancinmuneto(String valbgvarancinmuneto) {
        this.valbgvarancinmuneto = valbgvarancinmuneto;
    }

    public String getValbgvarancterr() {
        return valbgvarancterr;
    }

    public void setValbgvarancterr(String valbgvarancterr) {
        this.valbgvarancterr = valbgvarancterr;
    }

    public String getValbgvarancedif() {
        return valbgvarancedif;
    }

    public void setValbgvarancedif(String valbgvarancedif) {
        this.valbgvarancedif = valbgvarancedif;
    }

    public String getValbgvarancmaqu() {
        return valbgvarancmaqu;
    }

    public void setValbgvarancmaqu(String valbgvarancmaqu) {
        this.valbgvarancmaqu = valbgvarancmaqu;
    }

    public String getValbgvarancmueb() {
        return valbgvarancmueb;
    }

    public void setValbgvarancmueb(String valbgvarancmueb) {
        this.valbgvarancmueb = valbgvarancmueb;
    }

    public String getValbgvarancunidtrans() {
        return valbgvarancunidtrans;
    }

    public void setValbgvarancunidtrans(String valbgvarancunidtrans) {
        this.valbgvarancunidtrans = valbgvarancunidtrans;
    }

    public String getValbgvarancequidive() {
        return valbgvarancequidive;
    }

    public void setValbgvarancequidive(String valbgvarancequidive) {
        this.valbgvarancequidive = valbgvarancequidive;
    }

    public String getValbgvarancdepracum() {
        return valbgvarancdepracum;
    }

    public void setValbgvarancdepracum(String valbgvarancdepracum) {
        this.valbgvarancdepracum = valbgvarancdepracum;
    }

    public String getValbgvaranctrab() {
        return valbgvaranctrab;
    }

    public void setValbgvaranctrab(String valbgvaranctrab) {
        this.valbgvaranctrab = valbgvaranctrab;
    }

    public String getValbgvarancotroacti() {
        return valbgvarancotroacti;
    }

    public void setValbgvarancotroacti(String valbgvarancotroacti) {
        this.valbgvarancotroacti = valbgvarancotroacti;
    }

    public String getValbgvarancintan() {
        return valbgvarancintan;
    }

    public void setValbgvarancintan(String valbgvarancintan) {
        this.valbgvarancintan = valbgvarancintan;
    }

    public String getValbgvarancotroanc() {
        return valbgvarancotroanc;
    }

    public void setValbgvarancotroanc(String valbgvarancotroanc) {
        this.valbgvarancotroanc = valbgvarancotroanc;
    }

    public String getValbgvaranc() {
        return valbgvaranc;
    }

    public void setValbgvaranc(String valbgvaranc) {
        this.valbgvaranc = valbgvaranc;
    }

    public String getValbgvartotaacti() {
        return valbgvartotaacti;
    }

    public void setValbgvartotaacti(String valbgvartotaacti) {
        this.valbgvartotaacti = valbgvartotaacti;
    }

    public String getValbgvarpcbancdfinacp() {
        return valbgvarpcbancdfinacp;
    }

    public void setValbgvarpcbancdfinacp(String valbgvarpcbancdfinacp) {
        this.valbgvarpcbancdfinacp = valbgvarpcbancdfinacp;
    }

    public String getValbgvarpcotradfinacp() {
        return valbgvarpcotradfinacp;
    }

    public void setValbgvarpcotradfinacp(String valbgvarpcotradfinacp) {
        this.valbgvarpcotradfinacp = valbgvarpcotradfinacp;
    }

    public String getValbgvarpcdeudlp() {
        return valbgvarpcdeudlp;
    }

    public void setValbgvarpcdeudlp(String valbgvarpcdeudlp) {
        this.valbgvarpcdeudlp = valbgvarpcdeudlp;
    }

    public String getValbgvarpctribpaga() {
        return valbgvarpctribpaga;
    }

    public void setValbgvarpctribpaga(String valbgvarpctribpaga) {
        this.valbgvarpctribpaga = valbgvarpctribpaga;
    }

    public String getValbgvarpcremupaga() {
        return valbgvarpcremupaga;
    }

    public void setValbgvarpcremupaga(String valbgvarpcremupaga) {
        this.valbgvarpcremupaga = valbgvarpcremupaga;
    }

    public String getValbgvarpcprov() {
        return valbgvarpcprov;
    }

    public void setValbgvarpcprov(String valbgvarpcprov) {
        this.valbgvarpcprov = valbgvarpcprov;
    }

    public String getValbgvarpccxpsrel() {
        return valbgvarpccxpsrel;
    }

    public void setValbgvarpccxpsrel(String valbgvarpccxpsrel) {
        this.valbgvarpccxpsrel = valbgvarpccxpsrel;
    }

    public String getValbgvarpccxpdive() {
        return valbgvarpccxpdive;
    }

    public void setValbgvarpccxpdive(String valbgvarpccxpdive) {
        this.valbgvarpccxpdive = valbgvarpccxpdive;
    }

    public String getValbgvarpc() {
        return valbgvarpc;
    }

    public void setValbgvarpc(String valbgvarpc) {
        this.valbgvarpc = valbgvarpc;
    }

    public String getValbgvarpncbcosdfinalp() {
        return valbgvarpncbcosdfinalp;
    }

    public void setValbgvarpncbcosdfinalp(String valbgvarpncbcosdfinalp) {
        this.valbgvarpncbcosdfinalp = valbgvarpncbcosdfinalp;
    }

    public String getValbgvarpncotradfinalp() {
        return valbgvarpncotradfinalp;
    }

    public void setValbgvarpncotradfinalp(String valbgvarpncotradfinalp) {
        this.valbgvarpncotradfinalp = valbgvarpncotradfinalp;
    }

    public String getValbgvarpnccxpsrel() {
        return valbgvarpnccxpsrel;
    }

    public void setValbgvarpnccxpsrel(String valbgvarpnccxpsrel) {
        this.valbgvarpnccxpsrel = valbgvarpnccxpsrel;
    }

    public String getValbgvarpncotropnc() {
        return valbgvarpncotropnc;
    }

    public void setValbgvarpncotropnc(String valbgvarpncotropnc) {
        this.valbgvarpncotropnc = valbgvarpncotropnc;
    }

    public String getValbgvarpncganadife() {
        return valbgvarpncganadife;
    }

    public void setValbgvarpncganadife(String valbgvarpncganadife) {
        this.valbgvarpncganadife = valbgvarpncganadife;
    }

    public String getValbgvarpnc() {
        return valbgvarpnc;
    }

    public void setValbgvarpnc(String valbgvarpnc) {
        this.valbgvarpnc = valbgvarpnc;
    }

    public String getValbgvartotapasi() {
        return valbgvartotapasi;
    }

    public void setValbgvartotapasi(String valbgvartotapasi) {
        this.valbgvartotapasi = valbgvartotapasi;
    }

    public String getValbgvarpatcapi() {
        return valbgvarpatcapi;
    }

    public void setValbgvarpatcapi(String valbgvarpatcapi) {
        this.valbgvarpatcapi = valbgvarpatcapi;
    }

    public String getValbgvarpatcapadic() {
        return valbgvarpatcapadic;
    }

    public void setValbgvarpatcapadic(String valbgvarpatcapadic) {
        this.valbgvarpatcapadic = valbgvarpatcapadic;
    }

    public String getValbgvarpatexcereva() {
        return valbgvarpatexcereva;
    }

    public void setValbgvarpatexcereva(String valbgvarpatexcereva) {
        this.valbgvarpatexcereva = valbgvarpatexcereva;
    }

    public String getValbgvarpatrese() {
        return valbgvarpatrese;
    }

    public void setValbgvarpatrese(String valbgvarpatrese) {
        this.valbgvarpatrese = valbgvarpatrese;
    }

    public String getValbgvarpatresuacum() {
        return valbgvarpatresuacum;
    }

    public void setValbgvarpatresuacum(String valbgvarpatresuacum) {
        this.valbgvarpatresuacum = valbgvarpatresuacum;
    }

    public String getValbgvarpatresuejer() {
        return valbgvarpatresuejer;
    }

    public void setValbgvarpatresuejer(String valbgvarpatresuejer) {
        this.valbgvarpatresuejer = valbgvarpatresuejer;
    }

    public String getValbgvarpatotro() {
        return valbgvarpatotro;
    }

    public void setValbgvarpatotro(String valbgvarpatotro) {
        this.valbgvarpatotro = valbgvarpatotro;
    }

    public String getValbgvarpat() {
        return valbgvarpat;
    }

    public void setValbgvarpat(String valbgvarpat) {
        this.valbgvarpat = valbgvarpat;
    }

    public String getValvartotapasipatr() {
        return valvartotapasipatr;
    }

    public void setValvartotapasipatr(String valvartotapasipatr) {
        this.valvartotapasipatr = valvartotapasipatr;
    }

    public String getValghistebitdaanual() {
        return valghistebitdaanual;
    }

    public void setValghistebitdaanual(String valghistebitdaanual) {
        this.valghistebitdaanual = valghistebitdaanual;
    }

    public String getValghistcashflowanual() {
        return valghistcashflowanual;
    }

    public void setValghistcashflowanual(String valghistcashflowanual) {
        this.valghistcashflowanual = valghistcashflowanual;
    }

    
    
    
}
