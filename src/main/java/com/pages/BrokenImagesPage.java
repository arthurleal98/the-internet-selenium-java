package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class BrokenImagesPage {
    private final WebDriver driver;


    public BrokenImagesPage(WebDriver driver) {
        this.driver = driver;
    }

    public ArrayList<WebElement> obterImagens() {
        try{
            return (ArrayList<WebElement>) driver.findElements(By.tagName("img"));

        }
        catch (Exception e){
            return new ArrayList<>();
        }
    }



    public boolean verificarImagensQuebradas(ArrayList<WebElement> imagens) {
        boolean imagensQuebradas = false;
        for (WebElement imagem : imagens) {
            if (imagem.getAttribute("naturalWidth").equals("0")) {
                imagensQuebradas = true;
                break;
            }
        }
        return imagensQuebradas;
    }

    public ArrayList<ArrayList<Integer>> obterTamanhosImagens(ArrayList<WebElement> imagens) {
        ArrayList<ArrayList<Integer>> tamanhos = new ArrayList<>();
        for (WebElement imagem : imagens) {
            ArrayList<Integer> tamanho = new ArrayList<>();
            tamanho.add(Integer.parseInt(imagem.getAttribute("naturalWidth")));
            tamanho.add(Integer.parseInt(imagem.getAttribute("naturalHeight")));
            tamanhos.add(tamanho);
        }
        return tamanhos;
    }

    public boolean verificarTamanhosImagens(ArrayList<ArrayList<Integer>> tamanhos) {
        boolean tamanhosDiferentes = false;
        for (int i = 0; i < tamanhos.size() - 1; i++) {
            if (!tamanhos.get(i).equals(tamanhos.get(i + 1))) {
                tamanhosDiferentes = true;
                break;
            }
        }
        return tamanhosDiferentes;
    }

    public boolean verificarTamanhosIguais(ArrayList<ArrayList<Integer>> tamanhos) {
        boolean tamanhosIguais = true;
        for (int i = 0; i < tamanhos.size() - 1; i++) {
            if (!tamanhos.get(i).equals(tamanhos.get(i + 1))) {
                tamanhosIguais = false;
                break;
            }
        }
        return tamanhosIguais;
    }


    public boolean estouNaPaginaDeImagensQuebradas() {
        return driver.getCurrentUrl().equals("http://the-internet.herokuapp.com/broken_images");
    }

    public boolean existemImagensNaPagina() {
        return !obterImagens().isEmpty();
    }


}
