package pe.com.divemotor.solicitudcredito.dto.procedure.resumenFinanciero;
//EGH

import pe.com.divemotor.generico.dto.BaseProcedure;

public class InsertarResumenFinancieroProcedure extends BaseProcedure {
    private String codSoliCred;
    private String codcliente;
    private Integer valanoeeff;
    private Integer indice;
    private String codmoneeeff;
    private double valegypvtastota;
    private double valegypcostvtasserv;
    private double valegyputilbrut;
    private double valegypgastvtas;
    private double valegypgastadmi;
    private double valegypotroingrgast;
    private double valegyputiloper;
    private double valegypgastfina;
    private double valegypingrfina;
    private double valegyppartrela;
    private double valegyputilordi;
    private double valegypingrextrccja;
    private double valegypegreextrccaja;
    private double valegypingrextrscja;
    private double valegypegreextrscja;
    private double valegypotroingr;
    private double valegypotroegre;
    private double valegyputilanteimp;
    private double valegypimppart;
    private double valegyputilperdneta;
    private double valraticapitrab;
    private double valratidiasexist;
    private double valraticobrclie;
    private double valratipagoprov;
    private double valraticicloper;
    private double valratipasitotapatr;
    private double valratideudfinabrut;
    private double valratideudfinaestr;
    private double valratiporcvarvtas;
    private double valratiebitdaanual;
    private double valratiporcebitdavtas;
    private double valratiporcroe;
    private double valratiporcroa;
    private double valraticashflow;
    private double valratiporccashflowvtas;
    private double valratideudfinabrutanos;
    private double valratideudfinaestranos;
    private double valratideudfinaebitda;
    private double valratiebitda;
    private double valratidepramorejer;
    private double valratidivi;
    private double valratinromese;
    private double valbgaccajabcos;
    private double valbgacvalonego;
    private double valbgacclie;
    private double valbgacprovcobrdud;
    private double valbgaccxcsrel;
    private double valbgaccxcdive;
    private double valbgacexist;
    private double valbgacgastpagaanti;
    private double valbgac;
    private double valbgancinverela;
    private double valbgancotrainve;
    private double valbganccxcsrel;
    private double valbgancinmuneto;
    private double valbgancterr;
    private double valbgancedif;
    private double valbgancmaqu;
    private double valbgancmueb;
    private double valbgancunidtrans;
    private double valbgancequidive;
    private double valbgancdepracum;
    private double valbganctrab;
    private double valbgancotroacti;
    private double valbgancintan;
    private double valbgancotroanc;
    private double valbganc;
    private double valbgtotaacti;
    private double valbgpcbancdeudfinacp;//valbgpcbancdfinacp;//
    private double valbgpcotradeudfinacp;
    private double valbgpcdeudlp;
    private double valbgpctribpaga;
    private double valbgpcremupaga;
    private double valbgpcprov;
    private double valbgpccxpsrel;
    private double valbgpccxpdive;
    private double valbgpc;
    private double valbgpncbcosdeudfinalp;
    private double valbgpncotradeudfinalp;
    private double valbgpnccxpsrel;
    private double valbgpncotropnc;
    private double valbgpncganadife;
    private double valbgpnc;
    private double valbgtotapasi;
    private double valbgpatcapi;
    private double valbgpatcapadic;
    private double valbgpatexcereva;
    private double valbgpatrese;
    private double valbgpatresuacum;
    private double valbgpatresuejer;
    private double valbgpatotro;
    private double valbgpat;
    private double valtotapasipatr;
    private double valcdreactipasipatr;
    private double valegypvarvtastota;
    private double valegypvarcostvtasserv;
    private double valegypvarutilbrut;
    private double valegypvargastvtas;
    private double valegypvargastadmi;
    private double valegypvarotroingrgast;
    private double valegypvarutiloper;
    private double valegypvargastfina;
    private double valegypvaringrfina;
    private double valegypvarpartrela;
    private double valegypvarutilordi;
    private double valegypvaringrextrccja;
    private double valegypvaregreextrccaja;
    private double valegypvaringrextrscja;
    private double valegypvaregreextrscja;
    private double valegypvarotroingr;
    private double valegypvarotroegre;
    private double valegypvarutilanteimp;
    private double valegypvarimppart;
    private double valegypvarutilperdneta;
    private double valrativardepramorejer;
    private double valrativardivi;
    private double valbgvaraccajabcos;
    private double valbgvaracvalonego;
    private double valbgvaracclie;
    private double valbgvaracprovcobrdud;
    private double valbgvaraccxcsrel;
    private double valbgvaraccxcdive;
    private double valbgvaracexist;
    private double valbgvaracgastpagaanti;
    private double valbgvarac;
    private double valbgvarancinverela;
    private double valbgvarancotrainve;
    private double valbgvaranccxcsrel;
    private double valbgvarancinmuneto;
    private double valbgvarancterr;
    private double valbgvarancedif;
    private double valbgvarancmaqu;
    private double valbgvarancmueb;
    private double valbgvarancunidtrans;
    private double valbgvarancequidive;
    private double valbgvarancdepracum;
    private double valbgvaranctrab;
    private double valbgvarancotroacti;
    private double valbgvarancintan;
    private double valbgvarancotroanc;
    private double valbgvaranc;
    private double valbgvartotaacti;
    private double valbgvarpcbancdfinacp;
    private double valbgvarpcotradfinacp;
    private double valbgvarpcdeudlp;
    private double valbgvarpctribpaga;
    private double valbgvarpcremupaga;
    private double valbgvarpcprov;
    private double valbgvarpccxpsrel;
    private double valbgvarpccxpdive;
    private double valbgvarpc;
    private double valbgvarpncbcosdfinalp;
    private double valbgvarpncotradfinalp;
    private double valbgvarpnccxpsrel;
    private double valbgvarpncotropnc;
    private double valbgvarpncganadife;
    private double valbgvarpnc;
    private double valbgvartotapasi;
    private double valbgvarpatcapi;
    private double valbgvarpatcapadic;
    private double valbgvarpatexcereva;
    private double valbgvarpatrese;
    private double valbgvarpatresuacum;
    private double valbgvarpatresuejer;
    private double valbgvarpatotro;
    private double valbgvarpat;
    private double valvartotapasipatr;
    //extras
    private double valghistebitdaanual;
    private double valghistcashflowanual;

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

