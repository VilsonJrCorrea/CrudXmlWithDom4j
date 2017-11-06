package dom4j;

import model.Concurso;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class Dao {
    private String file;

    public Dao(String file) {
        this.file = file;
    }

    public Dao() {
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public void criarRegistro(Concurso objConcurso) {
        try {
            File xml = new File(file);
            SAXReader reader = new SAXReader();
            Document document = reader.read(xml);
            Element root = document.getRootElement();
            Element elementConcurso = root.addElement("concurso").addAttribute("numero",
                    Integer.toString(objConcurso.getNumero())).addAttribute("data", objConcurso.getData());

            elementConcurso.addElement("arrecadacao_total").addText(Double.toString(objConcurso.getArrecadacaoTotal()));
            Element elementNumeros = elementConcurso.addElement("numeros_sorteados");

            List<Integer> numerosSorteados = objConcurso.getNumerosSorteados();
            for (int i = 0; i < numerosSorteados.size(); i++) {
                elementNumeros.addElement("bola" + (i + 1)).addText(Integer.toString(numerosSorteados.get(i)));
            }

            elementConcurso.addElement("ganhadores_sena").addText(Integer.toString(objConcurso.getGanhadoresSena()));
            elementConcurso.addElement("ganhadores_quina").addText(Integer.toString(objConcurso.getGanhadoresQuina()));
            elementConcurso.addElement("ganhadores_quadra").addText(Integer.toString(objConcurso.getGanhadoresQuadra()));
            elementConcurso.addElement("acumulado").addText(objConcurso.getAcumulado());
            elementConcurso.addElement("valor_acumulado").addText(Double.toString(objConcurso.getValorAcumulado()));

            OutputFormat format = OutputFormat.createPrettyPrint();
            FileOutputStream fos = new FileOutputStream(file);
            XMLWriter writer = new XMLWriter(fos, format);

            writer.write(document);
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizarRegistro(int id, Concurso objConcurso) {
        try {
            File xml = new File(file);
            SAXReader reader = new SAXReader();
            Document document = reader.read(xml);
            List<Element> elements = document.getRootElement().elements();
            for (int i = 0; i < elements.size(); i++) {
                int numero = 0;
                Element e = elements.get(i);
                numero = Integer.parseInt(e.attributeValue("numero"));
                if (numero == id) {
                    Element root = document.getRootElement();
                    root.remove(e);
                    Element elementConcurso = root.addElement("concurso").addAttribute("numero",
                            Integer.toString(objConcurso.getNumero())).addAttribute("data", objConcurso.getData());

                    elementConcurso.addElement("arrecadacao_total").addText(Double.toString(objConcurso.getArrecadacaoTotal()));
                    Element elementNumeros = elementConcurso.addElement("numeros_sorteados");

                    List<Integer> numerosSorteados = objConcurso.getNumerosSorteados();
                    for (int j = 0; j < numerosSorteados.size(); j++) {
                        elementNumeros.addElement("bola" + (j + 1)).addText(Integer.toString(numerosSorteados.get(j)));
                    }

                    elementConcurso.addElement("ganhadores_sena").addText(Integer.toString(objConcurso.getGanhadoresSena()));
                    elementConcurso.addElement("ganhadores_quina").addText(Integer.toString(objConcurso.getGanhadoresQuina()));
                    elementConcurso.addElement("ganhadores_quadra").addText(Integer.toString(objConcurso.getGanhadoresQuadra()));
                    elementConcurso.addElement("acumulado").addText(objConcurso.getAcumulado());
                    elementConcurso.addElement("valor_acumulado").addText(Double.toString(objConcurso.getValorAcumulado()));

                    OutputFormat format = OutputFormat.createPrettyPrint();
                    FileOutputStream fos = new FileOutputStream(file);
                    XMLWriter writer = new XMLWriter(fos, format);

                    writer.write(document);
                    writer.flush();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removerRegistro(int id) {
        try {
            File xml = new File(file);
            SAXReader reader = new SAXReader();
            Document document = reader.read(xml);
            List<Element> elements = document.getRootElement().elements();
            for (int i = 0; i < elements.size(); i++) {
                int numero = 0;
                Element e = elements.get(i);
                numero = Integer.parseInt(e.attributeValue("numero"));
                if (numero == id) {
                    Element root = document.getRootElement();
                    root.remove(e);

                    OutputFormat format = OutputFormat.createPrettyPrint();
                    FileOutputStream fos = new FileOutputStream(file);
                    XMLWriter writer = new XMLWriter(fos, format);

                    writer.write(document);
                    writer.flush();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Concurso getConcurso(int id) {
        String data;
        double arrecadacaoTotal;
        int ganhadoresSena;
        int ganhadoresQuina;
        int ganhadoresQuadra;
        String acumulado;
        double valorAcumulado;
        Concurso objConcurso = null;
        try {
            File xml = new File(file);
            SAXReader reader = new SAXReader();
            Document document = reader.read(xml);
            List<Element> elements = document.getRootElement().elements();
            for (int i = 0; i < elements.size(); i++) {
                int numero = 0;
                Element e = elements.get(i);
                numero = Integer.parseInt(e.attributeValue("numero"));
                if (numero == id) {
                    objConcurso = new Concurso();
                    objConcurso.setNumero(numero);
                    data = e.attributeValue("data");
                    objConcurso.setData(data);

                    arrecadacaoTotal = Double.parseDouble(e.element("arrecadacao_total").getData().toString());
                    objConcurso.setArrecadacaoTotal(arrecadacaoTotal);

                    ganhadoresQuadra = Integer.parseInt(e.element("ganhadores_quadra").getData().toString());
                    objConcurso.setGanhadoresQuadra(ganhadoresQuadra);

                    ganhadoresQuina = Integer.parseInt(e.element("ganhadores_quina").getData().toString());
                    objConcurso.setGanhadoresQuina(ganhadoresQuina);

                    ganhadoresSena = Integer.parseInt(e.element("ganhadores_sena").getData().toString());
                    objConcurso.setGanhadoresSena(ganhadoresSena);

                    valorAcumulado = Double.parseDouble(e.element("valor_acumulado").getData().toString());
                    objConcurso.setValorAcumulado(valorAcumulado);

                    acumulado = e.element("acumulado").getData().toString();
                    objConcurso.setAcumulado(acumulado);

                    List<Element> numeros = e.element("numeros_sorteados").elements();
                    for (int j = 0; j < numeros.size(); j++) {
                        Element ee = numeros.get(j);
                        objConcurso.addNumero(Integer.parseInt(ee.getData().toString()));
                    }
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objConcurso;
    }
}
