package model;

import java.util.ArrayList;
import java.util.List;

public class Concurso {
    private int numero;
    private String data;
    private double arrecadacaoTotal;
    private List<Integer> numerosSorteados;
    private int ganhadoresSena;
    private int ganhadoresQuina;
    private int ganhadoresQuadra;
    private String acumulado;
    private double valorAcumulado;

    public Concurso(int numero, String data, double arrecadacaoTotal, int ganhadoresSena, int ganhadoresQuina, int ganhadoresQuadra, String acumulado, double valorAcumulado) {
        this.numero = numero;
        this.data = data;
        this.arrecadacaoTotal = arrecadacaoTotal;
        this.ganhadoresSena = ganhadoresSena;
        this.ganhadoresQuina = ganhadoresQuina;
        this.ganhadoresQuadra = ganhadoresQuadra;
        this.acumulado = acumulado;
        this.valorAcumulado = valorAcumulado;
        numerosSorteados = new ArrayList<>();
    }


    public Concurso() {
        numerosSorteados = new ArrayList<>();
    }

    public void addNumero(int numero) {
        numerosSorteados.add(numero);
    }

    public void removerNumero(int numero) {
        numerosSorteados.remove(numero);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getArrecadacaoTotal() {
        return arrecadacaoTotal;
    }

    public void setArrecadacaoTotal(double arrecadacaoTotal) {
        this.arrecadacaoTotal = arrecadacaoTotal;
    }

    public List<Integer> getNumerosSorteados() {
        return numerosSorteados;
    }

    public void setNumerosSorteados(List<Integer> numerosSorteados) {
        this.numerosSorteados = numerosSorteados;
    }

    public int getGanhadoresSena() {
        return ganhadoresSena;
    }

    public void setGanhadoresSena(int ganhadoresSena) {
        this.ganhadoresSena = ganhadoresSena;
    }

    public int getGanhadoresQuina() {
        return ganhadoresQuina;
    }

    public void setGanhadoresQuina(int ganhadoresQuina) {
        this.ganhadoresQuina = ganhadoresQuina;
    }

    public int getGanhadoresQuadra() {
        return ganhadoresQuadra;
    }

    public void setGanhadoresQuadra(int ganhadoresQuadra) {
        this.ganhadoresQuadra = ganhadoresQuadra;
    }

    public String getAcumulado() {
        return acumulado;
    }

    public void setAcumulado(String acumulado) {
        this.acumulado = acumulado;
    }

    public double getValorAcumulado() {
        return valorAcumulado;
    }

    public void setValorAcumulado(double valorAcumulado) {
        this.valorAcumulado = valorAcumulado;
    }

    @Override
    public String toString() {
        return "Concurso{" +
                "numero=" + numero +
                ", data='" + data + '\'' +
                ", arrecadacaoTotal=" + arrecadacaoTotal +
                ", numerosSorteados=" + numerosSorteados +
                ", ganhadoresSena=" + ganhadoresSena +
                ", ganhadoresQuina=" + ganhadoresQuina +
                ", ganhadoresQuadra=" + ganhadoresQuadra +
                ", acumulado='" + acumulado + '\'' +
                ", valorAcumulado=" + valorAcumulado +
                '}';
    }
}