    public double getValegypvtastota() {
        return valegypvtastota;
    }

    public void setValegypvtastota(double valegypvtastota) {
        this.valegypvtastota = valegypvtastota;
    }

    public double getValegypcostvtasserv() {
        return valegypcostvtasserv;
    }

    public void setValegypcostvtasserv(double valegypcostvtasserv) {
        this.valegypcostvtasserv = valegypcostvtasserv;
    }

    public double getValegyputilbrut() {
        return valegyputilbrut;
    }

    public void setValegyputilbrut(double valegyputilbrut) {
        this.valegyputilbrut = valegyputilbrut;
    }

    public double getValegypgastvtas() {
        return valegypgastvtas;
    }

    public void setValegypgastvtas(double valegypgastvtas) {
        this.valegypgastvtas = valegypgastvtas;
    }

    public double getValegypgastadmi() {
        return valegypgastadmi;
    }

    public void setValegypgastadmi(double valegypgastadmi) {
        this.valegypgastadmi = valegypgastadmi;
    }

    public double getValegypotroingrgast() {
        return valegypotroingrgast;
    }

    public void setValegypotroingrgast(double valegypotroingrgast) {
        this.valegypotroingrgast = valegypotroingrgast;
    }

    public double getValegyputiloper() {
        return valegyputiloper;
    }

    public void setValegyputiloper(double valegyputiloper) {
        this.valegyputiloper = valegyputiloper;
    }

    public double getValegypgastfina() {
        return valegypgastfina;
    }

    public void setValegypgastfina(double valegypgastfina) {
        this.valegypgastfina = valegypgastfina;
    }

    public double getValegypingrfina() {
        return valegypingrfina;
    }

    public void setValegypingrfina(double valegypingrfina) {
        this.valegypingrfina = valegypingrfina;
    }

    public double getValegyppartrela() {
        return valegyppartrela;
    }

    public void setValegyppartrela(double valegyppartrela) {
        this.valegyppartrela = valegyppartrela;
    }

    public double getValegyputilordi() {
        return valegyputilordi;
    }

    public void setValegyputilordi(double valegyputilordi) {
        this.valegyputilordi = valegyputilordi;
    }

    public double getValegypingrextrccja() {
        return valegypingrextrccja;
    }

    public void setValegypingrextrccja(double valegypingrextrccja) {
        this.valegypingrextrccja = valegypingrextrccja;
    }

    public double getValegypegreextrccaja() {
        return valegypegreextrccaja;
    }

    public void setValegypegreextrccaja(double valegypegreextrccaja) {
        this.valegypegreextrccaja = valegypegreextrccaja;
    }

    public double getValegypingrextrscja() {
        return valegypingrextrscja;
    }

    public void setValegypingrextrscja(double valegypingrextrscja) {
        this.valegypingrextrscja = valegypingrextrscja;
    }

    public double getValegypegreextrscja() {
        return valegypegreextrscja;
    }

    public void setValegypegreextrscja(double valegypegreextrscja) {
        this.valegypegreextrscja = valegypegreextrscja;
    }

    public double getValegypotroingr() {
        return valegypotroingr;
    }

    public void setValegypotroingr(double valegypotroingr) {
        this.valegypotroingr = valegypotroingr;
    }

    public double getValegypotroegre() {
        return valegypotroegre;
    }

    public void setValegypotroegre(double valegypotroegre) {
        this.valegypotroegre = valegypotroegre;
    }

    public double getValegyputilanteimp() {
        return valegyputilanteimp;
    }

    public void setValegyputilanteimp(double valegyputilanteimp) {
        this.valegyputilanteimp = valegyputilanteimp;
    }

    public double getValegypimppart() {
        return valegypimppart;
    }

    public void setValegypimppart(double valegypimppart) {
        this.valegypimppart = valegypimppart;
    }

    public double getValegyputilperdneta() {
        return valegyputilperdneta;
    }

    public void setValegyputilperdneta(double valegyputilperdneta) {
        this.valegyputilperdneta = valegyputilperdneta;
    }

    public double getValraticapitrab() {
        return valraticapitrab;
    }

    public void setValraticapitrab(double valraticapitrab) {
        this.valraticapitrab = valraticapitrab;
    }

    public double getValratidiasexist() {
        return valratidiasexist;
    }

    public void setValratidiasexist(double valratidiasexist) {
        this.valratidiasexist = valratidiasexist;
    }

