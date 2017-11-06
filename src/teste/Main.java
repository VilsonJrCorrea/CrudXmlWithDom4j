package teste;

import dom4j.Dao;
import model.Concurso;

public class Main {
    public static void main(String[] args) {
        Dao dao = new Dao("SorteiosMegaSena.xml");

        //Buscar concurso
        Concurso concurso = dao.getConcurso(1000);
        System.out.println(concurso.toString());

        //Remover um concurso
        dao.removerRegistro(1);

        //Cadastrar novo concurso
        Concurso ultimoConcurso = new Concurso();
        ultimoConcurso.setNumero(1984);
        ultimoConcurso.setData("04/11/2017");
        ultimoConcurso.setArrecadacaoTotal(23646889);
        ultimoConcurso.setAcumulado("Sim");
        ultimoConcurso.setValorAcumulado(16000000);
        ultimoConcurso.setGanhadoresQuadra(1743);
        ultimoConcurso.setGanhadoresQuina(13);
        ultimoConcurso.setGanhadoresSena(0);
        ultimoConcurso.addNumero(21);
        ultimoConcurso.addNumero(29);
        ultimoConcurso.addNumero(32);
        ultimoConcurso.addNumero(35);
        ultimoConcurso.addNumero(43);
        ultimoConcurso.addNumero(50);

        dao.criarRegistro(ultimoConcurso);


        //Atualizar um concurso
        Concurso errataConcurso1983 = new Concurso();
        errataConcurso1983.setNumero(1983);
        errataConcurso1983.setData("01/11/2017");
        errataConcurso1983.setArrecadacaoTotal(30465738);
        errataConcurso1983.setAcumulado("Não");
        errataConcurso1983.setValorAcumulado(0);
        errataConcurso1983.setGanhadoresQuadra(4884);
        errataConcurso1983.setGanhadoresQuina(73);
        errataConcurso1983.setGanhadoresSena(1);
        errataConcurso1983.addNumero(14);
        errataConcurso1983.addNumero(22);
        errataConcurso1983.addNumero(6);
        errataConcurso1983.addNumero(5);
        errataConcurso1983.addNumero(10);
        errataConcurso1983.addNumero(36);
        System.out.println(errataConcurso1983.toString());
        dao.atualizarRegistro(1983, errataConcurso1983);

    }
}
