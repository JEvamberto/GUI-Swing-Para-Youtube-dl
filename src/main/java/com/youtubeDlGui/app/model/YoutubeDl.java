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
public class YoutubeDl {
    private String url;
    private String qualidade;
    private Process youtubeDl;

    private ArrayList <Observer> observers  = new ArrayList();
    
    public void attach (Observer observer){
        this.observers.add(observer);
    
    }
    public void dettach (Observer observer) {
        this.observers.remove(observer);
    }
    
    public void notifyToAll(){
        for (Observer observer : this.observers){
            observer.update();
        }
    }
    
    public void youtubeDlBaixar (String qualidade,String url ) {
        try {
            /*processo = Runtime.getRuntime().exec("glucose "+arquivos[es].getName()+".cnf");
            BufferedReader in = new BufferedReader(new InputStreamReader(processo.getInputStream()));
            
            String line;
            
            while ((line = in.readLine()) != null) {
            if (line.equals("s SATISFIABLE")) {
            System.out.println("É satisfazível");
            System.out.println(line);
            isSatisfativel=true;
            } else {
            
            // System.out.println(line);
            isSatisfativel=false;
            }
            }
            processo.waitFor();*/
            this.youtubeDl=Runtime.getRuntime().exec("youtube-dl "+qualidade+url);
            BufferedReader in = new BufferedReader(new InputStreamReader(this.youtubeDl.getInputStream()));
            String line;
            while((line=in.readLine()) != null ){
                System.out.println(line);
            
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
    
    
}