    public double getValraticobrclie() {
        return valraticobrclie;
    }

    public void setValraticobrclie(double valraticobrclie) {
        this.valraticobrclie = valraticobrclie;
    }

    public double getValratipagoprov() {
        return valratipagoprov;
    }

    public void setValratipagoprov(double valratipagoprov) {
        this.valratipagoprov = valratipagoprov;
    }

    public double getValraticicloper() {
        return valraticicloper;
    }

    public void setValraticicloper(double valraticicloper) {
        this.valraticicloper = valraticicloper;
    }

    public double getValratipasitotapatr() {
        return valratipasitotapatr;
    }

    public void setValratipasitotapatr(double valratipasitotapatr) {
        this.valratipasitotapatr = valratipasitotapatr;
    }

    public double getValratideudfinabrut() {
        return valratideudfinabrut;
    }

    public void setValratideudfinabrut(double valratideudfinabrut) {
        this.valratideudfinabrut = valratideudfinabrut;
    }

    public double getValratideudfinaestr() {
        return valratideudfinaestr;
    }

    public void setValratideudfinaestr(double valratideudfinaestr) {
        this.valratideudfinaestr = valratideudfinaestr;
    }

    public double getValratiporcvarvtas() {
        return valratiporcvarvtas;
    }

    public void setValratiporcvarvtas(double valratiporcvarvtas) {
        this.valratiporcvarvtas = valratiporcvarvtas;
    }

    public double getValratiebitdaanual() {
        return valratiebitdaanual;
    }

    public void setValratiebitdaanual(double valratiebitdaanual) {
        this.valratiebitdaanual = valratiebitdaanual;
    }

    public double getValratiporcebitdavtas() {
        return valratiporcebitdavtas;
    }

    public void setValratiporcebitdavtas(double valratiporcebitdavtas) {
        this.valratiporcebitdavtas = valratiporcebitdavtas;
    }

    public double getValratiporcroe() {
        return valratiporcroe;
    }

    public void setValratiporcroe(double valratiporcroe) {
        this.valratiporcroe = valratiporcroe;
    }

    public double getValratiporcroa() {
        return valratiporcroa;
    }

    public void setValratiporcroa(double valratiporcroa) {
        this.valratiporcroa = valratiporcroa;
    }

    public double getValraticashflow() {
        return valraticashflow;
    }

    public void setValraticashflow(double valraticashflow) {
        this.valraticashflow = valraticashflow;
    }

    public double getValratiporccashflowvtas() {
        return valratiporccashflowvtas;
    }

    public void setValratiporccashflowvtas(double valratiporccashflowvtas) {
        this.valratiporccashflowvtas = valratiporccashflowvtas;
    }

    public double getValratideudfinabrutanos() {
        return valratideudfinabrutanos;
    }

    public void setValratideudfinabrutanos(double valratideudfinabrutanos) {
        this.valratideudfinabrutanos = valratideudfinabrutanos;
    }

    public double getValratideudfinaestranos() {
        return valratideudfinaestranos;
    }

    public void setValratideudfinaestranos(double valratideudfinaestranos) {
        this.valratideudfinaestranos = valratideudfinaestranos;
    }

    public double getValratideudfinaebitda() {
        return valratideudfinaebitda;
    }

    public void setValratideudfinaebitda(double valratideudfinaebitda) {
        this.valratideudfinaebitda = valratideudfinaebitda;
    }

    public double getValratiebitda() {
        return valratiebitda;
    }

    public void setValratiebitda(double valratiebitda) {
        this.valratiebitda = valratiebitda;
    }

    public double getValratidepramorejer() {
        return valratidepramorejer;
    }

    public void setValratidepramorejer(double valratidepramorejer) {
        this.valratidepramorejer = valratidepramorejer;
    }

    public double getValratidivi() {
        return valratidivi;
    }

    public void setValratidivi(double valratidivi) {
        this.valratidivi = valratidivi;
    }

    public double getValratinromese() {
        return valratinromese;
    }

    public void setValratinromese(double valratinromese) {
        this.valratinromese = valratinromese;
    }

    public double getValbgaccajabcos() {
        return valbgaccajabcos;
    }

    public void setValbgaccajabcos(double valbgaccajabcos) {
        this.valbgaccajabcos = valbgaccajabcos;
    }

    public double getValbgacvalonego() {
        return valbgacvalonego;
    }

    public void setValbgacvalonego(double valbgacvalonego) {
        this.valbgacvalonego = valbgacvalonego;
    }

    public double getValbgacclie() {
        return valbgacclie;
    }

    public void setValbgacclie(double valbgacclie) {
        this.valbgacclie = valbgacclie;
    }

    public double getValbgacprovcobrdud() {
        return valbgacprovcobrdud;
    }

    public void setValbgacprovcobrdud(double valbgacprovcobrdud) {
        this.valbgacprovcobrdud = valbgacprovcobrdud;
    }

    public double getValbgaccxcsrel() {
        return valbgaccxcsrel;
    }

    public void setValbgaccxcsrel(double valbgaccxcsrel) {
        this.valbgaccxcsrel = valbgaccxcsrel;
    }

    public double getValbgaccxcdive() {
        return valbgaccxcdive;
    }

    public void setValbgaccxcdive(double valbgaccxcdive) {
        this.valbgaccxcdive = valbgaccxcdive;
    }

