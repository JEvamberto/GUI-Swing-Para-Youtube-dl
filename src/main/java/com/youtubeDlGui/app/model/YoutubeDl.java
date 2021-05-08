/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youtubeDlGui.app.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose
 */
public class YoutubeDl implements Runnable{
    
    private String url;
    private String qualidade;
    private String titulo;
    private String urlThumb;
    private Process youtubeDl;
    private String placeDirectory;
    private Thread thread;
    private String output;

    private ArrayList <Observer> observers  = new ArrayList();
    
    public void attach (Observer observer){
        this.observers.add(observer);
    
    }
    public void dettach (Observer observer) {
        this.observers.remove(observer);
    }
    
    public void notifyToAll(){
        System.out.println("oi");
        for (Observer observer : this.observers){
            observer.update();
        }
    }
    
    public void iniciarBaixar(){
        thread= new Thread(this);
        this.thread.start();
    }
    public String selecionarQualidade (){
        String formato = " ";
            try {
            this.youtubeDl=Runtime.getRuntime().exec("youtube-dl -F "+this.getUrl());
            BufferedReader in = new BufferedReader(new InputStreamReader(this.youtubeDl.getInputStream()));
            String line ;
            
            while((line=in.readLine()) != null ){
                formato = formato + line+"\n";
            
            }
            
        } catch (IOException ex) {
            Logger.getLogger(YoutubeDl.class.getName()).log(Level.SEVERE, null, ex);
        }
            return formato;
    }
    public void obterThumb(){
        System.out.println("hello estou aqui");
        ArrayList test = new ArrayList();
        try {
            System.out.println("commando: youtube-dl --get-thumbnail "+this.getUrl());
            this.youtubeDl=Runtime.getRuntime().exec("youtube-dl --get-thumbnail "+this.getUrl());
            BufferedReader in = new BufferedReader(new InputStreamReader(this.youtubeDl.getInputStream()));
            String line;
            
            while((line=in.readLine()) != null ){
                
              test.add(line);
            }
           
            
        } catch (IOException ex) {
            Logger.getLogger(YoutubeDl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (Object testes : test){
            System.out.println("URL: "+ (String)testes);
            this.setUrlThumb((String) testes);
        }
        
    
    }
    public void obterTitulo(){
        try {
            this.youtubeDl=Runtime.getRuntime().exec("youtube-dl --get-title "+this.getUrl());
            BufferedReader in = new BufferedReader(new InputStreamReader(this.youtubeDl.getInputStream()));
            String line ;
            while((line=in.readLine()) != null ){
               this.setTitulo(line);
            
            }
            
        } catch (IOException ex) {
            Logger.getLogger(YoutubeDl.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void baixar ( ) {
        try {
            this.youtubeDl=Runtime.getRuntime().exec("youtube-dl "+this.getQualidade()+this.getUrl());
            BufferedReader in = new BufferedReader(new InputStreamReader(this.youtubeDl.getInputStream()));
            String line;
            System.out.println("Hello em baixar");
            while((line=in.readLine()) != null ){
                System.out.println(line);
               this.setOutput(line);
               
            }
            
        } catch (IOException ex) {
            Logger.getLogger(YoutubeDl.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getQualidade() {
        return qualidade;
    }

    public void setQualidade(String qualidade) {
        this.qualidade = qualidade;
    }
    
    public String getOutput(){
        return output;
    }
    public void setOutput(String output){
        this.output=output;
        this.notifyToAll();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrlThumb() {
        return urlThumb;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
        this.notifyToAll();
    }

    public void setUrlThumb(String urlThumb) {
       
            this.urlThumb = urlThumb;
            this.notifyToAll();
       
        
    }

    @Override
    public void run() {
     //  this.obterThumb();
   //    this.obterTitulo();
     //  this.baixar();
        
    }
    
    
    
}