    public double getValbgacexist() {
        return valbgacexist;
    }

    public void setValbgacexist(double valbgacexist) {
        this.valbgacexist = valbgacexist;
    }

    public double getValbgacgastpagaanti() {
        return valbgacgastpagaanti;
    }

    public void setValbgacgastpagaanti(double valbgacgastpagaanti) {
        this.valbgacgastpagaanti = valbgacgastpagaanti;
    }

    public double getValbgac() {
        return valbgac;
    }

    public void setValbgac(double valbgac) {
        this.valbgac = valbgac;
    }

    public double getValbgancinverela() {
        return valbgancinverela;
    }

    public void setValbgancinverela(double valbgancinverela) {
        this.valbgancinverela = valbgancinverela;
    }

    public double getValbgancotrainve() {
        return valbgancotrainve;
    }

    public void setValbgancotrainve(double valbgancotrainve) {
        this.valbgancotrainve = valbgancotrainve;
    }

    public double getValbganccxcsrel() {
        return valbganccxcsrel;
    }

    public void setValbganccxcsrel(double valbganccxcsrel) {
        this.valbganccxcsrel = valbganccxcsrel;
    }

    public double getValbgancinmuneto() {
        return valbgancinmuneto;
    }

    public void setValbgancinmuneto(double valbgancinmuneto) {
        this.valbgancinmuneto = valbgancinmuneto;
    }

    public double getValbgancterr() {
        return valbgancterr;
    }

    public void setValbgancterr(double valbgancterr) {
        this.valbgancterr = valbgancterr;
    }

    public double getValbgancedif() {
        return valbgancedif;
    }

    public void setValbgancedif(double valbgancedif) {
        this.valbgancedif = valbgancedif;
    }

    public double getValbgancmaqu() {
        return valbgancmaqu;
    }

    public void setValbgancmaqu(double valbgancmaqu) {
        this.valbgancmaqu = valbgancmaqu;
    }

    public double getValbgancmueb() {
        return valbgancmueb;
    }

    public void setValbgancmueb(double valbgancmueb) {
        this.valbgancmueb = valbgancmueb;
    }

    public double getValbgancunidtrans() {
        return valbgancunidtrans;
    }

    public void setValbgancunidtrans(double valbgancunidtrans) {
        this.valbgancunidtrans = valbgancunidtrans;
    }

    public double getValbgancequidive() {
        return valbgancequidive;
    }

    public void setValbgancequidive(double valbgancequidive) {
        this.valbgancequidive = valbgancequidive;
    }

    public double getValbgancdepracum() {
        return valbgancdepracum;
    }

    public void setValbgancdepracum(double valbgancdepracum) {
        this.valbgancdepracum = valbgancdepracum;
    }

    public double getValbganctrab() {
        return valbganctrab;
    }

    public void setValbganctrab(double valbganctrab) {
        this.valbganctrab = valbganctrab;
    }

    public double getValbgancotroacti() {
        return valbgancotroacti;
    }

    public void setValbgancotroacti(double valbgancotroacti) {
        this.valbgancotroacti = valbgancotroacti;
    }

    public double getValbgancintan() {
        return valbgancintan;
    }

    public void setValbgancintan(double valbgancintan) {
        this.valbgancintan = valbgancintan;
    }

    public double getValbgancotroanc() {
        return valbgancotroanc;
    }

    public void setValbgancotroanc(double valbgancotroanc) {
        this.valbgancotroanc = valbgancotroanc;
    }

    public double getValbganc() {
        return valbganc;
    }

    public void setValbganc(double valbganc) {
        this.valbganc = valbganc;
    }

    public double getValbgtotaacti() {
        return valbgtotaacti;
    }

    public void setValbgtotaacti(double valbgtotaacti) {
        this.valbgtotaacti = valbgtotaacti;
    }

    public double getValbgpcbancdeudfinacp() {
        return valbgpcbancdeudfinacp;
    }

    public void setValbgpcbancdeudfinacp(double valbgpcbancdeudfinacp) {
        this.valbgpcbancdeudfinacp = valbgpcbancdeudfinacp;
    }

    public double getValbgpcotradeudfinacp() {
        return valbgpcotradeudfinacp;
    }

    public void setValbgpcotradeudfinacp(double valbgpcotradeudfinacp) {
        this.valbgpcotradeudfinacp = valbgpcotradeudfinacp;
    }

    public double getValbgpcdeudlp() {
        return valbgpcdeudlp;
    }

    public void setValbgpcdeudlp(double valbgpcdeudlp) {
        this.valbgpcdeudlp = valbgpcdeudlp;
    }

    public double getValbgpctribpaga() {
        return valbgpctribpaga;
    }

    public void setValbgpctribpaga(double valbgpctribpaga) {
        this.valbgpctribpaga = valbgpctribpaga;
    }

    public double getValbgpcremupaga() {
        return valbgpcremupaga;
    }

    public void setValbgpcremupaga(double valbgpcremupaga) {
        this.valbgpcremupaga = valbgpcremupaga;
    }

    public double getValbgpcprov() {
        return valbgpcprov;
    }

    public void setValbgpcprov(double valbgpcprov) {
        this.valbgpcprov = valbgpcprov;
    }

    public double getValbgpccxpsrel() {
        return valbgpccxpsrel;
    }

    public void setValbgpccxpsrel(double valbgpccxpsrel) {
        this.valbgpccxpsrel = valbgpccxpsrel;
    }

    public double getValbgpccxpdive() {
        return valbgpccxpdive;
    }

    public void setValbgpccxpdive(double valbgpccxpdive) {
        this.valbgpccxpdive = valbgpccxpdive;
    }

    public double getValbgpc() {
        return valbgpc;
    }

    public void setValbgpc(double valbgpc) {
        this.valbgpc = valbgpc;
    }

    public double getValbgpncbcosdeudfinalp() {
        return valbgpncbcosdeudfinalp;
    }

    public void setValbgpncbcosdeudfinalp(double valbgpncbcosdeudfinalp) {
        this.valbgpncbcosdeudfinalp = valbgpncbcosdeudfinalp;
    }

    public double getValbgpncotradeudfinalp() {
        return valbgpncotradeudfinalp;
    }

    public void setValbgpncotradeudfinalp(double valbgpncotradeudfinalp) {
        this.valbgpncotradeudfinalp = valbgpncotradeudfinalp;
    }

    public double getValbgpnccxpsrel() {
        return valbgpnccxpsrel;
    }

    public void setValbgpnccxpsrel(double valbgpnccxpsrel) {
        this.valbgpnccxpsrel = valbgpnccxpsrel;
    }

    public double getValbgpncotropnc() {
        return valbgpncotropnc;
    }

    public void setValbgpncotropnc(double valbgpncotropnc) {
        this.valbgpncotropnc = valbgpncotropnc;
    }

    public double getValbgpncganadife() {
        return valbgpncganadife;
    }

    public void setValbgpncganadife(double valbgpncganadife) {
        this.valbgpncganadife = valbgpncganadife;
    }

    public double getValbgpnc() {
        return valbgpnc;
    }

    public void setValbgpnc(double valbgpnc) {
        this.valbgpnc = valbgpnc;
    }

    public double getValbgtotapasi() {
        return valbgtotapasi;
    }

    public void setValbgtotapasi(double valbgtotapasi) {
        this.valbgtotapasi = valbgtotapasi;
    }

    public double getValbgpatcapi() {
        return valbgpatcapi;
    }

    public void setValbgpatcapi(double valbgpatcapi) {
        this.valbgpatcapi = valbgpatcapi;
    }

    public double getValbgpatcapadic() {
        return valbgpatcapadic;
    }

    public void setValbgpatcapadic(double valbgpatcapadic) {
        this.valbgpatcapadic = valbgpatcapadic;
    }

    public double getValbgpatexcereva() {
        return valbgpatexcereva;
    }

    public void setValbgpatexcereva(double valbgpatexcereva) {
        this.valbgpatexcereva = valbgpatexcereva;
    }

    public double getValbgpatrese() {
        return valbgpatrese;
    }

    public void setValbgpatrese(double valbgpatrese) {
        this.valbgpatrese = valbgpatrese;
    }

    public double getValbgpatresuacum() {
        return valbgpatresuacum;
    }

    public void setValbgpatresuacum(double valbgpatresuacum) {
        this.valbgpatresuacum = valbgpatresuacum;
    }

    public double getValbgpatresuejer() {
        return valbgpatresuejer;
    }

    public void setValbgpatresuejer(double valbgpatresuejer) {
        this.valbgpatresuejer = valbgpatresuejer;
    }

    public double getValbgpatotro() {
        return valbgpatotro;
    }

    public void setValbgpatotro(double valbgpatotro) {
        this.valbgpatotro = valbgpatotro;
    }

    public double getValbgpat() {
        return valbgpat;
    }

    public void setValbgpat(double valbgpat) {
        this.valbgpat = valbgpat;
    }

    public double getValtotapasipatr() {
        return valtotapasipatr;
    }

    public void setValtotapasipatr(double valtotapasipatr) {
        this.valtotapasipatr = valtotapasipatr;
    }

    public double getValcdreactipasipatr() {
        return valcdreactipasipatr;
    }

    public void setValcdreactipasipatr(double valcdreactipasipatr) {
        this.valcdreactipasipatr = valcdreactipasipatr;
    }

    public double getValegypvarvtastota() {
        return valegypvarvtastota;
    }

    public void setValegypvarvtastota(double valegypvarvtastota) {
        this.valegypvarvtastota = valegypvarvtastota;
    }

    public double getValegypvarcostvtasserv() {
        return valegypvarcostvtasserv;
    }

    public void setValegypvarcostvtasserv(double valegypvarcostvtasserv) {
        this.valegypvarcostvtasserv = valegypvarcostvtasserv;
    }

    public double getValegypvarutilbrut() {
        return valegypvarutilbrut;
    }

    public void setValegypvarutilbrut(double valegypvarutilbrut) {
        this.valegypvarutilbrut = valegypvarutilbrut;
    }

    public double getValegypvargastvtas() {
        return valegypvargastvtas;
    }

    public void setValegypvargastvtas(double valegypvargastvtas) {
        this.valegypvargastvtas = valegypvargastvtas;
    }

    public double getValegypvargastadmi() {
        return valegypvargastadmi;
    }

    public void setValegypvargastadmi(double valegypvargastadmi) {
        this.valegypvargastadmi = valegypvargastadmi;
    }

    public double getValegypvarotroingrgast() {
        return valegypvarotroingrgast;
    }

    public void setValegypvarotroingrgast(double valegypvarotroingrgast) {
        this.valegypvarotroingrgast = valegypvarotroingrgast;
    }

    public double getValegypvarutiloper() {
        return valegypvarutiloper;
    }

    public void setValegypvarutiloper(double valegypvarutiloper) {
        this.valegypvarutiloper = valegypvarutiloper;
    }

    public double getValegypvargastfina() {
        return valegypvargastfina;
    }

    public void setValegypvargastfina(double valegypvargastfina) {
        this.valegypvargastfina = valegypvargastfina;
    }

    public double getValegypvaringrfina() {
        return valegypvaringrfina;
    }

    public void setValegypvaringrfina(double valegypvaringrfina) {
        this.valegypvaringrfina = valegypvaringrfina;
    }

    public double getValegypvarpartrela() {
        return valegypvarpartrela;
    }

    public void setValegypvarpartrela(double valegypvarpartrela) {
        this.valegypvarpartrela = valegypvarpartrela;
    }

    public double getValegypvarutilordi() {
        return valegypvarutilordi;
    }

    public void setValegypvarutilordi(double valegypvarutilordi) {
        this.valegypvarutilordi = valegypvarutilordi;
    }

    public double getValegypvaringrextrccja() {
        return valegypvaringrextrccja;
    }

    public void setValegypvaringrextrccja(double valegypvaringrextrccja) {
        this.valegypvaringrextrccja = valegypvaringrextrccja;
    }

    public double getValegypvaregreextrccaja() {
        return valegypvaregreextrccaja;
    }

    public void setValegypvaregreextrccaja(double valegypvaregreextrccaja) {
        this.valegypvaregreextrccaja = valegypvaregreextrccaja;
    }

    public double getValegypvaringrextrscja() {
        return valegypvaringrextrscja;
    }

    public void setValegypvaringrextrscja(double valegypvaringrextrscja) {
        this.valegypvaringrextrscja = valegypvaringrextrscja;
    }

    public double getValegypvaregreextrscja() {
        return valegypvaregreextrscja;
    }

    public void setValegypvaregreextrscja(double valegypvaregreextrscja) {
        this.valegypvaregreextrscja = valegypvaregreextrscja;
    }

    public double getValegypvarotroingr() {
        return valegypvarotroingr;
    }

    public void setValegypvarotroingr(double valegypvarotroingr) {
        this.valegypvarotroingr = valegypvarotroingr;
    }

    public double getValegypvarotroegre() {
        return valegypvarotroegre;
    }

    public void setValegypvarotroegre(double valegypvarotroegre) {
        this.valegypvarotroegre = valegypvarotroegre;
    }

    public double getValegypvarutilanteimp() {
        return valegypvarutilanteimp;
    }

    public void setValegypvarutilanteimp(double valegypvarutilanteimp) {
        this.valegypvarutilanteimp = valegypvarutilanteimp;
    }

    public double getValegypvarimppart() {
        return valegypvarimppart;
    }

    public void setValegypvarimppart(double valegypvarimppart) {
        this.valegypvarimppart = valegypvarimppart;
    }

    public double getValegypvarutilperdneta() {
        return valegypvarutilperdneta;
    }

    public void setValegypvarutilperdneta(double valegypvarutilperdneta) {
        this.valegypvarutilperdneta = valegypvarutilperdneta;
    }

    public double getValrativardepramorejer() {
        return valrativardepramorejer;
    }

    public void setValrativardepramorejer(double valrativardepramorejer) {
        this.valrativardepramorejer = valrativardepramorejer;
    }

    public double getValrativardivi() {
        return valrativardivi;
    }

    public void setValrativardivi(double valrativardivi) {
        this.valrativardivi = valrativardivi;
    }

    public double getValbgvaraccajabcos() {
        return valbgvaraccajabcos;
    }

    public void setValbgvaraccajabcos(double valbgvaraccajabcos) {
        this.valbgvaraccajabcos = valbgvaraccajabcos;
    }

    public double getValbgvaracvalonego() {
        return valbgvaracvalonego;
    }

    public void setValbgvaracvalonego(double valbgvaracvalonego) {
        this.valbgvaracvalonego = valbgvaracvalonego;
    }

    public double getValbgvaracclie() {
        return valbgvaracclie;
    }

    public void setValbgvaracclie(double valbgvaracclie) {
        this.valbgvaracclie = valbgvaracclie;
    }

    public double getValbgvaracprovcobrdud() {
        return valbgvaracprovcobrdud;
    }

    public void setValbgvaracprovcobrdud(double valbgvaracprovcobrdud) {
        this.valbgvaracprovcobrdud = valbgvaracprovcobrdud;
    }

    public double getValbgvaraccxcsrel() {
        return valbgvaraccxcsrel;
    }

    public void setValbgvaraccxcsrel(double valbgvaraccxcsrel) {
        this.valbgvaraccxcsrel = valbgvaraccxcsrel;
    }

    public double getValbgvaraccxcdive() {
        return valbgvaraccxcdive;
    }

    public void setValbgvaraccxcdive(double valbgvaraccxcdive) {
        this.valbgvaraccxcdive = valbgvaraccxcdive;
    }

    public double getValbgvaracexist() {
        return valbgvaracexist;
    }

    public void setValbgvaracexist(double valbgvaracexist) {
        this.valbgvaracexist = valbgvaracexist;
    }

    public double getValbgvaracgastpagaanti() {
        return valbgvaracgastpagaanti;
    }

    public void setValbgvaracgastpagaanti(double valbgvaracgastpagaanti) {
        this.valbgvaracgastpagaanti = valbgvaracgastpagaanti;
    }

    public double getValbgvarac() {
        return valbgvarac;
    }

    public void setValbgvarac(double valbgvarac) {
        this.valbgvarac = valbgvarac;
    }

    public double getValbgvarancinverela() {
        return valbgvarancinverela;
    }

    public void setValbgvarancinverela(double valbgvarancinverela) {
        this.valbgvarancinverela = valbgvarancinverela;
    }

    public double getValbgvarancotrainve() {
        return valbgvarancotrainve;
    }

    public void setValbgvarancotrainve(double valbgvarancotrainve) {
        this.valbgvarancotrainve = valbgvarancotrainve;
    }

    public double getValbgvaranccxcsrel() {
        return valbgvaranccxcsrel;
    }

    public void setValbgvaranccxcsrel(double valbgvaranccxcsrel) {
        this.valbgvaranccxcsrel = valbgvaranccxcsrel;
    }

    public double getValbgvarancinmuneto() {
        return valbgvarancinmuneto;
    }

    public void setValbgvarancinmuneto(double valbgvarancinmuneto) {
        this.valbgvarancinmuneto = valbgvarancinmuneto;
    }

    public double getValbgvarancterr() {
        return valbgvarancterr;
    }

    public void setValbgvarancterr(double valbgvarancterr) {
        this.valbgvarancterr = valbgvarancterr;
    }

    public double getValbgvarancedif() {
        return valbgvarancedif;
    }

    public void setValbgvarancedif(double valbgvarancedif) {
        this.valbgvarancedif = valbgvarancedif;
    }

    public double getValbgvarancmaqu() {
        return valbgvarancmaqu;
    }

    public void setValbgvarancmaqu(double valbgvarancmaqu) {
        this.valbgvarancmaqu = valbgvarancmaqu;
    }

    public double getValbgvarancmueb() {
        return valbgvarancmueb;
    }

    public void setValbgvarancmueb(double valbgvarancmueb) {
        this.valbgvarancmueb = valbgvarancmueb;
    }

    public double getValbgvarancunidtrans() {
        return valbgvarancunidtrans;
    }

    public void setValbgvarancunidtrans(double valbgvarancunidtrans) {
        this.valbgvarancunidtrans = valbgvarancunidtrans;
    }

    public double getValbgvarancequidive() {
        return valbgvarancequidive;
    }

    public void setValbgvarancequidive(double valbgvarancequidive) {
        this.valbgvarancequidive = valbgvarancequidive;
    }

    public double getValbgvarancdepracum() {
        return valbgvarancdepracum;
    }

    public void setValbgvarancdepracum(double valbgvarancdepracum) {
        this.valbgvarancdepracum = valbgvarancdepracum;
    }

    public double getValbgvaranctrab() {
        return valbgvaranctrab;
    }

    public void setValbgvaranctrab(double valbgvaranctrab) {
        this.valbgvaranctrab = valbgvaranctrab;
    }

    public double getValbgvarancotroacti() {
        return valbgvarancotroacti;
    }

    public void setValbgvarancotroacti(double valbgvarancotroacti) {
        this.valbgvarancotroacti = valbgvarancotroacti;
    }

    public double getValbgvarancintan() {
        return valbgvarancintan;
    }

    public void setValbgvarancintan(double valbgvarancintan) {
        this.valbgvarancintan = valbgvarancintan;
    }

    public double getValbgvarancotroanc() {
        return valbgvarancotroanc;
    }

    public void setValbgvarancotroanc(double valbgvarancotroanc) {
        this.valbgvarancotroanc = valbgvarancotroanc;
    }

    public double getValbgvaranc() {
        return valbgvaranc;
    }

    public void setValbgvaranc(double valbgvaranc) {
        this.valbgvaranc = valbgvaranc;
    }

    public double getValbgvartotaacti() {
        return valbgvartotaacti;
    }

    public void setValbgvartotaacti(double valbgvartotaacti) {
        this.valbgvartotaacti = valbgvartotaacti;
    }

    public double getValbgvarpcbancdfinacp() {
        return valbgvarpcbancdfinacp;
    }

    public void setValbgvarpcbancdfinacp(double valbgvarpcbancdfinacp) {
        this.valbgvarpcbancdfinacp = valbgvarpcbancdfinacp;
    }

    public double getValbgvarpcotradfinacp() {
        return valbgvarpcotradfinacp;
    }

    public void setValbgvarpcotradfinacp(double valbgvarpcotradfinacp) {
        this.valbgvarpcotradfinacp = valbgvarpcotradfinacp;
    }

    public double getValbgvarpcdeudlp() {
        return valbgvarpcdeudlp;
    }

    public void setValbgvarpcdeudlp(double valbgvarpcdeudlp) {
        this.valbgvarpcdeudlp = valbgvarpcdeudlp;
    }

    public double getValbgvarpctribpaga() {
        return valbgvarpctribpaga;
    }

    public void setValbgvarpctribpaga(double valbgvarpctribpaga) {
        this.valbgvarpctribpaga = valbgvarpctribpaga;
    }

    public double getValbgvarpcremupaga() {
        return valbgvarpcremupaga;
    }

    public void setValbgvarpcremupaga(double valbgvarpcremupaga) {
        this.valbgvarpcremupaga = valbgvarpcremupaga;
    }

    public double getValbgvarpcprov() {
        return valbgvarpcprov;
    }

    public void setValbgvarpcprov(double valbgvarpcprov) {
        this.valbgvarpcprov = valbgvarpcprov;
    }

    public double getValbgvarpccxpsrel() {
        return valbgvarpccxpsrel;
    }

    public void setValbgvarpccxpsrel(double valbgvarpccxpsrel) {
        this.valbgvarpccxpsrel = valbgvarpccxpsrel;
    }

    public double getValbgvarpccxpdive() {
        return valbgvarpccxpdive;
    }

    public void setValbgvarpccxpdive(double valbgvarpccxpdive) {
        this.valbgvarpccxpdive = valbgvarpccxpdive;
    }

    public double getValbgvarpc() {
        return valbgvarpc;
    }

    public void setValbgvarpc(double valbgvarpc) {
        this.valbgvarpc = valbgvarpc;
    }

    public double getValbgvarpncbcosdfinalp() {
        return valbgvarpncbcosdfinalp;
    }

    public void setValbgvarpncbcosdfinalp(double valbgvarpncbcosdfinalp) {
        this.valbgvarpncbcosdfinalp = valbgvarpncbcosdfinalp;
    }

    public double getValbgvarpncotradfinalp() {
        return valbgvarpncotradfinalp;
    }

    public void setValbgvarpncotradfinalp(double valbgvarpncotradfinalp) {
        this.valbgvarpncotradfinalp = valbgvarpncotradfinalp;
    }

    public double getValbgvarpnccxpsrel() {
        return valbgvarpnccxpsrel;
    }

    public void setValbgvarpnccxpsrel(double valbgvarpnccxpsrel) {
        this.valbgvarpnccxpsrel = valbgvarpnccxpsrel;
    }

    public double getValbgvarpncotropnc() {
        return valbgvarpncotropnc;
    }

    public void setValbgvarpncotropnc(double valbgvarpncotropnc) {
        this.valbgvarpncotropnc = valbgvarpncotropnc;
    }

    public double getValbgvarpncganadife() {
        return valbgvarpncganadife;
    }

    public void setValbgvarpncganadife(double valbgvarpncganadife) {
        this.valbgvarpncganadife = valbgvarpncganadife;
    }

    public double getValbgvarpnc() {
        return valbgvarpnc;
    }

    public void setValbgvarpnc(double valbgvarpnc) {
        this.valbgvarpnc = valbgvarpnc;
    }

    public double getValbgvartotapasi() {
        return valbgvartotapasi;
    }

    public void setValbgvartotapasi(double valbgvartotapasi) {
        this.valbgvartotapasi = valbgvartotapasi;
    }

    public double getValbgvarpatcapi() {
        return valbgvarpatcapi;
    }

    public void setValbgvarpatcapi(double valbgvarpatcapi) {
        this.valbgvarpatcapi = valbgvarpatcapi;
    }

    public double getValbgvarpatcapadic() {
        return valbgvarpatcapadic;
    }

    public void setValbgvarpatcapadic(double valbgvarpatcapadic) {
        this.valbgvarpatcapadic = valbgvarpatcapadic;
    }

    public double getValbgvarpatexcereva() {
        return valbgvarpatexcereva;
    }

    public void setValbgvarpatexcereva(double valbgvarpatexcereva) {
        this.valbgvarpatexcereva = valbgvarpatexcereva;
    }

    public double getValbgvarpatrese() {
        return valbgvarpatrese;
    }

    public void setValbgvarpatrese(double valbgvarpatrese) {
        this.valbgvarpatrese = valbgvarpatrese;
    }

    public double getValbgvarpatresuacum() {
        return valbgvarpatresuacum;
    }

    public void setValbgvarpatresuacum(double valbgvarpatresuacum) {
        this.valbgvarpatresuacum = valbgvarpatresuacum;
    }

    public double getValbgvarpatresuejer() {
        return valbgvarpatresuejer;
    }

    public void setValbgvarpatresuejer(double valbgvarpatresuejer) {
        this.valbgvarpatresuejer = valbgvarpatresuejer;
    }

    public double getValbgvarpatotro() {
        return valbgvarpatotro;
    }

    public void setValbgvarpatotro(double valbgvarpatotro) {
        this.valbgvarpatotro = valbgvarpatotro;
    }

    public double getValbgvarpat() {
        return valbgvarpat;
    }

    public void setValbgvarpat(double valbgvarpat) {
        this.valbgvarpat = valbgvarpat;
    }

    public double getValvartotapasipatr() {
        return valvartotapasipatr;
    }

    public void setValvartotapasipatr(double valvartotapasipatr) {
        this.valvartotapasipatr = valvartotapasipatr;
    }

    public double getValghistebitdaanual() {
        return valghistebitdaanual;
    }

    public void setValghistebitdaanual(double valghistebitdaanual) {
        this.valghistebitdaanual = valghistebitdaanual;
    }

    public double getValghistcashflowanual() {
        return valghistcashflowanual;
    }

    public void setValghistcashflowanual(double valghistcashflowanual) {
        this.valghistcashflowanual = valghistcashflowanual;
    }
    
    
}
